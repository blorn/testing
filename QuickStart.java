import processing.core.PApplet;

class Quickstart {

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        String[] processingArgs = { "MySketch" };
        MySketch mySketch = new MySketch();
        PApplet.runSketch(processingArgs, mySketch);

    }

}
