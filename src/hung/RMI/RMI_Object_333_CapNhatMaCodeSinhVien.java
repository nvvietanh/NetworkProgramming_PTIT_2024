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
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;


public class RMI_Object_333_CapNhatMaCodeSinhVien {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        ObjectService os = (ObjectService) rs.lookup("RMIObjectService");
        
        String msv = "b21dccn333", mch = "ikwjlxgi";
        Student student = (Student) os.requestObject(msv, mch);
        System.out.println(student);
        
        String ten = "";
        
        String [] lsStr = student.getName().split("\\s+");
        
        for(int i = 0; i < lsStr.length; i++) {
            ten += lsStr[i].substring(0,1).toUpperCase() + lsStr[i].substring(1,lsStr[i].length()).toLowerCase() + " ";
        }
        
//        ten += lsStr[lsStr.length-1].toUpperCase();
        student.setName(ten.trim());
        System.out.println(student.getName());
        
        String code = "B";
        code += Integer.toString(student.getEnrollmentYear()).substring(2,4);
        code += lsStr[lsStr.length-1].toUpperCase() + "_";
        for(int i = 0; i < lsStr.length - 1; i++) {
            code += lsStr[i].substring(0,1).toUpperCase();
        }
        
        
        System.out.println(code);
        
        student.setCode(code);
        
        
        os.submitObject(msv, mch, student);
        
    }
}
