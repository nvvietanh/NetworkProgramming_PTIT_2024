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


public class RMI_Byte_333_Octal {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ByteService bs = (ByteService) rs.lookup("RMIByteService");
        
        String msv = "b21dccn333", mch = "bfssqhjn";
        byte [] data = bs.requestData(msv, mch);
        System.out.println(data.length);
        
        String ans = "";
        for(byte x : data) {
            ans += String.format("%03o", (int) x);
        }
        
        bs.submitData(msv, mch, ans.getBytes());
        
        
    }
}
