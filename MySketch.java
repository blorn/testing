import java.util.ArrayList;

import processing.core.PApplet;

public class MySketch extends PApplet {

    private ArrayList<Ball> balls = new ArrayList<>();
    public static long counter = 0;

    private Grid grid;
    int gridWidth = 1500; // pixels
    int gridHeight = 1000;

    public void settings() {
        size(gridWidth, gridHeight);
        // balls.add(new Ball(this, width / 2, height / 2));

        grid = new Grid(this, 150, 100, gridWidth, gridHeight);

    }

    public void draw() {
        background(0);
        noStroke();

        grid.step();
        grid.render();

        for (Ball b : balls) {
            b.step();
            b.render();
        }

        // fill(100);
        // text(frameCount, 10, gridHeight + 20);
    }

    public void mouseClicked() {
        if (mouseX < gridWidth && mouseY < gridHeight) {
            grid.mouseClicked(mouseX, mouseY);
        }
    }
    // public void mouseDragged() {
    // //balls.add(new Ball(this, mouseX, mouseY));
    // }

}