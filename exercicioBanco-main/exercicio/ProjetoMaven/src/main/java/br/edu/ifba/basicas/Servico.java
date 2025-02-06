package br.edu.ifba.basicas;



import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false) 
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "Historico_Servico",
        joinColumns = @JoinColumn(name = "veiculo_id"),
        inverseJoinColumns = @JoinColumn(name = "servico_id")
    )
    private Set<Veiculo> servicos = new HashSet<>();

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   
}