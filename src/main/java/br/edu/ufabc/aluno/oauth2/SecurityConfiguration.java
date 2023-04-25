package br.edu.ufabc.aluno.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    protected SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/").anonymous()
                .anyRequest().fullyAuthenticated()
                .and()
                .oauth2Login().defaultSuccessUrl("/google")
                .and()
                .cors().and().csrf().disable();
        return http.build();
    }
}