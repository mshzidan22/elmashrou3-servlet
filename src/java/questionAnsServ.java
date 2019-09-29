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
public class questionAnsServ extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        //logic
        String question_id =request.getParameter("question_id");
        select select = new select();
       ResultSet rs = select.connect("select title , question from questions where question_id = "+question_id);
       rs.next();
       String title =rs.getString("title");
       String question = rs.getString("question");
       
          HttpSession session = request.getSession();
          String name =(String) session.getAttribute("name");
          
          ddl ddl = new ddl();
          ddl.connect("update questions set views = views + 1 where question_id ="+question_id);
          
         
          
        
        
        
        
        
        
        
        
        
        
        
        //presentation
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>put your answer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + title + "</h1>");
            out.println("<p>" + question + "</p>");
            out.println("<p>welcome " + name + "</p>");
            
            out.println("<div>");
            out.println("<form name = 'takeAnswer' action='http://localhost:8084/Elmashro3/takeAnsServ' method='get'>");
            out.println("<input type='hidden' name='question_id' value='"+question_id+"' />");
            out.println("<input type='hidden' name='name' value='"+name+"' />");
            out.println(" Enter your Answer<textarea name='answer' rows='4' cols='100'>");
            
            out.println(" </textarea><br><input type='submit' value='Enter your Answer' name='Answerbtn' />");
            out.println("</form>");
            out.println("<div>");
            
            
        
            
            
            
            
            
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
            Logger.getLogger(questionAnsServ.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(questionAnsServ.class.getName()).log(Level.SEVERE, null, ex);
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
