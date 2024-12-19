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
//import java.io.*;
//import java.util.*;
//import java.net.*;
//import java.rmi.*;
//import java.rmi.registry.*;
//import vn.medianews.*;
//
//public class WS_CharacterService_323_TuLonNhatnhoNhat {
//    public static void main(String[] args) throws RemoteException {
//        CharacterService_Service service = new CharacterService_Service();
//        CharacterService cs = service.getCharacterServicePort();
//        
//        String msv = "B21DCCn323", mch = "kPFIMTxU";
//        String s = (String) cs.requestString(msv, mch);
//        System.out.println(s);
//        String [] lsStr = s.split("[\\s]+");
//        
//        int maxLength = -1, minLength = 10000;
//        String maxString = "", minString = "";
//        for(String x: lsStr) {
//            if(x.length() > maxLength) {
//                maxLength = x.length();
//                maxString = x;
//            }
//            else if(x.length() < minLength) {
//                minLength = x.length();
//                minString = x;
//            }
//        }
//        
//        String ans = maxString + "; " + minString;
//        System.out.println(ans);
//        cs.submitCharacterString(msv, mch, ans);
//        
//    }
//}
