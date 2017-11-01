package com.sawai.medical.security;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import com.sawai.medical.enums.Role; 
import com.sawai.medical.model.User;
import com.sawai.medical.service.UserService;
 

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserService userService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/users/reset-password/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers("/").permitAll().antMatchers("/console/**").permitAll()
				.antMatchers("/signup", "/about", "/login", "login?error").permitAll()
				.antMatchers(HttpMethod.POST, "/user/**").access("hasRole('ROLE_ADMIN')")    // only ROLE_ADMIN create new user.
				.anyRequest().authenticated();
			
		/*http.logout()
			.logoutUrl("/logout")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.logoutSuccessHandler(new LogoutSuccessHandler() {
		public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
			response.setStatus(200);
		}
	});*/
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.requestCache().requestCache(new NullRequestCache());
		http.httpBasic();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userService).passwordEncoder(encoder);
		
		if (!userService.userExist("admin")) {
			User user = new User();
			user.setEmailId("admin");
			user.setPassword("password");
			user.setEnabled(true);
			List<Role> list = new ArrayList<Role>();
			list.add(Role.ROLE_ADMIN);
			user.setRoles(list);
			userService.create(user);
		}
	}
	
	@Bean
    public HttpSessionStrategy httpSessionStrategy() {
    	return new HeaderHttpSessionStrategy();
    }
}
