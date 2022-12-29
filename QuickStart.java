
import java.util.ArrayList;

class Quickstart {

    static Library library;

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        whatsIt(347);
    }

    public static void whatsIt(int n) {
        if (n > 10)
            whatsIt(n / 10);

        System.out.print(n % 10);
    }

}
