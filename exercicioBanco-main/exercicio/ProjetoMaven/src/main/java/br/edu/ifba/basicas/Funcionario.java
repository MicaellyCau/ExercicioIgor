package br.edu.ifba.basicas;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Funcionario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String funcao;
	private String nome;
	private String cpf;

	
	@OneToMany(mappedBy = "Hisorico_Servico")
	
	
	public Funcionario(){}
	
	public Funcionario(int id, String funcao, String cpf, String nome ) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
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

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", funcao=" + funcao + ", nome=" + nome + ", cpf=" + cpf + "]";
	}



}
