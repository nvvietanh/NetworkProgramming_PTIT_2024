///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ws;
//
///**
// *
// * @author ADMIN
// */
//
//import java.util.*;
//import java.io.*;
//import java.net.*;
//import java.rmi.*;
//import java.rmi.registry.*;
//import vn.medianews.*;
//
//public class WS_ObjectService_323_DanhSachKhachHangTiemNang {
//    
//    public static void main(String[] args) {
//        ObjectService_Service service = new ObjectService_Service();
//        ObjectService os = service.getObjectServicePort();
//        
//        String msv = "b21dccn323", mch = "lazvod1f";
//        List<Customer> lsCustomers = (List<Customer>) os.requestListCustomer(msv, mch);
//        System.out.println(lsCustomers);
//        
//        List<Customer> ans = new ArrayList<>();
//        for(Customer x : lsCustomers) {
//            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() > 5) {
//                ans.add(x);
//            }
//        }
//        
//        os.submitListCustomer(msv, mch, ans);
//        
//    }
//    
//}
