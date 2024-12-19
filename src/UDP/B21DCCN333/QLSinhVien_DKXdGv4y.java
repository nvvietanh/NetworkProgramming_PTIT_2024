package UDP.B21DCCN333;


import UDP.Student;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class QLSinhVien_DKXdGv4y {
    
    public static void main(String[] args) {
        
        try {
            
            DatagramSocket dSoc = new DatagramSocket();
            
            InetAddress ia = InetAddress.getByName("203.162.10.109");
            int port = 2209;
            
            String studentCode = "B21DCCN333";
            String qCode = "DKXdGv4y";
            
            String code = ";" + studentCode + ";" + qCode;
            
            // a
            DatagramPacket dpSend = new DatagramPacket(code.getBytes(), code.length() , ia, port);
            dSoc.send(dpSend);
            
            // b
            byte[] buff = new byte[2048];
            DatagramPacket dpRec = new DatagramPacket(buff, buff.length);
            dSoc.receive(dpRec);
            
            String reqId = new String(dpRec.getData(), 0, 8);
            
            ByteArrayInputStream bais = new ByteArrayInputStream(dpRec.getData(), 8, dpRec.getData().length - 8);
            ObjectInputStream ois = new ObjectInputStream(bais);
            
            Student sv = (Student) ois.readObject();
            System.out.println(sv);
            
            // chuẩn hóa tên
            sv.setName(String
                    .join(" ", Arrays
                        .asList(sv.getName().split("\\s+"))
                        .stream()
                        .map((word) -> {
                            return Character.toUpperCase(word.charAt(0))
                                    + word.substring(1, word.length())
                                        .toLowerCase();
                        })
                        .collect(Collectors.toList())));
            
            // tạo email
//            sv.setEmail(String.join(" ", Arrays
//                    .asList(sv.getName())
//                    .stream()
//                    .map((word) -> {
//                        return Character.toUpperCase(word.charAt(0))
//                                + word.substring(1, word.length())
//                                    .toLowerCase();
//                    })
//                    .collect(Collectors.toList()))          
                    
//            );
            List<String> lstName = Arrays.asList(sv.getName().split("\\s+"));
            StringBuilder emailSB = new StringBuilder();
            emailSB.append(lstName.get(lstName.size() - 1).toLowerCase());
            for (int i = 0; i < lstName.size() - 1; ++i) {
                emailSB.append(Character.toLowerCase(lstName.get(i).charAt(0)));
            }
            emailSB.append("@ptit.edu.vn");
            
            sv.setEmail(emailSB.toString());
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(sv);
            
            byte[] buff1 = new byte[2048];
            System.arraycopy(reqId.getBytes(), 0, buff1, 0, 8);
            System.arraycopy(baos.toByteArray(), 0, buff1, 8, baos.size());
            
            DatagramPacket dpSend1 = new DatagramPacket(buff1, buff1.length, ia, port);
            dSoc.send(dpSend1);
            
            // d
            dSoc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

/*
[Mã câu hỏi (qCode): DKXdGv4y].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2209. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản sau:
Đối tượng trao đổi là thể hiện của lớp UDP.Student được mô tả:
•	Tên đầy đủ lớp: UDP.Student
•	Các thuộc tính: id String,code String, name String, email String
•	02 Hàm khởi tạo: 
o	public Student(String id, String code, String name, String email)
o	public Student(String code)
•	Trường dữ liệu: private static final long serialVersionUID = 20171107
Thực hiện:
•       Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;EE29C059”
b.	Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Student từ server. Trong đó, các thông tin được thiết lập gồm id và name.
c.	Yêu cầu:
-	Chuẩn hóa tên theo quy tắc: Chữ cái đầu tiên in hoa, các chữ cái còn lại in thường và gán lại thuộc tính name của đối tượng
-	Tạo email ptit.edu.vn từ tên người dùng bằng cách lấy tên và các chữ cái bắt đầu của họ và tên đệm. Ví dụ: nguyen van tuan nam -> namnvt@ptit.edu.vn. Gán giá trị này cho thuộc tính email của đối tượng nhận được
-	Gửi thông điệp chứa đối tượng xử lý ở bước c lên Server với cấu trúc: 08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Student đã được sửa đổi.
d.	Đóng socket và kết thúc chương trình.
*/