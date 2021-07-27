package org.generation.BlogPessoal.PostagemController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.generation.BlogPessoal.model.postagem;
import org.generation.BlogPessoal.Repository.postagemRepository;
@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private postagemRepository Repose;

    @GetMapping
    public ResponseEntity<List<postagem>> getAll (){
        return ResponseEntity.ok(Repose.findAll()); // OK = 200
    }

    @GetMapping("/(id)")
            public ResponseEntity<postagem> GetbyID(@PathVariable long ID){
        return  Repose.findById(ID).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<postagem>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(Repose.findAllByTituloContainingIgnoreCase(titulo));
    }

}
