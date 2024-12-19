/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN409;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author admin
 */
public class obLU6n01 {
    
    public static void main(String[] args) {
        try {
            CharacterService_Service service = new CharacterService_Service();
//        RequestString rs = new RequestString();
            CharacterService port = service.getCharacterServicePort();

            String studentCode = "B21DCCN409";
            String qCode = "obLU6n01";

            // a
            List<String> strs = (List<String>) port.requestStringArray(studentCode, qCode);
            System.out.println(strs);

            // b
//            String[] strs = d.trim().split("[\\s_]+");

            int longestStrIdx = 0;
            int shortestStrIdx = 0;
            int shortestLength = 10000;
            int longestLength = 0;
            for (int i = 0; i < strs.size(); ++i) {
                int len = strs.get(i).trim().length();
                if (len > longestLength) {
                    longestStrIdx = i;
                    longestLength = strs.get(i).length();
                }
                if (len < shortestLength) {
                    shortestStrIdx = i;
                    shortestLength = strs.get(i).length();
                }
            }

            System.out.println("Longest: " + strs.get(longestStrIdx));
            System.out.println("Shortest: " + strs.get(shortestStrIdx));

            // c
            String ans = strs.get(longestStrIdx) + ";" + strs.get(shortestStrIdx);
            List<String> ansList = new ArrayList<>();
            ansList.add(strs.get(longestStrIdx));
            ansList.add(strs.get(shortestStrIdx));
            System.out.println(ans);

            //d
//            port.submitCharacterString(studentCode, qCode, ans);
//            port.submitCharacterStringArray(studentCode, qCode, ansList);
            port.submitCharacterString(studentCode, qCode, ans);

            // e
            System.out.println("Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
