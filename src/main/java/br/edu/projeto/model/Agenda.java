package br.edu.projeto.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Agenda {
	//Chave primária da tabela
    @Id
    //Gerada automaticamente pelo banco
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Nome da coluna na tabela, necessário indicar quando atributo não tiver o mesmo nome
    @Column(name = "id_consulta")
    private Integer id;
    
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "O nome não pode conter digitos.")
    private String Nome_paciente;
    
    @NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "O nome não pode conter digitos.")
    private String Nome_profissional;
    
    @NotNull
    @NotEmpty
    @Pattern(regexp = "HH:MM")
    private String Horario;
    
    @NotNull
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private String Data;
    
    @NotNull
    @NotEmpty
    private String Pagamento;
    
    
    @NotNull
    private Boolean Controle;
    
}
