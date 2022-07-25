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

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	public ContatoService service;

	@GetMapping
	public List<ContatoEntity> listarContatos() {
		return service.findAll();
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> pesquisaContato(@PathVariable Integer id) {
		Optional<ContatoEntity> contact = service.findById(id);
		if (contact.isPresent()) {
			return ResponseEntity.ok(contact);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ContatoEntity> save(@RequestBody ContatoEntity contact) {
		service.save(contact);
		return ResponseEntity.status(HttpStatus.CREATED).body(contact);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ContatoEntity contact) {
		Optional<ContatoEntity> contato = service.findById(id);
		if (contato.isPresent() && contact.getId() == id) {
			service.save(contact);
			return ResponseEntity.ok().body(contact);
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> removeById(@PathVariable("id") Integer id) {
		Optional<ContatoEntity> contact = service.findById(id);
		if (contact.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		service.deleteAll();
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
