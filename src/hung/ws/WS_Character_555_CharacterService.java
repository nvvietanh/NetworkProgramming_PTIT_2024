/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import vn.medianews.*;
import vn.medianews.*;
import java.util.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author ADMIN
 */



public class WS_Character_555_CharacterService {
    public static void main(String[] args) {
        CharacterService_Service service = new CharacterService_Service();
        CharacterService cs =  service.getCharacterServicePort();
        
        String msv = "b21dccn555", mch = "3iq4ojti";
        List<String> lsStr = cs.requestStringArray(msv, mch);
        
        System.out.println(lsStr.size());
        
        lsStr.sort((Comparator<? super String>) new Comparator<String>() {

            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        
        cs.submitCharacterStringArray(msv, mch, lsStr);
        
        
    }
}
