package org.project.spring.music_album.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    @SuppressWarnings("removal")
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/albums/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/albums/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/albums/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/albums", "/albums/**").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/artists/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/artists/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/artists/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/artists", "/albums/**").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/genres", "/genres/**").hasAnyAuthority("ADMIN")
                .requestMatchers("/**").permitAll()
                .and().formLogin()
                .and().logout()
                .and().exceptionHandling();

        return http.build();
    }

    @Bean
    @SuppressWarnings("deprecation")
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
