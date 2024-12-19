/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN104;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.CustomerY;
import vn.medianews.Employee;
import vn.medianews.EmployeeY;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

/**
 *
 * @author admin
 */
public class CHoTwBnV {
    
    public static void main(String[] args) {
        
        try {
            
            ObjectService_Service service = new ObjectService_Service();
            ObjectService port = (ObjectService) service.getObjectServicePort();
            
            // a            
            String studentCode = "B21DCCN104";
            String qCode = "CHoTwBnV";
            
            List<EmployeeY> lstEm = port.requestListEmployeeY(studentCode, qCode);
            System.out.println(lstEm);
            
            // b
            Collections.sort(lstEm, new Comparator<EmployeeY>() {
                @Override
                public int compare(EmployeeY o1, EmployeeY o2) {
//                    if (o1.getStartDate().compare(o2.getStartDate()) == 0) {
                    return o1.getStartDate().compare(o2.getStartDate());
                }
            });
            System.out.println(lstEm);
            
            // c
            port.submitListEmployeeY(studentCode, qCode, lstEm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
