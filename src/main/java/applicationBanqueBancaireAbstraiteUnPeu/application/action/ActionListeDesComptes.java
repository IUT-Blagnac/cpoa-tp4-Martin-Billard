package applicationBanqueBancaireAbstraiteUnPeu.application.action;

import applicationBanqueBancaireAbstraiteUnPeu.action.Action;
import applicationBanqueBancaireAbstraiteUnPeu.banque.AgenceBancaire;

public class ActionListeDesComptes implements Action<AgenceBancaire> {

    String message;
    String code;

    public ActionListeDesComptes(String code) {
        this.message = "Liste des comptes";
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
        ag.afficher();
    }
}
