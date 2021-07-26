package org.generation.BlogPessoal.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Postagens")
public class postagem {
    private long ID;
    private String Titulo;
    private String Texto;
    private Date date = new java.sql.Date(System.currentTimeMillis());


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
    @Size(min = 10, max = 500)
    public String getTitulo() {
        return Titulo;
    }

    @NotNull
    @Size(min = 2, max = 500)
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
