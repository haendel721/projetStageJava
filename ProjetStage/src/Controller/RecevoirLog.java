package Controller;

import View.Login;
import Modele.Compte;

public class RecevoirLog {
    public void recevoir(String Mail, String motPasse){
        Compte compte = new Compte();
        compte.setMail(Mail);
        compte.setMotPasse(motPasse);
        System.out.println(compte.getMail() +" "+compte.getMotPasse());
    }
}
