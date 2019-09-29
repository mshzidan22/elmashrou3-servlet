/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MshzidanPC
 */
public class viewAnswers extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        //logic
      String  question_id =request.getParameter("question_id");
        System.out.println("the question_id is "+question_id);
      select select = new select();
     ResultSet rs = select.connect("select * from questions where question_id ="+question_id);
        
       rs.next();
       String title=rs.getString(2);
       String question=rs.getString(3); 
       
       String user_id =rs.getString(6);
       
       select select2 = new select();
     ResultSet rs2 = select2.connect("select name from users where user_id ="+user_id);
     rs2.next();
     String nameElSaal =rs2.getString(1);
     
     select select3 = new select();
     ResultSet rs3 = select3.connect("select * from answers  where question_id ="+question_id);
     ///while
     
     
    //
     select select4 = new select();
    
     
     
       
        
             
        //presentation
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet viewAnswers</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> " +title + "</h1>");
            out.println("<h1> " +rs.getString(4) + "</h1>");
            out.println("<h2> " + question+ "</h2>");
            out.println("<h3>By " + nameElSaal+ "</h3>");
            out.println("------------------------------------------------------------------------------------");
            
            while(rs3.next()){
           out.println("<div>");
           
           out.println("------------------------------------------------------------------------------------");
           String answer = rs3.getString("answer");
           
           String user_idElgawib = rs3.getString(6);
           ResultSet rs4 = select4.connect("select name from users where user_id ="+user_idElgawib);
           rs4.next();
           String nameElGawib =rs4.getString(1);
           
           
           out.println("<p>"+nameElGawib+"</p>");
           out.println("<p>"+answer+"</p>");
           out.println("<p>"+rs3.getString(3)+"</p>");
           
           
           out.println("<div>");
           
           
           
           
           
           }
            
            
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(viewAnswers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(viewAnswers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
