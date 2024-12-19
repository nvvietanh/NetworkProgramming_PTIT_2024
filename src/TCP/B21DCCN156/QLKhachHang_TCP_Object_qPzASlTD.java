/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP.B21DCCN156;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import TCP.Customer;
import TCP.Customer;

/**
 *
 * @author admin
 */

public class QLKhachHang_TCP_Object_qPzASlTD {
    
    public static void main(String[] args) {
        
        try {
            
            Socket soc = new Socket("203.162.10.109", 2209);
            ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
            
            // b.1
            String studentCode = "B21DCCN156";
            String qCode = "qPzASlTD";
            oos.writeObject("B21DCCN156;qPzASlTD");
            oos.flush();
            
            // b.2
            Customer d = (Customer) ois.readObject();
            Customer csd = (Customer) d;
            System.out.println(csd);
            
            // b.3
            // name
            String[] names = csd.getName().trim().split("[ ]+");
            StringBuilder nameSB = new StringBuilder(names[names.length - 1].toUpperCase());
            nameSB.append(",");
            for (int i = 0; i < names.length - 1; ++i) {
                nameSB.append(" ");
                nameSB.append(Character.toUpperCase(names[i].charAt(0)));
                nameSB.append(names[i].substring(1, names[i].length()).toLowerCase());
            }
            csd.setName(nameSB.toString());
               
            // dob
            String[] doba = csd.getDayOfBirth().split("-");
            csd.setDayOfBirth(doba[1] + "/" + doba[0] + "/" + doba[2]);
            
            // username
            StringBuilder unSB = new StringBuilder();
            for (int i = 0; i < names.length - 1; ++i) {
                unSB.append(Character.toLowerCase(names[i].charAt(0)));
            }
            unSB.append(names[names.length - 1].toLowerCase());
            csd.setUserName(unSB.toString());
            
            System.out.println(csd);
            
            // send
            oos.writeObject(csd);
            
            // b.4
            ois.close();
            oos.close();
            soc.close();
                        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
/*
[Mã câu hỏi (qCode): qPzASlTD].  Thông tin khách hàng cần thay đổi định dạng lại cho phù hợp với khu vực, cụ thể:
a.	Tên khách hàng cần được chuẩn hóa theo định dạng mới. Ví dụ: nguyen van hai duong -> DUONG, Nguyen Van Hai
b.	Ngày sinh của khách hàng hiện đang ở dạng mm-dd-yyyy, cần được chuyển thành định dạng dd/mm/yyyy. Ví dụ: 10-11-2012 -> 11/10/2012
c.	Tài khoản khách hàng là các chữ cái in thường được sinh tự động từ họ tên khách hàng. Ví dụ: nguyen van hai duong -> nvhduong

Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2209 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng đối tượng (ObjectInputStream / ObjectOutputStream) thực hiện gửi/nhận đối tượng khách hàng và chuẩn hóa. Cụ thể:
a.	Đối tượng trao đổi là thể hiện của lớp Customer918 được mô tả như sau
      •	Tên đầy đủ của lớp: TCP.Customer918
      •	Các thuộc tính: id int, code String, name String, dayOfBirth String, userName String
      •	Hàm khởi tạo đầy đủ các thuộc tính được liệt kê ở trên
      •	Trường dữ liệu: private static final long serialVersionUID = 918; 
b.	Tương tác với server theo kịch bản dưới đây:
	1) Gửi đối tượng là một chuỗi gồm mã sinh viên và mã câu hỏi ở định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;F2DA54F3"
	2) Nhận một đối tượng là thể hiện của lớp Customer918 từ server với các thông tin đã được thiết lập
	3) Thay đổi định dạng theo các yêu cầu ở trên và gán vào các thuộc tính tương ứng.  Gửi đối tượng đã được sửa đổi lên server
	4) Đóng socket và kết thúc chương trình.
*/