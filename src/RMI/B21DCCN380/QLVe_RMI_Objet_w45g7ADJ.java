/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI.B21DCCN380;

import RMI.ObjectService;
import RMI.Ticket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author admin
 */
public class QLVe_RMI_Objet_w45g7ADJ {
    
    public static void main(String[] args) {
        
        try {
            
            Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
            ObjectService service = (ObjectService) rg.lookup("RMIObjectService");
            
            String studentCode = "B21DCCN380";
            String qCode = "w45g7ADJ";
            
            // a
            Ticket tk = (Ticket) service.requestObject(studentCode, qCode);
            System.out.println(tk);
            
            // b
            StringBuilder sb = new StringBuilder();
            // letters from eventName attr
            sb.append(Character.toUpperCase(tk.getEventName().charAt(0)));
            sb.append(Character.toUpperCase(tk.getEventName().charAt(tk.getTicketCode().length() - 1)));
            // day and month of saleDate
                        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
/*
[Mã câu hỏi (qCode): w45g7ADJ].  Một chương trình (tạm gọi là RMI Server) cung cấp giao diện cho phép triệu gọi từ xa để quản lý thông tin vé trong hệ thống bán vé sự kiện. Chương trình sẽ ngẫu nhiên tạo ra đối tượng Ticket với các giá trị ban đầu và cung cấp cho RMI client như sau:
    Giao diện từ xa:
public interface ObjectService extends Remote {
    public Serializable requestObject(String studentCode, String qCode) throws RemoteException;
    public void submitObject(String studentCode, String qCode, Serializable object) throws RemoteException;
}
Lớp Ticket gồm các thuộc tính: id String, eventName String, saleDate String, ticketCode String.
•	Trường dữ liệu: private static final long serialVersionUID = 20241133L;
•	02 hàm khởi dựng:
    	public Ticket()
    	public Ticket(String id, String eventName, String saleDate)
Trong đó:
•	Interface ObjectService và lớp Ticket được viết trong package RMI.
•	Đối tượng cài đặt giao diện từ xa ObjectService được đăng ký với RegistryServer: RMIObjectService.
Yêu cầu: Viết chương trình tại máy trạm (RMI client) để thực hiện các công việc sau với đối tượng vé được nhận từ RMI Server:
a. Triệu gọi phương thức requestObject để nhận đối tượng Ticket ngẫu nhiên từ server.
b. Tạo mã ticketCode cho vé dựa trên các quy tắc sau:
•	Bắt đầu với hai chữ cái là: Chữ cái đầu tiên và cuối cùng của eventName, viết hoa.
•	Thêm ngày và tháng từ saleDate (theo định dạng "MMdd")
•	Kết thúc bằng hai chữ số là: Chữ số lớn nhất và nhỏ nhất không xuất hiện trong saleDate.
    	Ví dụ: tên sự kiện là "Charity Concert", và ngày bán là "15/06/2024", mã ticketCode sẽ là "CT061593".
c. Cập nhật giá trị ticketCode trong đối tượng Ticket.
d. Triệu gọi phương thức submitObject để gửi đối tượng Ticket đã được xử lý trở lại server.
e. Kết thúc chương trình client.
*/