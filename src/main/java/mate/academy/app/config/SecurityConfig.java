package mate.academy.app.config;

import lombok.AllArgsConstructor;
import mate.academy.app.util.JwtConfig;
import mate.academy.app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getEncoder());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/register", "/login")
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "/reviews/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/items", "/reviews", "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/reviews/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/reviews/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .and()
                .httpBasic()
                .and()
                .apply(new JwtConfig(jwtUtil))
                .and()
                .headers()
                .frameOptions()
                .disable();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
