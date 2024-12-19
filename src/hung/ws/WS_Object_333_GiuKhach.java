/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

//import RMI.ObjectService;




import java.util.*;
import java.io.*;
import java.net.*;
import java.time.*;
import vn.medianews.*;
import vn.medianews.*;


//import sun.util.resources.LocaleData;



/**
 *
 * @author ADMIN
 */
public class WS_Object_333_GiuKhach {
    public static void main(String[] args) {
//        ObjectService_Service service = new ObjectService_Service();
//        ObjectService os = service.getObjectServicePort();
//        
//        String msv = "b21dccn333", mch = "pl3fxxsz";
//        List<CustomerY> lsCustomerY =  (List<CustomerY>) os.requestListCustomerY(msv, mch);
//        System.out.println(lsCustomerY.size());
//        
//        
//        List<CustomerY> ans = new ArrayList<>();
//        for( CustomerY x : lsCustomerY) {
//            LocalDate date = LocalDate.now();
////            System.out.println(x.getLastTransactionDate());
//            if(x.getLastTransactionDate().getYear() < date.getYear()) {
//                ans.add(x);
//            } else if(x.getLastTransactionDate().getMonth() < date.getMonthValue() - 6) {
//                System.out.println(x.getLastTransactionDate().getMonth());
//                ans.add(x);
//            } else if(x.getLastTransactionDate().getDay() < date.getDayOfMonth() && ( x.getLastTransactionDate().getMonth() == date.getMonthValue() - 6) ) {
//                ans.add(x);
//            }
//
//        }
//        
//        
//        os.submitListCustomerY(msv, mch, ans);
        
        
        ObjectService_Service service = new ObjectService_Service();
        ObjectService os = service.getObjectServicePort();
        
        String msv = "b21dccn333", mch = "pL3fxXsZ";
        List<CustomerY> lsCustomer = os.requestListCustomerY(msv, mch);
        
        System.out.println(lsCustomer.size());
        
        List<CustomerY> ans = new ArrayList<>();
        for( CustomerY x : lsCustomer ) {
            LocalDate now = LocalDate.now();
            
            
            System.out.println(x.getLastTransactionDate().getDay());
            if( x.getLastTransactionDate().getYear() < now.getYear() ) {
                ans.add(x);
            } else if(x.getLastTransactionDate().getMonth() < now.getMonthValue() - 6 ) {
                ans.add(x);
            } else if(x.getLastTransactionDate().getDay() < now.getDayOfMonth() && x.getLastTransactionDate().getMonth() == now.getMonthValue()-6 ) {
                ans.add(x);
            }
        }
        
        os.submitListCustomerY(msv, mch, ans);
        
    }
}
