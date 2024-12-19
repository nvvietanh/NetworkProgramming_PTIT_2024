/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

/**
 *
 * @author ADMIN
 */


import java.util.*;
import java.net.*;
import java.io.*;
public class UDP_DataType_444_GiaiMaCaese {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String code = ";B21DCCN444;dybzHwew";
        DatagramPacket dp  = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        String s= new String(dp.getData(), 0, dp.getLength());
        
        System.out.println(s);
        
        String [] lsStr = s.split("\\;+");
        System.out.println(lsStr.length);
        
        String ans = lsStr[0] + ";";
        
        int k = Integer.parseInt(lsStr[2]);
        
        for(char x : lsStr[1].toCharArray()) {
            if(x < 'a') {
                ans += (char) ( (x - 'A' + k)%26 +'A' );
            } else {
                ans += (char) ( (x - 'a' + k)%26 + 'a' );
            }
        }
        
        dp = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
        socket.send(dp);
        
    }
}
