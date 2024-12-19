/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN232;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author admin
 */
public class DayConTangDaiNhatKoLienTuc_TCP_Byte_XveVhhqo {
    
    public static void main(String[] args) {
                
        try (Socket socket = new Socket("203.162.10.109", 2206)) {
            
            String studentCode = "B21DCCN232"; 
            String qCode = "XveVhhqo";
            
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            
            String message = studentCode + ";" + qCode;
            outputStream.write(message.getBytes());
            outputStream.flush();

            // a
            byte[] buff = new byte[2048];
            int len = inputStream.read(buff);
            String receivedData = new String(buff);
            System.out.println(receivedData);

            List<Integer> numbers = new ArrayList<>();
            String[] parts = receivedData.split(",");
            for (String part : parts) {
                numbers.add(Integer.parseInt(part.trim()));
            }
            
            // b
            List<Integer> lis = findLIS(numbers);
            int length = lis.size();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lis.size(); i++) {
                sb.append(lis.get(i));
                if (i < lis.size() - 1) {
                    sb.append(",");
                }
            }
            // String sb = String.join(",", 
            
            // c
            String res = sb + ";" + length;            
            System.out.println(res);
            outputStream.write(res.getBytes());
            
            // d
            inputStream.close();
            outputStream.close();
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> findLIS(List<Integer> arr) {
        int n = arr.size();
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLength = 0; // độ dài LIS
        int lastIndex = 0; // vị trí phần tử cuối của LIS trong mảng ban đầu

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Truy vết LIS
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(arr.get(lastIndex));
            lastIndex = parent[lastIndex];
        }
        Collections.reverse(lis);
        return lis;
    }
    
}
