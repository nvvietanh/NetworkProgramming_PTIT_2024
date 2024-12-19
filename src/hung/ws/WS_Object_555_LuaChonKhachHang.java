/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import vn.medianews.*;
import vn.medianews.*;
import java.util.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author ADMIN
 */
public class WS_Object_555_LuaChonKhachHang {
    public static void main(String[] args) {
        ObjectService_Service service = new ObjectService_Service();
        ObjectService os = service.getObjectServicePort();
        
        String msv = "b21dccn555", mch = "w8qe7zmf";
        List<Customer> lsCustomer =  os.requestListCustomer(msv, mch);
        System.out.println(lsCustomer.size());
        
        
        List<Customer> ans = new ArrayList<>();
        for( Customer x : lsCustomer) {
            if(x.getPurchaseCount() >= 5 && x.getTotalSpent() > 5000) {
                ans.add(x);
            }
        }
        
        os.submitListCustomer(msv, mch, ans);
        
    }
}
