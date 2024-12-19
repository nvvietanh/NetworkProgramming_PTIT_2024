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

public class RMI_Object_356_TaoMa {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService os = (ObjectService) rs.lookup("RMIObjectService");
        
        String msv = "b21dccn356", mch = "iclixoz3";
        Order order = (Order) os.requestObject(msv, mch);
        System.out.println(order);
        
        String orderCode  ="";
        orderCode += order.getShippingType().substring(0,2).toUpperCase();
        
        int len = order.getCustomerCode().length();
        orderCode += order.getCustomerCode().substring(len-3, len);
        
        
        String [ ] lsStr = order.getOrderDate().split("\\-+");
        orderCode += lsStr[2] + lsStr[1];
        
        System.out.println(orderCode);
        order.setOrderCode(orderCode);
        
        os.submitObject(msv, mch, order);
        
    }
}
