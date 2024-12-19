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
import java.util.*;
import java.util.*;

public class UDP_Object_555_eduvn {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String code = ";b21dccn555;ncpqq5dh";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        String requestId = new String(dp.getData(), 0 ,8);
        System.out.println(requestId);
        
        
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer, 8, buffer.length);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Student student = (Student) ois.readObject();
        
        System.out.println(student);
        
        String name = "";
        String edu = "";
        String [] lsStr = student.getName().split("\\s+");
        
        int len_lsStr = lsStr.length;
        edu += lsStr[len_lsStr - 1].toLowerCase();
        for(int i = 0; i < lsStr.length; i++) {
            int lenStr = lsStr[i].length();
            name += lsStr[i].substring(0,1).toUpperCase() + lsStr[i].substring(1, lenStr).toLowerCase() + " ";
            edu += lsStr[i].substring(0,1).toLowerCase();
        }
        
        name = name.substring(0, name.length()-1);
        edu = edu.substring(0, edu.length()-1);
        edu += "@ptit.edu.vn";
        
        
        
        student.setEmail(edu);
        student.setName(name);
        
        System.out.println(name + " " + edu);
        
        
        
        
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        
        byte [] customData = baos.toByteArray();
        
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        baos1.write(requestId.getBytes());
        baos1.write(customData);
        
        byte [] sendData = baos1.toByteArray();
        
        
        dp = new DatagramPacket(sendData, sendData.length, ia, port);
        socket.send(dp);
        
        
        
        
        
    }
}
