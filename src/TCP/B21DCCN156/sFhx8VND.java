/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN156;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class sFhx8VND {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2208);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            
            // a
            String studentCode = "B21DCCN156";
            String qCode = "sFhx8VND";
            bw.write(studentCode + ";" + qCode);
            bw.newLine();
            bw.flush();
            
            // b
            String s1 = (String) br.readLine();
            System.out.println(s1);
            String s2 = (String) br.readLine();
            System.out.println(s2);
            
            // c
            StringBuilder sBd = new StringBuilder("");
            for (int i = 0; i < s1.length(); ++i) {
                if (!s2.contains(Character.toString(s1.charAt(i)))) {
                    sBd.append(Character.toString(s1.charAt(i)));
                }
            }
            String ans = sBd.toString();
            System.out.println(ans);
            bw.write(ans);
            bw.flush();
            
            // d
            br.close();
            bw.close();
            soc.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}

/*
[Mã câu hỏi (qCode): sFhx8VND].  [Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai]
Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng ký tự (BufferedReader/BufferedWriter) theo kịch bản sau:
a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;DE0C2BF0"
b.	Nhận lần lượt hai chuỗi ngẫu nhiên từ server
c.	Loại bỏ các ký tự trong chuỗi thứ nhất mà xuất hiện trong chuỗi thứ hai, yêu cầu giữ nguyên thứ tự xuất hiện của ký tự. Gửi chuỗi đã được xử lý lên server.
d.	Đóng kết nối và kết thúc chương trình
*/