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
import model.Invoice;
import model.Order;
import model.RoomType;

/**
 *
 * @author Vu Duc Tien
 */
public class OrderDetailController extends HttpServlet {

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
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        Order order = odbc.getOrderByID(orderID);
        
        RoomDBContext rdbc = new RoomDBContext();
        ArrayList<RoomType> typeList = rdbc.getAllRoomType();
        
        request.setAttribute("typeList", typeList);        
        request.setAttribute("order", order);
        request.getRequestDispatcher("../view/forAdmin/page/orderdetail.jsp").forward(request, response);
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
        request.setCharacterEncoding("utf-8");
        int orderID = Integer.parseInt(request.getParameter("orderID"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        Date checkIN = Date.valueOf(request.getParameter("checkIN"));
        Date checkOUT = Date.valueOf(request.getParameter("checkOUT"));
        int numberOfRooms = Integer.parseInt(request.getParameter("numberOfRooms"));
        int typeID = Integer.parseInt(request.getParameter("type"));

        Order order = new Order();
        order.setOrderID(orderID);
        order.setName(name);
        order.setEmail(email);
        order.setPhone(phone);
        order.setCheckIN(checkIN);
        order.setCheckOUT(checkOUT);
        order.setNumberOfRooms(numberOfRooms);

        RoomType rt = new RoomType();
        rt.setId(typeID);
        order.setRoomType(rt);

        RoomDBContext rdbc = new RoomDBContext();
        ArrayList<RoomType> typeList = rdbc.getAllRoomType();
        request.setAttribute("typeList", typeList);

        OrderDBContext odbc = new OrderDBContext();
        if (odbc.updateOrder(order)) {
            request.setAttribute("tag", "done");
            InvoiceDBContext idbc = new InvoiceDBContext();
        } else {
            request.setAttribute("tag", "fail");
        }
        request.setAttribute("order", order);
        request.getRequestDispatcher("../view/forAdmin/page/orderdetail.jsp").forward(request, response);
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
