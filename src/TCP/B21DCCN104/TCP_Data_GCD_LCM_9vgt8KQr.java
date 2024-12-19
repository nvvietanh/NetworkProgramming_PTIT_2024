/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN104;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class TCP_Data_GCD_LCM_9vgt8KQr {
    
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public static void main(String[] args) {
        try {
            
            Socket soc = new Socket("203.162.10.109", 2207);
            
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            
            // a
            dos.writeUTF("B21DCCN104;9vgt8KQr");
           
            // b
            int a = dis.readInt();
            int b = dis.readInt();
            System.out.println(a + " " + b);
            
            // c
            int sum = a + b;
            int prd = a * b;
            int gcd = gcd(a, b);
            int lcm = lcm(a, b);
            
            dos.writeInt(gcd);
            dos.writeInt(lcm);
            dos.writeInt(sum);
            dos.writeInt(prd);
            
            // d
            dis.close();
            dos.close();
            soc.close();
                    
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
