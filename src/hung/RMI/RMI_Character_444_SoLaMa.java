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

import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;

public class RMI_Character_444_SoLaMa {
    
    public static String chuyenDoi (String s) {
        int ans = 0;
        
        Map<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10  );
        mp.put('L', 50  );
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        
        int i = s.length() - 2;
        System.out.println(i);
        ans += mp.get(s.charAt(s.length()-1));
        while (i >= 0) {
            System.out.println(i);
            if( mp.get(s.charAt(i)) < mp.get(s.charAt(i+1)) ) {
                System.out.println(s.charAt(i));
                ans -= mp.get(  s.charAt(i));
            } else ans += mp.get(  s.charAt(i));
            i--;
        }
        
        return Integer.toString(ans);
        
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService cs = (CharacterService) rs.lookup("RMICharacterService");
        
        String msv = "b21dccn444", mch = "uhl1loTC";
        String s = cs.requestCharacter(msv  , mch);
        System.out.println(s);
        
        System.out.println(chuyenDoi(s));
        
        cs.submitCharacter(msv, mch, chuyenDoi(s));
        
    }
}
