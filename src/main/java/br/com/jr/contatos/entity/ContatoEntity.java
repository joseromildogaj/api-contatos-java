package br.com.jr.contatos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "db_contato")
public class ContatoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Informe o nome")
	@Size(min = 3, max = 100, message = "O nome deve ter no mínimo 3 caracteres")
	@Column(nullable = false, length = 100)
	private String nome;

	@NotBlank(message = "Informe o telefone")
	@Size(min = 11, max = 11, message = "O telefone deve ter 11 caracteres")
	@Column(nullable = false, length = 11)
	private String fone;

	@Email(message = "Email inválido")
	@Column(nullable = true, unique = true, length = 100)
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


}
