package br.edu.prova.emanuel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="profissional")
public class Profissional {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequencia")
    @SequenceGenerator(name="sequencia_prof", sequenceName="prof_seq", initialValue = 1, allocationSize = 1)
	private Integer id_profissional;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Pattern(regexp= "[^0-9]*", message="O nome nao pode conter numeros.")
	@Size(min=3, max=30, message="O nome nao pode ter menos que 3 letras e mais que 30 letras.")
	private String nome;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Pattern(regexp="[^a-zA-Z]*", message="O cpf nao pode conter letras.")
	private String cpf;
	
	@Email(message="insira um e-mail válido")
	private String email;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	private String profissao;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Size(min = 8,max=11, message="O telefone deve ter entre 8 a 11 numeros.")
	private String telefone;
	
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	private String data_nascimento;	
	
	public Integer getId_profissional() {
		return id_profissional;
	}

	public void setId_profissional(Integer id_profissional) {
		this.id_profissional = id_profissional;
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

	

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	
	
	
	
	
	
	
}
