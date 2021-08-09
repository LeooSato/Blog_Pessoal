package org.generation.BlogPessoal.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import org.generation.BlogPessoal.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional <Usuario> findByUsuario(String usuario);

	public List <Usuario> findAllByNomeContainingIgnoreCase (String nome);

	public Usuario findByNome(String nome);
}
