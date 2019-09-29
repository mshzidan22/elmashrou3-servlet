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
import javax.servlet.http.HttpSession;

/**
 *
 * @author MshzidanPC
 */
public class home extends HttpServlet {
ResultSet rs2 = null ;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Logic
        
        
    String name =request.getParameter("name");
    String password = request.getParameter("password");
    HttpSession session = request.getSession();
    session.setAttribute("name", name);
    session.setAttribute("password", password);
    select select = new select();
    ResultSet rs = select.connect("select * from questions");
    
        try {
            rs.next();
     rs2 = select.connect("select name from users where user_id = " +rs.getString("user_id"))  ;   
    rs2.next();
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   
     
        
        
        
        
        //Presetation
        PrintWriter out = response.getWriter();
        try {
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Home </title>");            
            out.println("</head>");
            out.println("<body>");
            //begining
            out.println("        <div>welcome "+name+"  </div>");
            out.println("        <div><a href = 'askPage.html' >ASk your Question</a></div> ");
            
            while(rs.next()){
            
                
            out.println("<div>");
            out.println("----------------------------------------------------------------------------------");
            out.println("<form action='http://localhost:8084/Elmashro3/questionAnsServ' method = 'get'>");
            out.println("title = "+rs.getString("title") +"<br>");
            out.println("askedby ="+rs2.getString(1) +"<br>");
            out.println("date = "+rs.getString(4) +"<br>");
            out.println("view = "+rs.getString(5) +"<br>");
            out.println("<input type='hidden' name='question_id' value='"+rs.getString(1) +"' /><br>");
            out.println(" <input type='submit' value='Answer' />");
            out.println("</form>");
            out.println("<form action='http://localhost:8084/Elmashro3/viewAnswers' method='get'>");
            out.println("<input type='hidden' name='question_id' value='"+rs.getString(1) +"' /><br>");
            out.println(" <input type='submit' value='viewAnswer' />");
            out.println("</form>");
            out.println("-------------------------------------------------------------------------------------");
            out.println("</div>");
            }
            //ending
            
            
            out.println("</body>");
            out.println("</html>");

        
        
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
