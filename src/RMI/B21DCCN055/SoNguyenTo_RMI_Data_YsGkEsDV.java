/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN055;

import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class SoNguyenTo_RMI_Data_YsGkEsDV {
    
    public static void main(String[] args) {
        
        try {
            
            String studentCode = "B21DCCN055";
            String qCode = "YsGkEsDV";
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            DataService service = (DataService) rg.lookup("RMIDataService");
            
            // a
            int n = (int) service.requestData(studentCode, qCode);
            System.out.println(n);
            
            // b
            List<Integer> il = new ArrayList<>();
            // ko dùng sàng snt
            for (int i = 2; i <= n; ++i) {
                if (isPrime(i) == 1) {
                    il.add(i);
                }
            }
            System.out.println(il);
            
            // c
            service.submitData(studentCode, qCode, il);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static int isPrime(int n) {
        if (n < 2) return 0;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
    
}
