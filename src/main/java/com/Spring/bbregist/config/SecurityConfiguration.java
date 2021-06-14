package com.Spring.bbregist.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.Spring.bbregist.Userservice.DonorDetails;
import com.Spring.bbregist.Userservice.HospitalDetails;

@Configuration
	public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Configuration
	@Order(2)
	public static class userConfigure extends WebSecurityConfigurerAdapter {
		@Autowired
		private DonorDetails userService;
		
		
		
		@Bean
		public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
			auth.setUserDetailsService(userService);
			auth.setPasswordEncoder(passwordEncoder());
			
			return auth;
		}
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO Auto-generated method stub
			auth.authenticationProvider(authenticationProvider());
		}
		
		
		    public userConfigure() {
		        super();
		    }
		@Override
		protected void configure(HttpSecurity http)  throws Exception{
			
			
			http.authorizeRequests().antMatchers("/**","/hospital/**")
			.permitAll().anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/donorlogin").defaultSuccessUrl("/donor-home").permitAll().and()
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/donorlogin?logout")
			.permitAll();
			http.csrf().disable();
		}
	}
		@Configuration
		@Order(1)
		public static class HospitalConfigure extends WebSecurityConfigurerAdapter {

		    public HospitalConfigure() {
		        super();
		    }
		    
			@Autowired
			private HospitalDetails hospitalService;
			
			
			
			@Bean
			public DaoAuthenticationProvider authentiCationprovider() {
				DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
				auth.setUserDetailsService(hospitalService);
				auth.setPasswordEncoder(passwordEncoder());
				return auth;
			}
			@Override
			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				// TODO Auto-generated method stub
				auth.authenticationProvider(authentiCationprovider());
			}
			
			
			@Override
			protected void configure(HttpSecurity http)  throws Exception{
				
				
				http.authorizeRequests().antMatchers("/hospital/**","/**").permitAll().anyRequest().authenticated()
				.and().formLogin()
				.loginPage("/hospital").defaultSuccessUrl("/hospital/hospital-home",true).permitAll().and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/hospital/logout"))
				.logoutSuccessUrl("/hospital?logout")
			.permitAll();
				
				http.csrf().disable();
			}
		}


		@Bean
		public static BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

}