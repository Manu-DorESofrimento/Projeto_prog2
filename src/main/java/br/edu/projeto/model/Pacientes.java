package br.edu.projeto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

//Anotação que indica classe modelada pelo OCR - JPA (Hibernate)
@Entity
public class Pacientes {

	//Chave primária da tabela
    @Id
    //Gerada automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Nome da coluna na tabela, necessário indicar quando atributo não tiver o mesmo nome
    @Column(name = "id_paciente")
    private Integer id;

    //Indica validações e mensagens de erro para atributo
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "O nome não pode conter digitos.")
    private String Nome;

    @NotNull
    @NotEmpty
    @CPF(message="Insira um CPF Valido")
    @Column(unique = true)
    private String CPF;
    
    @NotNull
    @NotEmpty
    @Size(max=7,min=7,message = "Insira um RG válido")
    @Pattern(regexp = "[^a-Z]*", message=("Somente numeros"))
    private String RG;
    
    @NotNull(message = "Não pode ser vazio")
    @NotEmpty(message = "Não pode ser vazio")
    private String Endereco;
    
    @NotNull(message = "Não pode ser vazio")
    @NotEmpty(message = "Não pode ser vazio")
    private String Telefone;
    
    @NotNull
    @NotEmpty
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private String Data_nascimento;
    
    @Pattern(regexp = "[^0-9]*", message = "O nome não pode conter digitos.")
    private String Med_solicit;
    
    private String Prev_diag;
    
    private String Hist_doencas;

    private String Cirurgias_reali;

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

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public String getData_nascimento() {
		return Data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		Data_nascimento = data_nascimento;
	}

	public String getMed_solicit() {
		return Med_solicit;
	}

	public void setMed_solicit(String med_solicit) {
		Med_solicit = med_solicit;
	}

	public String getPrev_diag() {
		return Prev_diag;
	}

	public void setPrev_diag(String prev_diag) {
		Prev_diag = prev_diag;
	}

	public String getHist_doencas() {
		return Hist_doencas;
	}

	public void setHist_doencas(String hist_doencas) {
		Hist_doencas = hist_doencas;
	}

	public String getCirurgias_reali() {
		return Cirurgias_reali;
	}

	public void setCirurgias_reali(String cirurgias_reali) {
		Cirurgias_reali = cirurgias_reali;
	}
    
    
}
    