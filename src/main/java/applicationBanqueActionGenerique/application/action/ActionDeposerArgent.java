package applicationBanqueActionGenerique.application.action;

import applicationBanqueActionGenerique.action.Action;
import applicationBanqueActionGenerique.banque.AgenceBancaire;

import java.util.Scanner;

public class ActionDeposerArgent implements Action {

    String message;
    String code;


    public ActionDeposerArgent(String code) {
        this.message = "Déposer de l'argent";
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
        System.out.println("Saisir le montant à déposer");
        double montant = scan.nextDouble();

        ag.getCompte(num).deposer(montant);
    }
}
