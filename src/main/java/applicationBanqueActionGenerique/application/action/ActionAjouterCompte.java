package applicationBanqueActionGenerique.application.action;

import applicationBanqueActionGenerique.action.Action;
import applicationBanqueActionGenerique.banque.AgenceBancaire;
import applicationBanqueActionGenerique.banque.Compte;

import java.util.Scanner;

public class ActionAjouterCompte implements Action {

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
