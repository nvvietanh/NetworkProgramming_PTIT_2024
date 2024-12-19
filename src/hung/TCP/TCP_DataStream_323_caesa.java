/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.net.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author ADMIN
 */
public class TCP_DataStream_323_caesa {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream((socket.getOutputStream()));
        
        String code = "B21DCCn323;cq9ah2g4";
        out.writeUTF(code);
        out.flush();
        
        String s  = in.readUTF();
        System.out.println(s);
        
        int k = in.readInt();
        System.out.println(k);
        
        String ans = "";
        for(char x: s.toCharArray()) {
            if( x >= 'A' && x <= 'Z') {
                ans += (char) ( (x+k-'A')%26 + 'A' );
            } else {
                ans += (char) ( (x+k-'a')%26 + 'a' );
            }
        }
        System.out.println(ans);
        out.writeUTF(ans);
        
    }
}
