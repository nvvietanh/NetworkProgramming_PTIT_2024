/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN156;

//import java.rmi.*;

import RMI.CharacterService;
import java.net.URLEncoder;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
//import java.rmi.registry.Registry;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class MaHoaURL_RMI_Char_k5uU1IzQ {
    
    public static void main(String[] args) throws Exception {
        
        try {
            
            // a
//            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            CharacterService charService = (CharacterService) rg.lookup("RMICharacterService");
            
            String studentCode = "B21DCCN156";
            String qCode = "k5uU1IzQ";
            String str = (String) charService.requestCharacter(studentCode, qCode);
            System.out.println(str);
            
            // b
//            String ans = URLEncoder.encode(d, "UTF-8");
//            String ans = "";
//            for(char x : str.toCharArray()) {
//                if(Character.isAlphabetic(x) 
//                        || Character.isDigit(x) 
//                        || "=()!@#$%^&*~".indexOf(x) != -1) {
//                    ans += ((char)x ) + "";
//                } else {
//                    ans += "%" + String.format("%X", (int) x);
//                }
//            }
            String ans = new java.net.URI(null, null, str, null).toASCIIString();
            System.out.println(ans);
            
            // c
            charService.submitCharacter(studentCode, qCode, ans);

            // d
            System.out.println("Done");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}

/*
[Mã câu hỏi (qCode): k5uU1IzQ].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý chuỗi.
Giao diện từ xa:
public interface CharacterService extends Remote {
public String requestCharacter(String studentCode, String qCode) throws RemoteException;
public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
Trong đó:
• Interface CharacterService được viết trong package RMI.
• Đối tượng cài đặt giao diện từ xa CharacterService được đăng ký với RegistryServer với tên là: RMICharacterService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với chuỗi được nhận từ RMI Server:
a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server với định dạng: "Chuỗi đầu vào".
b. Thực hiện thao tác mã hóa URL (URL Encoding) cho chuỗi đầu vào nhận được từ server. Mã hóa URL chuyển đổi các ký tự đặc biệt thành định dạng URL an toàn bằng cách thay thế các ký tự đó bằng ký hiệu phần trăm (%) và mã ASCII của chúng.
Ví dụ: Chuỗi ban đầu "Hello World!" -> Chuỗi mã hóa URL là: "Hello%20World%21"
c. Triệu gọi phương thức submitCharacter để gửi chuỗi đã được mã hóa trở lại server.
d. Kết thúc chương trình client.
*/