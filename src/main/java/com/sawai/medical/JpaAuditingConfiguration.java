/**
 * 
 */
package com.sawai.medical;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import com.sawai.medical.model.User;

/**
 * @author sawai
 *
 */

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaAuditingConfiguration {

	@Bean
	public AuditorAware<User> auditorAware() {
		return () -> {
			// Check For null because when application start then we need to insert a default user that time principal will be null. 
			if (SecurityContextHolder.getContext().getAuthentication() == null) return null;	
			return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		};
	}
}
