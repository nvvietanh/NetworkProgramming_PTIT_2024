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

public class UDP_Object_356_ChuanHoa {
    
    
    
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException, ClassNotFoundException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ia = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String code = ";b21dccn356;zxu9tzkr";
        DatagramPacket dp = new DatagramPacket(code.getBytes(), code.length(), ia, port);
        socket.send(dp);
        
        byte [] buffer = new byte[1024];
        dp = new DatagramPacket(buffer, buffer.length);
        socket.receive(dp);
        
        String s = new String(dp.getData(), 0 , 8);
        System.out.println(s);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData(), 8, dp.getLength());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Customer customer = (Customer) ois.readObject();
        
        // chuan hoa ten
        String ten = "";
        String ma = "";
        String ngaySinh = "";
        
        
        String [] lsStr = customer.getName().split("\\s+");
        for(int i = 0; i < lsStr.length - 1; i++) {
            ten += lsStr[i].substring(0,1).toUpperCase() + lsStr[i].substring(1, lsStr[i].length()).toLowerCase()+" ";
            ma += lsStr[i].substring(0,1).toLowerCase();
        }
        
        ten  = lsStr[lsStr.length-1].toUpperCase() + ", " + ten;
        ten = ten.trim();
        ma = ma+lsStr[lsStr.length-1].toLowerCase();
        
//        ngaySinh = customer.getDayOfBirth().replace('-', '/');
        
        String [] lsStr2 = customer.getDayOfBirth().split("[\\-]+");
        ngaySinh = lsStr2[1] + '/' + lsStr2[0] + '/' + lsStr2[2];
        
        System.out.println(ngaySinh);
        customer.setDayOfBirth(ngaySinh);
        customer.setName(ten);
        customer.setUserName(ma);
        
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(customer);
        
        System.out.println(customer);
        
        byte [] customData = baos.toByteArray();
        
        ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
        baos1.write(s.getBytes());
        baos1.write(customData);
        
        byte [] sendData = baos1.toByteArray();
        
        dp  = new DatagramPacket(sendData, sendData.length, ia, port);
        socket.send(dp);
                
                
        
//        System.out.println(customer);
        
        
    }
        
    
}
