package com.oudake.csrftest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wangyi
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_PROCESS_URL = "/doLogin";

    @Autowired
    private LoginAuthSuccessHandler loginAuthSuccessHandler;
    @Autowired
    private LoginAuthFailHandler loginAuthFailHandler;
    @Autowired
    private LoginAuthProvider loginAuthProvider;
    @Autowired
    private CustomAuthEntryPoint customAuthEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(loginAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl(LOGIN_PROCESS_URL)
                .successHandler(loginAuthSuccessHandler)
                .failureHandler(loginAuthFailHandler)
            .and()
                .logout().permitAll()
            .and()
                .exceptionHandling().authenticationEntryPoint(customAuthEntryPoint);
    }
}
