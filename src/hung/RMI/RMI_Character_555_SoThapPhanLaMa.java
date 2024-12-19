/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author ADMIN
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;

public class RMI_Character_555_SoThapPhanLaMa {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService cs = (CharacterService) rs.lookup("RMICharacterService");
        
        String msv = "b21dccn555", mch = "zxhaazik";
        String s = cs.requestCharacter(msv, mch);
        System.out.println(s);
        int n = Integer.parseInt(s);
        
        int [] tp = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1, 0};
        String [] lm = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V" , "IV", "I", " "};
        String ans ="";
        int j = 0;
        while (n > 0) {
            while(n < tp[j]) {
                j++;
            }
            ans += lm[j];
            n -= tp[j];
        }
        
        // 2500
        
        cs.submitCharacter(msv, mch, ans);
//        while
        
    }
}
