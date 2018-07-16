package fr.gtm.proxibanque.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.proxibanque.business.OperationsBancairesService;
import fr.gtm.proxibanque.domain.Compte;

@ManagedBean
@ViewScoped
public class TestPrimeFBean {
	private List<Compte> comptes;

	@Autowired
	OperationsBancairesService service;

	public List<Compte> getComptes() {
		return this.comptes;
	}

	@PostConstruct
	public void init() {
		this.comptes = this.service.findComptes(1);
	}
}
