package org.generation.BlogPessoal.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.generation.BlogPessoal.model.Postagem;
@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size( min = 2, max = 100)
	private String nome;
	@NotNull(message = "O Usuário é obrigatório")
	private String usuario;
	@NotNull(message = "A senha é obrigatória")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	private String senha;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
}
