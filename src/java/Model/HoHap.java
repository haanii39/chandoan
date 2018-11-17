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
public class HoHap implements Benh{

    public String Ho;
    public String Sot;
    public String KhoTho;
    public String Mui;
    public String Hong;
    public String ToanThan;
    public String AnUong;
    public String Benh;


    @Override
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        try {
            map.put(Base64Utils.encode("Ho"), TuDien.tudien.get(Ho));
            map.put(Base64Utils.encode("Sốt"), TuDien.tudien.get(Sot));
            map.put(Base64Utils.encode("Khó thở"), TuDien.tudien.get(KhoTho));
            map.put(Base64Utils.encode("Mũi"), TuDien.tudien.get(Mui));
            map.put(Base64Utils.encode("Họng"), TuDien.tudien.get(Hong));
            map.put(Base64Utils.encode("Mũi"), TuDien.tudien.get(Mui));
            map.put(Base64Utils.encode("ToanThan"), TuDien.tudien.get(ToanThan));
            map.put(Base64Utils.encode("Ăn uống"), TuDien.tudien.get(AnUong));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HoHap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }

}
