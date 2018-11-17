/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author HANG
 */
public class ListTrieuChung {
    public static HashMap<String,List<String>> TrieuChung = new HashMap<String, List<String>>();
    public ListTrieuChung() throws IOException{
        if(TrieuChung.isEmpty()){
            addList("\\TongQuat.arff");
            addList("\\TieuHoa.arff");
            addList("\\HoHap.arff");
        }
    }
    public List<String> getList(String key){
        return TrieuChung.get(key);
    }
        public void addList(String filename) throws FileNotFoundException, IOException
        {
            BufferedReader inputReader = null;
            String filepath = ChanDoanBenh.dataPath + filename;
            try {
                inputReader = new BufferedReader(new FileReader(filepath));
                String line = "";
                while(!line.equals("@DATA")){
                    line = inputReader.readLine();
                    if(!line.contains("@ATTRIBUTE"))
                        continue;
                    String []l = line.split(" ");
                    l[2] = l[2].replace("{","").replace("}","");
                    List<String> list = Arrays.asList(l[2].split(","));
                    TrieuChung.put(l[1],list);
                }  
            System.out.println("");
            } catch (FileNotFoundException ex) {
                System.err.println("File not found: " + filename);
            }
    }
        public static void main(String[] args) throws FileNotFoundException, IOException {
            ListTrieuChung tc = new ListTrieuChung();
            HashMap<String,List<String>> ltc = tc.TrieuChung;
            System.out.println(TuDien.tudien.get(ltc.get("Sot").get(0)));

    }
    }

