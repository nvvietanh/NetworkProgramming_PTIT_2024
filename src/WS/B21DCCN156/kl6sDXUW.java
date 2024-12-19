/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN156;

//import WS.StudentYz;
import vn.medianews.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import vn.medianews.ObjectService_Service;
import vn.medianews.ObjectService;

/**
 *
 * @author admin
 */
public class kl6sDXUW {
    
    public static void main(String[] args) {
        
        try {
            
            ObjectService_Service service = new ObjectService_Service();
            ObjectService port = service.getObjectServicePort();
            
            String studentCode = "B21DCCN156";
            String qCode = "kl6sDXUW";
            
            // a // retrieve the List<StudentY> object
            List<StudentY> st = port.requestListStudentY(studentCode, qCode);
            for (StudentY x : st) {
                System.out.println(x.getName());
            }
            
            // b // find and keep the StudentY object with the highest "score" on each "subject"
            HashMap<String, Integer> mapSubjectIndex = new HashMap<>();
            for (int i = 0; i < st.size(); ++i) {
                if (!mapSubjectIndex.containsKey(st.get(i).getSubject())
                        || st.get(mapSubjectIndex.get(st.get(i).getSubject())).getScore() < st.get(i).getScore()) {
                    mapSubjectIndex.put(st.get(i).getSubject(), i);
                }
            }
            Set<Integer> setIndex = new TreeSet<>(mapSubjectIndex.values());
            List<StudentY> lstAns = new ArrayList<>();
            for (int x : setIndex) {
                lstAns.add(st.get(x));
            }
            
            // c // submit the answer
            port.submitListStudentY(studentCode, qCode, lstAns);
            
            // d // end the program
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

/*
[Mã câu hỏi (qCode): kl6sDXUW].  Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với ObjectService thực hiện các công việc sau:
a. Triệu gọi phương thức requestListStudentY với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng StudentY từ server. Mỗi đối tượng Student có các thuộc tính:
•	studentId: kiểu String, đại diện cho mã sinh viên.
•	name: kiểu String, đại diện cho tên sinh viên.
•	subject: kiểu String, đại diện cho tên môn học.
•	score: kiểu float, đại diện cho điểm số của sinh viên trong môn học.
b. Thực hiện: Lọc và giữ lại sinh viên có điểm số cao nhất theo từng môn học
c. Triệu gọi phương thức submitListStudentY(String studentCode, String qCode, List<StudentY> studentYs) để gửi danh sách sinh viên đạt điểm cao nhất theo từng môn học trở lại server (Lưu ý bảo toàn vị trí xuất hiện của sinh viên trong danh sách ban đầu)
d. Kết thúc chương trình client.
*/