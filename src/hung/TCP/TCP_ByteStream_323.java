/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;


import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author ADMIN
 */
public class TCP_ByteStream_323 {
    public static void main(String[] args) throws IOException {
        String host = "203.162.10.109";
        int port = 2206;
        Socket socket = new Socket(host, port);
        
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        String code = "B21DCCN323;pqynye2q";
        out.write(code.getBytes());
        out.flush();
        
        byte [] buffer = new byte[1024];
        int numRead = in.read(buffer);
        String s = new String(buffer, 0 , numRead);
        System.out.println(s);
        
        String [] lsStr = s.trim().split("\\,+");
        List<Integer> lsNum = new ArrayList<>();
        for(String x : lsStr) {
            lsNum.add(Integer.parseInt(x));
        }
        
        
        List<Integer> b = new ArrayList<>(lsNum);
        
        b.sort((Comparator<? super Integer>) new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        String ans ="";
        for(int i = 0; i < lsNum.size(); i++) {
            if (lsNum.get(i) == b.get(1)) {
                ans = lsNum.get(i) + "," + (i);
            }
        }
        
        System.out.println(ans);
        out.write(ans.getBytes());
        out.flush();
        out.close();
        in.close();
        
    }
}
