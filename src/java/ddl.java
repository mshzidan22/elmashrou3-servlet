
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class ddl {
    
      public void connect (String sql){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
             Connection  conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","mshzidan","mshzidan");
             PreparedStatement stmt =conn.prepareStatement(sql);
             stmt.executeUpdate();
             conn.commit();
             stmt.close();
             conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ddl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ddl.class.getName()).log(Level.SEVERE, null, ex);
        }
    

      

}

}
