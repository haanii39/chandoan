/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Base64Utils;
/**
 *
 * @author Administrator
 */
public class Patient implements Benh{

    private int id;
    private String tenDN;
    private String tongQuat;
    private String chuyenKhoa;
    private String thoiGian;
    // private DateFormat thoiGian;
    private String nhanXet;

    public void setId(int id) {
        this.id = id;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }
    

    public int getId() {
        return id;
    }

    public String getTenDN() {
        return tenDN;
    }

    public Patient(String tongQuat, String chuyenKhoa,String thoiGian, String nhanXet) {
        this.tongQuat = tongQuat;
        this.chuyenKhoa = chuyenKhoa;
        this.thoiGian = thoiGian;
        this.nhanXet = nhanXet;
        
    }

    public Patient(int id, String tenDN, String tongQuat, String chuyenKhoa, String thoiGian, String nhanXet) {
        this.id = id;
        this.tenDN = tenDN;
        this.tongQuat = tongQuat;
        this.chuyenKhoa = chuyenKhoa;
        this.thoiGian = thoiGian;
        this.nhanXet = nhanXet;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public String getTongQuat() {
        return tongQuat;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setTongQuat(String tongQuat) {
        this.tongQuat = tongQuat;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }
   public String toString() { 
    return "Tổng Quát:'" + this.tongQuat + "', Chuyên Khoa:'" + this.chuyenKhoa + "', Thời Gian: '"+ this.thoiGian+ "', Nhận Xét:'" + this.nhanXet  ;
} 

    @Override
    public Map<String, String> getMap() {
         Map<String, String> map = new HashMap<>();
         map.put("TQ", this.tongQuat);
         map.put("CK", this.chuyenKhoa);
         map.put("TG", this.thoiGian);
         map.put("NX", this.nhanXet);
        return map;
    }
//    public static void main(String[] args) {
//        Patient p = new Patient("hi", "chuyenKhoa", "thoiGian", "nhanXet");
//        for(Map.Entry<String, String> entry : p.getMap().entrySet()){
//            System.out.println(entry.getValue());
//        }
//    }
}