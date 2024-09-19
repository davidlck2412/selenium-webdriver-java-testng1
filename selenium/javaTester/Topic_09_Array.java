package javaTester;

public class Topic_09_Array {

    int[] studentAge = {15, 10, 20, 22};;
    String[] studentame = {"Nguyễn Vănn An", "Lê Văn Hoà"};

    String[] studentAddress = new String[5];

    public static void main(String[] args){
        String[] studentAddress = new String[5];

        studentAddress[0] = "Ngọc Anh";
        studentAddress[1] = "Đào Lê";
        studentAddress[2] = "Thanh Xuân";
        studentAddress[3] = "Thanh Xuân";
        studentAddress[4] = "Thanh Xuân";

        System.out.println(studentAddress[0]);
        System.out.println(studentAddress[1]);

        for(int i = 0; i < studentAddress.length; i++){
            System.out.println(studentAddress[i]);
        }
    }
}
