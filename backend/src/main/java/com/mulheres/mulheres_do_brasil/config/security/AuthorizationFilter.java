package com.mulheres.mulheres_do_brasil.config.security;

import com.mulheres.mulheres_do_brasil.entities.User;
import com.mulheres.mulheres_do_brasil.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AuthorizationFilter extends OncePerRequestFilter {
    private TokenService tokenService;
    private UserRepository userRepository;

    public AuthorizationFilter(TokenService tokenService,UserRepository userRepository){
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        boolean validToken = tokenService.isTokenValid(token);
        System.out.println(validToken);
        if(validToken){
            userAuthentication(token);
        }
        filterChain.doFilter(request,response);
    }

    private void userAuthentication(String token) {
        UUID userId = UUID.fromString(tokenService.getUserId(token));
        User user = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }else {
            return token.substring(7,token.length());
        }
    }
}
