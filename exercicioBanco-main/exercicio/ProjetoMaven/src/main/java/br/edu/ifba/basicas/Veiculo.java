package br.edu.ifba.basicas;



import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Veiculo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    private String montadora;

    public Veiculo() {}

    public Veiculo(String modelo, String montadora) {
        this.modelo = modelo;
        this.montadora = montadora;
    }

    @ManyToMany(mappedBy = "veiculos")
    private Set<Servico> servisos = new HashSet<>();


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public Set<Servico> getServicos() {
        return servisos;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", modelo=" + modelo + ", montadora=" + montadora + ", servisos=" + servisos + "]";
    }

   
}
