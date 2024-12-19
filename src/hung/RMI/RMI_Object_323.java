/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.registry.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.*;
/**
 *
 * @author ADMIN
 */
public class RMI_Object_323 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService os = (ObjectService) rs.lookup("RMIObjectService");
        
        String msv = "B21DCCn323", mch = "WxJthZfg";
        Book b = (Book) os.requestObject("b21dccn323", "WxJthZfg");
        
        System.out.println(b);
        
        String ans = "";
        
        // lay ten dau
        String [] lsStr = b.getAuthor().trim().split("\\s+");
        ans += (lsStr[0].charAt(0) + "").toUpperCase() + (lsStr[lsStr.length - 1].charAt(0) + "").toUpperCase();
        
        String s = Integer.toString(b.getYearPublished());
        ans += s.substring(s.length()-2, s.length());
        
        ans+= b.getTitle().length();
        ans += String.format("%03d", b.getPageCount());
        
        System.out.println(ans);
        
        b.setCode(ans);
        os.submitObject(msv, mch, b);
        
        
    }
}
