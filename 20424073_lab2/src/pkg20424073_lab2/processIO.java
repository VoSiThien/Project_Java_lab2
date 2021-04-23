/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424073_lab2;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.*;

public class processIO {
    public void loadData(TreeMap<String, String> mapkey, TreeMap<String, String> mapvalue, ArrayList<String> His, String f) {
        String history = "../data/history.txt";
        try {
            File file = new File(history);
            if (file.exists()) {
                BufferedReader bh = new BufferedReader(new FileReader(history));
                String s = "";
                while (true) {
                    s = bh.readLine();
                    if (s == null) {
                        break;
                    }
                    His.add(s);
                }
            }
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str = br.readLine();
            while (true) {
                str = br.readLine();
                if (str == null) {
                    break;
                }
                int check = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '`') {
                        check = i;
                        break;
                    }
                }
                String key = str.substring(0, check);
                String value = str.substring(check + 1);
                if (check == 0) {
                    value = str.substring(check);
                }

                mapkey.put(key, value);
                if (mapvalue.containsKey(value)) {
                    String merge = mapvalue.get(value) + "| " + key;
                    mapvalue.put(value, merge);
                } else {
                    mapvalue.put(value, key);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(processIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(processIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void WriteDatatoFile(TreeMap<String, String> mapkey, ArrayList<String> His, String f) {
        String history = "../data/history.txt";
        FileWriter writer;
        try {
            writer = new FileWriter(f);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("Slag`Meaning\n");
            for (Map.Entry m : mapkey.entrySet()) {
                if(!m.getKey().toString().equals("")){
                    buffer.write(m.getKey() + "`" + m.getValue() + "\n");
                }
                else{
                    buffer.write(m.getValue() + "\n");
                }
            }
            buffer.close();
            writer = new FileWriter(history);
            buffer = new BufferedWriter(writer);
            for(String s: His){
                buffer.write(s + "\n");
            }
            
            buffer.close();
        } catch (IOException ex) {
            Logger.getLogger(processIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
