package javaTester;

public class Topic_07_String {
    public static  void main(String [] args){
        String firstName = "David";
        String lastName = "Luong";

        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        fullName = firstName.concat(" ").concat(lastName);
        System.out.println(fullName);

        String hotelMsg = "Welcome " + fullName + "to InterContinental Hotel";
        System.out.println(hotelMsg);
    }
}
