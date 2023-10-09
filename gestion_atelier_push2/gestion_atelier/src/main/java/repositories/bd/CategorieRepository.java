package repositories.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import core.MysqlDb;
import entities.Categorie;
import repositories.IRepository;
import repositories.ITables;

public class CategorieRepository extends MysqlDb implements IRepository<Categorie>{

    private final String sql_insert="INSERT INTO `Categorie` (`libelle`) VALUES (?);";
    private final String sql_select="SELECT * FROM `Categorie`";
    private final String sql_findById="SELECT `id`, `libelle` FROM `Categorie` WHERE ?";

    @Override
    public Categorie insert(Categorie data) {
        this.openConnexionDb();
        try {
            ps=connex.prepareStatement(sql_insert,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,data.getLibelle()); 
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                data.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnextionDb();

        return data;
    }

    @Override
    public Categorie update(Categorie data) {
        Categorie categories=null;;
        this.openConnexionDb();
        try{
            ps= connex.prepareStatement(sql_select);
            ps.setString(0, sql_select);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                categories = new Categorie(rs.getInt("id"),rs.getString("libelle"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnextionDb();
        return null;
    }

    @Override
    public ArrayList<Categorie> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Categorie findById(int id) {
        Categorie categorie=null;
        this.openConnexionDb();
        try{
            ps=connex.prepareStatement(sql_findById);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                categorie=new Categorie(
                    rs.getInt("id"),rs.getString("libelle")
                    );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        this.closeConnextionDb();
        return categorie;
    }

    @Override
    public Categorie delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Categorie indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    
    // public ArrayList<Categorie> findAll(){
    //     ArrayList<Categorie> categories = new ArrayList<>();
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         try {
    //             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
    //             Statement statement = conn.createStatement();
    //             ResultSet resultat = statement.executeQuery("SELECT * FROM categorie;");
    //             while (resultat.next()){
    //                 Categorie categorie = new Categorie(resultat.getInt("id"), resultat.getString("libelle"));
    //                 categories.add(categorie);   
    //             }

    //             conn.close();
    //             resultat.close();
    //         } catch (SQLException e) {
    //             // enter error custom message
    //         }

    //     } catch (ClassNotFoundException e) {
    //         // enter error custom message
    //     }

    //     return null;
    // }
}
