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
    public TreeMap<String, String> mapkey = new TreeMap<String, String>();
    public TreeMap<String, String> mapvalue = new TreeMap<String, String>();
    public ArrayList<String> listHistory = new ArrayList<String>();

    public processVMain() {
        String f = "slangnew.txt";
        p.loadData(mapkey, mapvalue, listHistory, f);
    }

    public Object [][] SearchSlang(String key) {
        Object [][] result = new Object[1][2];
        if (mapkey.containsKey(key)) {
            result[0][0] = key.toString();
            result[0][1] = mapkey.get(key).toString();
        }
        System.out.println(result[0][0] + " " + result[0][1]);
        return result;
    }

    public Object [][] SearchDefinition(String value) {
        Object [][] result = new Object[0][0];
        if (mapvalue.containsKey(value)) {
            String val = mapvalue.get(value);
            String[] list = val.split("\\s");

            result = new Object[list.length][2];
            for(int i = 0; i < list.length; i++){
                result[i][0] = list[i].replace("|", "").toString();
                result[i][1] = value.toString();
            }
        }
        return result;
    }

    public ArrayList<String> ListHistory() {
        return listHistory;
    }

    public int Add(String key, String value) {
        if (mapkey.containsKey(key)) {
            return 1;
        }
        String merge = key;
        if (mapvalue.containsValue(value)) {
            merge = mapvalue.get(value) + "| " + key;
        }
        mapkey.put(key, value);
        mapvalue.put(value, merge);
        return 0;
    }

    public int edit(String key, String newkey, String newvalue) {
        String value = mapkey.get(key);

        mapkey.remove(key);
        mapkey.put(newkey, newvalue);

        String marge = "";
        if (value.equals(newvalue)) {
            marge = mapvalue.get(value);// return definition
            marge = marge.replace(key, newkey);
            mapvalue.replace(value, marge);
        } else {
            marge = mapvalue.get(value);// return definition
            marge = marge.replace("| " + key, "");
            marge = marge.replace(key, "");

            if (marge.equals("")) {
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

    public int delete(String key) {
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
    public int reset() {
        String fs = "slang.txt";
        mapkey = new TreeMap<String, String>();
        mapvalue = new TreeMap<String, String>();
        p.loadData(mapkey, mapvalue, listHistory, fs);
        listHistory = new ArrayList<String>();
        return 0;
    }
}
