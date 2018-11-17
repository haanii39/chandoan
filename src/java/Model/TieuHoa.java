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
public class TieuHoa implements Benh{

    public String Sot,Bung,CamGiac,CanNang,TrieuChung,AnUong,Benh;

    @Override
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        try {
            
            map.put(Base64Utils.encode("Sốt"), TuDien.tudien.get(Sot));
            map.put(Base64Utils.encode("Bụng"), TuDien.tudien.get(Bung));
            map.put(Base64Utils.encode("Cảm giác"), TuDien.tudien.get(CamGiac));
            map.put(Base64Utils.encode("Cân nặng"), TuDien.tudien.get(CanNang));
            map.put(Base64Utils.encode("Triệu chứng"), TuDien.tudien.get(TrieuChung));
            map.put(Base64Utils.encode("Ăn uống"), TuDien.tudien.get(AnUong));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HoHap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return map;
    }
    

}
