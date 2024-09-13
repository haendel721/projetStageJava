package Controller;

import org.json.JSONObject;

public class AnalyseJson {
    public void analye(){
        String reponse=null,nomJson,motPasseJson;
        //reponse fichier json
        reponse =reponse.replace("[","");
        String jsonReponse =reponse.toString();
        try {
            JSONObject jsonObject = new JSONObject(jsonReponse);
//            nomJson=jsonObject.getString("adrMail");
//            motPasseJson=jsonObject.getString("motPasse");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}