package com.example.pos_javaee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public  class DoFilter implements Filter {
    public DoFilter() {
        System.out.println("Object created for DoFilter.");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DoFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DoFilter.doFilter");
        /*Since we cannot access HttpServlet methods from ServletRequest and ServletResponse
         * we can case those references to their subtype.Which is HttpServletRequest and
         * HttpServletResponse.//
         */

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "Content-Type");

        //In order to send the request to the relevant servlet, we need to call filterChain.doFilter() method.
        //If not , the request will not be sent to the relevant servlet..
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().write("This is from the filter!");


    }

    @Override
    public void destroy() {
        System.out.println("DoFilter.destroy");
    }
}