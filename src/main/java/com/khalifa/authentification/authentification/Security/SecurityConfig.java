package com.khalifa.authentification.authentification.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.khalifa.authentification.authentification.Service.MyAppUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired
    private MyAppUserService appUserService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Bean
    public UserDetailsService userDetailsService(){
        return appUserService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProviders())
                .build();
    }

    // Authentication provider is here for helping us log into our account we will need the password encoder as well it must no be sent in plain text
    @Bean
    public AuthenticationProvider authenticationProviders(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    //For encoding we use PasswordEncoder method provided by spring security when we log into our account
    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    

    //First we create this method to controll the access to our ressources from different paths
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                    .csrf(AbstractHttpConfigurer::disable)
                    // .formLogin(
                    //     httpForm -> {
                    //         httpForm.loginPage("/login").permitAll();
                    //     })
                    .authorizeHttpRequests(connect -> {
                        connect.requestMatchers("/api/login").permitAll();
                    })
                    .authorizeHttpRequests(registry ->{
                            // We should add a jwtauthentication filter to check the token and user
                            registry.requestMatchers("/api/req/signup").permitAll();
                            registry.anyRequest().authenticated()
                           .and().addFilterBefore(new JwtAuthenticationFilter(jwtTokenUtil, appUserService), UsernamePasswordAuthenticationFilter.class);
                        })
                    .build();
    }


}
