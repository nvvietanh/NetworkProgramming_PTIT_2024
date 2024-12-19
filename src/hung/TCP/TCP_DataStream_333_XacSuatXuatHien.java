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

import java.io.*;
import java.net.*;
import java.util.*;

public class TCP_DataStream_333_XacSuatXuatHien {
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        String code = "b21dccn333;tqti4lb0";
        out.writeUTF(code);
        out.flush();
        
        int n = in.readInt();
        
        int [] cnt = new int [7];
        for(int i = 0; i< n; i++) {
            int tmp = in.readInt();
            cnt[tmp] ++;
        }
        
        for(int i = 1; i <= 6 ; i++) {
            out.writeFloat((float) (1.0 * cnt[i] / n));
            out.flush();
        }
        out.close();
        in.close();
        
    }
}
