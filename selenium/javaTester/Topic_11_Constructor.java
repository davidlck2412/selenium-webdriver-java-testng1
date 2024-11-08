package javaTester;

public class Topic_11_Constructor {
    // Là 1 cái hàm cùng tên vs class
    // Không cớ giữ liệu trả về
    // Trong 1 class có thể có nhiều Constructor
    // 1 class nếu k define cái constructor cụ thể thì nó sẽ có 1 constructor rỗng (default)
    // Nếu mình define thì khi khởi tạo nó băắt buộc phải gọi tới constructor mà mình define

 public Topic_11_Constructor(String name){
     System.out.println(name);
 }

 public Topic_11_Constructor(int numberStudent){
        System.out.println(numberStudent);
    }

    public static void main(String[] args) {
     Topic_11_Constructor topic01 = new Topic_11_Constructor("Automation FC");
        Topic_11_Constructor topic02 = new Topic_11_Constructor(15);
    }
}
