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
import java.io.*;
import java.net.*;

public class TCP_Byte_555_ChuoiConKhongLapLai {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        
        String code = "b21dccn555;unxeaczn";
        out.write(code.getBytes());
        out.flush();
        
        byte [] data = new byte[1024];
        int numByte = in.read(data);
        String s = new String(data, 0, numByte);
        System.out.println(s);
        
        int max = -1;
        String ans = "";
        
        for(int i = 0; i < s.length()-1; i++) {
            int [] cnt = new int[256];
            for(int j = i; j < s.length(); j++) {
                cnt[s.charAt(j)]++;
                if(cnt[s.charAt(j)] == 1 && max < (j-i+1)) {
                    max = j-i+1;
                    ans = s.substring(i, j+1);
                } else if(cnt[s.charAt(j)] >= 2) {
                    break;
                }
            }
        }
        
        System.out.println(ans);
        
        out.write((ans +";" +max).getBytes());
        out.flush();
        
    }
}
