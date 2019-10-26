package br.com.aula7.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {

            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/usuario/salvar").permitAll().antMatchers(AUTH_WHITELIST)
				.permitAll()

				.antMatchers(HttpMethod.GET, "/usuario/listar").authenticated().anyRequest().authenticated();
	}
}
