import java.util.Random;

public class Color {
    int r, g, b;
    static Random rand = new Random();

    Color() {
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public String toString() {
        return "( " + r + ", " + g + ", " + b + " )";
    }

    static Color getRandomColor() {
        return new Color(getRandComponent(), getRandComponent(), getRandComponent());
    }

    static int getRandComponent() {
        return (int) (rand.nextFloat() * 255);
    }
}