package org.generation.BlogPessoal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @NotNull
    @Size(min=10,max=100,message = "Nome muito ou muito grande, certifique-se que esta correto")
    private String Nome;
    @NotNull
    @Size(min=4,max=50,message="Muito grande ou muito pequeno")
    private String UserLogin;
    @NotNull
    @Size(min=7,max=20,message="Muito grande ou muito pequeno")
    private String Senha;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getUserLogin() {
        return UserLogin;
    }

    public void setUserLogin(String userLogin) {
        UserLogin = userLogin;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
