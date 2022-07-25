package br.com.jr.contatos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_contato")
public class ContatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String fone;

	@Column(nullable = true, unique = true)
	private String email;

	
	public ContatoEntity() {

	}
	

	public ContatoEntity(String nome, String fone, String email) {
		this.nome = nome;
		this.fone = fone;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getFone() {
		return fone;
	}
	

	public void setFone(String fone) {
		this.fone = fone;
	}
	

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "ContatoEntity [id=" + id + ", nome=" + nome + ", fone=" + fone + ", email=" + email + "]";
	}

}
