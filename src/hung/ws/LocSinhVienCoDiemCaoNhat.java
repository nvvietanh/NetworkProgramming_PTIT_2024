/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
//package ws;
//
//import java.util.*;
//import java.io.*;
//import vn.medianews.*;
////import java..*;
//
///**
// *
// * @author ADMIN
// */
//public class LocSinhVienCoDiemCaoNhat {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        ObjectService_Service service = new ObjectService_Service();
//        ObjectService port = service.getObjectServicePort();
//
//        List<StudentY> lsStudent = port.requestListStudentY("B21dccn409", "g2oUi5j6");
//        
//        System.out.println(lsStudent.size());
//
//        for (StudentY student : lsStudent) {
//            System.out.println("Name: " + student.getName());
//            System.out.println("Score: " + student.getScore());
//            System.out.println("Student ID: " + student.getStudentId());
//            System.out.println("Subject: " + student.getSubject());
//        }
//
//        Map<String, StudentY> ans = new LinkedHashMap<>();
//        
//        for (StudentY x : lsStudent) {
//            if (ans.containsKey(x.getSubject())) {
//                if (ans.get(x.getSubject()).getScore() < x.getScore()) {
//                    ans.put(x.getSubject(), x);
//                }
//            } else {
//                ans.put(x.getSubject(), x);
//            }
//        }
//
//        System.out.println(ans.size());
//        
//        
//        List<StudentY> lsStudentYs = new ArrayList<>(ans.values());
////        lsStudentYs.sort((Comparator<? super StudentY>) new Comparator<StudentY>() {
////            public int compare(StudentY a, StudentY b) {
////                return a.getStudentId().compareTo(b.getStudentId());
////            }
////        });
//        
//        System.out.println(lsStudentYs.get(lsStudentYs.size()-1).getScore() );
//        
//        port.submitListStudentY("B21DCCN409", "g2oUi5j6", lsStudentYs);
//        
//    }
//
//}
////
////package ws;
////import java.util.*;
////import java.io.*;
////import java.net.*;
////import vn.medianews.*;
////
////
////public class TinhTong {
////    public static void main(String[] args) {
////        DataService_Service service = new DataService_Service();
////        DataService port = service.getDataServicePort();
////        
////        
////        
////        List<Integer> lsNum = port.getData("b21dccn409", "HJKNP2Jr");
////        
////        
////        System.out.println(lsNum);
////        int sum = 0;
////        for(int x : lsNum) {
////            sum += x;
////        }
////        System.out.println(sum);
////        
////        port.submitDataInt("B21DCCN409", "HJKNP2Jr", sum);
////        
////    }
////}