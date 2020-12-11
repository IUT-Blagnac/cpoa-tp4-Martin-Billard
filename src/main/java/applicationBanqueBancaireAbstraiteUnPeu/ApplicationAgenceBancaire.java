package applicationBanqueBancaireAbstraiteUnPeu;

import applicationBanqueBancaireAbstraiteUnPeu.action.ActionList;
import applicationBanqueBancaireAbstraiteUnPeu.application.AccesAgenceBancaire;
import applicationBanqueBancaireAbstraiteUnPeu.application.action.*;
import applicationBanqueBancaireAbstraiteUnPeu.application.actionList.ActionListAgenceBancaire;
import applicationBanqueBancaireAbstraiteUnPeu.banque.AgenceBancaire;

public class ApplicationAgenceBancaire {


	public static void main(String argv[]) {

		AgenceBancaire ag = AccesAgenceBancaire.getAgenceBancaire();
		ActionList al = new ActionListAgenceBancaire(null,"Agence CAISSE ECUREUIL de PIBRAC","Menu général");
		al.addAction(new ActionListeDesComptes("1"));
		al.addAction(new ActionVoirCompteNumero("2"));


		ActionList al1 = new ActionListAgenceBancaire("3","Menu Gestion Compte","Menu Gestion Compte");
		al1.addAction(new ActionAjouterCompte("1"));
		al1.addAction(new ActionSupprimerCompte("2"));
		al.addAction(al1);

		ActionList al2 = new ActionListAgenceBancaire("4","Menu Operation Compte","Menu Operation Compte");
		al2.addAction(new ActionDeposerArgent("1"));
		al2.addAction(new ActionRetirerArgent("2"));
		al.addAction(al2);

		try {
			al.execute(ag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
