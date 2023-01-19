import java.util.ArrayList;
import java.util.Random;
import processing.core.PApplet;

public class Grid {

    Cell[][] cells;
    int columns, rows;
    int pixelHeight, pixelWidth;
    int cellWidth, cellHeight;
    // ArrayList<Cluster> clusters;
    static Random rand = new Random();

    public Grid(PApplet sketch, int columns, int rows, int pixelWidth, int pixelHeight) {
        this.columns = columns;
        this.rows = rows;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;

        cells = new Cell[columns][rows];
        // clusters = new ArrayList<Cluster>();

        cellWidth = pixelWidth / columns;
        cellHeight = pixelHeight / rows;

        // special cluster
        Cluster special = new Cluster();
        special.size = 10000000; // fake it being bigger than any other cluster
        special.color = new Color(40, 80, 255); // blue
        // clusters.add(special);

        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {

                cells[x][y] = new Cell(sketch, x * cellWidth, y * cellHeight, cellWidth, cellHeight);

                // put the first column into the special cluster
                // if (x == 0) {
                // cells[x][y].isOpen = true;
                // cells[x][y].cluster = special;
                // }
            }
        }

    }

    public void step() {
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {

                cells[x][y].step();

                if (cells[x][y].isOpen) {
                    tryToMergeToNeighbors(x, y);
                }
            }
        }
    }

    public void tryToMergeToNeighbors(int x, int y) {
        tryToMergeWith(x, y, x + 1, y);
        tryToMergeWith(x, y, x - 1, y);
        tryToMergeWith(x, y, x, y + 1);
        tryToMergeWith(x, y, x, y - 1);
    }

    public void tryToMergeWith(int x, int y, int x2, int y2) {
        // slow down merging
        // if (rand.nextInt(2) > 0)
        // return;

        boolean sourceWon;
        Cluster winner, loser;

        if (x2 >= 0 && x2 < columns && y2 >= 0 && y2 < rows) {
            if (cells[x2][y2].isOpen) {
                // so cells x,y and x2,y2 are both open

                if (cells[x][y].cluster == cells[x2][y2].cluster)
                    return; // same, do nothing

                if (cells[x][y].cluster.size > cells[x2][y2].cluster.size) {
                    winner = cells[x][y].cluster;
                    loser = cells[x2][y2].cluster;
                    sourceWon = true;
                } else if (cells[x][y].cluster.size < cells[x2][y2].cluster.size) {
                    loser = cells[x][y].cluster;
                    winner = cells[x2][y2].cluster;
                    sourceWon = false;
                } else {
                    // random winner
                    if (rand.nextBoolean()) {
                        winner = cells[x][y].cluster;
                        loser = cells[x2][y2].cluster;
                        sourceWon = true;
                    } else {
                        loser = cells[x][y].cluster;
                        winner = cells[x2][y2].cluster;
                        sourceWon = false;
                    }
                }

                loser.size--;
                winner.size++;
                cells[x][y].cluster = winner;
                cells[x2][y2].cluster = winner;

                if (!sourceWon) {
                    tryToMergeToNeighbors(x, y);
                } else {
                    tryToMergeToNeighbors(x2, y2);
                }
            }
        }
    }

    public void render() {

        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {

                cells[x][y].render();
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY) {

        int x = mouseX / cellWidth;
        int y = mouseY / cellHeight;

        if (x < columns && y < rows)
            cells[x][y].mouseClicked();
        else
            System.out.println("Click not in valid grid cell");
    }
}
