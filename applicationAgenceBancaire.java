

import java.util.Locale;
import java.util.Scanner;

import application.AccesAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.ABCompteDejaExistantException;
import banque.exception.ABCompteInexistantException;
import banque.exception.ABCompteNullException;
import banque.exception.CompteException;

public class ApplicationAgenceBancaire {

	/**
	 * Affichage du menu de l'application
	 * @param ag	AgenceBancaire pour r�cup�rer le nom et la localisation
	 */
	public static void afficherMenu(AgenceBancaire ag) {
		System.out.println("Menu de " + ag.getNomAgence() + " (" + ag.getLocAgence() + ")");
		System.out.println("l - Liste des comptes de l'agence");
		System.out.println("v - Voir un compte (par son num�ro)");
		System.out.println("p - voir les comptes d'un Propri�taire (par son nom)");
		System.out.println("o - Menu des opération sur comptes");
		System.out.println("g - Menu gestion des comptes");

		System.out.println("q - Quitter");
		System.out.print("Choix -> ");
	}
	public static void afficherMenuOpe(AgenceBancaire ag) {
		String choix2;
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);


		String nom, numero;
		Compte c;
		double montant;

		System.out.println("Menu des operation de comptes");
		System.out.println("d - Deposer de l'argent sur un compte");
		System.out.println("r - Retirer de l'argent sur un compte");
		System.out.println("q - Quitter");
		System.out.print("Choix -> ");


		choix2 = lect.next();
		choix2 = choix2.toLowerCase();
		switch (choix2){
			case "d":
				System.out.print("Num compte -> ");
				numero = lect.next();
				System.out.print("Montant � deposer -> ");
				montant = lect.nextDouble();
				ApplicationAgenceBancaire.deposerSurUnCompte(ag, numero, montant);
				ApplicationAgenceBancaire.tempo();
				break;
			case "r":
				System.out.print("Num compte -> ");
				numero = lect.next();
				System.out.print("Montant � retirer -> ");
				montant = lect.nextDouble();
				ApplicationAgenceBancaire.retirerSurUnCompte(ag, numero, montant);
				ApplicationAgenceBancaire.tempo();
				break;
			case "q":
				ApplicationAgenceBancaire.afficherMenu(ag);
				break;
		}

	}
	public static void afficherMenCompte(AgenceBancaire ag) {
		String choix3;
		Scanner lect;
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);


		String nom, numero;
		Compte c;
		double montant;

		System.out.println("Menu de Gestion des comptes");
		System.out.println("a - Ajouter un compte");
		System.out.println("s - Supprimer un compte");
		System.out.println("q - Quitter");
		System.out.print("Choix -> ");


		choix3 = lect.next();
		choix3 = choix3.toLowerCase();
		switch (choix3){
			case "a":
				System.out.print("Num compte -> ");
				numero = lect.next();
				System.out.print("Nom du propri -> ");
				nom = lect.next();
				c = new Compte(numero,nom);
				try {
					ag.addCompte(c);
					System.out.println("Compte ajouter");
				} catch (ABCompteNullException e) {
					e.printStackTrace();
				} catch (ABCompteDejaExistantException e) {
					e.printStackTrace();
				}
				ApplicationAgenceBancaire.tempo();
				break;
			case "s":
				System.out.print("Num compte -> ");
				numero = lect.next();
				try {
					ag.removeCompte(numero);
					System.out.println("Compte supprimer");
				} catch (ABCompteInexistantException e) {
					e.printStackTrace();
				}
				ApplicationAgenceBancaire.tempo();
				break;
			case "q":
				ApplicationAgenceBancaire.afficherMenu(ag);
				break;
		}

	}

	
	/**
	 * Temporisation : Affiche un message et attend la frappe de n'importe quel caract�re.
	 */
	public static void tempo () {
		Scanner lect ;
		
		lect = new Scanner (System.in );
		
		System.out.print("Tapper un car + return pour continuer ... ");
		lect.next(); // Inutile � stocker mais ... 
	}

	public static void main(String argv[]) {
		
		String choix;

		AgenceBancaire monAg = AccesAgenceBancaire.getAgenceBancaire();
		boolean continuer ;
		Scanner lect;
		
		String nom, numero;		
		Compte c;
		double montant;
		
		lect = new Scanner ( System.in );
		lect.useLocale(Locale.US);
		

		
		continuer = true;
		while (continuer) {
			ApplicationAgenceBancaire.afficherMenu(monAg);
			choix = lect.next();
			choix = choix.toLowerCase();
			switch (choix) {
				case "q" :
					System.out.println("ByeBye");
					ApplicationAgenceBancaire.tempo();
					continuer = false;
					break;
				case "l" :
					monAg.afficher();
					ApplicationAgenceBancaire.tempo();
					break;	
				case "v" :
					System.out.print("Num compte -> ");
					numero = lect.next();
					c = monAg.getCompte(numero);
					if (c==null) {
						System.out.println("Compte inexistant ...");
					} else {
						c.afficher();
					}
					ApplicationAgenceBancaire.tempo();
					break;
				case "p" :
					System.out.print("Proprietaire -> ");
					nom = lect.next();
					ApplicationAgenceBancaire.comptesDUnPropretaire (monAg, nom);
					ApplicationAgenceBancaire.tempo();
					break;
				case "o" :
					ApplicationAgenceBancaire.afficherMenuOpe(monAg);
					break;
				case "g" :
					ApplicationAgenceBancaire.afficherMenCompte(monAg);
					break;
				default :
					System.out.println("Erreur de saisie ...");
					ApplicationAgenceBancaire.tempo();
					break;
			}
		}
		
	}
	
	public static void comptesDUnPropretaire (AgenceBancaire ag, String nomProprietaire) {
		Compte []  t; 
		
		t = ag.getComptesDe(nomProprietaire);
		if (t.length == 0) {
			System.out.println("pas de compte � ce nom ...");
		} else {
			System.out.println("  " + t.length + " comptes pour " + nomProprietaire);
			for (int i=0; i<t.length; i++)
				t[i].afficher();
		}
	}

	public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant d�p�t: "+c.soldeCompte());
			try {
				c.deposer(montant);
				System.out.println("Montant d�pos�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
		Compte c;
		
		c = ag.getCompte(numeroCompte);
		if (c==null) {
			System.out.println("Compte inexistant ...");
		} else {
			System.out.println("Solde avant retrait : " + c.soldeCompte());
			try {
				c.retirer(montant);
				System.out.println("Montant retir�, solde : "+c.soldeCompte());
			} catch (CompteException e) {
				System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
				System.out.println(e.getMessage());
			}
		}

	}
}
