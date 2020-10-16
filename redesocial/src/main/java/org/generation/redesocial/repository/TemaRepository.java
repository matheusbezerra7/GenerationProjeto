package org.generation.redesocial.repository;

import java.util.List;

import org.generation.redesocial.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.User;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByTemaContainingIgnoreCase(String tema);
	public List<Tema> findAllByEstadoContainingIgnoreCase(String estado);
}
