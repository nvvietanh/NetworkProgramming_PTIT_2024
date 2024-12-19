/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import vn.medianews.CharacterService;
import vn.medianews.CharacterService_Service;

/**
 *
 * @author admin
 */
public class jFT4tBbo {
    
    public static void main(String[] args) {
        
        try {
            
            String studentCode = "B21DCCN333";
            String qCode = "jFT4tBbo";
            
            CharacterService_Service service = new CharacterService_Service();
            CharacterService port = service.getCharacterServicePort();
            
            // a // retrieve the List<String> object from server
            List<String> strs = port.requestStringArray(studentCode, qCode);
            System.out.println(strs);
            
            // b // classify the strings into groups with the same number of vowels
            Map<Integer, ArrayList<String>> mp = new TreeMap<>();
            for (String s : strs) {
                
                // count the vowels in string s
                int numOfVowels = 0;
                for (int i = 0; i < s.length(); ++i) {
                    if ("aiueo".contains(String.valueOf(Character.toLowerCase(s.charAt(i))))) {
                        numOfVowels += 1;
                    }
                }
                
                // add to map
                if (!mp.containsKey(numOfVowels)) {
                    mp.put(numOfVowels, new ArrayList<>(Arrays.asList(s)));
                } else {
                    mp.get(numOfVowels).add(s);
                }
            }
            // iterate through the map to check
            for (Map.Entry<Integer, ArrayList<String>> entry : mp.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }
            
            List<String> ansL = new ArrayList<>();
            for (ArrayList<String> as : mp.values()) {
                ansL.add(String.join(", ", as.stream().sorted().collect(Collectors.toList())));                
            }
            System.out.println(ansL);
            
//            ansL.stream();
            
            
            // c
            port.submitCharacterStringArray(studentCode, qCode, ansL);
            
            // d
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public static void alternativeCodes() {
        try {

            CharacterService_Service service = new CharacterService_Service();
            CharacterService characterService = service.getCharacterServicePort();

            // Mã sinh viên và mã câu hỏi
            String studentCode = "B21DCCN333";
            String qCode = "jFT4tBbo";

            // a. Triệu gọi phương thức requestStringArray
            List<String> stringArray = characterService.requestStringArray(studentCode, qCode);
            System.out.println("Received string array: " + stringArray);

            // b. Phân loại các từ theo số lượng nguyên âm
            Map<Integer, List<String>> groupedByVowelCount = stringArray.stream()
                    .collect(Collectors.groupingBy(jFT4tBbo::countVowels));

            // Tạo danh sách kết quả
            List<String> result = new ArrayList<>();
            for (Map.Entry<Integer, List<String>> entry : groupedByVowelCount.entrySet()) {
                List<String> sortedWords = entry.getValue().stream()
                        .sorted()
                        .collect(Collectors.toList());
                String groupString = String.join(", ", sortedWords);
                result.add(groupString);
            }

            System.out.println("Resulting grouped list: " + result);

            // c. Triệu gọi phương thức submitCharacterStringArray
            characterService.submitCharacterStringArray(studentCode, qCode, result);
            System.out.println("Result submitted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm đếm số nguyên âm trong một từ
    private static int countVowels(String word) {
        return (int) word.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
    }

    // Interface định nghĩa các phương thức từ CharacterService
//    @javax.jws.WebService
//    public interface CharacterService {
//        List<String> requestStringArray(String studentCode, String qCode);
//
//        void submitCharacterStringArray(String studentCode, String qCode, List<String> data);
//    }
    
}

/*
[Mã câu hỏi (qCode): jFT4tBbo].  Một dịch vụ web được định nghĩa và mô tả trong tệp CharacterService.wsdl, được triển khai trên server tại URL http://<Exam_IP>:8080/JNPWS/CharacterService?wsdl để xử lý các bài toán về chuỗi và ký tự.
Yêu cầu: Viết chương trình tại máy trạm (WS client) để giao tiếp với CharacterService thực hiện các công việc sau:
a. Triệu gọi phương thức requestStringArray với tham số đầu vào là mã sinh viên (studentCode) và mã câu hỏi (qCode) để nhận về một danh sách chuỗi (List<String>) từ server.
b. Phân loại các từ trong mảng chuỗi thành các nhóm có cùng số lượng nguyên âm. Tạo một chuỗi cho mỗi nhóm, trong đó liệt kê các từ cách nhau bằng dấu phẩy, và sắp xếp các từ theo thứ tự từ điển trong mỗi nhóm.
c. Triệu gọi phương thức submitCharacterStringArray(String studentCode, String qCode, List<String> data) để gửi danh sách chuỗi kết quả trở lại server, trong đó mỗi phần tử là một nhóm từ với cùng số lượng nguyên âm.
Ví dụ: Nếu danh sách chuỗi nhận được từ phương thức requestCharacter là ["apple", "banana", "pear", "grape", "kiwi"], các nhóm có thể là:
•	Nhóm 2 nguyên âm: "apple, banana"
•	Nhóm 1 nguyên âm: "grape, kiwi, pear"
Danh sách kết quả sẽ là ["apple, banana", "grape, kiwi, pear"], và danh sách này sẽ được gửi lại server qua phương thức submitCharacter.
d. Kết thúc chương trình client.
*/

/*
Review:
    - lý do trước đó lỗi:
        + không toLowerCase (hoặc toUpperCase)
        + không sort các từ trong từng nhóm tìm đc
    - trước khi tìm số nguyên âm phải toLowerCase hoặc toUpperCase cho string ban đầu
    - sau khi có được các nhóm từ theo số nguyên âm phải sort các từ trong mỗi nhóm trước khi ghép vào list
*/