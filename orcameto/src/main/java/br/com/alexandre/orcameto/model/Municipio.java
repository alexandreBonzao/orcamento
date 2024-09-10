package br.com.alexandre.orcameto.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Municipio")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "municipio")
    private List<Cliente> clientelista = new ArrayList<>();
    private String nome;
    private String estado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEtado() {
        return estado;
    }

    public void setEtado(String etado) {
        this.estado = etado;
    }

    public List<Cliente> getClientelista() {
        return clientelista;
    }

    public void setClientelista(List<Cliente> clientelista) {
        this.clientelista = clientelista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio municipo = (Municipio) o;
        return id == municipo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
