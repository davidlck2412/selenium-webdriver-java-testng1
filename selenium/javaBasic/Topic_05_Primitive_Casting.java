package javaBasic;

public class Topic_05_Primitive_Casting {

    public static void main(String[] args) {
 /*       // Ngầm Định = Không mất dữ liệu
         byte bNumber = 126;
         short sNumber = bNumber;
         System.out.println(bNumber);

         int iNumber = sNumber;
        System.out.println(iNumber);

         long lNumber = iNumber;
        System.out.println(lNumber);

         float fNumber = lNumber;
        System.out.println(fNumber);

         double dNumber = fNumber;
        System.out.println(dNumber);
        */
        // Tường Minh (Cast)
        double dNumber = 1234567891;
        System.out.println(dNumber);

        float fNumber = (float) dNumber;
        System.out.println(fNumber);

        long lNumber = (long) fNumber;
        System.out.println(lNumber);

        int iNumber = (int) lNumber;
        System.out.println(iNumber);

    }
}
