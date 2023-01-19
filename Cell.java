import java.util.Random;
import processing.core.PApplet;

public class Cell {
    int x, y;
    int width, height;
    PApplet sketch;
    boolean isOpen = false;
    Cluster cluster; // the cluster this Cell belongs to currently, if any
    int ticksUntilOpen;
    static Random rand = new Random();
    static final int MAX_TICKS = 1000;
    static final boolean SHOW_DEBUG_TEXT = false;

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
        ticksUntilOpen = (int) (rand.nextFloat() * MAX_TICKS);
    }

    public void step() {

        if (!isOpen) {
            if (sketch.frameCount > ticksUntilOpen) {
                openCell();
            }
        }
    }

    public void render() {
        if (isOpen) {
            Color c = cluster.getColor();
            sketch.fill(c.r, c.g, c.b); // if open, color it with its cluster's color
        } else
            sketch.fill(0, 0, 0);

        sketch.rect(x, y, width, height);

        if (SHOW_DEBUG_TEXT) {
            sketch.fill(0, 0, 0);
            if (cluster != null) {
                sketch.text(cluster.getSizeString(), x + 2, y + 10);
                // sketch.text(cluster.getColor().toString(), x + 10, y + 20);
            } else {
                sketch.fill(255);
                sketch.text(ticksUntilOpen, x + 10, y + 10);
            }
        }
    }

    public void mouseClicked() {
        openCell();
    }

    private void openCell() {
        if (isOpen)
            return; // can't open twice, do nothing

        isOpen = true;

        // make a new cluster
        Cluster c = new Cluster();
        this.cluster = c;
    }

}
