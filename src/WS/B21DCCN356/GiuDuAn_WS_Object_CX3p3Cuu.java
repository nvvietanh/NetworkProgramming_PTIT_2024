/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN356;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import vn.medianews.ObjectService;
import vn.medianews.ObjectService_Service;
import vn.medianews.Project;

/**
 *
 * @author admin
 */
public class GiuDuAn_WS_Object_CX3p3Cuu {

    public static void main(String[] args) {

        try {

            ObjectService_Service service = new ObjectService_Service();
            ObjectService port = service.getObjectServicePort();

            String sCode = "B21DCCN356";
            String qCode = "CX3p3Cuu";

            List<Project> prjs = port.requestListProject(sCode, qCode);
            System.out.println(prjs);
            
            List<Project> ans = new java.util.ArrayList<>();
            
            for (Project p : prjs) {
                if (p.getCompletionPercentage() >= 80.0f) {
                    LocalDate now = LocalDate.now();
                    
                    // lấy phần ngày tháng năm
                    LocalDate dueDate = p.getDueDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                    
                    long dayDiff = ChronoUnit.DAYS.between(now, dueDate);
                    
                    System.out.println(now);
                    System.out.println(dueDate);
                    System.out.println(dayDiff);
                    
                    System.out.println(p.getDueDate());
                    
                    if (dayDiff <= 15) {
                        ans.add(p);
                    }
                    
                }
            }
            
            port.submitListProject(sCode, qCode, ans);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/*
[Mã câu hỏi (qCode): CX3p3Cuu].  Một dịch vụ web được định nghĩa và mô tả trong tệp ObjectService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/ObjectService?wsdl để xử lý các bài toán với đối tượng.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với ObjectService thực hiện các công việc sau:
a. Triệu gọi phương thức requestListProject với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về danh sách đối tượng Project từ server. Mỗi đối tượng Project có các thuộc tính:
•	projectId: kiểu String, đại diện cho mã dự án.
•	projectName: kiểu String, đại diện cho tên dự án.
•	completionPercentage: kiểu float, đại diện cho tỷ lệ hoàn thành của dự án (tính theo %).
•	dueDate: kiểu Date, đại diện cho hạn hoàn thành của dự án.
b. Lọc và giữ lại các dự án có completionPercentage từ 80% trở lên và có hạn hoàn thành (dueDate) trong vòng 15 ngày tới (tính từ ngày hiện tại).
c. Triệu gọi phương thức submitListProject(String studentCode, String qCode, List<Project> projects) để gửi danh sách các dự án gần hoàn thành và cần ưu tiên trở lại server. 
d. Kết thúc chương trình client.
*/