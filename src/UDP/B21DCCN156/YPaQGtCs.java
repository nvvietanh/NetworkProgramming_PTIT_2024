/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.B21DCCN156;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author admin
 */
public class YPaQGtCs {
    
    public static void main(String[] args) {
        try {
            
            DatagramSocket ds = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("203.162.10.109");
            int port = 2208;
            
            // a
            String code = ";B21DCCN156;YPaQGtCs";
            DatagramPacket dpSend = new DatagramPacket(code.getBytes(), code.length(), ia, port);
            ds.send(dpSend);
            
            // b
            byte buffer[] = new byte[1024];
            DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
            ds.receive(dpReceive);
            
            // c
            String d = new String(dpReceive.getData()).trim();
            String[] dss = d.trim().split("[; ]+");
            String a = dss[1];
            String b = dss[2];
            System.out.println(a); System.out.println(b);
            
//            String strOut = "";
            StringBuilder sbOut = new StringBuilder(dss[0] + ";");
            
            for (int i = 0; i < a.length(); ++i) {
                if (!b.contains(a.substring(i, i+1))) {
                    sbOut.append(a.substring(i, i+1));
                }
            }
            String strOut = sbOut.toString();
            System.out.println(strOut);
            DatagramPacket dpSend1 = new DatagramPacket(strOut.getBytes(), strOut.length(), ia, port);
            ds.send(dpSend1);
            
            // d
            ds.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}

/*
[Mã câu hỏi (qCode): YPaQGtCs].  [Loại bỏ ký tự đặc biệt và ký tự trùng giữ nguyên thứ tự xuất hiện]
Một chương trình server cho phép kết nối qua giao thức UDP tại cổng 2208 . Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản dưới đây:
a.	Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode”. Ví dụ: ";B15DCCN001;B34D51E0"
b.	Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;str1;str2".
•	requestId là chuỗi ngẫu nhiên duy nhất
•	str1,str2 lần lượt là chuỗi thứ nhất và chuỗi thứ hai
c.	Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai, giữ nguyên thứ tự xuất hiện. Gửi thông điệp là một chuỗi lên server theo định dạng "requestId;strOutput", trong đó chuỗi strOutput là chuỗi đã được xử lý ở trên.
d.	Đóng socket và kết thúc chương trình.

*/