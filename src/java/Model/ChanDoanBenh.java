package Model;


import java.io.File;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jdt.internal.compiler.apt.dispatch.HookedJavaFileObject;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.PropertyPath;
import wekapro.MyDecisionTreeModel;
import wekapro.Program;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NhiPhan
 */
public class ChanDoanBenh {
    private static MyDecisionTreeModel model; 
    private static MyDecisionTreeModel tieuhoaModel;
    private static MyDecisionTreeModel hohapModel;
   // public static String path = new ChanDoanBenh().getClass().getResource("").getPath().split("/build/web/WEB-INF/classes/")[0];
    //public static String dataPath = path + "//data//Ver4";
    public static String dataPath = "D:\\Project\\Source\\Ver 0.4\\ChanDoanBenh-master\\data\\Ver4";
    public ChanDoanBenh() {
    }
    
    public static void init(){
         if(model==null)
            try {
                model = new MyDecisionTreeModel();
                tieuhoaModel = new MyDecisionTreeModel();
                hohapModel = new MyDecisionTreeModel();
                model.setTree((J48) model.loadModel(dataPath + "\\tree"));
                tieuhoaModel.setTree((J48) model.loadModel(dataPath +"\\tree_TieuHoa"));
                hohapModel.setTree((J48) model.loadModel(dataPath +"\\tree_HoHap"));
        } catch (Exception ex) {
                System.out.println(ex);
            try {
                firstBuild();
            } catch (Exception exl) {
                System.out.println(exl);
            }
        }
    }
    
    //TongQuat
    public static String chanDoan(TongQuat tq) throws Exception{
                init();
                String ketqua ="";
        try{
        Instances dataRaw = createRaw(tq);
        ketqua = model.predict(dataRaw);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
        return TuDien.tudien.get(ketqua);
    }
    //Ho Hap
    public static String chanDoan(HoHap hh) throws Exception{
                init();
                String ketqua ="";
        try{
        Instances dataRaw = createRaw(hh);       
        ketqua= hohapModel.predict(dataRaw);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
        return TuDien.tudien.get(ketqua);
    }
    //TieuHOa
     public static String chanDoan(TieuHoa th) throws Exception{
                 init();
                String ketqua ="";
        try{
        Instances dataRaw = createRaw(th);       
        ketqua= tieuhoaModel.predict(dataRaw);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
        return TuDien.tudien.get(ketqua);
    }
    
     //Tong quat
    private static Instances createRaw(TongQuat tq) {
        Program program = new Program();
        tq.Benh= "BT";
        return program.createInstance(tq);
    }

    // Tieu hoa
     private static Instances createRaw(TieuHoa th) {
        Program program = new Program();
        th.Benh = "BT";
        return program.createInstance(th);
    }
     
    // tạo dữ liệu ho hap
    private static Instances createRaw(HoHap hh) {
        Program program = new Program();
        hh.Benh = "BT";
        return program.createInstance(hh);
    }
    
    private static void firstBuild() throws Exception {
        model = new MyDecisionTreeModel(dataPath +"\\TongQuat.arff", "-C 0.25 -M 2");
        model.buildDecisionTree();
        System.out.println("Thông số cây:\n---------------------------------------------");
        System.out.println(model);
        model.saveModel(dataPath +"\\tree", model.getTree());
        model.setTree((J48) model.loadModel(dataPath +"\\tree"));
        System.out.println(model.getTree());
        System.out.println("Dự đoán:");
        System.out.println("---------------------------------------------");
        
        
        tieuhoaModel = new MyDecisionTreeModel(dataPath +"\\TieuHoa.arff", "-C 0.25 -M 2");
        tieuhoaModel.buildDecisionTree();
        System.out.println("Thông số cây:\n---------------------------------------------");
        System.out.println(tieuhoaModel);
        model.saveModel(dataPath +"\\tree_TieuHoa", tieuhoaModel.getTree());
        model.setTree((J48) tieuhoaModel.loadModel(dataPath +"\\tree_TieuHoa"));
        System.out.println(tieuhoaModel.getTree());
        System.out.println("Dự đoán:");
        System.out.println("---------------------------------------------");
        
        hohapModel = new MyDecisionTreeModel(dataPath +"\\HoHap.arff", "-C 0.25 -M 2");
        hohapModel.buildDecisionTree();
        System.out.println("Thông số cây về bênh tiêu hóa:\n---------------------------------------------");
        System.out.println(hohapModel);
        hohapModel.saveModel(dataPath +"\\tree_HoHap", hohapModel.getTree());
        hohapModel.setTree((J48) hohapModel.loadModel(dataPath +"\\tree_HoHap"));
        System.out.println(hohapModel.getTree());
        System.out.println("Dự đoán:");
        System.out.println("---------------------------------------------");
    }
    public static void main(String[] args) throws Exception {
        
        String path = new ChanDoanBenh().getClass().getResource("").getPath();
        String fullPath = URLDecoder.decode(path, "UTF-8");
        System.out.println(fullPath.split("/build/web/WEB-INF/classes/")[0]);
}
}
