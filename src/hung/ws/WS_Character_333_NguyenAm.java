///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package ws;
//
/////**
//// *
//// * @author ADMIN
//// */
////
////import java.util.*;
////import java.net.*;
////import java.io.*;
////import javafx.util.Pair;
////import vn.medianews.*;
////import vn.medianews.*;
////
////        
////        
////public class WS_Character_333_NguyenAm {
////    public static void main(String[] args) {
////        CharacterService_Service service = new CharacterService_Service();
////        CharacterService cs = service.getCharacterServicePort();
////        
////        String msv = "B21DCCN333", mch = "jft4tbbo";
////        
////        List<String> lsStr = (List<String>)cs.requestStringArray(msv, mch);
////        System.out.println(lsStr);
////        lsStr.sort((Comparator<? super String>) new Comparator<String>() {
////
////            public int compare(String x, String y) {
////                return  x.compareTo(y);
////            }
////        });
////        
////        Map<Integer, List<String>> mp = new TreeMap<>();
////        for(String x : lsStr) {
////            int cnt = 0;
////            for(char y : x.toCharArray()) {
////                if(y == 'i' || y == 'a' || y == 'e' || y == 'o' || y =='u' || y == 'A' || y == 'E' || y =='I' || y == 'O' || y == 'U') {
////                    cnt ++;
////                }
////            }
////            if(!mp.containsKey(cnt)) {
////                List<String> tmp = new ArrayList();
////                tmp.add(x);
////                mp.put(cnt, tmp);
////            } else {
////                mp.get(cnt).add(x);
////            }
////        }
////        
////        
////        List<String> lsAns = new ArrayList<>();
////        
////        System.out.println(mp.keySet());
////        
////        for(int x: mp.keySet()) {
////            mp.get(x).sort((Comparator<? super String>) new Comparator<String>() {
////
////                public int compare(String a, String b) {
////                    return a.compareTo(b);
////                }
////            });
////            
////            String ans = "";
////            
////            for(String y : mp.get(x)) {
////                ans += y + ", ";
////            }
////            ans = ans.substring(0, ans.length()-2);
////            
////            lsAns.add(ans);
////        }
////        
////        for(String x: lsAns) {
////            System.out.println(x);
////        }
////        
//////        lsAns.sort((Comparator<? super String>) new Comparator<String>() {
//////
//////            public int compare(String x, String y) {
//////                return x.compareTo(y);
//////            }
//////        });
//////        
////        cs.submitCharacterStringArray(msv, mch, lsAns);
////        
////    }
////}
////
////
////
////
////
//
//
//
//
//
////
////
////Nguyễn Hoàng Hải
////package WebService.B21DCCN012;
////import vn.medianews.*;
////import java.util.*;
////public class NhomTuTheoNguyenAm {
////    public static void main(String[] args) throws Exception {
////        String msv = "B21DCCN012", qCode = "32He7sZg"; 
////        CharacterService_Service service = new CharacterService_Service();
////        CharacterService port = service.getCharacterServicePort();
////        List<String> a = port.requestStringArray(msv, qCode);
////        System.out.println(a);
////        Collections.sort(a, new Comparator<String>() {
////            @Override
////            public int compare(String s1, String s2) {
////                if(dem(s1)!=dem(s2)) return dem(s1) - dem(s2);
////                return s1.compareTo(s2);
////            }
////        });
////        List<String>ans = new java.util.ArrayList<>();
////        String gr = a.get(0);
////        for(int i = 1;i<a.size();i++){
////            if(dem(a.get(i))==dem(a.get(i - 1))) gr+=", " + a.get(i);
////            else{
////                ans.add(gr);
////                gr = a.get(i);
////            }
////        }
////        ans.add(gr);
////        // c. Triệu gọi phương thức submitCharacterStringArray để gửi mảng đã sắp xếp
////        port.submitCharacterStringArray(msv, qCode, ans);
////    }
////    // Hàm đếm số nguyên âm trong chuỗi
////    private static int dem(String str) {
////        int cnt = 0;
////        // Các ký tự nguyên âm
////        String ngAm = "aeiouAEIOU";
////        for (int i = 0; i < str.length(); i++) {
////            if (ngAm.indexOf(str.charAt(i)) != -1) cnt++;
////        }
////        return cnt;
////    }
////}
//
//
//
//
//
//
//
//import java.util.*;
//import java.net.*;
//import java.io.*;
//import vn.medianews.*;
//import vn.medianews.*;
//
//public class WS_Character_333_NguyenAm{
//    public static void main(String[] args) {
//        CharacterService_Service service = new CharacterService_Service();
//        CharacterService cs = service.getCharacterServicePort();
//        
//        
//        String msv = "b21dccn333", mch = "jft4tbbo";
//        List<String> lsStr = cs.requestStringArray(msv, mch);
//        System.out.println(lsStr.size());
//        
//        Map<Integer, List<String>> mp = new TreeMap<>();
//        
//        for(String x : lsStr) {
//            String nguyenAm = "ieouaIAEOU";
//            int cnt = 0;
//            for(char y : x.toCharArray()) {
//                if(nguyenAm.indexOf(y) != -1) {
//                    cnt++;
//                }
//            }
//            
//            if(!mp.containsKey(cnt)) {
//                mp.put(cnt, new ArrayList<>());
//            }
//            mp.get(cnt).add(x);
//        }
//        
//        
//        List<String> lsAns = new ArrayList<>();
//        for(int x: mp.keySet()) {
//            mp.get(x).sort((Comparator<? super String>) new Comparator<String>() {
//
//                public int compare(String o1, String o2) {
//                    return o1.compareTo(o2);
//                }
//            });
//            
//            String ans = "";
//            for(String y : mp.get(x)) {
//                ans += y + ", ";
//            }
//            
//            ans = ans.substring(0, ans.length()-2); 
//            System.out.println(ans);
//            lsAns.add(ans);
//        }
//        
//        cs.submitCharacterStringArray(msv, mch, lsAns);
//        
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
