package Controller;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Modele.*;
import View.Site;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class RequeteLogin {
    public final String nomdb = "user";
    public String requteToDb(String adrMail){
        DBconnection db = new DBconnection();
        Statement stmt;
        ResultSet rst;
        Connection conn;
        Compte compte = new Compte();
        String query ="select email , password from "+nomdb+" where email = '"+adrMail+"'";
        try {
            conn = db.connect_to_db();
            stmt = conn.createStatement();
            rst = stmt.executeQuery(query);
            while (rst.next()){
                compte.setMail(rst.getString("email"));
                compte.setMotPasse(rst.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(compte.getMotPasse());
        return compte.getMotPasse();
    }
    public boolean iscompteExiste(String adrMail){
        Boolean result=false;
        DBconnection db = new DBconnection();
        Connection conn= db.connect_to_db();
        Statement stmt;
        RequeteLogin rq = new RequeteLogin();
        String valMail=null;
        String query ="select email from "+nomdb+" where email = '" + adrMail + "'";
        try {
            conn = db.connect_to_db();
            stmt = conn.createStatement();
            ResultSet rst = stmt.executeQuery(query);
            while (rst.next()){
                valMail = rst.getString("email");
            }
            if(!(valMail == null)){
                result = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}