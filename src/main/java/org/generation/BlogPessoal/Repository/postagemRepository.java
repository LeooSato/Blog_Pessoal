package org.generation.BlogPessoal.Repository;

import org.generation.BlogPessoal.model.postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface postagemRepository extends JpaRepository<postagem,Long>
{
    public List<postagem> findAllByTituloContainingIgnoreCase (String Titulo);

}
