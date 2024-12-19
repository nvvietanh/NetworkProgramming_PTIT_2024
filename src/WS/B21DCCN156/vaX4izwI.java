/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS.B21DCCN156;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;
import vn.medianews.RequestString;

//import java.util.

/**
 *
 * @author admin
 */
public class vaX4izwI {
    
    public static void main(String[] args) {
        try {
            CharacterService_Service service = new CharacterService_Service();
//        RequestString rs = new RequestString();
            CharacterService port = service.getCharacterServicePort();

            String studentCode = "B21DCCN156";
            String qCode = "vaX4izwI";

            // a
            String d = (String) port.requestString(studentCode, qCode);
            System.out.println(d);

            // b
            String[] strs = d.trim().split("[\\s_]+");

            int longestStrIdx = 0;
            int shortestStrIdx = 0;
            int shortestLength = 10000;
            int longestLength = 0;
            for (int i = 0; i < strs.length; ++i) {
                int len = strs[i].trim().length();
                if (len > longestLength) {
                    longestStrIdx = i;
                    longestLength = strs[i].length();
                }
                if (len < shortestLength) {
                    shortestStrIdx = i;
                    shortestLength = strs[i].length();
                }
            }

            System.out.println("Longest: " + strs[longestStrIdx]);
            System.out.println("Shortest: " + strs[shortestStrIdx]);

            // c
            String ans = strs[longestStrIdx] + "; " + strs[shortestStrIdx];
            List<String> ansList = new ArrayList<>();
            ansList.add(strs[longestStrIdx]);
            ansList.add(strs[shortestStrIdx]);
            System.out.println(ans);

            //d
//            port.submitCharacterString(studentCode, qCode, ans);
//            port.submitCharacterStringArray(studentCode, qCode, ansList);
            port.submitCharacterString(studentCode, qCode, ans);

            // e
            System.out.println("Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*

*/

/*
[Mã câu hỏi (qCode): vaX4izwI].  Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với CharacterService thực hiện các công việc sau:
a. Triệu gọi phương thức requestString với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một chuỗi (String) từ server. Chuỗi này có thể chứa các từ và khoảng trắng.
b. Xử lý chuỗi nhận được để tìm từ có độ dài lớn nhất và từ có độ dài nhỏ nhất trong chuỗi. Nếu có nhiều từ có cùng độ dài lớn nhất hoặc nhỏ nhất, chọn từ xuất hiện đầu tiên trong chuỗi.
c. Tạo một chuỗi mới theo định dạng: "[từ lớn nhất]; [từ nhỏ nhất]".
d. Triệu gọi phương thức submitCharacterString(String studentCode, String qCode, String data) để gửi chuỗi kết quả đã xử lý trở lại server.
Ví dụ: Nếu chuỗi nhận được từ phương thức requestCharacter là "this is a sample test", từ có độ dài lớn nhất là "sample" và từ có độ dài nhỏ nhất là "a". Chuỗi kết quả sẽ là "sample; a", và được gửi lại server qua phương thức submitCharacter.
e. Kết thúc chương trình client.
*/