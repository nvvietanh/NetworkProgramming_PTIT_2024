/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.B21DCCN332;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class GiaiMaCaesar_UDP_Data_Type_cTrMIRgs {
    
    public static void main(String[] args) {
        
        try {
            
            DatagramSocket dSoc = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("203.162.10.109");
            int port = 2207;
            
            String code = ";B21DCCN332;cTrMIRgs";
            
            // a
            DatagramPacket dpCode = new DatagramPacket(code.getBytes(), code.length(), ia, port);
            dSoc.send(dpCode);
            
            // b
            byte[] buff = new byte[2048];
            DatagramPacket dpRec = new DatagramPacket(buff, buff.length);
            dSoc.receive(dpRec);
            String[] strs = new String(dpRec.getData()).split("[;\\s]+");
            for (String x : strs) {
                System.out.println(x);
            }
            String reqId = strs[0];
            String strEncode = strs[1];
            int shift = Integer.parseInt(strs[2].trim());
            
            // c
            StringBuilder sb = new StringBuilder();
            for (char x : strEncode.toCharArray()) {
//                sb.append((char) (x - 6));
                if (Character.isUpperCase(x)) {
                    sb.append((char) ((x - 'A' + shift) % 26 + 'A'));
                }
                if (Character.isLowerCase(x)) {
                    sb.append((char) ((x - 'a' + shift) % 26 + 'a'));
                }
            }
            System.out.println(sb);
            String ans = reqId + ";" + sb.toString();
            System.out.println(ans);
            
            DatagramPacket dpSend = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
            dSoc.send(dpSend);
            
            dSoc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
