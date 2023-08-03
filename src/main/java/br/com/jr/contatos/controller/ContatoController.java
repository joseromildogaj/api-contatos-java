package br.com.jr.contatos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.jr.contatos.entity.ContatoEntity;
import br.com.jr.contatos.service.ContatoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService service;

	@PostMapping
	public ResponseEntity<ContatoEntity> save(@RequestBody @Valid ContatoEntity contato) {
		ContatoEntity contatoEntity = service.save(contato);
		return ResponseEntity.status(HttpStatus.CREATED).body(contatoEntity);
	}

	@GetMapping
	public ResponseEntity<List<ContatoEntity>> findAll() {
		List<ContatoEntity> contatos = service.findAll();
		return ResponseEntity.ok(contatos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContatoEntity> findById(@PathVariable Integer id) {
		ContatoEntity contato = service.findById(id);
		return ResponseEntity.ok(contato);
	}
	@GetMapping("/nome")
	public ResponseEntity<List<ContatoEntity>> findByName(@RequestParam("nome") String nome){
		List<ContatoEntity> contatoEntityList = service.findByName(nome);
		return ResponseEntity.ok(contatoEntityList);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ContatoEntity> update(@PathVariable Integer id, @Valid @RequestBody ContatoEntity contato) {
		ContatoEntity contatoEntity = service.update(id, contato);
		return ResponseEntity.ok(contatoEntity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removeById(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
