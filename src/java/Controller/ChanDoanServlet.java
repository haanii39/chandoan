/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChanDoanBenh;
import Model.Database;
import Model.ListTrieuChung;
import Model.Patient;
import Model.TongQuat;
import Model.TuDien;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import utils.JsonUtil;

/**
 *
 * @author NhiPhan
 */
public class ChanDoanServlet extends HttpServlet {

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
            out.println("<title>Servlet ChanDoanServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChanDoanServlet at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
                        
        request.setAttribute("TuDien", TuDien.tudien);
        request.setAttribute("lTrieuChung", new ListTrieuChung().TrieuChung);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/chandoan.jsp");
        dispatcher.forward(request,response);
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
        String code = "";
        String benh="";
        try {
            TongQuat tq = new TongQuat();
            tq.Sot = request.getParameter("Sot");
            tq.Nguc = request.getParameter("Nguc");
            tq.Bung = request.getParameter("Bung");
            tq.Da = request.getParameter("Da");
            tq.CamGiac = request.getParameter("CamGiac");
            tq.AnUong = request.getParameter("AnUong");
            tq.TheTrang =request.getParameter("TheTrang");
            benh = ChanDoanBenh.chanDoan(tq);
        } catch (Exception ex) {
            Logger.getLogger(ChanDoanServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user != null){
            code = Database.InsertHistory(user.getName(), benh);
            user.setSessionCode(code);
                    HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        }
        PrintWriter out = response.getWriter();
         response.setContentType("text/plain");
//        Store benh vao database

        
        
	response.getWriter().write(benh);
//        out.print("GRANTED");
        out.close();
//        request.setAttribute("benh", benh);
//        request.getRequestDispatcher("chandoan.jsp").forward(request, response);
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
