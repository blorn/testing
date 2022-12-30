
import java.util.ArrayList;
import javax.swing.JFrame;

class Quickstart {

    static ArrayList<Quadrangle> quads;

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        JFrame f = new JFrame(); // this is the window for graphics

        DisplayGraphics m = new DisplayGraphics();
        f.add(m);
        f.setSize(400, 400);
        // f.setLayout(null);
        f.setVisible(true);

    }

    public static void playWithQuads() {

        quads = new ArrayList<Quadrangle>(10);
        // quads.add(new Rect());

        for (Quadrangle q : quads) {
            System.out.printf("Shape %s has area=%d\n", q.name, q.getArea());
        }
    }
}
