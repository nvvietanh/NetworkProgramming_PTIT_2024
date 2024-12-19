/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN156;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author admin
 */
public class XZjkOtoy {
    
    public static void main(String args[]) {
        
        try {
            Socket s = new Socket("203.162.10.109", 2206);
            
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();

            // a
            String code = "B21DCCN156;XZjkOtoy";
            
            os.write(code.getBytes());
            os.flush();
            
            // b
            byte[] buffer = new byte[1024];
            int bytesRead = is.read(buffer);
            String d = new String(buffer);
            
            // c
            String[] ds = d.trim().split("[, ]+");
            ArrayList<Integer> a = new ArrayList<>();
            
            int thunhat = 0;
            int thuhai = thunhat;
            int vitri;
            
            for (String x : ds) {
                int tmp = Integer.parseInt(x);
                System.out.println(tmp);
                a.add(tmp);
                if (thunhat < tmp) {
                    thuhai = thunhat;
                    thunhat = tmp;
                }
            }
//            Collections.sort(a);

            
//            for (int i = a.size() - 1; i >= 0; i--) {
//                if (a.get(i) < thunhat) {
//                    thuhai = a.get(i);
//                    break;
//                }
//            }
//            for (int i = 0; i < a.s)   
            vitri = a.indexOf(thuhai);
            
            String ans = thuhai + "," + vitri;
            System.out.println(ans);
            os.write(ans.getBytes());
            
            // d
            os.close();
            is.close();
            s.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}

/*
[Mã câu hỏi (qCode): XZjkOtoy].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
b.	Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách nhau bởi ký tự ",". Ví dụ: 1,3,9,19,33,20
c.	Tìm và gửi lên server giá trị lớn thứ hai cùng vị trí xuất hiện của nó trong chuỗi.Ví dụ: 20,5
d.	Đóng kết nối và kết thúc chương trình.
*/