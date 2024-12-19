package UDP.B21DCCN156;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class pSvt1S2s {
    public static void main(String[] artg) {
        try {
            
            DatagramSocket ds = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("203.162.10.109");
            int port = 2207;
            
            // a
            String code = ";B21DCCN156;pSvt1S2s";
            DatagramPacket dpToSend = new DatagramPacket(code.getBytes(), code.length(), ia, port);
            ds.send(dpToSend);
            
            // b
            byte[] buffer = new byte[1024];
            DatagramPacket dpToReceive = new DatagramPacket(buffer, buffer.length, ia, port);
            ds.receive(dpToReceive);
            String strData = new String(buffer);
            System.out.println(strData);
            
            
            // c
            String[] splittedData = strData.trim().split("[; ]+");
            for (String s : splittedData) {
                System.out.println(s);
            }
            
            int n = Integer.parseInt(splittedData[1]);
            String[] strNums = splittedData[2].trim().split("[, ]+");
            
            Set<Integer> intSet = new TreeSet<>();
            for (String strNum : strNums) {
                intSet.add(Integer.parseInt(strNum));
            }
            
            StringBuilder sbd = new StringBuilder(splittedData[0] + ";");
            int pointer = 1;
            for (int x : intSet) {
                System.out.print(x + " ");
                while (pointer < x) {
                    sbd.append(Integer.toString(pointer));
                    sbd.append(",");
                    pointer += 1;
                }
                pointer++;
            }
            while (pointer <= n) {
                sbd.append(Integer.toString(pointer));
                sbd.append(",");
                pointer += 1;
            }
            String ans = sbd.substring(0, sbd.length() - 1);
            System.out.println("");
            System.out.println(ans);
            
            DatagramPacket dpToSend1 = new DatagramPacket(ans.getBytes(), ans.length(), ia, port);
            ds.send(dpToSend1);
            
            // d
            ds.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*
[Mã câu hỏi (qCode): pSvt1S2s].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
a.	Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;73457A17”
b.	Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;n;A1,A2,...An” , với
-	requestId là chuỗi ngẫu nhiên duy nhất
-	n là một số ngẫu nhiên nhỏ hơn 100.
-            A1, A2 ... Am (m <= n) là các giá trị ngẫu nhiên nhỏ hơn hoặc bằng n và có thể trùng nhau.
Ex: requestId;10;2,3,5,6,5
c.	Tìm kiếm các giá trị còn thiếu và gửi lên server theo định dạng “requestId;B1,B2,...,Bm”
Ex: requestId;1,4,7,8,9,10
d.	Đóng socket và kết thúc chương trình.
*/