//package com.lhb.studentsystem.filter;
//
//import javax.servlet.*;
//import javax.servlet.Filter;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "userFilter", urlPatterns = "/user/*")
//public class UserFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String uri = request.getRequestURI();
//        if (uri.contains("login")) {
//            filterChain.doFilter(request, servletResponse);
//            return;
//        }
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.sendRedirect("login.html");
//        return;
//    }
//}
