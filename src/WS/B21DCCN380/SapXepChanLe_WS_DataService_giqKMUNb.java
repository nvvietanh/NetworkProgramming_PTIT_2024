/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN380;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.DataService;
import vn.medianews.DataService_Service;

/**
 *
 * @author admin
 */
public class SapXepChanLe_WS_DataService_giqKMUNb {
    
    public static void main(String[] args) {
        
        try {
            
            DataService_Service service = new DataService_Service();
            DataService port = (DataService) service.getDataServicePort();
            
            String studentCode = "B21DCCN380";
            String qCode = "giqKMUNb";
            
            // a
            List<Integer> iL = port.getData(studentCode, qCode);
            System.out.println(iL);

            // b
            List<Integer> chans = new ArrayList<>();
            List<Integer> les = new ArrayList<>();
            
            for (int x : iL) {
                if (x % 2 == 0)
                    chans.add(x);
                else
                    les.add(x);
            }
            
            List<Integer> ans = new ArrayList<>();
            
            int i0 = 0;
            int i1 = 0;
            
            while (i0 < chans.size() && i1 < les.size()) {
                ans.add(chans.get(i0));
                i0++;
                ans.add(les.get(i1));
                i1++;
            }
            
            while (i0 < chans.size()) {
                ans.add(chans.get(i0));
                i0++;
            }
            while (i1 < les.size()) {
                ans.add(les.get(i1));
                i1++;
            }
                                   
            System.out.println(ans);
            
            // c
            port.submitDataIntArray(studentCode, qCode, ans);
            
            // d
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
