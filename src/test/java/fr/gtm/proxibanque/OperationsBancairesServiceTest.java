package fr.gtm.proxibanque;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;

import fr.gtm.proxibanque.business.CompteException;
import fr.gtm.proxibanque.domain.CarteBleue;
import fr.gtm.proxibanque.domain.Chequier;
import fr.gtm.proxibanque.domain.Compte;

public class OperationsBancairesServiceTest {

	private OperationsBancaires app;

	@Before
	public void initializeApp() {
		this.app = new OperationsBancaires();

	}

	/* test sur retrait si montant à retirer est superieur au solde */
	@Test
	public void testRetraitLiquideSupSolde() {

		Compte cp = new Compte(122222256478L, LocalDate.parse("2018-01-02"), 250d, "COMPTE_COURANT");
		try {
			app.retraitLiquide(cp, 300d);
			fail("Votre solde est suffisant");
		} catch (CompteException e) {
			assert (e.getMessage().contains("Votre solde est insuffisant"));
		}

	}

	/* test si montant à retirer est supérieur à 300 euros */
	@Test
	public void testRetraitLiquideSup300() {

		Compte cp = new Compte(122222256478L, LocalDate.parse("2018-01-02"), 250d, "COMPTE_COURANT");
		try {
			app.retraitLiquide(cp, 400d);
			fail("Vous retirez moins de 300 euros");
		} catch (CompteException e) {
			assert (e.getMessage().contains("Vous ne pouvez pas retirer plus de 300 euros"));
		}
	}

	/* test retrait carte sur un compte n'ayant pas encore de carte */
	@Test
	public void testRetraitCarteNonExistante() {
		Compte compte = new Compte(122222256478L, LocalDate.parse("2018-01-02"), 250d, "COMPTE_COURANT");

		try {
			app.retraitCarte(compte, "VISA_ELECTRON");
		} catch (CompteException e) {
			assert (e.getMessage().contains("Vous ne pouvez pas retirer une carte avant son expiration"));
		}
	}

	/* test sur retrait carte non expirée */
	@Test
	public void testRetraitCarteNonExpire() {
		Compte compte = new Compte(122222256478L, LocalDate.parse("2020-01-02"), 250d, "COMPTE_COURANT");
		CarteBleue cb = new CarteBleue(1234567893256471L, "VISA_PREMIER", LocalDate.parse("2019-07-02"));
		compte.setCarteBleue(cb);

		try {
			app.retraitCarte(compte, "VISA_ELECTRON");
			fail("Vous retirez une carte non expiré");
		} catch (CompteException e) {
			assert (e.getMessage()
					.contains("Impossible d’effectuer le retrait, votre ancienne carte est encore valide"));
		}
	}

	/* test sur retrait carte expirée */
	@Test
	public void testRetraitCarteExpire() {
		Compte compte = new Compte(122222256478L, LocalDate.parse("2020-01-02"), 250d, "COMPTE_COURANT");
		CarteBleue cb = new CarteBleue(1234567893256471L, "VISA_PREMIER", LocalDate.parse("2018-06-02"));
		compte.setCarteBleue(cb);

		try {
			app.retraitCarte(compte, "VISA_ELECTRON");
		} catch (CompteException e) {
			assert (e.getMessage()
					.contains("Impossible d’effectuer le retrait, votre ancienne carte est encore valide"));
		}
	}

	/* test sur retrait chequier sur compte n'ayant pas encore de chequier */
	@Test
	public void testRetraitChequierNonExistant() {

		Compte compte = new Compte(122222256478L, LocalDate.parse("2018-01-02"), 250d, "COMPTE_COURANT");
		try {
			app.retraitChequier(compte);
		} catch (CompteException e) {
			assert (e.getMessage().contains("Vous ne pouvez pas retirer un chequier à moins de 3 mois"));
		}
	}

	/* test sur retrait chequier à moins de mois */
	@Test
	public void testRetraitChequierMoins3Mois() {

		Compte compte = new Compte(122222256478L, LocalDate.parse("2020-01-02"), 250d, "COMPTE_COURANT");
		Chequier chequier = new Chequier(LocalDate.parse("2018-06-02"), LocalDate.parse("2018-06-10"));
		compte.setChequier(chequier);
		LocalDate dateValide = compte.getChequier().getDateReception().plus(3, ChronoUnit.MONTHS);

		try {
			app.retraitChequier(compte);
		} catch (CompteException e) {
			assert (e.getMessage().contains(
					"Impossible d’effectuer le retrait d’un nouveau chéquier pour ce compte avant le " + dateValide));
		}
	}

	/* test sur retrait chequier à plus de 3 mois */
	@Test
	public void testRetraitChequierPlus3Mois() {

		Compte compte = new Compte(122222256478L, LocalDate.parse("2020-01-02"), 250d, "COMPTE_COURANT");
		Chequier chequier = new Chequier(LocalDate.parse("2018-01-02"), LocalDate.parse("2018-01-10"));
		compte.setChequier(chequier);
		LocalDate dateValide = compte.getChequier().getDateReception().plus(3, ChronoUnit.MONTHS);

		try {
			app.retraitChequier(compte);
		} catch (CompteException e) {
			assert (e.getMessage().contains(
					"Impossible d’effectuer le retrait d’un nouveau chéquier pour ce compte avant le " + dateValide));
		}
	}

}
