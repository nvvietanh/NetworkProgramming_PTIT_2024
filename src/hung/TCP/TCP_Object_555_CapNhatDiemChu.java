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

public class TCP_Object_555_CapNhatDiemChu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        String code = "b21dccn555;xj1u2byw";
        out.writeObject(code);
        out.flush();
        
        Student student = (Student) in.readObject();
        System.out.println(student);
        
        char x = ' ';
        if(student.getGpa() >= 3.7) {
            x = 'A';
        } else if (student.getGpa() >= 3) {
            x = 'B';
        } else if(student.getGpa() >= 2) {
            x = 'C';
        } else if(student.getGpa() >= 1) {
            x = 'D';
        } else {
            x = 'F';
        }
        
        
        
        student.setGpaLetter(x+"");
        
        System.out.println(student);
        out.writeObject(student);
        out.flush();
        out.close();
        in.close();
    }
}
