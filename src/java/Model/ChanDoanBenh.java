package Model;


import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import wekapro.MyDecisionTreeModel;
import wekapro.Program;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nam
 */
public class ChanDoanBenh {
    private static MyDecisionTreeModel model; 
    private static MyDecisionTreeModel ganModel; 
    private static MyDecisionTreeModel tieuhoaModel;
    private static String dataPath="D:\\workspace\\Java\\ChanDoanBenh-master\\data";
    public ChanDoanBenh() {
    }
    
    public static String chanDoan(String da,String mat, String bung,String cannang,String camgiac) throws Exception{
        if(model==null)
            try {
                model = new MyDecisionTreeModel();
                ganModel = new MyDecisionTreeModel();
                tieuhoaModel = new MyDecisionTreeModel();
                model.setTree((J48) model.loadModel(dataPath + "\\tree"));
                ganModel.setTree((J48) model.loadModel(dataPath +"\\tree_Gan"));
                tieuhoaModel.setTree((J48) model.loadModel(dataPath +"\\tree_TieuHoa"));
        } catch (Exception ex) {
                System.out.println(ex);
            try {
                firstBuild();
            } catch (Exception exl) {
                System.out.println(exl);
            }
        }
        String ketqua;
        String sobo ="";
        try{
        sobo = model.predict(createRaw(da,mat,bung,cannang,camgiac));
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
        switch (sobo) {
            case "Gan":
                Instances ganRaw = createRaw(da, mat, bung, camgiac);
                ketqua = ganModel.predict(ganRaw);
                break;
            case "BaoTu":
                Instances tieuhoaRaw = createRaw(bung, camgiac);
                ketqua = tieuhoaModel.predict(tieuhoaRaw);
                break;
            default:
                ketqua = "Bình thường";
                break;
        }
        return ketqua;
       
    }
    
     private static Instances createRaw(String Da, String Mat, String Bung, String CanNang, String CamGiac) {
        Program program = new Program();
        String Benh = "BT";
        return program.createInstance(Da, Mat, Bung, CanNang, CamGiac, Benh);
    }
    
    private static Instances createRaw(String Da, String Mat, String Bung, String CamGiac) {
        Program program = new Program();
        String Benh = "BT";
        return program.createInstance(Da, Mat, Bung, CamGiac, Benh);
    }
    
    private static Instances createRaw(String Bung, String CamGiac) {
        Program program = new Program();
        String Benh = "BT";
        return program.createInstance(Bung, CamGiac, Benh);
    }
    private static void firstBuild() throws Exception {
        model = new MyDecisionTreeModel(dataPath +"\\D13IS.arff", "-C 0.25 -M 2");
        model.buildDecisionTree();
        System.out.println("Thông số cây:\n---------------------------------------------");
        System.out.println(model);
        model.saveModel(dataPath +"\\tree", model.getTree());
        model.setTree((J48) model.loadModel(dataPath +"\\tree"));
        System.out.println(model.getTree());
        System.out.println("Dự đoán:");
        System.out.println("---------------------------------------------");
        
        ganModel = new MyDecisionTreeModel(dataPath +"\\Gan.arff", "-C 0.25 -M 2");
        ganModel.buildDecisionTree();
        System.out.println("Thông số cây về bênh gan:\n---------------------------------------------");
        System.out.println(ganModel);
        ganModel.saveModel(dataPath +"\\tree_Gan", ganModel.getTree());
        ganModel.setTree((J48) ganModel.loadModel(dataPath +"\\tree_Gan"));
        System.out.println(ganModel.getTree());
        System.out.println("Dự đoán:");
        System.out.println("---------------------------------------------");
        
        tieuhoaModel = new MyDecisionTreeModel(dataPath +"\\TieuHoa.arff", "-C 0.25 -M 2");
        tieuhoaModel.buildDecisionTree();
        System.out.println("Thông số cây về bênh tiêu hóa:\n---------------------------------------------");
        System.out.println(tieuhoaModel);
        tieuhoaModel.saveModel(dataPath +"\\tree_TieuHoa", tieuhoaModel.getTree());
        tieuhoaModel.setTree((J48) tieuhoaModel.loadModel(dataPath +"\\tree_TieuHoa"));
        System.out.println(tieuhoaModel.getTree());
        System.out.println("Dự đoán:");
        System.out.println("---------------------------------------------");
    }
    public static void main(String[] args) throws Exception {
        String benh = ChanDoanBenh.chanDoan("NoiMun","Vang","KhoTieu","Cao","BT");
        System.out.println(benh);
    }
}
