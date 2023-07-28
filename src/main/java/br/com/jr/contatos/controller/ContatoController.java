package br.com.jr.contatos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<List<ContatoEntity>> listarContatos() {
		List<ContatoEntity> contatos = service.findAll();
		return ResponseEntity.ok(contatos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContatoEntity> pesquisaContato(@PathVariable Integer id) {
		ContatoEntity contato = service.findById(id);
		return ResponseEntity.ok(contato);
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
