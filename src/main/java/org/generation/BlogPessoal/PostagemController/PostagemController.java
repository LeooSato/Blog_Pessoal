package org.generation.BlogPessoal.PostagemController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("idifelse/{id}")
    public ResponseEntity<postagem> getByIdIfElse(@PathVariable long id) {

        Optional<postagem> postagem = Repose.findById(id);
        if (postagem.isPresent()) {
            return ResponseEntity.ok(postagem.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/idtrycatch/{id}")
    public ResponseEntity<postagem> getByIdTryCatch(@PathVariable long id) {

        Optional<postagem> postagem = Repose.findById(id);
        try {
            return ResponseEntity.ok(postagem.get());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/(id)")
            public ResponseEntity<postagem> GetbyID(@PathVariable long ID){
        return  Repose.findById(ID).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<postagem>> getByTitulo(@PathVariable String titulo){
        return ResponseEntity.ok(Repose.findAllByTituloContainingIgnoreCase(titulo));
    }


    @PostMapping
    public ResponseEntity<postagem> postPostagem (@RequestBody postagem postagem){
        return ResponseEntity.status(HttpStatus.CREATED).body(Repose.save(postagem));
    }

    @PutMapping
    public ResponseEntity<postagem> putPostagem (@RequestBody postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(Repose.save(postagem));
    }

    @DeleteMapping("/{id}")
    public void deletePostagem(@PathVariable long id) {
        Repose.deleteById(id);
    }

}
