/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import Model.HoHap;
import Model.ListTrieuChung;
import Model.TieuHoa;
import Model.TongQuat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.layout.Region;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class Program {
    private final HashMap<String,List<String>> ltcb = init();
    // tổng quát
    public HashMap<String,List<String>> init(){
        try{
        return new ListTrieuChung().TrieuChung;
        }
        catch(Exception ex){
            return null;
        }
    }
    
    public ArrayList<String> createAtt(String attribute){
        List<String> list = ltcb.get(attribute);
        ArrayList<String> temp = new ArrayList<String>();
        for(String value : list){
            temp.add(value);
        }
        return temp;
    }
    
    public int getAttributeValue(String attribute,String trieuchung){
        return ltcb.get(attribute).indexOf(trieuchung);
    }
    
    public Instances createInstance(TongQuat tongquat){
        ArrayList<Attribute> atts = new ArrayList<>(8);
        ArrayList<String> SotAtt = createAtt("Sot");
        ArrayList<String> NgucAtt = createAtt("Nguc");
        ArrayList<String> BungAtt = createAtt("Bung");
        ArrayList<String> DaAtt = createAtt("Da");
        ArrayList<String> AnUongAtt = createAtt("AnUong");
        ArrayList<String> CamGiacAtt = createAtt("CamGiac");
        ArrayList<String> TheTrangAtt = createAtt("TheTrang");
        ArrayList<String> ClassAtt = createAtt("ClassTQ");
        
        
        atts.add(new Attribute("Sot", SotAtt));
        atts.add(new Attribute("Nguc", NgucAtt));
        atts.add(new Attribute("Bung", BungAtt));
        atts.add(new Attribute("Da", DaAtt));
        atts.add(new Attribute("AnUong", AnUongAtt));
        atts.add(new Attribute("CamGiac", CamGiacAtt));
        atts.add(new Attribute("TheTrang", TheTrangAtt));
        atts.add(new Attribute("ClassTQ", ClassAtt));
        
        Instances dataRaw = new Instances("TongQuat", atts, 0);
        double[] instanceValue = new double[dataRaw.numAttributes()];
       
        instanceValue[0] = getAttributeValue("Sot",tongquat.Sot);
        instanceValue[1] =  getAttributeValue("Nguc",tongquat.Nguc);
        instanceValue[2] =  getAttributeValue("Bung",tongquat.Bung);
        instanceValue[3] =  getAttributeValue("Da",tongquat.Da);
        instanceValue[4] =  getAttributeValue("AnUong",tongquat.AnUong);
        instanceValue[5] =  getAttributeValue("CamGiac",tongquat.CamGiac);
        instanceValue[6] =  getAttributeValue("TheTrang",tongquat.TheTrang);
        instanceValue[7] =  getAttributeValue("ClassTQ",tongquat.Benh);
        dataRaw.add(new DenseInstance(1.0, instanceValue));
        dataRaw.setClassIndex(dataRaw.numAttributes() - 1);

        return dataRaw;
    }
    // tiêu hóa 
    public Instances createInstance(TieuHoa tieuhoa) {
        ArrayList<Attribute> atts = new ArrayList<>(7);
        ArrayList<String> SotAtt = createAtt("Sot");
        ArrayList<String> BungAtt = createAtt("Bung");
        ArrayList<String> CamGiacAtt = createAtt("CamGiac");
        ArrayList<String> TrieuChungAtt = createAtt("TrieuChung");
        ArrayList<String> CanNangAtt = createAtt("CanNang");
        ArrayList<String> AnUongAtt = createAtt("AnUong");
        ArrayList<String> ClassAtt = createAtt("ClassTH");
        
        atts.add(new Attribute("Sot", SotAtt));
        atts.add(new Attribute("Bung", BungAtt));
        atts.add(new Attribute("CamGiac", CamGiacAtt));
        atts.add(new Attribute("TrieuChung", TrieuChungAtt));
        atts.add(new Attribute("CanNang", CanNangAtt));
        atts.add(new Attribute("AnUong", AnUongAtt));
        atts.add(new Attribute("ClassTH", ClassAtt));
        
        Instances dataRaw = new Instances("TieuHoa", atts, 0);
        double[] instanceValue = new double[dataRaw.numAttributes()];
        instanceValue[0] = getAttributeValue("Sot",tieuhoa.Sot);
        instanceValue[1] = getAttributeValue("Bung",tieuhoa.Bung);
        instanceValue[2] = getAttributeValue("CamGiac",tieuhoa.CamGiac);
        instanceValue[3] = getAttributeValue("TrieuChung",tieuhoa.TrieuChung);
        instanceValue[4] = getAttributeValue("CanNang",tieuhoa.CanNang);
        instanceValue[5] = getAttributeValue("AnUong",tieuhoa.AnUong);
        instanceValue[6] = getAttributeValue("ClassTH",tieuhoa.Benh);

        dataRaw.add(new DenseInstance(1.0, instanceValue));
        dataRaw.setClassIndex(dataRaw.numAttributes() - 1);

        return dataRaw;
    }
    // hô hấp
    public Instances createInstance(HoHap hohap) {
        ArrayList<Attribute> atts = new ArrayList<>();
        
        ArrayList<String> HoAtt = createAtt("Ho");
        ArrayList<String> SotAtt = createAtt("Sot");
        ArrayList<String> KhoThoAtt = createAtt("KhoTho");
        ArrayList<String> MuiAtt = createAtt("Mui");
        ArrayList<String> HongAtt = createAtt("Hong");
        ArrayList<String> ToanThanAtt = createAtt("ToanThan");
        ArrayList<String> AnUongAtt = createAtt("AnUong");
        ArrayList<String> ClassAtt = createAtt("ClassHH");
        
        
        atts.add(new Attribute("Ho", HoAtt));
        atts.add(new Attribute("Sot", SotAtt));
        atts.add(new Attribute("KhoTho", KhoThoAtt));
        atts.add(new Attribute("Mui", MuiAtt));
        atts.add(new Attribute("Hong", HongAtt));
        atts.add(new Attribute("ToanThan", ToanThanAtt));
        atts.add(new Attribute("AnUong", AnUongAtt));
        atts.add(new Attribute("ClassTH", ClassAtt));

        Instances dataRaw = new Instances("HoHap", atts, 0);
        double[] instanceValue = new double[dataRaw.numAttributes()];
        instanceValue[0] = getAttributeValue("Ho",hohap.Sot);
        instanceValue[1] = getAttributeValue("Sot",hohap.Sot);
        instanceValue[2] = getAttributeValue("KhoTho",hohap.KhoTho);
        instanceValue[3] = getAttributeValue("Mui",hohap.Mui);
        instanceValue[4] = getAttributeValue("Hong",hohap.Hong);
        instanceValue[5] = getAttributeValue("ToanThan",hohap.ToanThan);
        instanceValue[6] = getAttributeValue("AnUong",hohap.AnUong);
        instanceValue[7] = getAttributeValue("ClassTH",hohap.Benh);

        dataRaw.add(new DenseInstance(1.0, instanceValue));
        dataRaw.setClassIndex(dataRaw.numAttributes() - 1);

        return dataRaw;
    }
    
    
//    public Instances createInstance(String Da, String Mat, String Bung, String CamGiac,String AnUong,String Sot, String Benh) {
//        ArrayList<Attribute> atts = new ArrayList<>();
//        ArrayList<String> DaAtt = new ArrayList<>();
//        ArrayList<String> MatAtt = new ArrayList<>();
//        ArrayList<String> BungAtt = new ArrayList<>();
//        ArrayList<String> CamGiacAtt = new ArrayList<>();
//        ArrayList<String> AnUongAtt = new ArrayList<>();
//        ArrayList<String> SotAtt = new ArrayList<>();
//        ArrayList<String> classVal = new ArrayList<>();
//        
//        DaAtt.add("Vang");
//        DaAtt.add("ManNgua");
//        DaAtt.add("SaoMach");
//        DaAtt.add("BT");
//        
//        MatAtt.add("Vang");
//        MatAtt.add("BT");
//        
//        BungAtt.add("Chuong");
//        BungAtt.add("Dau");
//        BungAtt.add("KhoTieu");
//        BungAtt.add("BT");
//        
//        CamGiacAtt.add("BuonNon");
//        CamGiacAtt.add("OChua");
//        CamGiacAtt.add("BT");
//        
//        AnUongAtt.add("ChanAn");
//        AnUongAtt.add("KhongNgonMieng");
//        AnUongAtt.add("BT");
//        
//        SotAtt.add("SotNhe");
//        SotAtt.add("SotCao");
//        SotAtt.add("BT");
//        
//        classVal.add("XoGan");
//        classVal.add("MenGanCao");
//        classVal.add("NhiemMo");
//        classVal.add("BT");
//        
//        atts.add(new Attribute("Da", DaAtt));
//        atts.add(new Attribute("Mat", MatAtt));
//        atts.add(new Attribute("Bung", BungAtt));
//        atts.add(new Attribute("CamGiac", CamGiacAtt));
//        atts.add(new Attribute("AnUong", AnUongAtt));
//        atts.add(new Attribute("Sot", SotAtt));
//        atts.add(new Attribute("class", classVal));
//
//        Instances dataRaw = new Instances("gan", atts, 0);
//        double[] instanceValue = new double[dataRaw.numAttributes()];
//        instanceValue[0] = dataRaw.attribute(0).addStringValue(Da);
//        instanceValue[1] = dataRaw.attribute(1).addStringValue(Mat);
//        instanceValue[2] = dataRaw.attribute(2).addStringValue(Bung);
//        instanceValue[3] = dataRaw.attribute(3).addStringValue(CamGiac);
//        instanceValue[4] = dataRaw.attribute(4).addStringValue(AnUong);
//        instanceValue[5] = dataRaw.attribute(5).addStringValue(Sot);
//        // Da
//        int da = 0;
//        if (null != Da) switch (Da) {
//            case "Vang":
//                da = 0;
//                break;
//            case "ManNgua":
//                da = 1;
//                break;
//            case "SaoMach":
//                da = 2;
//                break;
//            case "BT":
//                da = 3;
//                break;
//            default:
//                break;
//        }
//        instanceValue[0] = da;
//        // Mat
//        int mat = 0;
//        if ("Vang".equals(Mat)) {
//            mat = 0;
//        } else if ("BT".equals(Mat)) {
//            mat = 1;
//        }
//        instanceValue[1] = mat;
//        // Bung
//        int bung = 0;
//        if (null != Bung) switch (Bung) {
//            case "Chuong":
//                bung = 0;
//                break;
//            case "Dau":
//                bung = 1;
//                break;
//            case "KhoTieu":
//                bung = 2;
//                break;
//            case "BT":
//                bung = 3;
//                break;
//            default:
//                break;
//        }
//        instanceValue[2] = bung;
//        
//        //CamGiac
//        int camgiac = 0;
//         if (null != CamGiac) switch (CamGiac) {
//            case "BuonNon":
//                camgiac = 0;
//                break;
//            case "OChua":
//                camgiac = 1;
//                break;
//            case "BT":
//                camgiac = 2;
//                break;
//            default:
//                break;
//        }
//        instanceValue[3] = camgiac;
//        
//        int anuong = 0;
//        if (null != AnUong) switch (AnUong) {
//            case "ChanAn":
//                anuong = 0;
//                break;
//            case "KhongNgonMieng":
//                anuong = 1;
//                break;
//            case "BT":
//                anuong = 2;
//                break;
//            default:
//                break;
//        }
//        instanceValue[4] = anuong;
//        
//        int sot = 0;
//        if (null != Sot) switch (Sot) {
//            case "SotNhe":
//                sot = 0;
//                break;
//            case "SotCao":
//                sot = 1;
//                break;
//            case "BT":
//                sot = 2;
//                break;
//            default:
//                break;
//        }
//        instanceValue[5] = sot;
//        
//        int lop = 0;
//        if (null != Benh) switch (Benh) {
//            case "XoGan":
//                lop = 0;
//                break;
//            case "MenGanCao":
//                lop = 1;
//                break;
//            case "NhiemMo":
//                lop = 2;
//                break;
//            case "BT":
//                lop = 3;
//                break;
//            default:
//                break;
//        }
//        instanceValue[6] = lop;
//
//        dataRaw.add(new DenseInstance(1.0, instanceValue));
//        dataRaw.setClassIndex(dataRaw.numAttributes() - 1);
//
//        return dataRaw;
//    }
    
}

