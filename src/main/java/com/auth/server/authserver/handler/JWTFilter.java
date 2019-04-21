package com.auth.server.authserver.handler;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JWTFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final String authorization = request.getHeader("authorization");

        if(authorization == null || authorization.startsWith("Bearer ")){
            throw new ServletException("401 - Unauthorized");
        }

        try{
            final Claims claims = Jwts.parser().setSigningKey("27*%$09aju#").parseClaimsJws(authorization.substring(7))
                    .getBody();
            request.setAttribute("claims", claims);
        }catch (final SignatureException e){
            throw new ServletException("401 - Unauthorized");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
