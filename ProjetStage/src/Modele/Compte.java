package Modele;
public class Compte{
    private String mail;
    private String motPasse;
    public String getMail(){
        return mail;
    }
    public String getMotPasse(){
        return motPasse;
    }
    public void setMail(String email){
        this.mail =email;
    }
    public void setMotPasse(String motDePasse){
        this.motPasse= motDePasse;
    }
}
