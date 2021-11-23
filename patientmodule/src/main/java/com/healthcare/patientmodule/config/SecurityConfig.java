package com.healthcare.patientmodule.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	VaultConfig vaultConfig;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         .authorizeRequests().antMatchers("/api/**").authenticated().and().httpBasic();
    }
    
	
	  @Bean
		@Override
		protected UserDetailsService userDetailsService() {
			List<UserDetails> userList = new ArrayList<UserDetails>();
			userList.add(User.withDefaultPasswordEncoder().username(vaultConfig.getUsername()).password(vaultConfig.getPassword())
					.roles("ADMIN").build());
			return new InMemoryUserDetailsManager(userList);
		}
	 
  
}
