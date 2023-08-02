package br.com.jr.contatos.service;

import java.util.List;
import java.util.Optional;

import br.com.jr.contatos.exceptions.ExistingEmailException;
import br.com.jr.contatos.exceptions.ResourceNotFoundException;
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
		if (repository.existsByEmail(contato.getEmail())){
			throw new ExistingEmailException("O email informado já existe");
		}
		return  repository.save(contato);
	}

	public List<ContatoEntity> findAll() {
		return repository.findAll();
	}

	public ContatoEntity findById(Integer id) {
		return repository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Contato não encontrado com id " + id));
	}

	public ContatoEntity update(Integer id, ContatoEntity contato) {
		ContatoEntity contatoEntity = findById(id);
		contato.setId(contatoEntity.getId());
		return repository.save(contato);
	}

	public void deleteById(Integer id) {
		ContatoEntity contato = findById(id);
		repository.delete(contato);
	}

}
