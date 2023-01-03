import java.util.Random;
import processing.core.PApplet;

public class Cell {
    int x, y;
    int width, height;
    PApplet sketch;
    boolean isOpen = false;
    boolean isWet = false;
    float secretValue;
    static Random rand = new Random();

    /**
     * @param x      x Position of upper left corner
     * @param y      y Position of upper left corner
     * @param width
     * @param height
     */
    Cell(PApplet sketch, int x, int y, int width, int height) {
        this.sketch = sketch;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        secretValue = rand.nextFloat();
    }

    public void step() {

        if (!isOpen) {
            if ((sketch.frameCount % 1000) / 1000.0 >= secretValue) {
                isOpen = true;

                // make a new cluster
                Cluster c = new Cluster();
            }
        }
    }

    public void render() {
        if (isWet)
            sketch.fill(0, 0, 135);
        else if (isOpen)
            sketch.fill(0, 135, 0);
        else
            sketch.fill(135, 0, 0);
        sketch.rect(x, y, width, height);

        // if (false) {
        // sketch.fill(0, 0, 0);
        // sketch.text(secretValue, x + 10, y + 10);
        // }
    }

    public void mouseClicked() {

        isOpen = true;
        // todo consider a toggle
    }

}
