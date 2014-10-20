package com.apress.springrecipes.social.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by marten on 08-09-14.
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable();

        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
            .and()
                .formLogin()
                .defaultSuccessUrl("/connect");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("1111").authorities("ROLE_USER").and()
                .withUser("user2").password("2222").authorities("ROLE_USER").and()
                .withUser("user3").password("3333").authorities("ROLE_USER");
    }
}
