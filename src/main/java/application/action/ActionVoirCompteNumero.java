package application.action;

import action.Action;
import banque.AgenceBancaire;
import banque.Compte;

import java.util.Scanner;

public class ActionVoirCompteNumero implements Action {

    String message;
    String code;

    public ActionVoirCompteNumero(String message, String code) {
        this.message = message;
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

        String numero;
        Scanner lect;
        lect = new Scanner ( System.in );

        Compte c;

        System.out.print("Num compte -> ");
        numero = lect.next();
        c = ag.getCompte(numero);
        if (c==null) {
            System.out.println("Compte inexistant ...");
        } else {
            c.afficher();
        }

    }
}
