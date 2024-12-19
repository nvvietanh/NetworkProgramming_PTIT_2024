/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN333;

import RMI.CharacterService;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author admin
 */
public class _27VkCJlR {
    
    public static void main(String[] args) {
        
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            CharacterService service = (CharacterService) rg.lookup("RMICharacterService");
            
            String studentCode = "B21DCCN333";
            String qCode = "27VkCJlR";
            
            // a
            String d = service.requestCharacter(studentCode, qCode);
            System.out.println(d);
            
            // b
            int n = Integer.parseInt(d.trim().replace(" ", ""));
            int i = 0;
            System.out.println(n);
            List<String> lst = new ArrayList<>();
            while (n > 0) {
//                int digit = n % 10;
                
//                switch (i) {
//                    
//                    case 0 : // hàng đơn vị
//                        
//                        break;
//                        
//                    case 1 : // hàng chục
//                        
//                    case 2 :
//                        
//                    case 3 :
//                    
//                    default :
//                        break;
//                }

//                StringBuilder roman = new StringBuilder();
//                while (digit > 0) {
////                    if (digit > 1) {
////                        roman.append("I");
////                        digit -= 1;
////                    }
////                    else if (digit > 5) {
////                        
////                    }
//
//                }
                i++;
                int decDigit = n % 10;
                
                lst.add(getRomanDigit(decDigit, i));
                
                n /= 10;
            }
            System.out.println(lst);
            Collections.reverse(lst);
            System.out.println(lst);
            String ans = String.join("", lst);
            System.out.println(ans);
            
            // c
            service.submitCharacter(studentCode, qCode, ans);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static String decDigitToRoman(int n) {
        StringBuilder sb = new StringBuilder();
        // 1 = don vi, 2 = chuc, 3 = tram, 4 = nghin
        switch (n) {
            case 1 :
                
            case 2 :
        }
        
        return sb.toString();
    }
    
    public static String getRomanDigit(int num, int level) {
//        if (num == 4) {
//            return getRomanDigit(1, level) + getRomanDigit(5, level);
//        }
//        if (num == 4) {
//            return getRomanDigit(1, level) + getRomanDigit(5, level);
//        }
//        if (level == 1) {
//            if (num == 1) return "I";
//            else if (num == 5) return "V";
//        }
//        if (level == 2) {
//            if (num == 1) return "X";
//            else if (num == 5) return "L";
//        }
//        if (level == 3) {
//            if (num == 1) return "C";
//            else if (num == 5) return "D";
//        }
//        if (level == 4) {
//            if (num == 1) return "M";
////            else if (num == 5) return "V";
//        }
//        return "";
//        
        switch (num) {
            case 1 :
                if (level == 1) return "I";
                if (level == 2) return "X";
                if (level == 3) return "C";
                if (level == 4) return "M";
                break;
                
            case 2 :
                return getRomanDigit(1, level) + getRomanDigit(1, level);
                
            case 3 :
                return getRomanDigit(1, level) + getRomanDigit(1, level) + getRomanDigit(1, level);

            case 4 :
                return getRomanDigit(1, level) + getRomanDigit(5, level);

            case 5 :
                if (level == 1) return "V";
                if (level == 2) return "L";
                if (level == 3) return "D";
                break;
                
            case 6 :
                return getRomanDigit(5, level) + getRomanDigit(1, level);
                
            case 7 :
                return getRomanDigit(5, level) + getRomanDigit(1, level) + getRomanDigit(1, level);
                
            case 8 :
                return getRomanDigit(5, level) + getRomanDigit(1, level)
                        + getRomanDigit(1, level) + getRomanDigit(1, level);
                
            case 9 :
                return getRomanDigit(1, level) + getRomanDigit(1, level + 1);
                
            default :
                return "";
        }
        System.out.println(num + " " +level);
        return "";
    }
    
}

/*
[Mã câu hỏi (qCode): 27VkCJlR].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để xử lý chuỗi.
Giao diện từ xa:
public interface CharacterService extends Remote {
public String requestCharacter(String studentCode, String qCode) throws RemoteException;
public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
Trong đó:
• Interface CharacterService được viết trong package RMI.
• Đối tượng cài đặt giao diện từ xa CharacterService được đăng ký với RegistryServer với tên là: RMICharacterService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với chuỗi được nhận từ RMI Server:
a. Triệu gọi phương thức requestCharacter để nhận chuỗi ngẫu nhiên từ server với định dạng: "Số thập phân đầu vào".
b. Thực hiện chuyển đổi số thập phân nhận được thành chuỗi số La Mã (Roman).
Quy tắc chuyển đổi:
    Các ký tự La Mã chính bao gồm: I=1, V=5, X=10, L=50, C=100, D=500, M=1000.
    Ví dụ: 58 -> "LVIII".
c. Triệu gọi phương thức submitCharacter để gửi chuỗi số La Mã đã chuyển đổi trở lại server.
d. Kết thúc chương trình client.
*/