/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package page;

import auth.BaseRequiredAuthController;
import dal.InvoiceDBContext;
import dal.OrderDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Invoice;
import model.Order;
import model.User;

/**
 *
 * @author Vu Duc Tien
 */
public class TransactionHistoryController extends BaseRequiredAuthController {

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
        User user = (User) request.getSession().getAttribute("user");
        OrderDBContext odbc = new OrderDBContext();
        int pageSize = 5;
        int pageIndex;
        String pageIndex_raw = request.getParameter("pageIndex");
        if (pageIndex_raw == null) {
            pageIndex = 1;
        } else {
            pageIndex = Integer.parseInt(pageIndex_raw);
        }
        int totalRows = odbc.getTotalRowsForUser(user.getId());
        int totalPages = (totalRows % pageSize == 0) ? totalRows / pageSize : totalRows / pageSize + 1;
        ArrayList<Order> orders = odbc.getListOrderForUser(user.getId(), pageSize, pageIndex);
        String url = request.getContextPath() + "/transactionhistory?pageIndex=";

        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("orders", orders);
        request.setAttribute("url", url);
        request.setAttribute("tag", "transactionhistory");
        request.getRequestDispatcher("view/forUser/page/transactionhistory.jsp").forward(request, response);
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
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
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
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
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
