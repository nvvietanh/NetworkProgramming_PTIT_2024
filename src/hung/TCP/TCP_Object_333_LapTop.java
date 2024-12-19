/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

/**
 *
 * @author ADMIN
 */


import java.util.*;
import java.net.*;
import java.io.*;

public class TCP_Object_333_LapTop {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        String code = "B21dccn333;ukekiqbf";
        out.writeObject(code);
        
        Laptop laptop = (Laptop) in.readObject();
        System.out.println(laptop);
        
        String [] lsStr = laptop.getName().split("\\s+");
        String name = lsStr[lsStr.length-1];
        for(int i = 1; i < lsStr.length-1; i++) {
            name += " " + lsStr[i];
        }
        
        name += " "+lsStr[0];
        
        laptop.setName(name);
        
        laptop.setQuantity(Integer.parseInt( new StringBuilder(Integer.toString(laptop.getQuantity())).reverse().toString()  ));
        
        out.writeObject(laptop);
        out.flush();
        out.close();
        in.close();
        
    }
}
