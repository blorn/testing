
import java.util.ArrayList;

class Quickstart {

    static ArrayList<Quadrangle> quads;

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        quads = new ArrayList<Quadrangle>(10);
        quads.add(new Rect());

        for (Quadrangle q : quads) {
            System.out.printf("Shape %s has area=%d\n", q.name, q.getArea());
        }
    }

}
