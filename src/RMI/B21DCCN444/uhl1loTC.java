/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN444;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class uhl1loTC {
    
    public static int romanToInt(char c) {
        switch (c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default  : return 0;
        }
    }
    
    public static void main(String[] args) {
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            CharacterService service = (CharacterService) rg.lookup("RMICharacterService");
            
            String studentCode = "B21DCCN444";
            String qCode = "uhl1loTC";
            
            // a
            String d = service.requestCharacter(studentCode, qCode).trim();
            System.out.println(d);
            
            // b
            int sum = romanToInt(d.charAt(d.length() - 1));
            for (int i = d.length() - 2; i >= 0; --i) {
                int cur = romanToInt(d.charAt(i));
                int next = romanToInt(d.charAt(i + 1));
                if (cur < next) {
                    sum -= cur;
                }
                else {
                    sum += cur;
                }
            }
            System.out.println(sum);
            
            // c
            service.submitCharacter(studentCode, qCode, String.valueOf(sum));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
[Mã câu hỏi (qCode): uhl1loTC].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý chuỗi.
Giao diện từ xa:
public interface CharacterService extends Remote {
public String requestCharacter(String studentCode, String qCode) throws RemoteException;
public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
Trong đó:
• Interface CharacterService được viết trong package RMI.
• Đối tượng cài đặt giao diện từ xa CharacterService được đăng ký với RegistryServer với tên là: RMICharacterService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với chuỗi được nhận từ RMI Server:
a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server với định dạng: "Chuỗi số La Mã đầu vào".
b. Thực hiện chuyển đổi chuỗi số La Mã nhận được thành số thập phân (Decimal).
Quy tắc chuyển đổi: Các ký tự La Mã chính bao gồm: I=1, V=5, X=10, L=50, C=100, D=500, M=1000.
    Ví dụ: "MCMXCIV" -> 1994.
c. Triệu gọi phương thức submitCharacter để gửi số thập phân đã chuyển đổi trở lại server.
d. Kết thúc chương trình client.
*/

/*
MCMXCIV
(1000) + (1000 - 100) + (100 - 10) + (5 - 1)

VIII -> 8
IX -> 9
tại char x, lấy int(x): 
    - trừ đi int của 1 ký tự la mã phía trước nhỏ hơn nó
    - cộng int của 3 ký tự la mã phía sau nhỏ hơn nó

tại char x, lẩy int(x) trừ giá trị phía trước của nó mà nhỏ hơn nó.
*/

/*
CLXIVDLXXC

100 - 10 + 10 

*/