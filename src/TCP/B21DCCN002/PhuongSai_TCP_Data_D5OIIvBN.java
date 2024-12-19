/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN002;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class PhuongSai_TCP_Data_D5OIIvBN {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2207);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream()
            );
            
            // a
            dos.writeUTF("B21DCCN002;D5OIIvBN");
            
            // b
            ArrayList<Integer> il = new ArrayList<>();
            int n = dis.readInt();
            System.out.println(n);
            for (int i = 0; i < n; ++i) {
                il.add(dis.readInt());
            }
            System.out.println(il);
            
            // tong
            int sum = 0;
            for (int x : il) {
                sum += x;
            }
            // tbc
            float average = 1.0f * sum/n;
            // phuong sai
            float variance = 0.0f;
            float sum1 = 0.0f;
            for (int x : il) {
                sum1 += (1.0f * x - average)*(1.0f * x - average);
            }
            variance = 1.0f * sum1 / n;
            
            System.out.println(sum + " " + average + " " + variance);
            
            // c
            dos.writeInt(sum);
            dos.writeFloat(average);
            dos.writeFloat(variance);
            
            // d
            dis.close();
            dos.close();
            soc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
