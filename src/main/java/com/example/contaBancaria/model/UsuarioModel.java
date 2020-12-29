package com.example.contaBancaria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table (name = "tb_usuarios", uniqueConstraints={@UniqueConstraint(columnNames={"cpf"})})
public class UsuarioModel {
	
	//ATRIBUTOS 
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@Column
	@NotNull @NotEmpty(message= "Por favor, verifique o campo nome o mesmo não pode ser vazio ou nulo!")
	private String nome;
	
	@Column
	@NotNull @NotEmpty(message= "Por favor, verifique o campo senha o mesmo não pode ser vazio ou nulo!")
	private String senha;
	
	@Column(unique = true)
	@NotNull @NotEmpty(message= "Por favor, verifique o campo email o mesmo não pode ser vazio ou nulo!")
	@Email
	private String email;
	
	@Column(name = "cpf")
	@NotNull @NotEmpty(message= "Por favor, verifique o campo cpf o mesmo não pode ser vazio ou nulo!")
	private String cpf;
	
	@Column
	@NotNull 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	
	
	//MÉTODOS GETTERS AND SETTERS
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	

	
	
	
}
