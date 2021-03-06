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
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;
import model.Room;
import sendmail.SendEmail;

/**
 *
 * @author Vu Duc Tien
 */
public class ChooseRoomController extends HttpServlet {

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
        ArrayList<Room> rooms = rdbc.getRooms(order);

        if (order.getNumberOfRooms() > rooms.size()) {
            request.setAttribute("noroom", true);
        } else {
            request.setAttribute("rooms", rooms);
        }
        request.setAttribute("order", order);
        request.getRequestDispatcher("../view/forAdmin/page/chooseroom.jsp").forward(request, response);
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
        String[] rooms = request.getParameterValues("roomID");

        RoomDBContext rdbc = new RoomDBContext();
        OrderDBContext odbc = new OrderDBContext();
        InvoiceDBContext idbc = new InvoiceDBContext();

        rdbc.setRooms(orderID, rooms);
        Order order = odbc.getOrderByID(orderID);
        idbc.insertInvoice(order);

        SendEmail sm = new SendEmail();
        String subject = "Booking success";
        String message = "<h1>Welcome to Queen Hotel</h1>"
                + "<h2>Wish you have a great experience</h2>"
                + "<h3>Your room: ";
        for (String room : rooms) {
            Room r = rdbc.getRoomsByID(Integer.parseInt(room));
            message += r.getName() + " ";
        }

        message += "</h3>";

        sm.send(order.getEmail(), subject, message);

        request.setAttribute("order", order);
        request.setAttribute("tag", "done");
        request.getRequestDispatcher("../view/forAdmin/page/chooseroom.jsp").forward(request, response);
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
