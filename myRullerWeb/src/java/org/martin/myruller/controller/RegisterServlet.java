/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.martin.myruller.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.martin.myRuller.db.ClientDAO;
import org.martin.myRuller.db.UserDAO;
import org.martin.myRuller.model.Client;
import org.martin.myRuller.model.User;

/**
 *
 * @author martin
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register.do"})
public class RegisterServlet extends HttpServlet {

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
        String name = request.getParameter("name");
        byte age = Byte.parseByte(request.getParameter("age"));
        String nick = request.getParameter("nick");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        UserDAO dao = new UserDAO();
        
        User result = dao.getElementByFieldName("nick", nick);
        
        // No existe un usuario con ese nick.
        if (result == null) {
            if (!pass1.equals(pass2)) {
                response.sendRedirect("register.jsp");
            }
            else{
                dao.addElement(new User(nick, pass1));
                Client newClient = new Client(name, age, dao.getLast().getId());
                new ClientDAO().addElement(newClient);
                response.sendRedirect("index.jsp?sm="+ServerMessage.RIGHT_REGISTRY);
            }
        }
        else
            response.sendRedirect("register.jsp");
        
        result = null;
        dao = null;
        nick = pass1 = pass2 = null;
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
        response.sendRedirect("index.jsp");
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
