package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                // Implement your own user and admin authentication logic here
                if ("user".equals(username)) {
                    return User.withUsername("user")
                            .password("userpassword")
                            .roles("USER")
                            .build();
                } else if ("admin".equals(username)) {
                    return User.withUsername("admin")
                            .password("adminpassword")
                            .roles("ADMIN")
                            .build();
                } else {
                    throw new UsernameNotFoundException("User not found");
                }
            }
        };
    }
}
    
    

  