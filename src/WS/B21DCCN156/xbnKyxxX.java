/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN156;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import vn.medianews.*;
import vn.medianews.DataService_Service;
import vn.medianews.DataService;

/**
 *
 * @author admin
 */
public class xbnKyxxX {
    
    public static void main(String[] args) {
        
        try {
            
            DataService_Service service = new DataService_Service();
            DataService port = service.getDataServicePort();
            
            String studentCode = "B21DCCN156";
            String qCode = "xbnKyxxX";
            
            // a // Call getData() to retrive List<Integer>
            List<Integer> a = port.getData(studentCode, qCode);
            System.out.println(a);
            
            // b
            Collections.sort(a);
            System.out.println(a);
            
            int currentNum = a.get(0);
            int cnt = 0;
            List<String> ansAL = new ArrayList<>();
            for (int x : a) {
                if (currentNum == x) {
                    cnt += 1;
                }
                else {
                    ansAL.add(currentNum + ", " + cnt);
                    
                    currentNum = x;
                    cnt = 1;
                }
            }
            ansAL.add(currentNum + ", " + cnt);
            System.out.println(ansAL);
            
            // c
            port.submitDataStringArray(studentCode, qCode, ansAL);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

/*
[Mã câu hỏi (qCode): xbnKyxxX].  Một dịch vụ web được định nghĩa và mô tả trong tệp DataService?wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/DataService?wsdl để xử lý các bài toán với dữ liệu nguyên thủy.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với DataService thực hiện các công việc sau:
a. Triệu gọi phương thức getData với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách số nguyên (List<Integer>) từ server.
b. Với mảng số nguyên nhận được, thực hiện đếm số lần xuất hiện của từng phần tử trong mảng và lưu kết quả vào một chuỗi theo định dạng: giá trị của phần tử, số lần xuất hiện tương ứng của nó.
c. Triệu gọi phương thức submitDataStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi kết quả chứa cặp giá trị [phần tử, tần suất] của từng phần tử đã tính được trở lại server.
Ví dụ: Nếu mảng số nguyên nhận được từ phương thức getData là [1, 2, 2, 3, 3, 3], kết quả tần suất sẽ là ["1, 1", "2, 2", "3, 3"], và danh sách kết quả này sẽ được gửi lại server qua phương thức submitDataStringArray.
d. Kết thúc chương trình client.
*/