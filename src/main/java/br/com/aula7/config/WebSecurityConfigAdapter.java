package br.com.aula7.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.aula7.entity.User;
import br.com.aula7.entity.UserCustomDTO;
import br.com.aula7.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManagerBean();
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository usuarioRepository)
			throws Exception {
		if (usuarioRepository.count() == 0) {
			User usuario = new User();
			usuario.setNome("admin");
			usuario.setPassword(passwordEncoder().encode("admin"));
			usuarioRepository.save(usuario);
		}

		builder.userDetailsService(nome -> new UserCustomDTO(usuarioRepository.findByNome(nome)))
				.passwordEncoder(passwordEncoder());
	}

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}