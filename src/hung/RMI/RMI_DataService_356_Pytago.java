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

public class RMI_DataService_356_Pytago {
    
    public static int soConLai(int a, int b) {
        float x = (float) Math.sqrt(a*a + b* b);
        int y = (int) Math.floor(x);
        return y;
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        DataService ds = (DataService) rs.lookup("RMIDataService");
        
        String msv = "b21dccn356", mch = "cq3dswvl";
        int a = (int) ds.requestData(msv, mch);
        System.out.println(a);
        
//        int sqrt_a = (int) Math.sqrt(a);
        
        List<List<Integer>> ans = new ArrayList();
        for(int i = 3; i <= a; i++) {
            for(int j = i+1; j <= a; j++) {
                int c = soConLai(i, j);
                if(c <= a && c*c == i*i + j*j) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    tmp.add(c);
                    ans.add(tmp);
                }
            }
        }
        
        
        System.out.println(ans);
        
        ds.submitData(msv, mch, ans);
    }
}
