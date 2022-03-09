/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package for_admin;

import dal.InvoiceDBContext;
import dal.OrderDBContext;
import dal.RoomDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Invoice;
import model.Order;
import model.Room;

/**
 *
 * @author Vu Duc Tien
 */
public class ChangeRoomController extends HttpServlet {

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
        OrderDBContext odbc = new OrderDBContext();
        RoomDBContext rdbc = new RoomDBContext();

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        Order order = odbc.getOrderByID(orderID);
        order = rdbc.getRoomsByOrderID(order);
        ArrayList<Room> rooms = rdbc.getRoomsToChange(order);

        request.setAttribute("order", order);
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("../view/forAdmin/page/changeroom.jsp").forward(request, response);
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
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        String[] listChangeRooms = request.getParameterValues("roomID");

        RoomDBContext rdbc = new RoomDBContext();
        OrderDBContext odbc = new OrderDBContext();
        
        rdbc.setRooms(orderID, listChangeRooms);
        Order order = odbc.getOrderByID(orderID);
        order = rdbc.getRoomsByOrderID(order);
        ArrayList<Room> rooms = rdbc.getRoomsToChange(order);
        
        request.setAttribute("order", order);
        request.setAttribute("rooms", rooms);
        request.setAttribute("tag", "done");
        request.getRequestDispatcher("../view/forAdmin/page/changeroom.jsp").forward(request, response);
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
