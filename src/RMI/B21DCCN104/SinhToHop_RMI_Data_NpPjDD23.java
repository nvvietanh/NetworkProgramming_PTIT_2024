/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN104;

import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class SinhToHop_RMI_Data_NpPjDD23 {
    
    public static void main(String[] args) {
        
        try {
            
            String studentCode = "B21DCCN104";
            String qCode = "NpPjDD23";
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            DataService service = (DataService) rg.lookup("RMIDataService");
            
            /// a
            String d = (String) service.requestData(studentCode, qCode);
            System.out.println(d);
            
            String[] ds1 = d.trim().split("[;]+");
            int k = Integer.valueOf(ds1[1].trim());
            System.out.println(k);
            List<Integer> intLst = Arrays
                    .asList(ds1[0].split("[, ]+"))
                    .stream()
                    .map((item) -> {                
                        return Integer.valueOf(item.trim());
                    }).collect(Collectors.toList());
            System.out.println(intLst);
            
            // b // sinh to hop
            List<List<Integer>> combinations = new ArrayList<>();
            
            backtrack(combinations, intLst, new ArrayList<>(), 0, k);
            
            System.out.println(combinations.size());
            for (List<Integer> x : combinations) {
//                System.out.print("[" + x + "], ");
                System.out.println(x);
            }
            
            // c
            service.submitData(studentCode, qCode, combinations);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void backtrack(List<List<Integer>> res, List<Integer> itemList, List<Integer> com, int idx, int k) {
        
        if (com.size() == k) {
            res.add(new ArrayList<>(com));
            return;
        }
        
        for (int i = idx; i < itemList.size(); ++i) {
            com.add(itemList.get(i));
            backtrack(res, itemList, com, i + 1, k);
            com.remove(com.size() - 1);
        }
    }
    
    
    
}
