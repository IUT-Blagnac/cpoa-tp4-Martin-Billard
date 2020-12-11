package applicationBanqueBancaireAbstraiteUnPeu.application.action;

import applicationBanqueBancaireAbstraiteUnPeu.action.Action;
import applicationBanqueBancaireAbstraiteUnPeu.banque.AgenceBancaire;
import applicationBanqueBancaireAbstraiteUnPeu.banque.Compte;

import java.util.Scanner;

public class ActionAjouterCompte implements Action<AgenceBancaire> {

    private String message;
    private String code;

    public ActionAjouterCompte(String code) {
        this.message = "Ajouter un compte";
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(AgenceBancaire ag) throws Exception {
        System.out.println("Saisir le numéro du compte:");
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        System.out.println("Saisir le propriétaire");

        String prop = scan.nextLine();

        Compte c = new Compte(num,prop);
        ag.addCompte(c);

    }
}
