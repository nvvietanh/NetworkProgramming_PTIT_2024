/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

/**
 *
 * @author ADMIN
 */

import java.io.*;
import java.util.*;
import java.net.*;

public class TCP_Character_555_LoaijBoKyTuTrung {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        
        String code = "b21dccn555;vkchfk74";
        out.write(code);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        System.out.println(s);
        
        
        String s1 = " ";
        for(char x : s.toCharArray()) {
            if(Character.isAlphabetic(x) && s1.indexOf(x) == -1) {
                s1 += ((char) x)+"";
            }
        }
        
        String ans = s1.substring(1, s1.length());
        System.out.println(ans);
        out.write(ans);
        out.newLine();
        out.flush();
    }
}
