package org.generation.redesocial.controller;

import java.util.List;
import java.util.Optional;

import org.generation.redesocial.model.Usuario;
import org.generation.redesocial.model.UsuarioLogin;
import org.generation.redesocial.repository.UsuarioRepository;
import org.generation.redesocial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	public UsuarioRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByTema(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	/*
	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(usuario));
	}
	*/
	
	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(repository.save(usuario));
	}
	
	@DeleteMapping("/id/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	/*Metodos novos , Logar e Cadastrar , que estão na Classe UsuarioService*/
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> autentication(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
	}
	
	
}
