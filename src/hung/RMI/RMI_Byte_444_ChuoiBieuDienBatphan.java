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

public class RMI_Byte_444_ChuoiBieuDienBatphan {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ByteService bs = (ByteService) rs.lookup("RMIByteService");
        
        
        String msv = "b21dccn444", mch = "DTeseqVn";
        byte [] buffer = bs.requestData(msv, mch);
        System.out.println(buffer.length);
        
        
        String ans = "";
        
        for(int i = 0; i < buffer.length; i++) {
//            System.out.println(x);
            String tmp = Integer.toOctalString( (int) buffer[i]); // Chuyển sang chuỗi bát phân
            while(tmp.length() < 3) {
                tmp = "0" +tmp;
            }
            ans +=tmp;
            
        }
        
        byte [] sendData = ans.getBytes();
        
        bs.submitData(msv, mch, sendData);
        
    }
}
