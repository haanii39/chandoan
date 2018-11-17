/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class User {
    private String name;
    private String password;
    private String fullName;
    private String sessionCode;
    private String diachi;
    private Date ngaysinh;

    public String getDiachi() {
        return diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }
    
    

    public User(String name, String fullName,  Date ngaysinh,String diachi) {
        this.name = name;
        this.fullName = fullName;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
    }
  
    public User(String name, String fullName) {
        this.name = name;
        this.fullName = fullName;
    }

    public String getSessionCode() {
        return sessionCode;
    }

    public void setSessionCode(String sessionCode) {
        this.sessionCode = sessionCode;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
