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

public class WS_Data_333_tinhTong {
    public static void main(String[] args) {
//        DataService_Service service = new DataService_Service();
//        DataService ds = service.getDataServicePort();
//        
//        
//        String msv = "B21DCCN333", mch = "f8oycj4l";
//        List<Integer> lsNum = (ArrayList<Integer>) ds.getData(msv, mch);
//        System.out.println(lsNum);
//        
//        int tong = 0;
//        for(int x : lsNum) {
//            tong += x;
//        }
//        
//        ds.submitDataInt(msv, mch, tong);
        
        
        DataService_Service service = new DataService_Service();
        DataService ds = service.getDataServicePort();
        
        String msv= "b21dccn333", mch = "f8OYcJ4L";
        List<Integer> lsNum = ds.getData(msv, mch);
        
        System.out.println(lsNum);
        
        int tong = 0;
        for( int x : lsNum ) {
            tong += x;
        }
        
        ds.submitDataInt(msv, mch, tong);
        
        
        
    }
}
