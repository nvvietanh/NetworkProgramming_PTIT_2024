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
public class UDP_String_323_ChuanHoaChuoiKyTu {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String code = ";B21DCCN323;fxkeqav7";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte [1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);
        
        String [] lsStr = s.trim().split("[\\s\\;]+");
        
        String ans = lsStr[0] + ";";
        for(int i = 1; i < lsStr.length; i ++) {
            ans += lsStr[i].substring(0,1).toUpperCase() + lsStr[i].substring(1, lsStr[i].length()).toLowerCase() + " ";
        }
        
        
        ans = ans.trim();
        
        dp = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
        socket.send(dp);
        
    }
}
