/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class TCP_Character_333_SapXepChuCai {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        
        String code = "B21dccn333;mt4uxxax";
        out.write(code, 0, code.length());
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        System.out.println(s);
        
        List<String> lsStr = Arrays.asList(s.split("\\s+"));
        lsStr.sort((Comparator<? super String>) new Comparator<String>() {

            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        
        String ans = "";
        for(String x: lsStr) {
            ans += x + " ";
        }
        
        out.write(ans.trim());
        out.newLine();
        out.flush();
        out.close();
        in.close();
        
    }
}
