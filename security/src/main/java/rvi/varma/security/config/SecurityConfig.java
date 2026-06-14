package rvi.varma.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	JWTFilter jwtFilter;
	@Autowired
	AuthenticationProvider authProvider;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http

.csrf(csrf -> csrf.disable())// not allowed in production
			.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/register").permitAll()
				.requestMatchers("/login").permitAll()
				.anyRequest().authenticated()
			)
			/*.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults())
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
			);*/
			.authenticationProvider(authProvider)
			
		.sessionManagement(session -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
