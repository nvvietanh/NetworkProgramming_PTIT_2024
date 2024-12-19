/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN002;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class ChuoiConKhongLapDaiNhat_TCP_Byte_YaRebRFf {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2206);
            OutputStream os = soc.getOutputStream();
            InputStream is = soc.getInputStream();
            
            // a
            String code = "B21DCCN002;YaRebRFf";
            os.write(code.getBytes());
            os.flush();
            
            // b
            byte[] buffer = new byte[2048];
            is.read(buffer);
            String str = new String(buffer);
            System.out.println(str);
            
            // c
            StringBuilder tmp = new StringBuilder();
            String ans = new String();
            for (int i = 0; i < str.length(); ++i) {
                for (int j = i; j < str.length(); ++j) {
                    if (tmp.indexOf(Character.toString(str.charAt(j))) != -1) {
                        if (ans.length() < tmp.length()) {   
                            ans = tmp.toString();
                        }
                        break;
                    }
                    else {
                        tmp.append(str.charAt(j));
                    }
                }
                tmp.delete(0, tmp.length());
            }
            System.out.println(ans);
            
            // c
            os.write((ans.toString() + ";" + ans.length()).getBytes());
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

/*
[Mã câu hỏi (qCode): YaRebRFf].  
Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client thực hiện kết nối tới server sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:
    a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;10048F28".
    b. Nhận chuỗi ký tự từ server. Ví dụ: "abcabcbb"
    c. Tìm và gửi lên server chuỗi con dài nhất từ chuỗi nhận được mà không có ký tự lặp lại theo format "longestsubstring;length". Ví dụ: "abc;3".
    d. Đóng kết nối và kết thúc chương trình.
*/