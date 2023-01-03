import java.util.Random;

import processing.core.PApplet;

public class Cluster {

    int rgb;
    int size;
    static Random rand = new Random();

    public Cluster() {
        int r = rand.nextInt() * 255;
        int g = rand.nextInt() * 255;
        int b = rand.nextInt() * 255;

        rgb = r << 16 + g << 8 + b;
        size = 1;
    }

    public int getColor() {
        return rgb;
    }

    
}
