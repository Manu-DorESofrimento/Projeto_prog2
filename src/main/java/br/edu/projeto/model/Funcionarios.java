package br.edu.projeto.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

public class Funcionarios {
	//Chave primária da tabela
    @Id
    //Gerada automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Nome da coluna na tabela, necessário indicar quando atributo não tiver o mesmo nome
    @Column(name = "id_funcionario")
    private Integer id;
    
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "O nome não pode conter digitos.")
    private String Nome;

    @NotNull
    @NotEmpty
    @CPF(message="Insira um CPF Valido")
    @Column(unique = true)
    private String CPF;
    
    @NotNull(message = "Não pode ser vazio")
    @NotEmpty(message = "Não pode ser vazio")
    private String Telefone;
    
    @Email(message="Insira um e-mail valido")
    private String Email;
    
    @NotNull(message = "Não pode ser vazio")
    @NotEmpty(message = "Não pode ser vazio")
    private String Profissao;

    @NotNull
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private String Data_nascimento;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getProfissao() {
		return Profissao;
	}

	public void setProfissao(String profissao) {
		Profissao = profissao;
	}

	public String getData_nascimento() {
		return Data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		Data_nascimento = data_nascimento;
	}
    
    
    
}
