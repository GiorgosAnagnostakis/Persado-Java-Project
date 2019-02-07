package com.persado.assignment.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableWebSecurity
public class ProjectApplication extends WebSecurityConfigurerAdapter {


	public static void main(String[] args) {

		new SpringApplicationBuilder(ProjectApplication.class)
				.properties("server.port=8093","management.port=8000","management.security.enabled=false")
				.run(args);
	}




	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests().anyRequest().authenticated()
				.antMatchers( "/**").authenticated()
				.anyRequest().permitAll()
		;

	}


}

