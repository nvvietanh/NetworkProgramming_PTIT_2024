/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN055;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI.CharacterService;
import java.util.Base64;

/**
 *
 * @author admin
 */
public class MaHoaBase64_RMI_Char_6VWvxMBQ {
    
    public static void main(String[] args) {
        
        try {
            
            String studentCode = "B21DCCN055";
            String qCode = "6VWvxMBQ";
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            CharacterService service = (CharacterService) rg.lookup("RMICharacterService");
            
            // a
            String str = service.requestCharacter(studentCode, qCode);
            System.out.println(str);
            
            // b
            String ans = java.util.Base64.getEncoder().encodeToString(str.getBytes());
            
            System.out.println(ans);
            
            // c
            service.submitCharacter(studentCode, qCode, ans);
            
            // d
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
