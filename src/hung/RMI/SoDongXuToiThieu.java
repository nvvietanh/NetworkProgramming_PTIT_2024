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

public class SoDongXuToiThieu {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        DataService ds = (DataService) rs.lookup("RMIDataService");
        
        String msv = "B21DCCN323", mch = "IVwZ7608";
        int money = (int) ds.requestData(msv, mch);
        System.out.println(money);
        
        int cnt = 0;
        String ans = "";
        
        int[] gia = {10, 5, 2, 1};
        int i = 0;
        while (money > 0) {
            while (money < gia[i]) {
                i++;
            }
            money -= gia[i];
            ans += gia[i] +",";
            cnt ++;
        }
        
        ans = cnt + "; " + ans;
        ans = ans.substring(0, ans.length()-1);
        
        System.out.println(ans);
        ds.submitData(msv, mch, ans);
    }
}
