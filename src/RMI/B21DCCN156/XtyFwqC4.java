/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN156;

import java.rmi.registry.LocateRegistry;

import RMI.ByteService;
import RMI.ByteService;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class XtyFwqC4 {
    
    public static void main(String[] args) {
        
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            ByteService service = (ByteService) rg.lookup("RMIByteService");
            
            String studentCode = "B21DCCN156";
            String qCode = "XtyFwqC4";
            
            // a
            byte[] d = service.requestData(studentCode, qCode);
            int n = d.length;
            char[] a = new char[d.length];
            for (byte x : d) {
                System.out.print(((int) x) + " ");
            } System.out.println("");
            
            // b
            for (int i = 0; i < n; ++i) {
                d[i] += n;
            }
            
            for (byte x : d) {
                System.out.print(((int) x) + " ");
            } System.out.println("");
            
            // c
            service.submitData(studentCode, qCode, d);
            
            // d
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
/*
[Mã câu hỏi (qCode): XtyFwqC4].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
Giao diện từ xa:
public interface ByteService extends Remote {
public byte[] requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
Trong đó:
•	Interface ByteService được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa ByteService được đăng ký với RegistryServer với tên là: RMIByteService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhị phân nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân (byte[]) từ server, đại diện cho một chuỗi văn bản ASCII.
b. Thực hiện mã hóa Caesar cho mảng dữ liệu nhị phân bằng cách dịch chuyển mỗi byte trong mảng đi một số bước cố định trong bảng mã ASCII. Số bước dịch chuyển là số ký tự ASCII trong mảng dữ liệu.
    Ví dụ: Nếu dữ liệu nhị phân nhận được là [72, 101, 108, 108, 111] (tương ứng với chuỗi "Hello"), chương trình sẽ thực hiện mã hóa Caesar với độ dịch là 5. Kết quả mã hóa là mảng [77, 108, 113, 113, 116], tương ứng với chuỗi "Mlqqt".
c. Triệu gọi phương thức submitData để gửi mảng dữ liệu đã được mã hóa bằng Caesar trở lại server.
d. Kết thúc chương trình client.

*/