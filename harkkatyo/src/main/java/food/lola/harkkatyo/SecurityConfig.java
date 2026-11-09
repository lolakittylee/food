package food.lola.harkkatyo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// public browsing allowed on index and foodlist
// login needed for adding, editing and deleting

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/", "/index", "/foodlist", "/foods", "/food/*",
                "/css/**", "/js/**", "/images/**"
            ).permitAll()
            .anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults());

        return http.build();
    }
}
