import processing.core.PApplet;

public class Grid {

    Cell[][] cells;
    int columns, rows;
    int pixelHeight, pixelWidth;
    int cellWidth, cellHeight;

    public Grid(PApplet sketch, int columns, int rows, int pixelWidth, int pixelHeight) {
        this.columns = columns;
        this.rows = rows;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;

        cells = new Cell[columns][rows];

        cellWidth = pixelWidth / columns;
        cellHeight = pixelHeight / rows;

        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {

                cells[x][y] = new Cell(sketch, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                if (x == 0) {
                    cells[x][y].isOpen = true;
                    cells[x][y].isWet = true;
                }
            }
        }

    }

    public void step() {
        for (int x = 0; x < columns; x++) {
            for (int y = 0; y < rows; y++) {

                cells[x][y].step();

                if (cells[x][y].isWet) {
                    tryToFlowTo(x + 1, y);
                    tryToFlowTo(x - 1, y);
                    tryToFlowTo(x, y + 1);
                    tryToFlowTo(x, y - 1);
                }
            }
        }
    }

    public void tryToFlowTo(int x, int y) {
        if (x >= 0 && x < columns && y >= 0 && y < rows) {
            if (cells[x][y].isOpen)
                cells[x][y].isWet = true;
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
