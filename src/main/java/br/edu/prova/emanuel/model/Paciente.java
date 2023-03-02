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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="paciente")
public class Paciente {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sequencia")
    @SequenceGenerator(name="sequencia", sequenceName="paciente_seq", initialValue = 1, allocationSize = 1)
	private Integer id_paciente;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Pattern(regexp= "[^0-9]*", message="O nome nao pode conter numeros.")
	@Size(min=3, max=30, message="O nome nao pode ter menos que 3 letras e mais que 30 letras.")
	private String nome;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Pattern(regexp="[^a-zA-Z]*", message="O cpf nao pode conter letras.")
	private String cpf;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	private String rg;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	@Size(min = 8,max=11, message="O telefone deve ter entre 8 a 11 numeros.")
	private String telefone;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	private String endereco;
	
	@NotNull(message="Não pode ser vazio, por favor preencha")
	@NotEmpty(message="Não pode ser vazio, por favor preencha")
	private String data_nascimento;	
	
	private String med_solicitante;
	
	private String diagnostico_prev;
	
	private String cirurgias_realizadas;
	
	private String historico_doencas;

	public Integer getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getMed_solicitante() {
		return med_solicitante;
	}

	public void setMed_solicitante(String med_solicitante) {
		this.med_solicitante = med_solicitante;
	}

	public String getDiagnostico_prev() {
		return diagnostico_prev;
	}

	public void setDiagnostico_prev(String diagnostico_prev) {
		this.diagnostico_prev = diagnostico_prev;
	}

	public String getCirurgias_realizadas() {
		return cirurgias_realizadas;
	}

	public void setCirurgias_realizadas(String cirurgias_realizadas) {
		this.cirurgias_realizadas = cirurgias_realizadas;
	}

	public String getHistorico_doencas() {
		return historico_doencas;
	}

	public void setHistorico_doencas(String historico_doencas) {
		this.historico_doencas = historico_doencas;
	}

	
	
	
	
	
	
}
