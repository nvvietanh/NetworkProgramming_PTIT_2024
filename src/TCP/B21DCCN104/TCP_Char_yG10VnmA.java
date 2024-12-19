/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN104;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class TCP_Char_yG10VnmA {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2208);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            
            // a
            bw.write("B21DCCN104;yG10VnmA");
            bw.newLine();
            bw.flush();
            
            // b
            String str = br.readLine();
            System.out.println(str);
            
            // c
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                    sb1.append(c);
                }
                else {
                    sb2.append(c);
                }
            }
            
            System.out.println(sb1.toString());
            System.out.println(sb2.toString());
            
            bw.write(sb1.toString());
//            bw.newLine();
            bw.flush();
            
            bw.write(sb2.toString());
//            bw.newLine();
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
