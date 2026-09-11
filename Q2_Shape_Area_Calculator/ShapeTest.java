public class ShapeTest {

    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];

        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);

        for (Shape s : shapes) {
            s.displayArea();
        }
    }
}