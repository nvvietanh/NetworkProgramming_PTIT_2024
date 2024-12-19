/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN333;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import vn.medianews.CustomerY;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;

/**
 *
 * @author admin
 */
public class QLKhachHang_WS_Object_pL3fxXsZ {
    
    public static void main(String[] args) {
        
        try {
            
            ObjectService_Service service = new ObjectService_Service();
            ObjectService port = (ObjectService) service.getObjectServicePort();
            
            String studentCode = "B21DCCN333";
            String qCode = "pL3fxXsZ";
            
            // a
            List<CustomerY> lstC = port.requestListCustomerY(studentCode, qCode);
            System.out.println(lstC);
            
            // b
//            LocalDateTime now = LocalDateTime.now();
//            ctm.getLastTransactionDate().getMillisecond();
//            
//            long milisecs = now.
//            
//            XMLGregorianCalendar now = XMLGregorianCalendar.
//            long diffInMilisecs = System.currentTimeMillis() - ctm.getLastTransactionDate().getMillisecond();
////            Date diffInMonth

            List<CustomerY> ans = new ArrayList<>();
            for (CustomerY c : lstC) {
                LocalDate now = LocalDate.now();
                
                XMLGregorianCalendar xgc = c.getLastTransactionDate();
                System.out.println(xgc);
                
                System.out.println(c.getLastTransactionDate().getDay());
                
                if (c.getLastTransactionDate().getYear() < now.getYear()) {
                    ans.add(c);
                }
                else if (c.getLastTransactionDate().getMonth() < now.getMonthValue()  - 6) {
                    ans.add(c);
                }
                else if (c.getLastTransactionDate().getMonth() == now.getMonthValue() - 6 && c.getLastTransactionDate().getDay() < now.getDayOfMonth()) {
                    ans.add(c);
                }
            }
            System.out.println(ans);
            port.submitListCustomerY(studentCode, qCode, ans);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
