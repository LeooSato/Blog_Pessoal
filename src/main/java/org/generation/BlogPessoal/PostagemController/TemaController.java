package org.generation.BlogPessoal.PostagemController;

import org.apache.coyote.Response;
import org.generation.BlogPessoal.Repository.TemaRepository;
import org.generation.BlogPessoal.model.Tema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController {
    @Autowired
    private TemaRepository Repository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
        return ResponseEntity.ok(Repository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable long id){
        return Repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Tema>> getByName(@PathVariable String nome){
        return ResponseEntity.ok(Repository.findAllByDescricaoContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Tema> post (@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(Repository.save(tema));
    }

    @PostMapping
    public ResponseEntity<Tema> put (@RequestBody Tema tema) {
        return ResponseEntity.ok(Repository.save(tema));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        Repository.deleteById(id);
    }
}
