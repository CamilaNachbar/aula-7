package br.com.aula7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aula7.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long >{

	public User findByNome(String nome);

}
