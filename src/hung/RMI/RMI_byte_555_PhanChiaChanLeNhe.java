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

public class RMI_byte_555_PhanChiaChanLeNhe {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ByteService bs = (ByteService) rs.lookup("RMIByteService");
        
        String msv = "b21dccn555", mch = "xi3hbsiy";
        byte [] data = bs.requestData(msv, mch);
        
        System.out.println(data.length);
        
        byte [] ans = new byte[data.length];
        int i = 0;
        for(int j = 0; j < data.length; j++) {
            if(data[j] % 2 == 0) {
                ans[i] = data[j];
                i++;
            }
        }
        
        
        for(int j = 0; j< data.length; j++) {
            if(data[j]%2==1) {
                ans[i] = data[j];
                i++;
            }
        }
        
        bs.submitData(msv, mch, ans);
        
    }
}
