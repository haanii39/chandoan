/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wekapro;

import java.io.File;
import java.io.IOException;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.filters.unsupervised.instance.Resample;

/**
 *
 * @author NhiPhan
 */
public class MyKnowledgeModel {

    DataSource source;
    Instances dataset;
    Instances trainset;
    Instances testset;
    String[] model_option;

    public MyKnowledgeModel() {
    }

    public MyKnowledgeModel(String filename, String model_option) throws Exception {
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
        this.dataset.setClassIndex(this.dataset.numAttributes() - 1);
        if (model_option != null) {
            this.model_option = weka.core.Utils.splitOptions(model_option);
        }
    }

    @Override
    public String toString() {
        return dataset.toSummaryString();
    }

    public void saveData(String filename, Instances dataset) throws IOException {
        ArffSaver outData = new ArffSaver();
        outData.setInstances(dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("save done");
    }

    public void saveDataCSV(String filename) throws IOException {
        CSVSaver outData = new CSVSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("save done");
    }

    public Instances divideTrainTest(Instances originalSet, double percent, boolean isTest) throws Exception {
        RemovePercentage rp = new RemovePercentage();
        rp.setPercentage(percent);
        rp.setInvertSelection(isTest);
        rp.setInputFormat(originalSet);
        return Filter.useFilter(originalSet, rp);
    }

    public Instances divideTrainTestR(Instances originalSet, double percent, boolean isTest) throws Exception {
        Resample rs = new Resample();
        rs.setNoReplacement(true);
        rs.setSampleSizePercent(percent);
        rs.setInvertSelection(isTest);
        rs.setInputFormat(originalSet);
        return Filter.useFilter(originalSet, rs);
    }

    public void saveModel(String filename, Object model) throws Exception {
        weka.core.SerializationHelper.write(filename, model);
    }

    public Object loadModel(String filename) throws Exception {
        return weka.core.SerializationHelper.read(filename);
    }
}
