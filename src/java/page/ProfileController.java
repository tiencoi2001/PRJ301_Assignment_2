/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import auth.BaseRequiredAuthController;
import dal.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Vu Duc Tien
 */
public class ProfileController extends BaseRequiredAuthController {

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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/forUser/page/profile.jsp").forward(request, response);
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        User u = (User) request.getSession().getAttribute("user");
        int id = Integer.parseInt(request.getParameter("accountID"));
        String username = u.getUsername();
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String address = request.getParameter("address");

        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setDob(dob);
        user.setAddress(address);

        UserDBContext udbc = new UserDBContext();

        if (u.getPhone().equals(user.getPhone()) && u.getEmail().equals(user.getEmail())) {
            udbc.updateUser(user);
            request.getSession().setAttribute("user", udbc.getUser(username, password));
            request.setAttribute("done", true);
            request.getRequestDispatcher("view/forUser/page/profile.jsp").forward(request, response);
        } else {
            if (udbc.checkEmailAndPhone(user)) {
                request.setAttribute("fail", true);
                request.getRequestDispatcher("view/forUser/page/profile.jsp").forward(request, response);
            } else {
                udbc.updateUser(user);
                User u1 = udbc.getUser(username, password);
                request.getSession().setAttribute("user", udbc.getUser(username, password));
                request.setAttribute("done", true);
                request.getRequestDispatcher("view/forUser/page/profile.jsp").forward(request, response);
            }
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
