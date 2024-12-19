/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN104;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author admin
 */
public class Nen_RLE_RMI_Byte_Y05l7lzF {
    
    public static void main(String[] args) {
        
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            ByteService service = (ByteService) rg.lookup("RMIByteService");
            
            String studentCode = "B21DCCN104";
            String qCode = "Y05l7lzF";
            
            // a
            byte[] d = service.requestData(studentCode, qCode);
            for (byte x : d) {
                System.out.print((int) x + " ");
            } System.out.println("");
            
            // b
//            TreeMap<Byte, Integer> mp = new TreeMap<>();
//            for (byte x : d) {
//                if (!mp.containsKey(x)) {
//                    mp.put(x, 1);
//                }
//                else {
//                    mp.put(x, mp.get(x) + 1);
//                }
//            }
//            
//            ArrayList<Byte> ansL = new ArrayList<>();
//            for (byte x : mp.keySet()) {
//                ansL.add(x);
//                ansL.add(mp.get(x).byteValue());
//            }
//            byte[] ans = new byte[ansL.size()];
//            int idx = 0;
//            for (byte x : ansL) {
//                ans[idx] = x;
//                idx++;
//            }
//            System.out.println(ans);
            List<Byte> ansL = new ArrayList<>();
//            for (int i = 0; i < d.length - 1; ++i) {
//                byte cnt = 1;
//                while (i < d.length - 1 && d[i] == d[i+1]) {
//                    cnt++;
//                    i = i + 1;
//                }
//                ansL.add(d[i]);
//                ansL.add(cnt);
//            }
            byte cur = d[0];
            byte cnt = 0;
            for (byte x : d) {
                if (cur == x) {
                    cnt++;
                }
                else {
                    ansL.add(cur);
                    ansL.add(cnt);
                    cur = x;
                    cnt = 1;
                }
            }
            ansL.add(cur);
            ansL.add(cnt);
            
            byte[] ans = new byte[ansL.size()];
            int idx = 0;
            for (byte x : ansL) {
                ans[idx] = x;
                idx++;
            }
            for (byte x : ans) {
                System.out.print((int) x + " ");
            }
            
            service.submitData(studentCode, qCode, ans);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
