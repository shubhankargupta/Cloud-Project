/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gupta
 */
public class PatientSignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            int flag=0;
        try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","test");
        
        //Statement s=conn.createStatement();
        
        //ResultSet rs=s.executeQuery("select username,password,name from patient");
        
        PreparedStatement ps=conn.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
        
        
        ps.setString(1,request.getParameter("username"));
        ps.setString(2,request.getParameter("password"));
        ps.setString(3,request.getParameter("id"));
        ps.setString(4,request.getParameter("name"));
        ps.setString(5,request.getParameter("location"));
        ps.setString(6,request.getParameter("contact"));
        ps.setString(7,request.getParameter("bloodgroup"));
        
        int x=ps.executeUpdate();
        
        if(x>=1)
        {
            flag=1;
        }
        
                
        }
        
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
            
        }
        
        String message1="You have registered successfully";
        String message2="Sorry could not enter the data";
        String fin;
        
        if(flag==1)
        {   
            fin=message1;
        }
        
        else{
            fin=message2;
        }
        
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Status</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<br>"+fin+"</br>");
            out.println("<br><center><a href='LoginJSP.jsp'>Home</a></center>");
            out.println("</body>");
            out.println("</html>");
        
        
        
    }
            
            
            /* TODO output your page here. You may use following sample code. */
            
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
