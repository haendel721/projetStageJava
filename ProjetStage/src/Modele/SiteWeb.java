package Modele;

public class SiteWeb {
    private  String nomSite,urlSite,idSite,passwordSite,idChampMail,idChampMotPasse;
    public String getNomSite(){
        return nomSite;
    }
    public String getUrlSite(){
        return urlSite;
    }
    public String getIdSite(){
        return idSite;
    }
    public String getPasswordSite(){
        return passwordSite;
    }
    public String getIdChampMail(){
        return idChampMail;
    }
    public String getIdChampMotPasse(){
        return idChampMotPasse;
    }

    public void setNomSite( String NomSite){
        this.nomSite = NomSite;
    }
    public void setUrlSite(String Url){
        this.urlSite= Url;
    }
    public void setIdSite(String Idsite){
        this.idSite=Idsite;
    }
    public void setPasswordSite(String MotPasse){
        this.passwordSite =MotPasse;
    }
    public void setIdChampMail(String Id){
        this.idChampMail = Id;
    }
    public void setIdChampMotPasse(String Mot){
        this.idChampMail = Mot;
    }

}
