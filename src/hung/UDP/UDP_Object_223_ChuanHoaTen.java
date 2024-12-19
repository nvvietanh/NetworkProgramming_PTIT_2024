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
public class UDP_Object_223_ChuanHoaTen {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("203.162.10.109");
            int port = 2209;

            String code  = ";b21dccn223;ETvgBdtP";
            DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
            socket.send(dp);
            
            byte [] data = new byte[1024];
            dp = new DatagramPacket(data, data.length);
            socket.receive(dp);
            
            
            String requestID = new String(dp.getData(), 0, 8);
            System.out.println(requestID);
            
            
            ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData(), 8, dp.getLength());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Student student = (Student) ois.readObject();
            
            System.out.println(student);
            
            
            String name = "";
            String email = "";
            String [] lsStr = student.getName().split("\\s+");
            for(int i = 0; i< lsStr.length ; i++) {
                String x = lsStr[i];
                name += x.substring(0,1).toUpperCase() + x.substring(1, x.length()).toLowerCase() + " ";
                email += x.substring(0,1).toLowerCase();
            }
            
            email = email.substring(0, email.length() - 1);
            email = lsStr[lsStr.length - 1].toLowerCase() + email + "@ptit.edu.vn";
            name = name.trim(); 
            
            student.setEmail(email);
            student.setName(name);
            
            
            System.out.println(student);
            
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(student);
            byte [] customData = baos.toByteArray();
            
//            byte[] newData = new byte [requestID.length() + customData.length];
            
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            baos1.write(requestID.getBytes());
            baos1.write(customData);
            
            byte [] sendData = baos1.toByteArray();
            
            dp = new DatagramPacket(sendData, sendData.length, ia, port);
            socket.send(dp);
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
    }
}
