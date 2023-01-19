import java.util.Random;

public class Cluster {

    Color color;
    int size;
    static Random rand = new Random();
    static String infinity = "∞";

    public Cluster() {
        color = Color.getRandomColor();
        size = 1;
    }

    public Color getColor() {
        return color;
    }

    public String getSizeString() {
        if (size > 100000) {
            return infinity;
        } else
            return String.valueOf(size);
    }

}
