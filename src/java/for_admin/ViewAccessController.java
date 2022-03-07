/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package for_admin;

import dal.OrderDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;

/**
 *
 * @author Vu Duc Tien
 */
public class ViewAccessController extends HttpServlet {

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
        OrderDBContext odbc = new OrderDBContext();
        int pageSize = 5;
        int pageIndex;
        String pageIndex_raw = request.getParameter("pageIndex");
        if (pageIndex_raw == null) {
            pageIndex = 1;
        } else {
            pageIndex = Integer.parseInt(pageIndex_raw);
        }

        ArrayList<Order> orders = new ArrayList<>();
        int totalRows;
        String url;
        Date checkIN = null;
        Date checkOUT = null;
        String raw_checkIN = request.getParameter("checkIN");
        String raw_checkOUT = request.getParameter("checkOUT");
        if (raw_checkIN != null && raw_checkIN.length() != 0) {
            checkIN = Date.valueOf(raw_checkIN);
        }
        if (raw_checkOUT != null && raw_checkOUT.length() != 0) {
            checkOUT = Date.valueOf(raw_checkOUT);
        }

        if (checkIN == null && checkOUT == null) {
            orders = odbc.getListOrder(true, null, null, pageSize, pageIndex,"desc");
            totalRows = odbc.getTotalRows(true, null, null);
            url = request.getContextPath() + "/admin/viewaccess?pageIndex=";
        } else {
            orders = odbc.getListOrder(true, checkIN, checkOUT, pageSize, pageIndex, "desc");
            totalRows = odbc.getTotalRows(true, checkIN, checkOUT);
            url = request.getContextPath() + "/admin/viewaccess?checkIn=" + checkIN + "&checkOUT=" + checkOUT + "&pageIndex=";
            request.setAttribute("checkIN", checkIN);
            request.setAttribute("checkOUT", checkOUT);
        }

        int totalPages = (totalRows % pageSize == 0) ? totalRows / pageSize : totalRows / pageSize + 1;

        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("orders", orders);
        request.setAttribute("url", url);
        request.setAttribute("tag", "admin/viewaccess");
        request.getRequestDispatcher("../view/forAdmin/page/viewaccess.jsp").forward(request, response);
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
