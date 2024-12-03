package com.example.spring_api.API.Configuration;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class APIKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY = "thinhdeptrai1234";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader("X-API-KEY");
        if (API_KEY.equals(apiKey)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("\t======FORBIDDEN======\n\tPlease provide API key!!!\nCONTACTS\nemail: thkinh2008@gmail.com\nPhone:0905272847");
        }
    }
}
