/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;


import java.io.*;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author ADMIN
 */
public class SuaThongTinSanPham {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String code  =  ";B21DCCN156;m6o5c66D";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        System.out.println(dp.getLength());
        String requestCode = new String (dp.getData(), 0, 8);
        System.out.println(requestCode);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData(), 8, dp.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product p = (Product) ois.readObject();
        
        System.out.println(p);
        
        
        String [] lsStr = p.getName().trim().split("[\\s]+");
        String newName = lsStr[lsStr.length - 1] + " ";
        for(int i = 1; i < lsStr.length - 1; i++) {
            newName =  newName + lsStr[i] + " ";
        }
        newName += lsStr[0];
        
        newName = newName.trim();
        
        p.setName(newName);
        
        p.setQuantity(Integer.parseInt(new StringBuilder(Integer.toString(p.getQuantity())).reverse().toString()) );
        
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        ObjectOutputStream oos  = new ObjectOutputStream(baos1);
        oos.writeObject(requestCode.getBytes());
        oos.writeObject(p);
        oos.flush();
        
        byte [] customData =  baos1.toByteArray();
        
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        baos2.write(requestCode.getBytes());
        baos2.write(customData);
        
        byte [] sendData = baos2.toByteArray();
        
        System.out.println(p);
        dp = new DatagramPacket(sendData, sendData.length, ia, port);
        socket.send(dp);
         
        
    }
    
}
