package applicationBanqueActionGenerique.application.action;

import applicationBanqueActionGenerique.action.Action;
import applicationBanqueActionGenerique.banque.AgenceBancaire;

public class ActionListeDesComptes implements Action {

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
