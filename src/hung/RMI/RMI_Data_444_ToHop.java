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


import com.sun.jmx.remote.internal.ArrayQueue;
import java.util.*;
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;


public class RMI_Data_444_ToHop {
    
    private static List<Integer> lsNum;
    private static List<List<Integer>> ans;
    
    public static void toHop(int k, int i, List<Integer> tmp) {
        if(tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int j = i; j < lsNum.size() - k + tmp.size()+1; j++) {
            tmp.add(lsNum.get(j));
            toHop(k, j+1, tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109");
        DataService ds = (DataService) registry.lookup("RMIDataService");
        
        String msv = "b21dccn444", mch = "cduq8mna";
        String s = (String) ds.requestData(msv, mch);
        System.out.println(s);
        
        String [] lsStr = s.split("[\\;\\s\\,]+");
        
        int k = Integer.parseInt(lsStr[lsStr.length - 1]);
        lsNum = new ArrayList<>();
        ans = new ArrayList<>();
        
        for(int i = 0; i< lsStr.length-1; i++) {
            lsNum.add(Integer.parseInt(lsStr[i]));
        }
        System.out.println(lsNum.size());
        
        toHop(k, 0, new ArrayList<>());
        
        ds.submitData(msv, mch, ans);
        
    }
    
}
