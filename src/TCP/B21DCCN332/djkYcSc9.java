/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN332;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class djkYcSc9 {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2208);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            
            // a
            bw.write("B21DCCN332;djkYcSc9");
            bw.newLine();
            bw.flush();
            
            // b
            String s1 = br.readLine();
            String s2 = br.readLine();
            System.out.println(s1);
            System.out.println(s2);
            
            // c
            StringBuilder sb = new StringBuilder();
            for (char x : s1.toCharArray()) {
                if (s2.indexOf(x) < 0) {
                    sb.append(x);
                }
            }
            System.out.println(s1);
            
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
            
            // d
            br.close();
            bw.close();
            soc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
