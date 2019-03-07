package com.imkzp.life.config.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(JWTUtil.TOKEN_HEADER);

        // 如果请求头中没有Authorization信息则直接放行了
        if (header == null || !header.startsWith(JWTUtil.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        // 如果请求头中有token，则进行解析，并且设置认证信息
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(header);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    /**
     * 这里从token中获取用户信息并新建一个token
     */
    private UsernamePasswordAuthenticationToken getAuthentication(String header) {

        String token = header.replace(JWTUtil.TOKEN_PREFIX, "");
        String principal = JWTUtil.getUsername(token);

        if (principal != null) {
            return new UsernamePasswordAuthenticationToken(principal, null, new ArrayList<>());
        }
        return null;
    }

}
