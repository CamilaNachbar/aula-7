package br.com.aula7.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserCustomDTO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String senha;

	public UserCustomDTO(User usuario) {
		this.nome = usuario.getNome();
		this.senha = usuario.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return nome;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}