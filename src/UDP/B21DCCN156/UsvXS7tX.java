/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.B21DCCN156;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class UsvXS7tX {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2207);
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());                    
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            
            // a
            String studentCode = "B21DCCN156";
            String qCode = "UsvXS7tX";
            dos.writeUTF(studentCode + ";" + qCode);
//            dos.flush();
        
            // b
            // Nhận số phần tử của mảng từ server
            int n = dis.readInt();
            System.out.println("Received array size: " + n);

            // Nhận mảng số nguyên từ server
            int[] array = new int[n];
            System.out.println("Received array from server:");
            for (int i = 0; i < n; i++) {
                array[i] = dis.readInt();
                System.out.print(array[i] + " ");
            }
            System.out.println();

            // c
            // Tính toán tổng, trung bình cộng, và phương sai
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            float mean = (float) sum / n;

            float variance = 0;
            for (int num : array) {
                variance += Math.pow(num - mean, 2);
            }
            variance /= n;

            dos.writeInt(sum); 
            dos.writeFloat(mean); 
            dos.writeFloat(variance); 
            System.out.println("Sent to server: sum=" + sum + ", mean=" + mean + ", variance=" + variance);
            
            // d
            dis.close();
            dos.close();
            soc.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}

/*
[Mã câu hỏi (qCode): UsvXS7tX].  Một chương trình server cho phép kết nối qua TCP tại cổng 2207 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu là xây dựng chương trình client tương tác với server bằng các byte stream (DataInputStream/DataOutputStream) để trao đổi thông tin theo trình tự sau:
a. Gửi một chuỗi chứa mã sinh viên và mã câu hỏi ở định dạng "studentCode;qCode". Ví dụ: "B10DCCN000;A1B2C3D4".
b. Nhận từ server một mảng chứa n số nguyên, với n được gửi từ máy chủ. Ví dụ: Server gửi mảng [5, 9, 3, 6, 8].
c. Tính tổng, trung bình cộng, và phương sai của mảng. Gửi kết quả lần lượt lên server dưới dạng số nguyên và float. Ví dụ, gửi lên lần lượt: 31, 6.2, 4.5599995.
d. Đóng kết nối và kết thúc chương trình.
*/