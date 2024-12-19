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


import java.util.*;
import java.net.*;
import java.io.*;

public class TCP_Character_356_dem {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        String code ="b21dccn356;0fpfqg1b";
        out.write(code);
        out.newLine();
        out.flush();
        
        
        String s = in.readLine();
        System.out.println(s);
        int [] cnt = new  int[256];
        for(char x : s.toCharArray()) {
            cnt[x]++;
        }
        
        
        String ans = "";
        for(char x : s.toCharArray()) {
            if(cnt[x] > 1) {
                ans += ((char) x) + ":"+ cnt[x] + ",";
                cnt[x] = 0;
            }
        }
        
        
        out.write(ans);
        out.flush();
        out.close();
        in.close();
        
        
        
        
    }
}
