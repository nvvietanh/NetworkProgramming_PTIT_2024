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
//import vn.medianews.ObjectService;

public class RMI_Object_444_TinhFinalSalary {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs= LocateRegistry.getRegistry("203.162.10.109");
        ObjectService os = (ObjectService) rs.lookup("RMIObjectService");
        
        String msv ="b21dccn444", mch = "z1e0u2gp";
        Employee employee = (Employee) os.requestObject(msv , mch);
        System.out.println(employee);
        
        double k = employee.getExperienceYears();
        
        int tmp = employee.getExperienceYears();
        while(tmp > 0) {
            k += tmp %10;
            tmp /= 10;
        }
        
        int cnt = 0;
        for(int i = 1; i <= employee.getExperienceYears(); i++) {
            if(employee.getExperienceYears()% i == 0) {
                cnt ++;
            }
        }
        
        k += cnt;
        k /= 100.0;
        
        System.out.println(employee.getBaseSalary()*(1 + k));
        employee.setFinalSalary(employee.getBaseSalary()*(1 + k));
        
        os.submitObject(msv, mch, employee);
        
    }
}
