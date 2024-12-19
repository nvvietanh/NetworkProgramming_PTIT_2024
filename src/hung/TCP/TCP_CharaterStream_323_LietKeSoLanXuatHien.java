/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.net.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author ADMIN
 */
public class TCP_CharaterStream_323_LietKeSoLanXuatHien {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        String code = "B21DCCn323;v6bku3f1";
        out.write(code);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        System.out.println(s);
        
        String ans = "";
        int [] cnt = new int [256];
        for(char x : s.toCharArray()) {
            if(x != ' ') {
                cnt[x]++;
            }
        }
        
        for(char x: s.toCharArray()) {
            if(cnt[x] > 1) {
                ans += (x + "") + ":" + (cnt[x] + ",");
                cnt[x] = 0;
            }
        }
        
        System.out.println(ans);
        out.write(ans);
        out.newLine();
        out.flush();
        out.close();
        in.close();
        
    }
}
