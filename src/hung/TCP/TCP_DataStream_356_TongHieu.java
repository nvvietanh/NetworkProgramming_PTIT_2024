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
import java.io.*;
import java.math.BigInteger;
import java.net.*;

public class TCP_DataStream_356_TongHieu {
    
    public static int ucln(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        
        return  a;
    }
    
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        
        String code = "b21dccn356;krnzvqog";
        out.writeUTF(code);
        out.flush();
        
        int a = in.readInt();
        int b = in.readInt();
        
        System.out.println(a + " " + b);
        
//        BigInteger b = new BigInteger();
        
        
        int ucln = ucln(a, b);
        System.out.println(ucln);
        int bcnn = a * b / ucln;
        int tong = a+ b;
        int tich = a*b;
        out.writeInt(ucln);
        out.flush();
        out.writeInt(bcnn);
        out.flush();
        out.writeInt(tong);
        out.flush();
        out.writeInt(tich);
        out.flush();
        out.close();
        in.close();
    }
}
