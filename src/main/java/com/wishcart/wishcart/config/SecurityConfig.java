package com.wishcart.wishcart.config;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @NonNull
    private UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());*/
                auth.inMemoryAuthentication()
                .passwordEncoder(encoder())
                .withUser("shashi")
                .password("shashi")
                .roles("USER", "ADMIN");
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(HttpSecurity httpSecurity){
        try {
            httpSecurity.csrf().disable()
                    .authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN")
                    .anyRequest().hasRole("USER").anyRequest()
                    .permitAll()
                    .and().httpBasic();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
