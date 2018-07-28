/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import java.util.ArrayList;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.Debug;
import weka.core.DenseInstance;
import weka.core.Instances;

/**
 *
 * @author dien
 */
public class WekaPro {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

//        MyKnowledgeModel model = new MyKnowledgeModel(
//                "C:\\Users\\dien\\Desktop\\tt-tDuy\\iris.arff",
//                null);
//        System.out.println(model);
//        
//        //model.saveData("C:\\Users\\dien\\Desktop\\tt-tDuy\\Data\\iris.arff");
//        model.saveDataCSV("C:\\Users\\dien\\Desktop\\tt-tDuy\\Data\\iris.csv");
//        model.trainset = model.divideTrainTestR(model.dataset, 90, false);
//        model.testset = model.divideTrainTestR(model.dataset, 10, true);
//        
//        System.out.println(model);
//        System.out.println(model.trainset.toSummaryString());
//        System.out.println(model.testset.toSummaryString());
//        System.out.println(String.valueOf(model.trainset.size()));
        MyDecisionTreeModel model = new MyDecisionTreeModel(
                "C:\\Users\\Nam\\Documents\\NetBeansProjects\\ChanDoan\\data\\D13IS.arff",
                "-C 0.25 -M 2");
        model.buildDecisionTree();
        System.out.println("Thông số cây:\n---------------------------------------------");
        System.out.println(model);
        model.saveModel("C:\\Users\\Nam\\Documents\\NetBeansProjects\\ChanDoan\\data\\tree", model.tree);
        model.tree = (J48) model.loadModel("C:\\Users\\Nam\\Documents\\NetBeansProjects\\ChanDoan\\data\\Tree");
        System.out.println(model.tree);

        System.out.println("Dự đoán:");
        System.out.println("---------------------------------------------");
        Program program = new Program();
        //Phần này nhập vào từ form nha mấy chế:
        String Da = "NoiMun";
        String Mat = "BT";
        String Bung = "BT";
        String CanNang = "BT";
        String CamGiac = "OChua";
        String Benh = "BT";
        //
        Instances dataRaw = program.createInstance(Da, Mat, Bung, CanNang, CamGiac, Benh);
        //model.saveData("C:\\Users\\dien\\Desktop\\tt-tDuy\\Data\\iris1.arff", dataRaw);
        //MyDecisionTreeModel model1 = new MyDecisionTreeModel("C:\\Users\\dien\\Desktop\\tt-tDuy\\Data\\iris1.arff","-C 0.25 -M 2");
        // model.predictClassLabel(model.testset);
        model.predictClassLabel(dataRaw);
        System.out.println(System.getProperty("user.dir"));
    }

}
