public class BitwiseOperator {
    public static void main(String[] args) {
        // to double any number just left shift by 1
        int a = 10;
        int b = 12;

        // left shift operator
        System.out.println("Left Shift : ");
        System.out.println(a << 1);
        System.out.println(b << 1);

        a = 2;
        b = 3;

        System.out.println(a << b); // a * 2^b

        // right shift operator
        a = 10;
        b = 12;

        System.out.println("Right Shift operator : ");

        // just to half of any number the use right shift
        System.out.println(a >> 1);
        System.out.println(b >> 1);

        a = 16; 
        b = 3;

        System.out.println(a >> b); // a / 2^b



    }
}
