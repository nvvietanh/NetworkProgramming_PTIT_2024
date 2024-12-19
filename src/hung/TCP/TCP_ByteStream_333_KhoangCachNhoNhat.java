/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */



public class TCP_ByteStream_333_KhoangCachNhoNhat {
    public static void main(String[] args) throws IOException {
        Socket socker = new Socket("203.162.10.109", 2206);
        InputStream in = socker.getInputStream();
        OutputStream out = socker.getOutputStream();
        
        String code = "B21DCCN333;zjrnntgt";
        out.write(code.getBytes());
        
        byte [] buffer = new byte[1024];
        int numbyte = in.read(buffer);
        String s = new String(buffer, 0, numbyte);
        System.out.println(s);
        
        String [] lsStr = s.split("\\,+");
        
        List<Integer> lsNum = new ArrayList<>();
        
        for(String x : lsStr) {
            lsNum.add(Integer.parseInt(x));
        }
        
        
        int tmp = 100000, x1 = 0, x2 = 0;
        for(int i = 0; i < lsNum.size() - 1; i++) {
            for(int j = i + 1; j < lsNum.size(); j ++) {
                if(Math.abs(lsNum.get(i) - lsNum.get(j)) < tmp) {
                    tmp  = (int) Math.abs(lsNum.get(i) -lsNum.get(j) );
                    x1 = lsNum.get(i);
                    x2 = lsNum.get(j);
                }
            }
        }
        
        String ans = tmp + "," + x1 + "," + x2;
        out.write(ans.getBytes());
        out.close();
        in.close();
        
    }
}
