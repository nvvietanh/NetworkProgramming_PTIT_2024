/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN055;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class DecimalToOctal_RMI_Byte_9w35CQMR {
    
    public static void main(String[] args) {
        
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            ByteService service = (ByteService) rg.lookup("RMIByteService");
            
            String studentCode = "B21DCCN055";
            String qCode = "9w35CQMR";
            
            // a
            byte[] d = service.requestData(studentCode, qCode);
            System.out.println(d);
            
            // b
            StringBuilder sb = new StringBuilder();
            for (byte x : d) {
                sb.append(String.format("%o", x));
            }
            System.out.println(sb);
            
            // c
            service.submitData(studentCode, qCode, sb.toString().getBytes());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
