/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChanDoanBenh;
import Model.Database;
import Model.TieuHoa;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ChanDoanTieuHoaServlet", urlPatterns = {"/ChanDoanTieuHoaServlet"})
public class ChanDoanTieuHoaServlet extends HttpServlet {

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
            out.println("<title>Servlet ChanDoanTieuHoaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChanDoanTieuHoaServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
                User user =  null;
        user = (User) request.getSession(true).getAttribute("user");
        String benh="";
        try {
            TieuHoa th = new TieuHoa();
            th.Sot = request.getParameter("Sot");
            th.Bung = request.getParameter("Bung");
            th.CamGiac = request.getParameter("CamGiac");
            th.CanNang = request.getParameter("CanNang");
            th.TrieuChung = request.getParameter("TrieuChung");
            th.AnUong = request.getParameter("AnUong");
            benh = ChanDoanBenh.chanDoan(th);
            
        } catch (Exception ex) {
            Logger.getLogger(ChanDoanServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (user != null){
                       String code =Database.UpdateHistory(user.getName(), benh, user.getSessionCode(),"Tiêu hóa");
            user.setSessionCode(code);
                    HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        }
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
	response.getWriter().write(benh);
//        out.print("GRANTED");
        out.close();
        
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
