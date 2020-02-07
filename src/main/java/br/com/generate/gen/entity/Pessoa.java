package br.com.generate.gen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int idade;
	private String cpf;
	private String rg;
	private String data_nasc;
	private String signo;
	private String mae;
	private String pai;
	private String email;
	private String senha;
	private String cep;
	private String endereco;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefone_fixo;
	private String celular;
	private String altura;
	private float peso;
	private String tipo_sanguineo;
	private String cor;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getData_nasc() {
		return data_nasc;
	}

	public String getSigno() {
		return signo;
	}

	public String getMae() {
		return mae;
	}

	public String getPai() {
		return pai;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public int getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getTelefone_fixo() {
		return telefone_fixo;
	}

	public String getCelular() {
		return celular;
	}

	public String getAltura() {
		return altura;
	}

	public float getPeso() {
		return peso;
	}

	public String getTipo_sanguineo() {
		return tipo_sanguineo;
	}

	public String getCor() {
		return cor;
	}

}
