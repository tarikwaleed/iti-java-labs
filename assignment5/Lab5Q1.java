import java.util.List;
import java.util.ArrayList;
abstract class Shape {
    public abstract void draw();
}
class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println("Drawing a rectangle with width " + width + " and height " + height);
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}
class Test {
    public void drawShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Rectangle(4, 5));
        shapes.add(new Circle(3));

        Test test = new Test();
        test.drawShapes(shapes);
    }
}

