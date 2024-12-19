/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN333;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author admin
 */
public class KhoangCachNhoNhat_zjrnNTgt {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2206);
            InputStream is = soc.getInputStream();
            OutputStream os = soc.getOutputStream();
            
            // a
            os.write("B21DCCN333;zjrnNTgt".getBytes());
            os.flush();
            
            // b
            byte[] buffer = new byte[2408];
            int len = is.read(buffer);
            List<String> lstStrInt = Arrays.asList(new String(buffer,0, len).split("[,\\s]+"));
//            for (int x : lstInt)
            System.out.println(lstStrInt);
            
            List<Integer> intLst = lstStrInt
                    .stream()
                    .map((c) -> {
                        c.trim();
                        return Integer.valueOf(c);
                    })
                    .sorted()
                    .collect(Collectors.toList());
            
            System.out.println(intLst);
            
            // c
            int minDis = 1000000, first = 0, sec = 0;
            for (int i = 0; i < intLst.size() - 1; ++i) {
                int dis = intLst.get(i+1) - intLst.get(i);
                if (dis <= minDis) {
                    minDis = dis;
                    first = intLst.get(i);
                    sec = intLst.get(i + 1);
                }
            }
            String ans = String.valueOf(minDis) + "," 
                    + String.valueOf(first) + ","
                    + String.valueOf(sec);
            
            os.write(ans.getBytes());
            
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
[Mã câu hỏi (qCode): zjrnNTgt].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu xây dựng chương trình client thực hiện kết nối tới server trên sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;FF49DC02"
b.	Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách nhau bởi ký tự ","
Ex: 1,3,9,19,33,20
c.	Thực hiện tìm giá trị khoảng cách nhỏ nhất của các phần tử nằm trong chuỗi và hai giá trị lớn nhất tạo nên khoảng cách đó. Gửi lên server chuỗi gồm "khoảng cách nhỏ nhất, số thứ nhất, số thứ hai". Ex: 1,19,20
d.	Đóng kết nối và kết thúc
*/