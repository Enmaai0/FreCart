# Spring 文件上传示例 / Spring File Upload Example
下文演示了如何使用 Spring Boot 和 Spring MVC 实现文件上传功能。/ This following demonstrates a file upload functionality using Spring Boot and Spring MVC.

## Configuration

### WebMvcConfig

`WebMvcConfig` 是一个 Spring 配置类，用于定义静态资源的处理方式。它将 `/images/**` 路径下的资源映射到文件系统中的实际路径。

`WebMvcConfig` is a Spring Configuration class that defines how static resources should be handled. It maps resources under `/images/**` to the physical path in the file system.

```java
        @Configuration
        public class WebMvcConfig implements WebMvcConfigurer {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/images/**").addResourceLocations("file:" + Constant.uploadFileDir);
            }
        }
awd
