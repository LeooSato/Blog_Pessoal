package org.generation.BlogPessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Postagens")
public class postagem {
    private long ID;
    private String Titulo;
    private String Texto;
    private Date date = new java.sql.Date(System.currentTimeMillis());
    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }


    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getID() {
        return ID;
    }

    @NotNull
    @Size(min = 10, max = 500,message = "Texto com tamanho errado tente entre 10 a 500")
    public String getTitulo() {
        return Titulo;
    }

    @NotNull
    @Size(min = 10, max = 500, message = "Texto com tamanho errado tente entre 10 a 500")
    public String getTexto() {
        return Texto;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setTexto(String texto) {
        Texto = texto;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
