package br.com.jr.contatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jr.contatos.entity.ContatoEntity;
import br.com.jr.contatos.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;

	public List<ContatoEntity> findAll() {
		return repository.findAll();
	}

	public ContatoEntity save(ContatoEntity contato) {
		return repository.save(contato);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Optional<ContatoEntity> findById(Integer id) {
		return repository.findById(id);
	}

	public ContatoEntity update(ContatoEntity contato) {
		return repository.save(contato);
	}

}
