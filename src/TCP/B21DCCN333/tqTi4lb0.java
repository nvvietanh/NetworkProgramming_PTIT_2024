/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN333;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class tqTi4lb0 {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2207);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            
            // a
            dos.writeUTF("B21DCCN333;tqTi4lb0");
            
            // b // read the int number n
            int n = dis.readInt();
            System.out.println(n);
            
            // b // read the int numbers one by one
            List<Integer> diceRolls = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) {
                diceRolls.add(dis.readInt());
            }
            System.out.println(diceRolls);
            
            // c
            
            List<Float> probablities = new ArrayList<>();
            for (int i = 1; i <= 6; ++i) {
                int cnt = 0; 
                for (int x : diceRolls) {
                    if (x == i) cnt++;
                }
                probablities.add(1.0f * cnt / n);
            }
            System.out.println(probablities);
            
            for (float x : probablities) {
                dos.writeFloat(x);
            }
            
            // d
            dis.close();
            dos.close();
            soc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

/*
[Mã câu hỏi (qCode): tqTi4lb0].  Một chương trình servercho phép kết nối qua TCP tại cổng 2207 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu là xây dựng chương trình client tương tác với server bằng các byte stream (DataInputStream/DataOutputStream) để trao đổi thông tin theo trình tự sau:

a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi ở định dạng "studentCode;qCode". Ví dụ: "B10DCCN000;0D135D6A".

b. Nhận từ server một số nguyên n, là số lần tung xúc xắc. Ví dụ: Nếu bạn nhận được n = 21 từ máy chủ, có nghĩa bạn sẽ nhận giá trị tung xúc xắc 21 lần.

b. Nhận từ server các giá trị sau mỗi lần tung xúc xắc. Ví dụ: Server gửi lần lượt 21 giá trị là 1,6,4,4,4,3,2,6,3,4,5,4,5,2,4,5,4,6,1,5,5

c. Tính xác suất xuất hiện của các giá trị [1,2,3,4,5,6] khi tung xúc sắc và gửi lần lượt xác suất này (dưới dạng float) lên server theo đúng thứ tự. Ví dụ gửi lên server lần lượt 6 giá trị là 0.0952381, 0.0952381, 0.0952381, 0.33333334, 0.232209524, 0.14285715

d. Đóng kết nối và kết thúc chương trình.
*/
