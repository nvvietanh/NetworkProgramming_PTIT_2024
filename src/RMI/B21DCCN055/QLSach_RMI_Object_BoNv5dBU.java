/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN055;

import RMI.BookX;
import RMI.ObjectService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class QLSach_RMI_Object_BoNv5dBU {
    
    public static void main(String[] args) {
        
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            ObjectService service = (ObjectService) rg.lookup("RMIObjectService");
            
            String studentCode = "B21DCCN055";
            String qCode = "BoNv5dBU";
            
            // a
            BookX b = (BookX) service.requestObject(studentCode, qCode);
            System.out.println(b);
            
            // b
            StringBuilder sb = new StringBuilder();
            // first and last letters of author name
            String name = b.getAuthor();
            sb.append(name.charAt(0));
            sb.append(name.charAt(name.length() - 1));
            // last 2 digits of year
            String strYear = String.valueOf(b.getYearPublished());
            sb.append(strYear.substring(strYear.length() - 2, strYear.length()));
            // number of letters in genre
            int cnt = 0;
            for (char x : b.getGenre().toCharArray()) {
                if (Character.isAlphabetic(x)) {
                    cnt += 1;
                }
            }
            sb.append(String.valueOf(cnt));
            // length of title % 10
            sb.append(b.getTitle().length() % 10);
            
            System.out.println(sb.toString());
            
            // c
            b.setCode(sb.toString());
            
            // d
            service.submitObject(studentCode, qCode, b);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
