/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug;
import weka.core.Debug.Random;
import weka.core.Instances;

/**
 *
 * @author dien
 */
public class MyDecisionTreeModel extends MyKnowledgeModel {

    public MyDecisionTreeModel(String filename, String model_option) throws Exception {
        super(filename, model_option);
    }

    public MyDecisionTreeModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return tree.toSummaryString();
    }

    J48 tree;

    public void buildDecisionTree() throws Exception {
        this.trainset = divideTrainTestR(this.dataset, 100, false);
        this.testset = divideTrainTestR(this.dataset, 100, true);
        this.trainset.setClassIndex(this.trainset.numAttributes() - 1);
        this.testset.setClassIndex(this.testset.numAttributes() - 1);
        this.dataset.setClassIndex(this.dataset.numAttributes() -1);
        tree = new J48();
        tree.setOptions(this.model_option);
        tree.buildClassifier(this.trainset);
    }

    public void evaluateDecisionTree() throws Exception {
        Random random = new Debug.Random(1);
        int folds = 5;
        Evaluation evaluation = new Evaluation(this.trainset);
        evaluation.crossValidateModel(tree, this.testset, folds, random);
        System.out.println(evaluation.toSummaryString("\n Đánh giá kết quả test đối với cây J48 vừa học:\n--------------------------------------", false));
    }

    public void predictClassLabel(Instances input) throws Exception {
        for (int i = 0; i < input.numInstances(); i++) {
            double predict = tree.classifyInstance(input.instance(i));
            double actual = input.instance(i).classValue();
            
            System.out.println("Intance thứ " + i + ": \nDự đoán: " + input.classAttribute().value((int) predict)
                    + " \nThực tế: " + input.classAttribute().value((int) actual));
        }
    }
    
    public String predict(Instances input) throws Exception {
            double predict = tree.classifyInstance(input.instance(0));
//            tree.
            return input.classAttribute().value((int) predict);
    }

    public J48 getTree() {
        return tree;
    }

    public void setTree(J48 tree) {
        this.tree = tree;
    }
    
    
    
}
