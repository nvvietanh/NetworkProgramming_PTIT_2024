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
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import javax.sound.sampled.AudioFileFormat;

public class RMI_Data_333_SoNguyenToNhoHonN {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        DataService ds = (DataService) rs.lookup("RMIDataService");
        
        String msv = "b21dccn333", mch = "hdy0l2hw";
        int n  = (int)ds.requestData(msv, mch);
        System.out.println(n);
             
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i ++) {
            int sqrt_i = (int) Math.sqrt(i);
            boolean check = false;
            for(int j = 2; j <= sqrt_i; j ++) {
                if(i % j == 0) {
                    check = true;
                    break;
                }
            }
            
            if(check == false) {
                ans.add(i);
            }
        }
        
        
        System.out.println(ans);
        ds.submitData(msv, mch, ans);
        
        
    }
}
