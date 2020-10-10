//package com.authright.timesheet.filter;
//
//
//import com.authright.timesheet.util.JwtUtil;
//import io.jsonwebtoken.Claims;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
//public class SecurityFilter implements Filter{
//
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    private static String AUTH_URI = "/auth";
//    private static String REG_URI = "/auth/registration";
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//        // TODO Auto-generated method stub
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest)request;
//        int statusCode = authorization(req);
//        if (statusCode == HttpServletResponse.SC_ACCEPTED) filterChain.doFilter(request, response);
//        else ((HttpServletResponse)response).sendError(statusCode);
//    }
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//    }
//
//    private int authorization(HttpServletRequest req) {
//        int statusCode = HttpServletResponse.SC_UNAUTHORIZED;
//        String uri = req.getRequestURI();
//        String verb = req.getMethod();
//        if (uri.equalsIgnoreCase(AUTH_URI) || uri.equalsIgnoreCase(REG_URI)) return HttpServletResponse.SC_ACCEPTED;
//        try {
//            String token = req.getHeader("Authorization").replaceAll("^(.*?) ", "");
//            if (token == null || token.isEmpty()) return statusCode;
//            Claims claims = JwtUtil.decodeJwtToken(token);
//            statusCode = HttpServletResponse.SC_ACCEPTED;
//        }
//        catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return statusCode;
//    }
//}
