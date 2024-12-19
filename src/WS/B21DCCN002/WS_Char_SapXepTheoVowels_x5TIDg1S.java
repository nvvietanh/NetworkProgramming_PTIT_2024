/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN002;

//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;

import java.rmi.*;
import java.rmi.registry.*;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author admin
 */
public class WS_Char_SapXepTheoVowels_x5TIDg1S {
    
    public static void main(String[] args) {
        
        try {
            
            String studentCode = "B21DCCN002";
            String qCode = "x5TIDg1S";
            
            CharacterService_Service service = new CharacterService_Service();
            CharacterService port = (CharacterService) service.getCharacterServicePort();
            
            // a
            List<String> strs = port.requestStringArray(studentCode, qCode);
            System.out.println(strs);
            
            // b
            strs.sort((x, y) -> {
                return cntVowels(x) - cntVowels(y);
            });
            System.out.println(strs);
            
            // c
            port.submitCharacterStringArray(studentCode, qCode, strs);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static int cntVowels(String s) {
        String vowelsPattern = "aiueoAIUEO";
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (vowelsPattern.indexOf(s.charAt(i)) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
    
}

/*
[Mã câu hỏi (qCode): x5TIDg1S].  Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với CharacterService thực hiện các công việc sau:
a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách chuỗi (List<String>) từ server.
b. Sắp xếp các chuỗi trong danh sách theo số lượng nguyên âm tăng dần. Nếu hai chuỗi có cùng số lượng nguyên âm, giữ nguyên thứ tự xuất hiện ban đầu của chúng trong mảng.
c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi đã sắp xếp trở lại server.
Ví dụ: Nếu mảng chuỗi nhận được từ phương thức requestCharacter là ["apple", "kiwi", "banana", "pear"], số lượng nguyên âm trong các từ là:
•	"apple" có 2 nguyên âm
•	"kiwi" có 2 nguyên âm
•	"pear" có 2 nguyên âm
•	"banana" có 3 nguyên âm
Sau khi sắp xếp theo số lượng nguyên âm tăng dần, kết quả sẽ là ["apple", "kiwi", "pear", , "banana"]. Danh sách này sẽ được gửi lại server qua phương thức submitCharacter.
d. Kết thúc chương trình client.
*/