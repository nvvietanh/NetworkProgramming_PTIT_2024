/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP.B21DCCN156;

import UDP.Product;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author admin
 */
public class M6o5C66D {
    
    public static void main(String[] args) {
        
        try {
            
            DatagramSocket dSoc = new DatagramSocket();
            InetAddress ia = InetAddress.getByName("203.162.10.109");
            int port = 2209;
            
            // b.1
            String studentCode = "B21DCCN156";
            String qCode = "M6o5C66D";
            String reqCode = ";" + studentCode + ";" + qCode;
            // send the packet containing codes
            DatagramPacket dpToSend = new DatagramPacket(reqCode.getBytes(), reqCode.length(), ia, port);
            dSoc.send(dpToSend);
            
            // b.2
            // receive the packet
            byte[] buff = new byte[2048];
            DatagramPacket dpToReceive = new DatagramPacket(buff, buff.length);
            dSoc.receive(dpToReceive);
            
            // retrieve requestId in first 8 bytes
            String reqId = new String(dpToReceive.getData(), 0, 8);
            System.out.println(reqId);
            
            // retrieve the Object from the bytes from index 8 to the end.
            ByteArrayInputStream bais = new ByteArrayInputStream(dpToReceive.getData(), 8, dpToReceive.getData().length - 8);
            ObjectInputStream ois = new ObjectInputStream(bais);
            Product prd = (Product) ois.readObject();
            System.out.println(prd);
            
            // process data of the object <Product>
                // name
//            String[] names = ;
//            
            String[] names = prd.getName().trim().split("[ ]+");
            StringBuilder namesSB = new StringBuilder("");
            namesSB.append(names[names.length - 1]);
            namesSB.append(" ");
            for (int i = 1; i < names.length - 1; ++i) {
                namesSB.append(names[i]);
                namesSB.append(" ");
            }
            namesSB.append(names[0]);
            prd.setName(namesSB.toString());
            
                // quantity
//            ArrayL rstrQuantity = Integer.toString(prd.getQuantity());
//            Collections.reverse();
            int q = prd.getQuantity();
            int rq = 0;
            while (q > 0) {
                rq = rq * 10 + q % 10;
                q /= 10;
            }
            prd.setQuantity(rq);
            
            System.out.println(prd);
            
            // send
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(prd); oos.flush();
            
            byte[] bufferToSend = new byte[reqId.length() + baos.size() + 1000];
            System.arraycopy(reqId.getBytes(), 0, bufferToSend, 0, 8);
            System.arraycopy(baos.toByteArray(), 0, bufferToSend, 8, baos.size());
            DatagramPacket dpToSend1 = new DatagramPacket(bufferToSend, bufferToSend.length, ia, port);
            dSoc.send(dpToSend1);
            
            // close connections
            dSoc.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

/*
[Mã câu hỏi (qCode): M6o5C66D].  Thông tin sản phẩm vì một lý do nào đó đã bị sửa đổi thành không đúng, cụ thể:
a.	Tên sản phẩm bị đổi ngược từ đầu tiên và từ cuối cùng, ví dụ: “lenovo thinkpad T520” bị chuyển thành “T520 thinkpad lenovo”
b.	Số lượng sản phẩm cũng bị đảo ngược giá trị, ví dụ từ 9981 thành 1899

Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2209. Yêu cầu là xây dựng một chương trình client giao tiếp với server để gửi/nhận các sản phẩm theo mô tả dưới đây:
a.	Đối tượng trao đổi là thể hiện của lớp Product được mô tả như sau
•	Tên đầy đủ của lớp: UDP.Product
•	Các thuộc tính: id String, code String, name String, quantity int
•	Một hàm khởi tạo có đầy đủ các thuộc tính được liệt kê ở trên
•	Trường dữ liệu: private static final long serialVersionUID = 20161107; 
b.	Giao tiếp với server theo kịch bản
•       Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;EE29C059”

•	Nhận thông điệp chứa: 08 byte đầu chứa chuỗi requestId, các byte còn lại chứa một đối tượng là thể hiện của lớp Product từ server. Trong đối tượng này, các thuộc tính id, name và quantity đã được thiết lập giá trị.
•	Sửa các thông tin sai của đối tượng về tên và số lượng như mô tả ở trên và gửi đối tượng vừa được sửa đổi lên server theo cấu trúc:
08 byte đầu chứa chuỗi requestId và các byte còn lại chứa đối tượng Product đã được sửa đổi.
•	Đóng socket và kết thúc chương trình.
*/