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

public class TCP_Byte_356_RLE {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ByteService bs= (ByteService) rs.lookup("RMIByteService");
        
        String msv =  "B21dccn356", mch = "xdszjIdo";
        byte [] lsNum = bs.requestData(msv, mch);
        System.out.println(lsNum.length);
        
        
        List<Byte> ans = new ArrayList<>();
        
        byte cnt = 1;
        for(int i = 0; i < lsNum.length; i++) {
            if(i + 1 < lsNum.length) {
                if(lsNum[i] == lsNum[i+1]) {
                    cnt++;
                } else {
                    ans.add(lsNum[i]);
                    ans.add(cnt);
                    cnt = 1;
                }
            } else {
                ans.add(lsNum[i]);
                ans.add(cnt);
            }
        }
        
        
        byte [] arrAns = new byte[ans.size()];
        int i  =0;
        for(byte x : ans) {
            arrAns[i] = x;
            i++;
        }
            
        bs.submitData(msv, mch, arrAns);
        
    }
}
