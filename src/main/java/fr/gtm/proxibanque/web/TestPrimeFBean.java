package fr.gtm.proxibanque.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.gtm.proxibanque.business.OperationsBancairesService;
import fr.gtm.proxibanque.domain.Compte;

@ManagedBean
@ViewScoped
public class TestPrimeFBean {
	private List<Compte> comptes;

	@ManagedProperty("#{operationsBancairesService}")
	private OperationsBancairesService service;

	public List<Compte> getComptes() {
		return this.comptes;
	}

	/**
	 * @return the service
	 */
	public OperationsBancairesService getService() {
		return this.service;
	}

	@PostConstruct
	public void init() {
		this.comptes = this.service.findComptes(1);
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(final OperationsBancairesService service) {
		this.service = service;
	}
}
