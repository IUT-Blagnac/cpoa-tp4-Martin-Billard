package application.action;

import java.util.Scanner;

import action.Action;
import banque.AgenceBancaire;

public class ActionDeposerArgent implements Action<AgenceBancaire>{

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
