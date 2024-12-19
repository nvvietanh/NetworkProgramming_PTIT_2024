/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN356;

import java.time.LocalDate;
import java.util.List;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Project;

/**
 *
 * @author admin
 */
public class GiuDuAn_WS_Object_CX3p3Cuu {

    public static void main(String[] args) {

        try {

            ObjectService_Service service = new ObjectService_Service();
            ObjectService port = service.getObjectServicePort();

            String sCode = "B21DCCN356";
            String qCode = "CX3p3Cuu";

            List<Project> prjs = port.requestListProject(sCode, qCode);
            System.out.println(prjs);
            
            List<Project> ans = new java.util.ArrayList<>();
            
            for (Project p : prjs) {
                if (p.getCompletionPercentage() >= 80.0f) {
                    LocalDate now = LocalDate.now();
                    LocalDate dueDate = p.getDueDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
