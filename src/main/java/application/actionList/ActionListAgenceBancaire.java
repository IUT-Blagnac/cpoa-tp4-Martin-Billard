package application.actionList;

import action.Action;
import action.ActionList;
import banque.AgenceBancaire;

import java.util.ArrayList;
import java.util.Scanner;

public class ActionListAgenceBancaire implements ActionList<AgenceBancaire> {

    String message, code, title;
    ArrayList<Action> listeactions;

    public ActionListAgenceBancaire(String code, String title,String message) {
        this.message = message;
        this.code = code;
        this.title = title;
        this.listeactions= new ArrayList<Action>();
    }

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return listeactions.size();
    }

    @Override
    public boolean addAction(Action ac) {
        if(!(this.listeactions.contains(ac)))
            return listeactions.add(ac);
        return false;
    }

    @Override
    public boolean remove(Action ac) {
        if(this.listeactions.contains(ac))
            return listeactions.remove(ac);
        return false;
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
        Scanner lect;
        String choix;
        lect = new Scanner(System.in);

        Boolean continuer =true;
        while(continuer) {
            System.out.println(this.title);
            System.out.println(this.message);

            for(Action act : listeactions) {
                System.out.println(act.actionCode() +" - "+ act.actionMessage());
            }
            System.out.println("0 - Quitter");

            choix=lect.next();

            boolean isFound = false;
            for (Action action : listeactions){
                if(action.actionCode().equals(choix)){
                    action.execute(ag);
                    isFound=true;
                    break;
                }
            }
            if(choix.equals("0")){
                System.out.println("ByeBye");
                continuer = false;
                break;
            }
            if (!isFound){
                System.out.println("Aucun choix ne correspond à ce que vous avez saisie");
            }

        }
    }
}
