/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN104;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class LonThuHai_TCP_Byte_JyKyLK8n {
    
    public static void main(String[] args) {
        try {
            
            Socket soc = new Socket("203.162.10.109", 2206);
            OutputStream os = soc.getOutputStream();
            InputStream is = soc.getInputStream();
            
            // a
            String code = "B21DCCN104;JyKyLK8n";
            os.write(code.getBytes());
            os.flush();
            
            // b
            byte[] buff = new byte[2048];
            is.read(buff);
            
//            List<Integer> intList = Arrays.asList(new String(buff).split("[,\\s]+")).stream().map((item) -> {
//                int x = Integer.parseInt(item.trim().replaceAll("\\s+", ""));
//                return x;
//            }).collect(Collectors.toList());

            List<Integer> intList = new ArrayList<>();
            int thunhat = -1000000;
            for (String str : new String(buff).split("[, ]+")) {
                int x = Integer.valueOf(str.trim());
                if (thunhat < x) {
                    thunhat = x;
                }
                intList.add(x);
            }

            System.out.println(intList);
            
//            intList = new ArrayList<>(new TreeSet<>(intList));
//            int ans = intList.get(intList.size() - 2);
            
            int thuhai = 0;
            int thuhaiIdx = -1;
            
            for (int i = 0; i < intList.size(); ++i) {
                int x = intList.get(i);
                if (x != thunhat && x > thuhai) {
                    thuhai = x;
                    thuhaiIdx = i;
                } 
            }

            String ans = thuhai + "," + thuhaiIdx;
            System.out.println(ans);
            
            // c
            os.write(ans.getBytes());
            os.flush();
            
            // d
            is.close();
            os.close();
            soc.close();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
