/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package for_admin;

import dal.InvoiceDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Invoice;

/**
 *
 * @author Vu Duc Tien
 */
public class ViewPaidController extends HttpServlet {

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
        InvoiceDBContext idbc = new InvoiceDBContext();
        int pageSize = 5;
        int pageIndex;
        String pageIndex_raw = request.getParameter("pageIndex");
        if (pageIndex_raw == null) {
            pageIndex = 1;
        } else {
            pageIndex = Integer.parseInt(pageIndex_raw);
        }
        int totalRows = idbc.getTotalRows(true);
        int totalPages = (totalRows % pageSize == 0) ? totalRows / pageSize : totalRows / pageSize + 1;
        ArrayList<Invoice> invoices = idbc.getListInvoice(true, pageSize, pageIndex, "desc");
        String url = request.getContextPath() + "/admin/paid?pageIndex=";
        
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("invoices", invoices);
        request.setAttribute("url", url);
        request.setAttribute("tag", "admin/paid");
        request.getRequestDispatcher("../view/forAdmin/page/paid.jsp").forward(request, response);
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
