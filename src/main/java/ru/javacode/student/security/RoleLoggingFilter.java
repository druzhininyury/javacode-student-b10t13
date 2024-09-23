package ru.javacode.student.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@Component
public class RoleLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // Получаем аутентификацию
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            // Извлекаем роли пользователя
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            System.out.println("Roles assigned to user:");
            for (GrantedAuthority authority : authorities) {
                System.out.println(authority.getAuthority());
            }
        }

        // Передаем управление дальше
        filterChain.doFilter(request, response);
    }
}
