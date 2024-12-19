///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ws;
//
//import vn.medianews.*;
//import java.util.*;
//import java.io.*;
//import java.net.*;
//
///**
// *
// * @author ADMIN
// */
//public class WS_DataService_323_PhanTichThuaSoNguyenTo {
//    public static void main(String[] args) {
//        DataService_Service service = new DataService_Service();
//        DataService ds = service.getDataServicePort();
//        
//        String msv = "B21DCCN323", mch = "Yjqxwkeb";
//        List<Integer> lsNum = ds.getData("b21DCCN323", mch);
//        System.out.println(lsNum);
//        
//        List<String> ansList = new ArrayList<>();
//        for( int x : lsNum ) {
//            String ans  = "";
//            int i = 2;
//            int tmp_x = x;
//            int sqrt_x = (int) Math.sqrt(x);
//            while (tmp_x > 1 && i < x) {
//                while (tmp_x % i == 0) {
//                    ans += i + ", ";
//                    tmp_x /= i;
//                }
//                i++;
//            }
//            
//            if(ans.equals("")) {
//                ans = x+"";
//            } else {
//                ans = ans.substring(0, ans.length()-2);
//            }
//            System.out.println(ans);
//            ansList.add(ans);
//            
//            
//        }
//        
////        System.out.println("");
//        
////        String [] send = ansList.toArray(new String[0]);
//        ds.submitDataStringArray(msv, mch, ansList );
//        
//    }
//}
