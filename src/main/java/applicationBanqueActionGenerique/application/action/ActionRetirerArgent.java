package applicationBanqueActionGenerique.application.action;

import applicationBanqueActionGenerique.action.Action;
import applicationBanqueActionGenerique.banque.AgenceBancaire;

import java.util.Scanner;

public class ActionRetirerArgent implements Action {

    String message;
    String code;


    public ActionRetirerArgent(String code) {
        this.message = "Retirer de l'argent";
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
        System.out.println("Saisir numéro du compte:");
        Scanner scan = new Scanner(System.in);
        String num = scan.nextLine();
        System.out.println("Saisir le montant à retirer");
        double montant = scan.nextDouble();


        ag.getCompte(num).retirer(montant);
    }
}
