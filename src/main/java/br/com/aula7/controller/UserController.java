package br.com.aula7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula7.entity.User;
import br.com.aula7.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("usuario")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public ResponseEntity<?> login() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);

	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> getList() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping("/salvar")
	public ResponseEntity<?> salvar(@RequestBody User usuario) {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.saveAndFlush(usuario));
	}

}
