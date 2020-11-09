package cn.com.pro.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @title: AuthFilter
 * @projectName pro
 * @description: TODO
 * @User: zhoubin
 * @Date: 2020-11-08 10:35
 */
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
@Order(1)
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 支持跨域访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept,X-Custom-Header");
        response.setHeader("X-Powered-By", "SpringBoot");
        System.out.println("==================");

        // 除了拦截login.html 其他html都拦截
        StringBuffer url = request.getRequestURL();
        // System.out.println(url);
        String path = url.toString();

        request.getRequestURI();
        request.getQueryString();
        // 只拦截这些类型请求
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    private void processAccessControl(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Object adminUser = request.getSession().getAttribute("login_user");
        Object user = request.getSession().getAttribute("user");
        String url = request.getRequestURL().toString();
        if (url.indexOf("admin") != -1) {
            if (adminUser == null) {
                response.sendRedirect("/mall/admin/toLogin.html");
            } else {
                chain.doFilter(request, response);
            }
        } else {

            String token = request.getHeader("token");// 从 http 请求头中取出 token
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }

            // return true;
            if (user == null || token == null) {
                response.sendRedirect("/mall/user/toLogin.html");
            } else {

                chain.doFilter(request, response);
            }
        }
    }
}
