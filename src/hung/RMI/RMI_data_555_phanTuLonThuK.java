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

public class RMI_data_555_phanTuLonThuK {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        DataService ds = (DataService) rs.lookup("RMIDataService");
        
        String msv = "b21dccn555", mch = "kxyk2hts";
        String s = (String) ds.requestData(msv, mch);
        System.out.println(s);
        
        
        String [] lsStr = s.trim().split("[\\s\\,\\;]+");
        
        int k = Integer.parseInt(lsStr[lsStr.length-1]);
        
        List<Integer> lsNum = new ArrayList<>();
        for(int i = 0; i < lsStr.length; i++) {
            lsNum.add(Integer.parseInt(lsStr[i]));
        }
        
        lsNum.sort((Comparator<? super Integer>) new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return  o2 - o1;
            }
        });
        
        
        System.out.println(lsNum);
        
        ds.submitData(msv, mch, lsNum.get(k-1));
        
    }
}
