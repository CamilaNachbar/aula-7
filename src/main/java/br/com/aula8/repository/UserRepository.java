package br.com.aula8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aula8.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long >{

}
