package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_15_Generic {

    public static void main(String[] args){
        // List chỉ chưứa kiểu dữ liệu Sring
        List<String> students  = new ArrayList<String>();
        students.add("John");
        students.add("David");
        students.add("Jame");
        students.add("Petter");

        // non-Generic
        List address = new ArrayList<>();
        address.add("123 Main S."); // String
        address.add(15); // Integer
        address.add(true); // Boolean
        address.add(15.56); // Float
    }
}
