package bookstore.bookstorelola;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
@EnableMethodSecurity 
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/css/**").permitAll()
                .anyRequest().authenticated()
            ).formLogin(formlogin -> formlogin
                .defaultSuccessUrl("/index", true).permitAll()
            ).logout(logout -> logout
                .permitAll()
            );
        return http.build();
    } 



}
