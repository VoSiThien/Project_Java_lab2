/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20424073_lab2;

import java.util.*;
public class SlangWord {
    private String slang;
    private String definition;

    public SlangWord(){
    }
    public SlangWord(String slang, String definition) {
        this.slang = slang;
        this.definition = definition;
    }
    
    public String getSlang() {
        return slang;
    }

    public String getDefinition() {
        return definition;
    }

    public void setSlang(String slang) {
        this.slang = slang;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    
}
