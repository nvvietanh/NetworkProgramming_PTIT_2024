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
public class UDP_DataType_323_SoNguyenTo {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String code = ";B21dccn323;lipy45ss";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);
        
        String [] lsStr = s.trim().split("\\;+");
        String requestID = lsStr[0];
        int n = Integer.parseInt(lsStr[1]);
        
        String ans = requestID + ";";
        
        int tmp = 2;
        while( n > 0) {
            boolean check = true;
            int sqrt_tmp = (int) Math.sqrt(tmp);
            for(int i = 2; i <= sqrt_tmp; i++) {
                if(tmp % i == 0) {
                    check = false;
                    break;
                }
            }
            if(check == true) {
                ans += tmp + ",";
                n--;
            }
            tmp++;
        }
        
        ans = ans.substring(0, ans.length()-1);
        
        dp = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
        socket.send(dp);
        
        
    }
}
