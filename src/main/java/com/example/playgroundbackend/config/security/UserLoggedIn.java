package com.example.playgroundbackend.config.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserLoggedIn {

    public static String getId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static Collection<SimpleGrantedAuthority> getGroups() {
        return (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }

    public static User getUser() {
        return User.builder()
                .id(getId())
                .groups(getGroups())
                .build();
    }
}
