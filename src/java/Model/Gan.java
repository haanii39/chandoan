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
public class Gan implements Benh {

    String da, mat, bung, camgiac, anuong, sot;

    public Gan() {
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getBung() {
        return bung;
    }

    public void setBung(String bung) {
        this.bung = bung;
    }

    public String getCamgiac() {
        return camgiac;
    }

    public void setCamgiac(String camgiac) {
        this.camgiac = camgiac;
    }

    public String getAnuong() {
        return anuong;
    }

    public void setAnuong(String anuong) {
        this.anuong = anuong;
    }

    public String getSot() {
        return sot;
    }

    public void setSot(String sot) {
        this.sot = sot;
    }

    @Override
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        try {
            map.put(Base64Utils.encode("Da"), TuDien.tudien.get(da));
            map.put(Base64Utils.encode("Mắt"), TuDien.tudien.get(mat));
            map.put(Base64Utils.encode("Bụng"), TuDien.tudien.get(bung));
            map.put(Base64Utils.encode("Cảm giác"), TuDien.tudien.get(camgiac));
            map.put(Base64Utils.encode("Ăn uống"), TuDien.tudien.get(anuong));
            map.put(Base64Utils.encode("Sốt"), TuDien.tudien.get(sot));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HoHap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

}
