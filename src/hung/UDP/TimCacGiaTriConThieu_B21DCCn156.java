/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class TimCacGiaTriConThieu_B21DCCn156 {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String code = ";B21DCCn156;pSvt1S2s";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        String s = new String(buffer, 0, dp.getLength());
        System.out.println(s);
                
        String [] lsStr = s.trim().split("[\\;\\,]");
        String requestId = lsStr[0];
        int n = Integer.parseInt(lsStr[1]);
        
        String ans = requestId + ";";
        int cnt = 1;
        
        
        
        List<Integer> lsNum = new ArrayList<>();
//        for(int i = 2; i < lsStr.length; i++) {
//            int tmp = Integer.parseInt(lsStr[i]);
//            for(int j = x; j < tmp; j++) {
//                ans += j + ",";
//            }
//            x = tmp + 1;
//        }
        
        for(String x: Arrays.copyOfRange(lsStr, 2, lsStr.length)) {
            lsNum.add(Integer.parseInt(x));
        }
        
        lsNum.sort((Comparator<? super Integer>) new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {
                return  a - b;
            }
        });
        
        for( int x : lsNum) {
            for(int i = cnt; i < x; i++) {
                ans += i + ",";
            }
            cnt = x + 1;
        }
        
        while (cnt <= n) {
            ans += cnt + ",";
            cnt++;
        }
        
        
        System.out.println(ans);
        
        
        ans = ans.substring(0, ans.length() - 1);
        
        dp = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
        socket.send(dp);
        
    }
    
}
