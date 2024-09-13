package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBconnection {
    public Connection connect_to_db() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/api","root","");
            System.out.println("Connexion établie");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}

