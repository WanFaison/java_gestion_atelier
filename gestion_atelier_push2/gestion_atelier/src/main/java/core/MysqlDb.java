package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MysqlDb implements IDatabase {
    protected Connection connex;
    protected PreparedStatement ps;

    @Override
    public void openConnexionDb() {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creer l'objet connexion 
            Connection connex = DriverManager.getConnection("jdbc:mysql://localhost:3306/java/mvc1", "root", "");
        } catch (SQLException e){
            e.printStackTrace();
        }
         catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnextionDb() {
        if(connex!=null){
            try {
                connex.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
