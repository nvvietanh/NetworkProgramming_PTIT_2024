/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN444;

import RMI.Employee;
import RMI.ObjectService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class z1E0U2gP {
    
    public static void main(String[] args) {
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            ObjectService service = (ObjectService) rg.lookup("RMIObjectService");
                        
            String studentCode = "B21DCCN444";
            String qCode = "z1E0U2gP";
            
            // a
            Employee em = (Employee) service.requestObject(studentCode, qCode);
            System.out.println(em);
            
            // b
            // b.1
            int expYears = em.getExperienceYears();
            int sumOfDigits = 0;
            for (char x : String.valueOf(expYears).toCharArray()) {
                sumOfDigits += (int) (x - '0');
            }
            // b.2
            int cntOfDigits = 0;
            for (int i = 1; i <= expYears; ++i) {
                if (expYears % i == 0) {
                    cntOfDigits += 1;                
                }                
            }
            // b.3
            double factor = 1.0 * (expYears + sumOfDigits + cntOfDigits) / 100.0;
            
            // b.4
            double finalSalary = em.getBaseSalary() * (1.0 + factor);
            
            // c
            em.setFinalSalary(finalSalary);
            
            System.out.println(em);
            // d
            service.submitObject(studentCode, qCode, em);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

/*
[Mã câu hỏi (qCode): z1E0U2gP].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý thông tin nhân viên. Chương trình sẽ ngẫu nhiên tạo ra đối tượng Employee với các giá trị ban đầu và cung cấp cho RMI client như sau:
Giao diện từ xa:
public interface ObjectService extends Remote {
    public Serializable requestObject(String studentCode, String qCode) throws RemoteException;
    public void submitObject(String studentCode, String qCode, Serializable object) throws RemoteException;
}
Lớp Employee gồm các thuộc tính: id String, name String, baseSalary double, experienceYears int, finalSalary double.
Trường dữ liệu: private static final long serialVersionUID = 20241119L;
02 hàm khởi dựng: 
public Employee() 
public Employee(String id, String name, double baseSalary, int experienceYears)
Trong đó:
•	Interface ObjectService và lớp Employee được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa ObjectService được đăng ký với RegistryServer với tên là: RMIObjectService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với đối tượng nhân viên được nhận từ RMI Server:
a. Triệu gọi phương thức requestObject với tham số đầu vào là mã sinh viên và mã câu hỏi để nhận đối tượng Employee ngẫu nhiên từ server.
b. Tính toán finalSalary dựa trên baseSalary, experienceYears, và áp dụng thuật toán xử lý số phức tạp để tạo hệ số điều chỉnh, yêu cầu sinh viên phải thao tác và xử lý experienceYears như sau:
•	Tách experienceYears thành tổng các chữ số (ví dụ, 14 sẽ thành 1 + 4 = 5).
•	Tính số lượng ước số nguyên của experienceYears (ví dụ, nếu experienceYears là 12, các ước số là 1, 2, 3, 4, 6, 12, nên có 6 ước số).
•	Xác định hệ số điều chỉnh factor dựa trên công thức sau: factor = (Số năm làm việc + tổng các chữ số + số lượng ước số) / 100.0
•	Tính finalSalary theo công thức: finalSalary = baseSalary * (1 + factor)
c. Cập nhật giá trị finalSalary trong đối tượng Employee.
d. Triệu gọi phương thức submitObject để gửi đối tượng Employee đã được xử lý trở lại server.
e. Kết thúc chương trình client.
*/