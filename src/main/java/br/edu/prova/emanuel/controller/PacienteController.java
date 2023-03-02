package br.edu.prova.emanuel.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.prova.emanuel.dao.PacienteDAO;
import br.edu.prova.emanuel.model.Paciente;

@RequestScoped
@Named
public class PacienteController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private PacienteDAO	pacienteDAO;
	
	@Produces
	@Named
	private Paciente novoPaciente;
	
	private List<Paciente> listaPacientes;

	@PostConstruct
	public void inicializarPaciente(){
		novoPaciente = new Paciente();
		listaPacientes = pacienteDAO.findAllHQL();
	}
	
	public void register() throws Exception{
		try {
        	pacienteDAO.save(novoPaciente);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Registro concluido");
            facesContext.addMessage(null, m);
            inicializarPaciente();
        } catch (Exception e) {
            String errorMessage = getMensagemDeErro(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Errou!!!, nao foi possivel registrar");
            facesContext.addMessage(null, m);
        }
	}
	
	private String getMensagemDeErro(Exception e) {
        String errorMessage = "Falha no registro";
        if (e == null) {
            return errorMessage;
        }
        Throwable t = e;
        while (t != null) {
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        return errorMessage;
	}

	public Paciente getNovoPaciente() {
		return novoPaciente;
	}

	public void setNovoPaciente(Paciente novoPaciente) {
		this.novoPaciente = novoPaciente;
	}

	public List<Paciente> getListaPacientes() {
		if (listaPacientes==null) {
			listaPacientes=pacienteDAO.findAllHQL();
		}
		return listaPacientes;
	}

	public void setListaPacientes(List<Paciente> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}
	
	
	
}
