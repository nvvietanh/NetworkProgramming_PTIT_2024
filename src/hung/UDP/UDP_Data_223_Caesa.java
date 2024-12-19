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

public class UDP_Data_223_Caesa {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String code = ";b21dccn223;fbWVBM64";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        
        byte [] data = new byte[1024];
        dp = new DatagramPacket(data, data.length);
        socket.receive(dp);
        
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);
        
        
        String [] lsStr = s.split("\\;+");
//        System.out.println(lsStr.length);
        
        int k = Integer.parseInt(lsStr[2]);
        String requestID = lsStr[0];
        
        String ans = "";
        for(int i = 0; i < lsStr[1].length(); i++) {
            char x = lsStr[1].charAt(i);
            if( x < 'a' ) {
                ans += ( (char) ((x - 'A' +k)%26 +'A') );
            } else {
                ans += ( (char) ((x - 'a' + k)%26 + 'a') );
            }
        }
        
        System.out.println(ans);
        
        ans = requestID +";" + ans;
        
        dp = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
        socket.send(dp);
        
    }
}
