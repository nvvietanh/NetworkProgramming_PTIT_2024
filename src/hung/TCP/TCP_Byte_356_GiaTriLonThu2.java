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

public class TCP_Byte_356_GiaTriLonThu2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("203.162.10.109", 2206);
        
        InputStream in = socket.getInputStream();
        OutputStream out =  socket.getOutputStream();
        
        String code = "b21dccn356;lvycf4rd";
        out.write(code.getBytes());
        out.flush();
        
        byte [] data = new byte[1024];
        int num = in.read(data);
        String s = new String(data, 0 , num);
        
        String [] lsStr  = s.split("\\,+");
        List<Integer> lsNum =  new ArrayList();
        for(String x: lsStr) {
            lsNum.add(Integer.parseInt(x));
        }
        
        
        lsNum.sort((Comparator<? super Integer>) new Comparator<Integer>() {

            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        System.out.println(s);
        
        int idx = 0;
        for(int i = 0; i < lsStr.length; i++) {
            if(lsStr[i].compareTo(Integer.toString(lsNum.get(1))) == 0) {
                idx = i;
                break;
            }
        }
        
        out.write( (lsNum.get(1) + "," + idx ).getBytes() );
        out.flush();
        
        
        
    }
}
