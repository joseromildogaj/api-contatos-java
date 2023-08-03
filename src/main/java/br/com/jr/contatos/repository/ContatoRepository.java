package br.com.jr.contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jr.contatos.entity.ContatoEntity;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {
    boolean existsByEmail(String email);
    List<ContatoEntity> findByNomeIgnoreCaseContaining(String nome);
}
