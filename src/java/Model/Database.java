/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.tomcat.jni.Address;
import static org.apache.tomcat.jni.User.username;

import utils.SQLServerConnUtils_SQLJDBC;
import weka.core.pmml.Array;

/**
 *
 * @author Administrator
 */
public class Database {

    public static User Login(String username, String password) {
        User user = null;
        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("");
            //  PreparedStatement ps = con.prepareStatement("select username, HOTEN from [USER] where username = ? and password = ?");
            PreparedStatement ps = con.prepareStatement("select TENDANGNHAP, HOTEN from NGUOIDUNG where TENDANGNHAP = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println("sss");
//            List<User> luser = new ArrayList<User>();
            while (rs.next()) {
                System.out.println(rs.getString("TENDANGNHAP") + " " + rs.getString("HOTEN"));
                String fullName = rs.getString("HOTEN");
                user = new User(username, fullName);
//                luser.`23467add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    public static String InsertHistory(String username, String TongQuat) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String code = "Completed";
        if (TongQuat.equals("Tiêu hóa") || TongQuat.equals("Hô hấp")) {
            code = dateFormat.format(new Date());
        }
        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("");
            String query = "insert into THONGTIN (TONGQUAT,THOIGIAN,TENDANGNHAP,SESSIONCODE) values(?,GETDATE(),?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, TongQuat);
            ps.setString(2, username);
            ps.setString(3, code);
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return code.equals("Completed") ? "" : code;
    }

    public static String UpdateHistory(String username, String benh, String SCode, String TongQuat) {
        User user = null;
        int ret = 0;
        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("");
            if (!SCode.equals("")) {
                String query = "Update THONGTIN set THOIGIAN= GETDATE(),CHUYENKHOA=?, SESSIONCODE='Completed' WHERE SESSIONCODE=? and TENDANGNHAP=? and TONGQUAT =? ";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, benh);
                ps.setString(2, SCode);
                ps.setString(3, username);
                ps.setString(4, TongQuat);
                ret = ps.executeUpdate();
            }
            if (SCode.equals("") || ret == 0) {
                String query = "insert into THONGTIN (CHUYENKHOA,THOIGIAN,TENDANGNHAP,SESSIONCODE) values(?,GETDATE(),?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, benh);
                ps.setString(2, username);
                ps.setString(3, "Completed");
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }

    public static int DeleteHistory(String username) {
        User user = null;
        int ret = 0;
        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("");

            String query = "delete from THONGTIN Where user=? and SESSIONCODE not in ('Completed') ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ret = ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ret;
    }

    public static List<Patient> SelectHistory(String username) {
        Patient patient = null;
        List<Patient> listPatient = new ArrayList<Patient>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("Kết nối thành công");

            PreparedStatement ps = con.prepareStatement(" SELECT TONGQUAT,CHUYENKHOA,THOIGIAN,NHANXET from THONGTIN where TENDANGNHAP=? ");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            System.out.println("Trước While Size: " + listPatient.size());
            System.out.println("Trước While String: " + listPatient.toString());
            System.out.println("Hồ Sơ Bệnh Án");

            int i = 1;
            while (rs.next()) {
                String TQ = rs.getString("TONGQUAT");
                String CK = rs.getString("CHUYENKHOA");
                //  Date TG = rs.getDate("THOIGIAN");
                String TG = dateFormat.format(rs.getDate("THOIGIAN"));
                String NX = rs.getString("NHANXET");
                patient = new Patient(TQ, CK, TG, NX);
                System.out.println("" + patient.toString());
//                System.out.println(" " + i + " " + username + " " + rs.getString("TONGQUAT") + "   "
//                        + rs.getString("CHUYENKHOA") + "  "
//                        + rs.getDate("THOIGIAN") + "  "
//                        + rs.getString("NHANXET"));
                listPatient.add(patient);
                i++;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return listPatient;
    }

    public static List<Patient> SearchHistory(String username) {
        //public ArrayList<Patient> SelectHistory(String username) {
        // Patient patient = new Patient(username, username, username);
        Patient patient = null;
        List<Patient> listPatient = new ArrayList<Patient>();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("Kết nối thành công");
            PreparedStatement ps = con.prepareStatement(" SELECT id, TONGQUAT,CHUYENKHOA,THOIGIAN,TENDANGNHAP ,NHANXET from THONGTIN where TENDANGNHAP=? ");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            System.out.println("Trước While Size: " + listPatient.size());
            System.out.println("Trước While String: " + listPatient.toString());
            System.out.println("Hồ Sơ Bệnh Án");

            int i = 1;
            while (rs.next()) {
                String TQ = rs.getString("TONGQUAT");
                String CK = rs.getString("CHUYENKHOA");
                String TG = dateFormat.format(rs.getDate("THOIGIAN"));
                String NX = rs.getString("NHANXET");
                String TDN = rs.getString("TENDANGNHAP");
                int ID = rs.getInt("ID");
                patient = new Patient(ID, TDN, TQ, CK, TG, NX);
                System.out.println("" + patient.toString());

                System.out.println(" " + i + " " + username + " "
                        + TQ + " " + CK + " " + TG + " " + NX + " " + TDN + " ");
                listPatient.add(patient);
                i++;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return listPatient;
    }

    public static void AdminUpdate(String id, String nhanXet) {
        Patient patient = null;
        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("Kết nối thành công");

            if (!"".equals(id)) {
                //String query = "Update THONGTIN set THOIGIAN= GETDATE(),CHUYENKHOA=?, SESSIONCODE='Completed' WHERE SESSIONCODE=? and TENDANGNHAP=? and TONGQUAT =? ";
                String query = "Update THONGTIN set NHANXET=? WHERE ID =? ";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, nhanXet);
                ps.setString(2, id);
                int rs = ps.executeUpdate();
                System.out.println("Số dòng update: " + rs);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static Doctor AdminLogin(String username, String password) {

        Doctor doctor = null;
        try {
            Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
            System.out.println("");
            //  PreparedStatement ps = con.prepareStatement("select username, HOTEN from [USER] where username = ? and password = ?");
            PreparedStatement ps = con.prepareStatement("select TENDANGNHAP,TENBS from ADMIN where TENDANGNHAP = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println("Successful");
            while (rs.next()) {
                System.out.println("Nhi");
                System.out.println(rs.getString("TENDANGNHAP") + " " + rs.getString("TENBS"));
                String fullName = rs.getString("TENBS");
                doctor = new Doctor(username, fullName);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return doctor;
    }


    public static void main(String[] args) {

        System.out.println("hi");
        //Patient t= new Patient(null, null, null, null,null, null);
       //  List<Patient> arr = SearchHistory("nhinhi");
        // p = SelectHistory("nhinhi");
        //User  u = Login("huyhuy","123");
        //  AdminUpdate("74", "Ăn uống điều độ");
        Doctor d =AdminLogin("admin","456");
       // User  u = Login("huyhuy","123");
    }

}
