## 新增功能：Redis 缓存支持 / New Feature: Redis Cache Support

通过 Spring Data Redis 和 Spring Cache 引入了 Redis 作为缓存解决方案，以提高用户获取商品列表的性能和响应速度。  
I introduced Redis as a caching solution through Spring Data Redis and Spring Cache to improve the response speed for users to obtain category lists.

### 1. 依赖项更新 / Dependency Updates

在 `pom.xml` 中添加了以下 Maven 依赖：  
Added the following Maven dependencies in `pom.xml`:

    ```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>

### 2. 启用缓存 / Enable Caching
在主应用程序的入口类上添加 @EnableCaching 注解，以启用 Spring Cache 功能：

Add the @EnableCaching annotation on the main application entry class to enable Spring Cache functionality:

### 3. 缓存配置 / Cache Configuration
创建 CachingConfig 类，配置 Redis 作为缓存管理器：

Create the CachingConfig class to configure Redis as the cache manager:

      @Configuration
      @EnableCaching
      public class CachingConfig {
          @Bean
          public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
              RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory);
              RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
              redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofSeconds(30));
      
              RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
              return redisCacheManager;
          }
      }

* RedisCacheManager：用于管理 Redis 缓存。

* RedisCacheManager: Used to manage Redis cache.

* entryTtl：设置缓存的有效时间，这里为 30 秒。

* entryTtl: Sets the cache expiration time, here it is 30 seconds.

### 4. 新增接口 / New Interface
新增了一个获取分类列表的接口：

A new interface to retrieve the category list has been added:

        @GetMapping("category/list")
        @ResponseBody
        public ApiRestResponse listCategoryForCustomer() {
            List<CategoryVO> categoryVOS = categoryService.listCategoryForCustomer(0);
            return ApiRestResponse.sucess(categoryVOS);
        }
### 5. 使用缓存的服务方法 / Service Method Using Cache
在 CategoryService 中使用 @Cacheable 注解，缓存分类列表：

In the CategoryService, use the @Cacheable annotation to cache the category list:

        @Override
        @Cacheable(value = "listCategoryForCustomer")
        public List<CategoryVO> listCategoryForCustomer(Integer parentId) {
            List<Category> categories = categoryMapper.selectByParentId(parentId);
            List<CategoryVO> categoryVOList = new ArrayList<>();
            for (Category category : categories) {
                CategoryVO categoryVO = new CategoryVO();
                BeanUtils.copyProperties(category, categoryVO);
                List<CategoryVO> subCategories = listCategoryForCustomer(category.getId());
                categoryVO.setSubCategories(subCategories);
                categoryVOList.add(categoryVO);
            }
            return categoryVOList;
        }
* @Cacheable：该注解用于标记需要缓存的服务方法，指定缓存的名称为 listCategoryForCustomer。
* @Cacheable: This annotation is used to mark the service method that needs to be cached, specifying the cache name as listCategoryForCustomer.
  
