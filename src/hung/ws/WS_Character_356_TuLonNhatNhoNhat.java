package ws;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//import java.rmi.RemoteException;
import vn.medianews.*;
import vn.medianews.*;
import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author ADMIN
 */
public class WS_Character_356_TuLonNhatNhoNhat {
    public static void main(String[] args) {
        CharacterService_Service service =  new CharacterService_Service();
        CharacterService cs = (CharacterService) service.getCharacterServicePort();
        
        String msv = "b21dccn356", mch = "p08m4jdv";
        String s = cs.requestString(msv, mch);
        System.out.println(s);
        
        String [] lsStr = s.split("\\s+");
        
        String max = "";
        String min = "                                                                                                                 ";
        for(int i = 0; i < lsStr.length; i++) {
            if(max.length() < lsStr[i].length()) {
                max = lsStr[i];
            }
            if(min.length() > lsStr[i].length()) {
                min = lsStr[i];
            }
        }
        
        
        String ans = max + "; " + min;
        
        cs.submitCharacterString(msv, mch, ans);
        
        
    }
}
