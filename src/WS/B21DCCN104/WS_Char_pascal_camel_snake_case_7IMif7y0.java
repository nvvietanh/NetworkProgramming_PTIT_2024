/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN104;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author admin
 */
public class WS_Char_pascal_camel_snake_case_7IMif7y0 {
    
    public static void main(String[] args) {
        
        try {
            
            String studentCode = "B21DCCN104";
            String qCode = "7IMif7y0";
            
            CharacterService_Service service = new CharacterService_Service();
            CharacterService port = (CharacterService) service.getCharacterServicePort();
            
            // a
            String str = port.requestString(studentCode, qCode);
            System.out.println(str);
            
            // b
            List<String> strs = Arrays.asList(str.split("[_ ]+"));
            List<String> ans = new ArrayList<>();
            
            // to PascalCase
            ans.add(String.join("", strs.stream().map((s1) -> {
                return Character.toUpperCase(s1.charAt(0)) 
                        + s1.substring(1).toLowerCase();
            }).collect(Collectors.toList())));
                
            // to camelCase
            ans.add(IntStream.range(0, strs.size())
                    .mapToObj(i -> {
                        if (i < 1) {
                            return strs.get(i).toLowerCase();
                        }
                        else {
                            return Character.toUpperCase(strs.get(i).charAt(0))
                                    + strs.get(i).substring(1).toLowerCase();
                        }
                    }).collect(Collectors.joining("")));
                
            // to snake_case
            ans.add(String.join("", strs.stream().map((s1) -> {
                return s1.toLowerCase();
            }).collect(Collectors.joining("_"))));
            
            System.out.println(ans);
            
            // c
            port.submitCharacterStringArray(studentCode, qCode, ans);
            
            // d
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
