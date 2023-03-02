package br.edu.prova.emanuel.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.prova.emanuel.dao.ProfissionalDAO;
import br.edu.prova.emanuel.model.Profissional;

@RequestScoped
@Named
public class ProfissionalController {
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ProfissionalDAO	profissionalDAO;
	
	@Produces
	@Named
	private Profissional novoProfissional;
	
	private List<Profissional> listaProfissional;

	@PostConstruct
	public void inicializarPaciente(){
		novoProfissional = new Profissional();
		listaProfissional = profissionalDAO.findAllHQL();
	}
	
	public void register() throws Exception{
		try {
			profissionalDAO.save(novoProfissional);
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

	public Profissional getNovoProfissional() {
		return novoProfissional;
	}

	public void setNovoProfissional(Profissional novoProfissional) {
		this.novoProfissional = novoProfissional;
	}

	public List<Profissional> getListaProfissional() {
		if (listaProfissional==null) {
			listaProfissional=profissionalDAO.findAllHQL();
		}
		return listaProfissional;
	}

	public void setListaPacientes(List<Profissional> listaProfissional) {
		this.listaProfissional = listaProfissional;
	}
	
	
	
}
