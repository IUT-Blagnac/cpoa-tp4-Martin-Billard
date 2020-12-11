package applicationBanqueBancaireAbstraiteUnPeu.application.action;

import applicationBanqueBancaireAbstraiteUnPeu.action.Action;
import applicationBanqueBancaireAbstraiteUnPeu.banque.AgenceBancaire;

import java.util.Scanner;

public class ActionSupprimerCompte implements Action<AgenceBancaire> {
    private String message;
    private String code;

    public ActionSupprimerCompte(String code) {
        this.message = "Supprimer un compte";
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

        ag.removeCompte(num);
    }

}
