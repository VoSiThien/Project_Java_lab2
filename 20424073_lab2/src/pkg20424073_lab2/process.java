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

public class process {
    public void ReadFileToTreeMap(){
        String f = "slang.txt";
        TreeMap<String,String> mapkey = new TreeMap<String,String>(); 
        TreeMap<String,String> mapvalue = new TreeMap<String,String>(); 
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String str = br.readLine();
            while (true) {
                str = br.readLine();
                if (str == null) {
                    break;
                }
                int check = 0;
                for(int i = 0; i< str.length(); i++){
                    if(str.charAt(i) == '`'){
                        check = i;
                        break;
                    }
                }
                String key = str.substring(0,check);
                String value = str.substring(check+1);
                if(check == 0){
                    value = str.substring(check);
                }
                
                mapkey.put(key, value);
                if(mapvalue.containsKey(value)){
                    String merge = mapvalue.get(value)+ "| " + key;
                    mapvalue.put(value, merge);
                }
                else{
                    mapvalue.put(value, key);
                }
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(process.class.getName()).log(Level.SEVERE, null, ex);
        }
//        for(Map.Entry m:mapvalue.entrySet()){    
//            System.out.println(m.getKey()+"----"+m.getValue());    
//        }
        System.out.println("key : " + mapvalue.get("Happy"));
    }
}
