/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChanDoanBenh;
import Model.Gan;
import Model.HoHap;
import Model.TieuHoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.JsonUtil;
import Model.Benh;
import Model.TuDien;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "KetQuaServlet", urlPatterns = {"/KetQua"})
public class KetQuaServlet extends HttpServlet {

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
            out.println("<title>Servlet KetQuaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KetQuaServlet at " + request.getContextPath() + "</h1>");
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
        // nhombenh: hohap, gan, tieuhoa
        String nhombenh = request.getParameter("nhombenh");
        
        String ketqua = request.getParameter("ketqua");
        Benh benh = null;
        switch (nhombenh) {
            case "hohap":
                try {
                    HoHap hh = new HoHap();
                    hh.AnUong = request.getParameter("AnUong");
                    hh.Ho = request.getParameter("Ho");
                    hh.Sot = request.getParameter("Sot");
                    hh.KhoTho = request.getParameter("KhoTho");
                    hh.Hong = request.getParameter("Hong");
                    hh.Mui = request.getParameter("Mui");
                    hh.ToanThan = request.getParameter("ToanThan");
                    benh = hh;
                } catch (Exception ex) {
                    Logger.getLogger(ChanDoanServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "tieuhoa":
                try {
                    TieuHoa th = new TieuHoa();
                    th.Sot = request.getParameter("Sot");
                    th.Bung = request.getParameter("Bung");
                    th.CamGiac = request.getParameter("CamGiac");
                    th.CanNang = request.getParameter("CanNang");
                    th.TrieuChung = request.getParameter("TrieuChung");
                    th.AnUong = request.getParameter("AnUong");
                    benh = th;
                } catch (Exception ex) {
                    Logger.getLogger(ChanDoanServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

        }
        request.setAttribute("benh", benh);
        request.setAttribute("ketqua", TuDien.tudien.get(ketqua));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/ketqua.jsp");
        dispatcher.forward(request, response);

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
