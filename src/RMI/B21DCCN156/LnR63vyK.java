/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN156;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import java.math.BigInteger;

import vn.medianews.*;

import RMI.DataService;
import RMI.DataService;

/**
 *
 * @author admin
 */
public class LnR63vyK {
        
    public static void main(String[] args) {
        try {
            // Kết nối đến RMI Server
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            DataService dataService = (DataService) rg.lookup("RMIDataService");
            
//            DataService dataService = (DataService) Naming.lookup("rmi://203.162.10.109/RMIDataService");

            // a. Triệu gọi phương thức requestData để lấy số nguyên dương lớn N
            String studentCode = "B21DCCN156"; // Thay bằng mã sinh viên của bạn
            String qCode = "LnR63vyK"; // Mã câu hỏi
            int result = (int) dataService.requestData(studentCode, qCode);
            int N = (int) result;
            System.out.println("Số nhận được từ server: " + N);

            // b. Phân rã số N thành các thừa số nguyên tố
            List<Integer> primeFactors = getPrimeFactors(N);
            System.out.println("Danh sách các thừa số nguyên tố: " + primeFactors);

            // c. Gửi danh sách các thừa số nguyên tố trở lại server
            dataService.submitData(studentCode, qCode, primeFactors);
            System.out.println("Danh sách thừa số nguyên tố đã gửi lại server.");

            // d. Kết thúc chương trình
            System.out.println("Hoàn thành.");
        } catch (Exception e) {
            System.err.println("Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Hàm phân rã số N thành các thừa số nguyên tố
    public static List<Integer> getPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        // Xử lý các số 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        // Xử lý các số lẻ
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        // Nếu n là số nguyên tố lớn hơn 2
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }
    
}

/*
[Mã câu hỏi (qCode): LnR63vyK].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu.
Giao diện từ xa:
public interface DataService extends Remote {
public Object requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
}
Trong đó:
•	Interface DataService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa DataService được đăng ký với RegistryServer với tên là: RMIDataService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một số nguyên dương lớn từ server, gọi là N.
b. Thực hiện phân rã số N thành các thừa số nguyên tố. Kết quả trả về là danh sách các thừa số nguyên tố của N.
Ví dụ: Với N = 84, kết quả là danh sách “2, 2, 3, 7”.
c. Triệu gọi phương thức submitData để gửi danh sách các thừa số nguyên tố đã tìm được trở lại server.
d. Kết thúc chương trình client.

*/

/*
package ontap;
import java.util.*;
import RMI.DataService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class OnTap {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int n = (int) sv.requestData("B21DCCN156", "LnR63vyK");
        System.out.println(n);
        List<Integer>a = new ArrayList<>();

*/