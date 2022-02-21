/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import dal.OrderDBContext;
import dal.RoomDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;
import model.RoomType;

/**
 *
 * @author Vu Duc Tien
 */
public class BookingController extends HttpServlet {

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
        RoomDBContext rdbc = new RoomDBContext();
        ArrayList<RoomType> typeList = rdbc.getAllRoomType();
        request.setAttribute("typeList", typeList);
        request.getRequestDispatcher("view/forUser/page/booking.jsp").forward(request, response);
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
        int accountID = Integer.parseInt(request.getParameter("accountID"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Date checkIN = Date.valueOf(request.getParameter("checkIN"));
        Date checkOUT = Date.valueOf(request.getParameter("checkOUT"));
        int numberOfRooms = Integer.parseInt(request.getParameter("numberOfRooms"));
        int typeID = Integer.parseInt(request.getParameter("type"));

        Order order = new Order();
        order.setAccountID(accountID);
        order.setName(name);
        order.setEmail(email);
        order.setPhone(phone);
        order.setCheckIN(checkIN);
        order.setCheckOUT(checkOUT);
        order.setNumberOfRooms(numberOfRooms);
        order.setTypeID(typeID);
        OrderDBContext odbc = new OrderDBContext();
        if(odbc.insertOrderWait(order)){
            request.setAttribute("success", true);
            request.getSession().removeAttribute("order");
            request.getRequestDispatcher("view/forUser/page/booking.jsp").forward(request, response);
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
