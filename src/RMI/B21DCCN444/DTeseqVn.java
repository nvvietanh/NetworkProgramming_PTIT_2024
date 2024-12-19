/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN444;

import RMI.ByteService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DTeseqVn {
    
    public static void main(String[] args) {
        
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            ByteService service = (ByteService) rg.lookup("RMIByteService");
            
            String studentCode = "B21DCCN444";
            String qCode = "DTeseqVn";
            
            // a
            byte[] d = service.requestData(studentCode, qCode);
            
            // b
//            List<String> ans = new ArrayList<>();
//            for (byte x : d) {
//                StringBuilder s = new StringBuilder("");
//                while (x > 0) {
//                    s.append((int) x % 8);
//                    x /= 8;
//                }
//                s.reverse();
//                ans.add(s.toString());
//            }
//            String strAns = String.join("", ans);
//            
//            // c
//            service.submitData(studentCode, qCode, strAns.getBytes());

            byte [] buffer = service.requestData(studentCode, qCode);
            System.out.println(buffer.length);


            String ans = "";

            for(int i = 0; i < buffer.length; i++) {
    //            System.out.println(x);
                String tmp = Integer.toOctalString(buffer[i]); // Chuyển sang chuỗi bát phân
                while(tmp.length() < 3) {
                    tmp = "0" +tmp;
                }
                ans +=tmp;

            }
            System.out.println(ans);
            byte [] sendData = ans.getBytes();

            service.submitData(studentCode, qCode, sendData);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Integer.toOc
    }
    
}

/*

72 = 1 * 8^2 + 1 * 8^1 + 0 * 8^0
72 % 8 = 0, 72 / 8 = 9
9 % 8 = 1, 9 / 8 = 1
1 % 8 = 1, 1 / 8 = 0
*/

/*
[Mã câu hỏi (qCode): DTeseqVn].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý dữ liệu nhị phân.
Giao diện từ xa:
public interface ByteService extends Remote {
public byte[] requestData(String studentCode, String qCode) throws RemoteException;
public void submitData(String studentCode, String qCode, byte[] data) throws RemoteException;
}
Trong đó:
•	Interface ByteService được viết trong package RMI.
Đối tượng cài đặt giao diện từ xa ByteService được đăng ký với RegistryServer với tên là: RMIByteService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với dữ liệu nhị phân nhận được từ RMI Server:
a. Triệu gọi phương thức requestData để nhận một mảng dữ liệu nhị phân (byte[]) từ server.
b. Chuyển đổi mỗi byte trong mảng dữ liệu nhận được thành chuỗi biểu diễn số bát phân (octal). Mỗi byte sẽ được chuyển thành một chuỗi số bát phân gồm ba chữ số (nếu cần, thêm các chữ số 0 ở đầu để đảm bảo đúng định dạng).
Ví dụ: Nếu mảng dữ liệu nhận được là [72, 101, 108], chương trình sẽ thực hiện chuyển đổi từng byte thành dạng bát phân:
•	72 -> "110"
•	101 -> "145"
•	108 -> "154"
Kết quả là chuỗi octal "110145154". Chuyển chuỗi bát phân này trở lại thành mảng byte[] (mỗi ký tự trong chuỗi octal được mã hóa dưới dạng ASCII byte) để gửi về server.
c. Triệu gọi phương thức submitData để gửi mảng byte[] chứa chuỗi bát phân trở lại server.
d. Kết thúc chương trình client.
*/