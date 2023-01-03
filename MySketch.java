import java.util.ArrayList;

import processing.core.PApplet;

public class MySketch extends PApplet {

    private ArrayList<Ball> balls = new ArrayList<>();
    public static long counter = 0;

    private Grid grid;
    int gridWidth = 800;
    int gridHeight = 800;

    public void settings() {
        size(800, 900);
        // balls.add(new Ball(this, width / 2, height / 2));

        grid = new Grid(this, 150, 150, gridWidth, gridHeight);
    }

    public void draw() {
        background(0);

        grid.step();
        grid.render();

        for (Ball b : balls) {
            b.step();
            b.render();
        }

        fill(100);
        text(frameCount, 10, gridHeight + 20);
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