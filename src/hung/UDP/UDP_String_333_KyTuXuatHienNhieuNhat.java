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

public class UDP_String_333_KyTuXuatHienNhieuNhat {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2208;
        
        String code= ";b21dccn645;9xfc0wfw";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] data = new byte[1024];
        dp = new DatagramPacket(data, data.length);
        socket.receive(dp);
        
        String s = new String(dp.getData(), 0, dp.getLength());
        System.out.println(s);
        
        String [] lsStr = s.split("\\;");
        
        int [] cnt = new int[256];
        
        int max = -1;
        char maxCntChar = 0;
        for( char x : lsStr[1].toCharArray()) {
            cnt[x]++;
            if(cnt[x] > max) {
                maxCntChar = x;
                max = cnt[x];
            }
        }
        
        for(char x : lsStr[1].toCharArray()) {
            if(cnt[x] == max) {
                maxCntChar = x;
                break;
            }
        }
        
        
        String ans = lsStr[0] +";" + ((char) maxCntChar) + ":" ;
        System.out.println(ans);
        for(int i = 0; i < lsStr[1].length(); i++) {
            if(lsStr[1].charAt(i) == maxCntChar) {
                ans += (i+1)+",";
            }
        }
        
        
        dp = new DatagramPacket(ans.getBytes(), ans.length(),ia,port);
        socket.send(dp);
        
        
    }
}
