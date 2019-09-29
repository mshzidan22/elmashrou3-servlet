
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MshzidanPC
 */
public class select {
 public  ResultSet rs ;

public ResultSet connect(String sql){
    try {

            Class.forName("oracle.jdbc.OracleDriver");
            Connection  conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","mshzidan","mshzidan");
            PreparedStatement stmt =conn.prepareStatement(sql);
            rs =stmt.executeQuery();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(select.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(select.class.getName()).log(Level.SEVERE, null, ex);
        }
    
return rs ;


}
    
}
