package Mizut452.learn_law.LoginSecurity;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login/error")
                .permitAll()
        ).logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers("/quiz").permitAll()
                .requestMatchers("/quiz/questionList").permitAll()
                .requestMatchers("/quiz/preQuiz").permitAll()
                .requestMatchers("/quiz/preQuiz/good/{quizId}/").permitAll()
                .requestMatchers("/quiz/question").permitAll()
                .requestMatchers("/quiz/question/{quizId}/").permitAll()
                .requestMatchers("/quiz/question/{quizId}/judge/").permitAll()
                .requestMatchers("/quiz").permitAll()
                .requestMatchers("/lawboard").permitAll()
                .requestMatchers("/lawboard/{lawboard_id}/").permitAll()
                .requestMatchers("/createaccount").permitAll()
                .requestMatchers("/createaccount/create").permitAll()
                .requestMatchers("/precedent").permitAll()
                .requestMatchers("/precedent/{precedent_id}/").permitAll()
                .requestMatchers("/precedent/all").permitAll()
                .requestMatchers("/precedent/all/changeList").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }

    //パスワードのハッシュ化
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
