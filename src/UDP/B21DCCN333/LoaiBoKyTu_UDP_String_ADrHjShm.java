/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.B21DCCN333;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class LoaiBoKyTu_UDP_String_ADrHjShm {
    
    public static void main(String[] args) {
        
        try {
            
            DatagramSocket dSoc = new DatagramSocket();
            
            InetAddress ia = InetAddress.getByName("203.162.10.109");
            int port = 2208;
            
            String code = ";B21DCCN333;ADrHjShm";
            
            // a
            DatagramPacket dpCode = new DatagramPacket(code.getBytes(), code.length(), ia, port);
            dSoc.send(dpCode);
            
            // b
            byte[] buffer = new byte[2048];
            DatagramPacket dpRec = new DatagramPacket(buffer, buffer.length);
            dSoc.receive(dpRec);
            
            String reqId = new String(dpRec.getData(), 0, 8);
            String strInput = new String(dpRec.getData(), 8, dpRec.getLength());
            System.out.println(reqId);
            System.out.println(strInput);
            
            // c
            StringBuilder sb1 = new StringBuilder(reqId + ";");
            StringBuilder sb = new StringBuilder();
            for (char x : strInput.toCharArray()) {
                if (Character.isAlphabetic(x) && !sb.toString().contains(Character.toString(x))) {
//                    for (int i = 0; i < sb.length(); ++i) {
//                        if (x == sb.charAt(i)) {
//                            break;
//                        }                        
//                    }
                    sb.append(Character.toString(x));
                }
            }
            String ans = sb1.toString() + sb.toString();
            System.out.println(ans);
            
            DatagramPacket dpSend = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
            dSoc.send(dpSend);
            
            dSoc.close();                    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

// 333 356 WS Object