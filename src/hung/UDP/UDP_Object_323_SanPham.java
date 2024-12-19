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
public class UDP_Object_323_SanPham {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        
        String code = ";B21dccn323;tu5ezxec";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        String requestID = new String(dp.getData(), 0 , 8);
        System.out.println(requestID);
        
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData(), 8, dp.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Product product = (Product) ois.readObject();
        System.out.println(product);
        
        String [] lsStr = product.getName().trim().split("\\s+");
        String name = lsStr[lsStr.length-1] + "";
        for(int i = 1; i < lsStr.length-1; i++) {
            name += " " + lsStr[i];
        }
        name += " " + lsStr[0];
        
        product.setName(name);
        product.setQuantity( Integer.parseInt( new StringBuilder( product.getQuantity()+"" ).reverse().toString()  ) );
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();
        
        byte [] customData = baos.toByteArray();
        
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        baos1.write(requestID.getBytes());
        baos1.write(customData);
        
        byte [] sendData = baos1.toByteArray();
        dp = new DatagramPacket(sendData, sendData.length, ia, port);
        socket.send(dp);
        
    }
}
