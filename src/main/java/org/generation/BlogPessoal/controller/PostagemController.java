package org.generation.BlogPessoal.controller;

import java.util.List;

import org.generation.BlogPessoal.Repository.postagemRepository;
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

import org.generation.BlogPessoal.model.Postagem;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private postagemRepository repository;
	
	// essa anotação/metodo retorna tudo que tem no banco de dados por isso é o findAll
	@GetMapping 
	public ResponseEntity<List<Postagem>> GetAll (){
		return ResponseEntity.ok(repository.findAll());
	}
	
	// Essa possibilita a pesquisa por id exemplo http://localhost:8080/postagens/2  e caso não seja encontrado retorna 404-notfound
	@GetMapping("/{id}") 
	public ResponseEntity<Postagem> GetById(@PathVariable long id){ 
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()); 
	}
	

	@GetMapping ("/titulo/{titulo}")  
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo)); 
	}
	

	@PostMapping 
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	

	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id); 
	}
}