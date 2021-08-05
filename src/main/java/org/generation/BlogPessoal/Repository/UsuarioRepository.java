package org.generation.BlogPessoal.Repository;

import org.generation.BlogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Optional<Usuario> findByUsuario(String UserLogin);

    public List <Usuario> findAllByNomeContainingIgnoreCase (String Nome);

    public Optional <Usuario> findByNome(String Nome);

}
