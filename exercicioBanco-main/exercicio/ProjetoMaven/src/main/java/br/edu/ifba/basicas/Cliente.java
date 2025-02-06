package br.edu.ifba.basicas;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String cpf;
	private String rg;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = false)
	private Funcionario categoria;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Servico> vendas = new HashSet<>();

	public Cliente(int id, String nome, String cpf, String rg, Funcionario categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.categoria = categoria;
	}
	


	public Cliente() {}

	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Funcionario getCategoria() {
		return categoria;
	}

	public void setCategoria(Funcionario categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", endereco=" + endereco.getRua()
				+  "]";
	}


	

}
