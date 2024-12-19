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

public class RMI_object_555_FinalSalary {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs= LocateRegistry.getRegistry("203.162.10.109");
        ObjectService os = (ObjectService) rs.lookup("RMIObjectService");
        
        String msv = "b21dccn555", mch = "neurcesn";
        Employee employee = (Employee) os.requestObject(msv,mch);
        System.out.println(employee);
        
        double  k = 0;
        k+= employee.getExperienceYears();
        for(char x : Integer.toString(employee.getExperienceYears()).toCharArray() ) {
            System.out.println(x -'0');
            k += x - '0';
        }
        
        int cnt = 0;
        for(int i = 1; i <= employee.getExperienceYears(); i++) {
            if( employee.getExperienceYears() % i == 0) {
                cnt ++;
            }
        }
        
        k += cnt;
        
        employee.setFinalSalary(employee.getBaseSalary()*(1+k/100));
        
        os.submitObject(msv, mch, employee);
        
    }
}
