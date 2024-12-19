/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author ADMIN
 */

import java.util.*;
import java.net.*;
import java.io.*;
import vn.medianews.*;
import vn.medianews.*;

public class WS_Data_555_SoThapPhan {
    public static void main(String[] args) {
        DataService_Service service = new DataService_Service();
        DataService ds = service.getDataServicePort();
        
        String msv = "b21dccn555", mch = "aqfhmooe";
        Double a = ds.getDataDouble(msv , mch);
        System.out.println(a);
        
        float j = 0;
        double ans1 = 0, ans2 = 0;
        for(int i = 1; i < 1000000; i++) {
            ans1 = Math.round(a*i);
            if( Math.abs(ans1 - a*i) < 0.0001) {
                ans2 = i;
                break;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add((int) ans1);
        ans.add((int) ans2);
        
        ds.submitDataIntArray(msv, mch, ans);
        
    }
}
