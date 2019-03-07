package com.imkzp.life.config.security;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imkzp.life.bean.security.JwtUser;
import com.imkzp.life.common.Base.RespResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

@Slf4j
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.info("尝试登陆");
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        logger.info("手机:"+phone+"    密码:"+pwd);
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(phone,pwd,new ArrayList<>()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        logger.info("登陆成功");
        String principal = ((JwtUser)authResult.getPrincipal()).getUsername();
        String token = JWTUtil.createToken(principal,false);
        response.setHeader(JWTUtil.TOKEN_HEADER,JWTUtil.TOKEN_PREFIX+token);
        PrintStream out = new PrintStream(response.getOutputStream());
        RespResult respResult = new RespResult();
        respResult.setCode(0);
        respResult.setMsg("登陆成功");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRes =  objectMapper.writeValueAsString(respResult);
        out.print(jsonRes);
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        logger.info("登陆失败");
        logger.info(failed.getMessage());
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
