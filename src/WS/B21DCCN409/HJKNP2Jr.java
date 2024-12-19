/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN409;

import java.util.List;
import vn.medianews.*;


/**
 *
 * @author admin
 */
public class HJKNP2Jr {
    
    public static void main(String[] args) {
        
        try {
            
            DataService_Service service = new DataService_Service();
            DataService port = service.getDataServicePort();
                                    
            String studentCode = "B21DCCN409";
            String qCode = "HJKNP2Jr";
            
            // a
            List<Integer> a = (List<Integer>) port.getData(studentCode, qCode);
            System.out.println(a);
            
            // b 
            int sum = 0;
            for (int x : a) {
                sum += x;
            }
             
            // c
            port.submitDataInt(studentCode, qCode, sum);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

/*
[Mã câu hỏi (qCode): HJKNP2Jr].  Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.
b. Thực hiện tính toán tổng của tất cả các phần tử trong danh sách số nguyên nhận được.
c. Triệu gọi phương thức submitDataInt(String studentCode, String qCode, int data) để gửi kết quả tổng đã tính được trở lại server.
Ví dụ: Nếu mảng số nguyên nhận được từ phương thức getData là [1, 2, 3, 4, 5], chương trình client sẽ tính tổng là 15 và gửi kết quả này trở lại server qua phương thức submitData 
d. Kết thúc chương trình client.
*/