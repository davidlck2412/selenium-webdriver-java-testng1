package javaTester;

public class Topic_08_Parameter {

    static  String fullNameGlobal = "Luong Cam Khang";

    public static void main(String[] args){
        // Tham số
        setFullName("Manual Testing");

        System.out.println(getFullName());
    }

    public static void setFullName(String fullName){ // Tham số
        fullNameGlobal = fullName;
    }

    public static String getFullName(){
        return fullNameGlobal;
    }
}
