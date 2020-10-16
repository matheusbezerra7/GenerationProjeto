package org.generation.redesocial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.generation.redesocial.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
	public Optional<Usuario> findByEmailAndSenha(String email, String senha);
	public Optional<Usuario> findByEmail(String email);
}
