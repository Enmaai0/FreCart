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
