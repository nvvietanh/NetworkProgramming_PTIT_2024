/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.registry.*;
import java.rmi.*;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class RMI_ByteStream_323_PhanTuLonThu3 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ByteService bs = (ByteService) rs.lookup("RMIByteService");
        
        byte [] lsNum = (byte []) bs.requestData("B21DCCN323", "3BSAsw4y");
        
        Byte [] lsByte = new Byte[lsNum.length];
        for (int i =0; i < lsByte.length; i++) {
            lsByte[i] = (Byte) lsNum[i];
        }
        
        System.out.println(lsNum.length);
        
        Arrays.sort(lsByte, (a, b) -> (b-a));
        
        
        byte k = lsNum[lsNum.length - 1];
        byte [] ans= new byte[2];
        ans[0] = lsByte[k-1];
        for(byte i = 0; i < lsNum.length; i++) {
            if (lsNum[i] == lsByte[k-1]) {
                ans[1] = (byte)((byte) i+1);
                break;
            }
        }
        
        bs.submitData("B21dccn323", "3bsasw4y", ans);
        
    }
}
