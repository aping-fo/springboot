package com.app.tomcat;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by lucky on 2017/12/20.
 */
public class TomcatFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //进行权限控制，拦截等操作
        System.out.println("ip:"+servletRequest.getRemoteHost());
        System.out.println("ip:"+servletRequest.getRemotePort());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
