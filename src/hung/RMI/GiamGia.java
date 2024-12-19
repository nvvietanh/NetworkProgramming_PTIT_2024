/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;


import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.*;
import java.rmi.registry.*;
/**
 *
 * @author ADMIN
 */
public class GiamGia {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService os = (ObjectService) rs.lookup("RMIObjectService");
        ProductX p = (ProductX) os.requestObject("B21DCCN156", "WvFfnZeK");
        
        System.out.println(p);
        
        int tong = 0;
        for(char x: p.getDiscountCode().toCharArray()) {
            if(Character.isDigit(x)) {
                tong += Integer.parseInt(x+"");
            }
        }
        
        p.setDiscount(tong);
        
        os.submitObject("B21DCCN156", "WvFfnZeK", p);
    }
}
