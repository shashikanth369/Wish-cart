package com.wishcart.wishcart.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(HttpSecurity httpSecurity){
        try {
            httpSecurity.
                    authorizeRequests()

                    .anyRequest()

                    .permitAll()
                    .and().httpBasic();
            httpSecurity.csrf().disable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
