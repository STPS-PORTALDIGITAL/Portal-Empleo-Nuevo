package stps.gob.mx.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.http.HttpMethod;
import stps.gob.mx.security.JWTAuthorizationFilter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@SpringBootApplication
@ComponentScan(basePackages = { "stps.gob.mx.controller","stps.gob.mx.service","stps.gob.mx.dto"})
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"stps.gob.mx.repositories"})
@EntityScan(basePackages =  {"stps.gob.mx.domain"})
public class PortalDigitalApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PortalDigitalApplication.class, args);
	}
	
	 @Override
	   protected SpringApplicationBuilder configure(final SpringApplicationBuilder applicationBuilder) {
	      return applicationBuilder.sources(PortalDigitalApplication.class);
	   }
	 

		@EnableWebSecurity
		@Configuration
		class WebSecurityConfig extends WebSecurityConfigurerAdapter {

			@Override
			protected void configure(HttpSecurity http) throws Exception {
				http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					//.antMatchers(HttpMethod.POST, "/Login").permitAll()
//					.antMatchers("/Login/**").permitAll()
//					.anyRequest().authenticated();
				
				.antMatchers(HttpMethod.POST, "/private").authenticated()
				.anyRequest().permitAll(); 
			}
		}
		
	   
}