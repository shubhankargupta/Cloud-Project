/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gupta
 */
public class LoginServlet extends HttpServlet {

    @EJB
    private SimpleSession simple;

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
            /* TODO output your page here. You may use following sample code. */
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Page</title>");            
            out.println("</head>");
            out.println("<body>");
            String username=request.getParameter("user");
            String password=request.getParameter("password");
            String profession=request.getParameter("prof");
            
            
            //String ans=simple.validate(username, password);
            
            
            
            
            //out.println("<br><b><center>"+ans+"</b></center>");
            //out.println("<br>"+profession);
            if(profession.equals("Patient"))
            {
                String ans=simple.validatePatient(username, password);
                if(ans.equals("Either Username or Password is wrong")){
                    RequestDispatcher rdispatcher=request.getRequestDispatcher("Error.html");
                    rdispatcher.forward(request, response);
                }
                else{
                out.println("<br><b><center>"+ans+"</b></center>");
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(15);
                RequestDispatcher rd1=request.getRequestDispatcher("patient.jsp");
                rd1.include(request, response);
            
            RequestDispatcher rd2=request.getRequestDispatcher("footer.html");
            rd2.include(request, response);
            
            //response.addHeader("refesh","10");
            }
            }
            
            else if(profession.equals("Doctor"))
            {
                String doc=simple.validateDoctor(username, password);
                if(doc.equals("Either Username or Password is wrong")){
                    RequestDispatcher rdispatcher=request.getRequestDispatcher("Error.html");
                    rdispatcher.forward(request, response);
                }
                else{
                out.println("<br><center>"+doc+"</b></center>");
                HttpSession session = request.getSession();
                session.setAttribute("Doctor", doc);
                session.setMaxInactiveInterval(15);
                RequestDispatcher rd3=request.getRequestDispatcher("doctor.jsp");
                rd3.forward(request, response);
                
                RequestDispatcher rd4=request.getRequestDispatcher("footer.html");
                rd4.include(request, response);
                //response.addHeader("refesh","10");    
            }
            
            //out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
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
        try{processRequest(request, response);}
        catch(IOException | ServletException e)
        {
            
        }
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
        try{processRequest(request, response);}
        catch(IOException | ServletException e)
        {
            
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