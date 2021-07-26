package org.generation.BlogPessoal.PostagemController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.generation.BlogPessoal.model.postagem;
import org.generation.BlogPessoal.Repository.postagemRepository;
@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

    @Autowired
    private postagemRepository postagemRepository;

    @GetMapping
    public ResponseEntity<List<postagem>> getAll (){
        return ResponseEntity.ok(postagemRepository.findAll()); // OK = 200
    }

}
