/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.net.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author ADMIN
 */
public class UDP_String_444_DemSoLuongKytu {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String code= ";B21DCCN444;YVZ0s7gs";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia,port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        String s = new String(dp.getData(), 0, dp.getLength());
        
        System.out.println(s);
        
        String [] lsStr = s.split("\\;+");
        System.out.println(lsStr.length);
        s = lsStr[1];
        
        String ans = lsStr[0] + ";";
        int i = 0;
        
        int [] cnt = new int [256];
        for(char x : s.toCharArray()) {
            cnt[x]++;
        }
        
        for(char x : s.toCharArray()) {
            if(cnt[x] > 0) {
                ans += cnt[x] + "" + ((char)x);
                cnt[x] = 0;
            }
        }
        
        System.out.println(ans.length());
        System.out.println(ans);
//        ans = ans.substring(0, ans.length());
        dp = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
        socket.send(dp);
        
        
        
        
        
    }
}
