package com.isoqualtech.plateformAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.isoqualtech.plateformAPI.Auth.ApiAuthService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter{

	private final class WebMvcConfigurerAdapterExtension extends WebMvcConfigurerAdapter {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
		    registry.addMapping("/**")
		            .allowedMethods(/*"HEAD",*/ "GET", "PUT", "POST", "DELETE"/*, "PATCH"*/);
		}
	}

	private final PasswordEncoder passwordEncoder;
	private final ApiAuthService apiAuthService;
	private final JwtEntryPointAuth unauthorizedHandler;
	
	@Autowired
	public ApiSecurityConfig(PasswordEncoder passwordEncoder,ApiAuthService apiAuthService, JwtEntryPointAuth unauthorizedHandler) {
		this.passwordEncoder = passwordEncoder;
		this.apiAuthService = apiAuthService;
		this.unauthorizedHandler = unauthorizedHandler;
	}

	@Bean
	public JwtRequestFilter authenticateJwtTokenFilter() {
		return new JwtRequestFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
			.csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers("/user/auth").permitAll();
			//.anyRequest()
			//.authenticated();
			//.and()
			//.formLogin()
			//.and().httpBasic();
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapterExtension();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(apiAuthService);
		return provider;
	}
}
