/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class Program {

    public Instances createInstance(String Da, String Mat, String Bung, String CanNang, String CamGiac, String Benh) {
        ArrayList<Attribute> atts = new ArrayList<>(6);
        ArrayList<String> classVal = new ArrayList<>(3);
        ArrayList<String> DaAtt = new ArrayList<>(2);
        ArrayList<String> MatAtt = new ArrayList<>(4);
        ArrayList<String> BungAtt = new ArrayList<>(3);
        ArrayList<String> CangNangAtt = new ArrayList<>(3);
        ArrayList<String> CamGiacAtt = new ArrayList<>(3);
        
        DaAtt.add("Vang");
        DaAtt.add("NoiMun");
        DaAtt.add("BT");
        
        MatAtt.add("Vang");
        MatAtt.add("BT");
        
        BungAtt.add("Chuong");
        BungAtt.add("Dau");
        BungAtt.add("KhoTieu");
        BungAtt.add("BT");
        
        CangNangAtt.add("Thap");
        CangNangAtt.add("Cao");
        CangNangAtt.add("BT");
        
        CamGiacAtt.add("BuonNon");
        CamGiacAtt.add("OChua");
        CamGiacAtt.add("BT");
        
        classVal.add("Gan");
        classVal.add("BaoTu");
        classVal.add("BT");
        
        atts.add(new Attribute("Da", DaAtt));
        atts.add(new Attribute("Mat", MatAtt));
        atts.add(new Attribute("Bung", BungAtt));
        atts.add(new Attribute("CanNang", CangNangAtt));
        atts.add(new Attribute("CamGiac", CamGiacAtt));
        atts.add(new Attribute("class", classVal));

        Instances dataRaw = new Instances("iris", atts, 0);
        double[] instanceValue = new double[dataRaw.numAttributes()];
        instanceValue[0] = dataRaw.attribute(0).addStringValue(Da);
        instanceValue[1] = dataRaw.attribute(1).addStringValue(Mat);
        instanceValue[2] = dataRaw.attribute(2).addStringValue(Bung);
        instanceValue[3] = dataRaw.attribute(3).addStringValue(CanNang);
        instanceValue[4] = dataRaw.attribute(4).addStringValue(CamGiac);
        // Da
        int da = 0;
        if (null != Da) switch (Da) {
            case "Vang":
                da = 0;
                break;
            case "NoiMun":
                da = 1;
                break;
            case "BT":
                da = 2;
                break;
            default:
                break;
        }
        instanceValue[0] = da;
        // Mat
        int mat = 0;
        if ("Vang".equals(Mat)) {
            mat = 0;
        } else if ("BT".equals(Mat)) {
            mat = 1;
        }
        instanceValue[1] = mat;
        // Bung
        int bung = 0;
        if (null != Bung) switch (Bung) {
            case "Chuong":
                bung = 0;
                break;
            case "Dau":
                bung = 1;
                break;
            case "KhoTieu":
                bung = 2;
                break;
            case "BT":
                bung = 3;
                break;
            default:
                break;
        }
        instanceValue[2] = bung;
        //CanNang
        int canNang = 0;
        if (null != CanNang) switch (CanNang) {
            case "Thap":
                canNang = 0;
                break;
            case "Cao":
                canNang = 1;
                break;
            case "BT":
                canNang = 2;
                break;
            default:
                break;
        }
        instanceValue[3] = canNang;
        //CamGiac
        int camGiac = 0;
        if (null != CamGiac) switch (CamGiac) {
            case "BuonNon":
                camGiac = 0;
                break;
            case "OChua":
                camGiac = 1;
                break;
            case "BT":
                camGiac = 2;
                break;
            default:
                break;
        }
        instanceValue[4] = camGiac;
        
        int lop = 0;
        if (null != Benh) switch (Benh) {
            case "Gan":
                lop = 0;
                break;
            case "BaoTu":
                lop = 1;
                break;
            case "BT":
                lop = 2;
                break;
            default:
                break;
        }
        instanceValue[5] = lop;

        dataRaw.add(new DenseInstance(1.0, instanceValue));
        dataRaw.setClassIndex(dataRaw.numAttributes() - 1);

        return dataRaw;
    }

    public Instances createInstance(String Da, String Mat, String Bung, String CamGiac, String Benh) {
        ArrayList<Attribute> atts = new ArrayList<>();
        ArrayList<String> classVal = new ArrayList<>();
        ArrayList<String> DaAtt = new ArrayList<>();
        ArrayList<String> MatAtt = new ArrayList<>();
        ArrayList<String> BungAtt = new ArrayList<>();
        ArrayList<String> CamGiacAtt = new ArrayList<>();
        
        DaAtt.add("Vang");
        DaAtt.add("NoiMun");
        
        MatAtt.add("Vang");
        MatAtt.add("BT");
        
        BungAtt.add("Chuong");
        BungAtt.add("Dau");
        BungAtt.add("KhoTieu");
        
        CamGiacAtt.add("BuonNon");
        CamGiacAtt.add("OChua");
        
        classVal.add("XoGan");
        classVal.add("MenGanCao");
        classVal.add("NhiemMo");
        
        atts.add(new Attribute("Da", DaAtt));
        atts.add(new Attribute("Mat", MatAtt));
        atts.add(new Attribute("Bung", BungAtt));
        atts.add(new Attribute("CamGiac", CamGiacAtt));
        atts.add(new Attribute("class", classVal));

        Instances dataRaw = new Instances("iris", atts, 0);
        double[] instanceValue = new double[dataRaw.numAttributes()];
        instanceValue[0] = dataRaw.attribute(0).addStringValue(Da);
        instanceValue[1] = dataRaw.attribute(1).addStringValue(Mat);
        instanceValue[2] = dataRaw.attribute(2).addStringValue(Bung);
        instanceValue[3] = dataRaw.attribute(3).addStringValue(CamGiac);
        // Da
        int da = 0;
        if (null != Da) switch (Da) {
            case "Vang":
                da = 0;
                break;
            case "NoiMun":
                da = 1;
                break;
            default:
                break;
        }
        instanceValue[0] = da;
        // Mat
        int mat = 0;
        if ("Vang".equals(Mat)) {
            mat = 0;
        } else if ("BT".equals(Mat)) {
            mat = 1;
        }
        instanceValue[1] = mat;
        // Bung
        int bung = 0;
        if (null != Bung) switch (Bung) {
            case "Chuong":
                bung = 0;
                break;
            case "Dau":
                bung = 1;
                break;
            case "KhoTieu":
                bung = 2;
                break;
            default:
                break;
        }
        instanceValue[2] = bung;
        
        //CamGiac
        int camGiac = 0;
        if (null != CamGiac) switch (CamGiac) {
            case "BuonNon":
                camGiac = 0;
                break;
            case "OChua":
                camGiac = 1;
                break;
            default:
                break;
        }
        instanceValue[3] = camGiac;
        
        int lop = 0;
        if (null != Benh) switch (Benh) {
            case "XoGan":
                lop = 0;
                break;
            case "MenGanCao":
                lop = 1;
                break;
            case "NhiemMo":
                lop = 2;
                break;
            default:
                break;
        }
        instanceValue[4] = lop;

        dataRaw.add(new DenseInstance(1.0, instanceValue));
        dataRaw.setClassIndex(dataRaw.numAttributes() - 1);

        return dataRaw;
    }
        
    public Instances createInstance(String Bung, String CamGiac, String Benh) {
        ArrayList<Attribute> atts = new ArrayList<>();
        ArrayList<String> classVal = new ArrayList<>();
        ArrayList<String> BungAtt = new ArrayList<>();
        ArrayList<String> CamGiacAtt = new ArrayList<>();
        
        BungAtt.add("Chuong");
        BungAtt.add("Dau");
        BungAtt.add("KhoTieu");
        
        CamGiacAtt.add("BuonNon");
        CamGiacAtt.add("OChua");
        
        classVal.add("BaoTu");
        classVal.add("ChuongBung");
        
        atts.add(new Attribute("Bung", BungAtt));
        atts.add(new Attribute("CamGiac", CamGiacAtt));
        atts.add(new Attribute("class", classVal));

        Instances dataRaw = new Instances("iris", atts, 0);
        double[] instanceValue = new double[dataRaw.numAttributes()];
        instanceValue[0] = dataRaw.attribute(0).addStringValue(Bung);
        instanceValue[1] = dataRaw.attribute(1).addStringValue(CamGiac);

        // Bung
        int bung = 0;
        if (null != Bung) switch (Bung) {
            case "Chuong":
                bung = 0;
                break;
            case "Dau":
                bung = 1;
                break;
            case "KhoTieu":
                bung = 2;
                break;
            default:
                break;
        }
        instanceValue[0] = bung;
        
        //CamGiac
        int camGiac = 0;
        if (null != CamGiac) switch (CamGiac) {
            case "BuonNon":
                camGiac = 0;
                break;
            case "OChua":
                camGiac = 1;
                break;
            default:
                break;
        }
        instanceValue[1] = camGiac;
        
        int lop = 0;
        if (null != Benh) switch (Benh) {
            case "BaoTu":
                lop = 0;
                break;
            case "ChuongBung":
                lop = 1;
                break;
            default:
                break;
        }
        instanceValue[2] = lop;

        dataRaw.add(new DenseInstance(1.0, instanceValue));
        dataRaw.setClassIndex(dataRaw.numAttributes() - 1);

        return dataRaw;
    }
}
