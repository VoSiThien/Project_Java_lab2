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

public class processVMain {

    processIO p = new processIO();
    private TreeMap<String, String> mapkey = new TreeMap<String, String>();
    private TreeMap<String, String> mapvalue = new TreeMap<String, String>();
    private ArrayList<String> listHistory = new ArrayList<String>();

    public processVMain() {
        String f = "../data/slangnew.txt";
        p.loadData(mapkey, mapvalue, listHistory, f);
        
    }
    public Object[][] getMapkey(){
        Object[][] result = new Object[mapkey.size()][2];
        int i = 0;
        for (Map.Entry m : mapkey.entrySet()) {
            result[i][0] = m.getKey();
            result[i][1] = m.getValue();
            i++;
        }

        return result;
    }

    public Object[][] SearchSlang(String key) {
        Object[][] result = new Object[1][2];
        if (mapkey.containsKey(key)) {
            result[0][0] = key.toString();
            result[0][1] = mapkey.get(key).toString();
        }
        listHistory.add(key);
        return result;
    }

    public Object[][] SearchDefinition(String value) {
        Object[][] result = new Object[0][0];
        if (mapvalue.containsKey(value)) {
            String val = mapvalue.get(value);
            String[] list = val.split("\\s");

            result = new Object[list.length][2];
            for (int i = 0; i < list.length; i++) {
                result[i][0] = list[i].replace("|", "").toString();
                result[i][1] = value.toString();
            }
        }
        listHistory.add(value);
        return result;
    }

    public ArrayList<String> ListHistory() {
        return listHistory;
    }

    public int reset() {
        String fs = "../data/slang.txt";
        mapkey = new TreeMap<String, String>();
        mapvalue = new TreeMap<String, String>();
        p.loadData(mapkey, mapvalue, listHistory, fs);
        
        listHistory = new ArrayList<String>();
        return 0;
    }

    public SlangWord ramdomSlang() {
        Object[] listkey = mapkey.keySet().toArray();
        Object key = listkey[new Random().nextInt(listkey.length)];
        String slang = key.toString() + ',' + mapkey.get(key);
        SlangWord s = new SlangWord(key.toString(), mapkey.get(key));
        return s;
    }

    public List<String> questionSlang() {
        Object[] listkey;
        listkey = mapkey.keySet().toArray();

        Object key = listkey[new Random().nextInt(listkey.length)];
        String value = mapkey.get(key);

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(mapkey.entrySet());
        Collections.shuffle(list);
        List<String> kq = new ArrayList<String>();
        kq.add(list.get(0).getValue());
        kq.add(list.get(1).getValue());
        kq.add(list.get(2).getValue());
        kq.add(value);
        Collections.shuffle(kq);
        kq.add(key.toString());
        kq.add(value.toString());
        return kq;
    }

    public List<String> questionDefinition() {
        Object[] listvalue;
        listvalue = mapvalue.keySet().toArray();

        Object value = listvalue[new Random().nextInt(listvalue.length)];
        String key = mapvalue.get(value);

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(mapvalue.entrySet());
        Collections.shuffle(list);

        List<String> kq = new ArrayList<String>();
        kq.add(list.get(0).getValue());
        kq.add(list.get(1).getValue());
        kq.add(list.get(2).getValue());
        kq.add(key);

        Collections.shuffle(kq);
        kq.add(value.toString());
        kq.add(key);
        return kq;
    }
    
    public void saveData(){
        String f = "../data/slangnew.txt";
        p.WriteDatatoFile(mapkey, listHistory, f);
    }
    
    public void OverWrite(String key, String newvalue) {
        String value = mapkey.get(key);
        mapkey.put(key, newvalue);
        String marge = "";
        marge = mapvalue.get(value);// return definition
        marge = marge.replace("| " + key, "");
        marge = marge.replace(key, "");
        

        if (marge.equals("")) {
            mapvalue.remove(value);
        } else {
            mapvalue.replace(value, marge);
        }
        if (mapvalue.containsKey(newvalue)) {
            marge = mapvalue.get(newvalue) + "| " + key;
            mapvalue.replace(newvalue, marge);
        } else {
            marge = key;
            mapvalue.put(newvalue, marge);
        }
    }
    
    public void Duplicate(String key, String value){
        String values = mapkey.get(key).toString();
        String valueshead = mapkey.get(key).toString();
        values = values.replace(value + "| ", "");
        values = values.replace("| " + value, "");
        values = values + "| " + value;
        mapkey.put(key, values);
        
        mapvalue.remove(valueshead);
        mapvalue.put(values, key);
    }
    
    public int addSlang(String Key, String value) {
        if (mapkey.containsKey(Key)) {
            return 1;
        }
        String merge = Key;
        if (mapkey.containsValue(value)) {
            merge = mapvalue.get(value) + "| " + Key;

        }
        mapkey.put(Key, value);
        mapvalue.put(value, merge);
        return 0;
    }
    
    public int edit(String key, String newkey, String newvalue) {
        String value = mapkey.get(key);
        if (!key.equals(newkey) && mapkey.containsKey(newkey)) {
            return 1;
        }
        else {
            mapkey.remove(key);
            mapkey.put(newkey, newvalue);

            String marge = "";
            if (value.equals(newvalue)) {
                marge = mapvalue.get(value);// return definition
                marge = marge.replace(key, newkey);
                mapvalue.replace(value, marge);
            } else {
                marge = mapvalue.get(value);// return definition
                marge = marge.replace(key + "| ", "");
                marge = marge.replace("| " + key, "");
                marge = marge.replace(key, "");

                if (marge.equals("") || marge.equals(" ")) {
                    mapvalue.remove(value);
                } else {
                    mapvalue.replace(value, marge);
                }
                if (mapvalue.containsKey(newvalue)) {
                    marge = mapvalue.get(newvalue) + "| " + newkey;
                    mapvalue.replace(newvalue, marge);
                } else {
                    marge = newkey;
                    mapvalue.put(newvalue, marge);
                }
            }
            return 0;
        }
    }
    
    public int deleted(String key) {
        if(mapkey.containsKey(key)){
            String value = mapkey.get(key);
            String merge = mapvalue.get(value);
            merge = merge.replace("| " + key, "");
            merge = merge.replace(key, "");
            if (merge.equals("")) {
                mapvalue.remove(value);
            } else {
                mapvalue.replace(value, merge);
            }
            mapkey.remove(key);
            return 0;
        }
        return 1;
    }
}
