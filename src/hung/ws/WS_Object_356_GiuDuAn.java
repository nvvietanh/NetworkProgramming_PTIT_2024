/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import vn.medianews.*;
import vn.medianews.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.xml.datatype.*;
import javax.xml.datatype.*;

/**
 *
 * @author ADMIN
 */
public class WS_Object_356_GiuDuAn {
    public static void main(String[] args) throws DatatypeConfigurationException {
        ObjectService_Service service = new ObjectService_Service();
        ObjectService os= service.getObjectServicePort();
        
        String msv = "b21dccn356", mch = "cx3p3cuu";
        List<Project> lsProjects =  os.requestListProject(msv, mch);
        
//        System.out.println(project.size());
        
        List<Project> ans = new ArrayList<>();
        for(Project p : lsProjects) {
            System.out.println(p.getCompletionPercentage());
            if(p.getCompletionPercentage() >= 80) {
//                System.out.println(p.getDueDate());
                LocalDate now = LocalDate.now();
                LocalDate then = p.getDueDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                
                long x = ChronoUnit.DAYS.between(now, then);
                
                if(x < 15) {
                    System.out.println(now + " " + then);
                    ans.add(p);
                }
                
            }
        }
        
        System.out.println(ans.size());
        
        
        os.submitListProject(msv, mch, ans);
        
        
    }
}
