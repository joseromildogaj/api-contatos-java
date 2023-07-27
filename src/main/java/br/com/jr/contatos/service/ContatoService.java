package br.com.jr.contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jr.contatos.entity.ContatoEntity;
import br.com.jr.contatos.repository.ContatoRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;

	public ContatoEntity save(ContatoEntity contato) {
		return  repository.save(contato);
	}

	public List<ContatoEntity> findAll() {
		return repository.findAll();
	}

	public ContatoEntity findById(Integer id) {
		Optional<ContatoEntity> contatoOptional = repository.findById(id);
		if (contatoOptional.isEmpty()){
			throw new RuntimeException("Contato não encontrado com id " + id);
		}
		return contatoOptional.get();
	}

	public ContatoEntity update(Integer id, ContatoEntity contato) {
		Optional<ContatoEntity> contatoOptional = repository.findById(id);
		if (contatoOptional.isEmpty()){
			throw new RuntimeException("Contato não encontrado com id " + id);
		}
		return repository.save(contato);
	}

	public void deleteById(Integer id) {
		Optional<ContatoEntity> contatoOptional = repository.findById(id);
		if (contatoOptional.isEmpty()) {
			throw new RuntimeException("Contato não encontrado com id " + id);
		}
		repository.deleteById(id);
	}

}
