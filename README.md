# AdminFilter

`AdminFilter` 是关于管理员路由的 Servlet 过滤器。确保只有登录的管理员用户才能访问指定的接口。

`AdminFilter` is a Servlet filter designed to protect admin routes. It ensures that only logged-in administrator users can access specified admin backend endpoints.

## Example Code / 示例代码
    ```java
    @Component
    @WebFilter(urlPatterns = { "/admin/category/*", "/admin/product/*", "/admin/order/*" })
    public class AdminFilter implements Filter {
        @Autowired
        UserService userService;
    
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }
    
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpSession session = request.getSession();
            User curUser = (User) session.getAttribute(Constant.HAOMALL_USER);
            
            PrintWriter writer = servletResponse.getWriter();
            if (curUser == null) {
                writer.write("{\n" +
                        "    \"status\": 10007,\n" +
                        "    \"message\": \"NEED_LOGIN\",\n" +
                        "    \"data\": null\n" +
                        "}");
                writer.flush();
                return;
            }
    
            boolean isAdmin = userService.isAdmin(curUser);
            if (isAdmin) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                writer.write("{\n" +
                        "    \"status\": 10009,\n" +
                        "    \"message\": \"NEED_ADMIN\",\n" +
                        "    \"data\": null\n" +
                        "}");
                writer.flush();
            }
        }
    
        @Override
        public void destroy() {
        }
    }

# AdminFilterConfig
为了确保 AdminFilter 可以在指定url下正常使用，配置如下：

To ensure AdminFilter is properly registered, configure it as follows:
    ```java
    @Configuration
    public class AdminFilterConfig {
        @Bean
        public AdminFilter adminFilter() {
            return new AdminFilter();
        }
    
        @Bean
        public FilterRegistrationBean<AdminFilter> adminFilterConfiguration() {
            FilterRegistrationBean<AdminFilter> filterRegistrationBean = new FilterRegistrationBean<>();
            filterRegistrationBean.setFilter(adminFilter());
            filterRegistrationBean.addUrlPatterns("/admin/category/*", "/admin/product/*", "/admin/order/*");
            return filterRegistrationBean;
        }
    }
