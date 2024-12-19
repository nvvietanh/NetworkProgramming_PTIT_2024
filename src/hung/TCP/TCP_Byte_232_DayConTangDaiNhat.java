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
public class TCP_Byte_232_DayConTangDaiNhat {

    public static List<Integer> yeah;
    public static List<Integer> lsNum;
    public static boolean ok;

//    public static void deQuy(List<Integer> tmp, int n, int i) {
//        if(ok == true) return;
//        if(tmp.size() == n ) {
//            yeah = new ArrayList<>(tmp);
//        } 
//        for(int j = 0; j < lsNum.size(); j ++) {
//            
//        }
//        
//    }
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("203.162.10.109", 2206);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            String code = "b21dccn232;XveVhhqo";
            out.write(code.getBytes());

            byte[] data = new byte[1024];
            int numByte = in.read(data);
            String s = new String(data, 0, numByte);
            System.out.println(s);

            String[] lsStr = s.split("\\,");
            lsNum = new ArrayList<>();

            for (String x : lsStr) {
                lsNum.add(Integer.parseInt(x));
            }

            System.out.println(lsNum.size());

            Integer[] dp = new Integer[lsNum.size()];
            Integer[] vet = new Integer[lsNum.size()];
            for (int i = 0; i < lsNum.size(); i++) {
                dp[i] = 1;
                vet[i] = -1;
            }
            for (int i = 0; i < lsNum.size(); i++) {
                for (int j = 0; j < i; j++) {
                    int dpMax = 0; // Tạo mới mỗi lần lặp
                    if (lsNum.get(i) > lsNum.get(j)) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] +1;
                            vet[i] = j;
                        }
                    }
                }
            }

            
            
            int max = Collections.max(Arrays.asList(dp));
            int idx = 0;
            System.out.println(max);

            for (int i = 0; i < lsNum.size(); i++) {
                if (dp[i] == max) {
                    idx = i;
                    break;
                }
            }

            String ans = "";
            while (idx != -1) {
                ans = lsNum.get(idx) + "," + ans;
                int z = idx;
                idx = vet[z];
            }

            ans = ans.substring(0, ans.length() - 1) + ";" + max;
            System.out.println(ans);
            out.write(ans.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}







//
//
//package TCP.B21DCCN232;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//
///**
// *
// * @author admin
// */
//public class DayConTangDaiNhatKoLienTuc_TCP_Byte_XveVhhqo {
//    
//    public static void main(String[] args) {
//                
//        try (Socket socket = new Socket("203.162.10.109", 2206)) {
//            
//            String studentCode = "B21DCCN232"; 
//            String qCode = "XveVhhqo";
//            
//            InputStream inputStream = socket.getInputStream();
//            OutputStream outputStream = socket.getOutputStream();
//            
//            String message = studentCode + ";" + qCode;
//            outputStream.write(message.getBytes());
//            outputStream.flush();
//
//            // a
//            byte[] buff = new byte[2048];
//            int len = inputStream.read(buff);
//            String receivedData = new String(buff);
//            System.out.println(receivedData);
//
//            List<Integer> numbers = new ArrayList<>();
//            String[] parts = receivedData.split(",");
//            for (String part : parts) {
//                numbers.add(Integer.parseInt(part.trim()));
//            }
//            
//            // b
//            List<Integer> lis = findLIS(numbers);
//            int length = lis.size();
//
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < lis.size(); i++) {
//                sb.append(lis.get(i));
//                if (i < lis.size() - 1) {
//                    sb.append(",");
//                }
//            }
//            
//            // c
//              outputStream.write(res.getBytes());
//            String res = sb + ";" + length;
//            System.out.println(res);
//            
//            // d
//            inputStream.close();
//            outputStream.close();
//            socket.close();
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static List<Integer> findLIS(List<Integer> arr) {
//        int n = arr.size();
//        int[] dp = new int[n];
//        int[] parent = new int[n];
//        Arrays.fill(dp, 1);
//        Arrays.fill(parent, -1);
//
//        int maxLength = 0; // độ dài LIS
//        int lastIndex = 0; // vị trí phần tử cuối của LIS trong mảng ban đầu
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr.get(j) < arr.get(i) && dp[i] < dp[j] + 1) {
//                    dp[i] = dp[j] + 1;
//                    parent[i] = j;
//                }
//            }
//            if (dp[i] > maxLength) {
//                maxLength = dp[i];
//                lastIndex = i;
//            }
//        }
//
//        // Truy vết LIS
//        List<Integer> lis = new ArrayList<>();
//        while (lastIndex != -1) {
//            lis.add(arr.get(lastIndex));
//            lastIndex = parent[lastIndex];
//        }
//        Collections.reverse(lis);
//        return lis;
//    }
//    
//}
