class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void area() {
        System.out.println("Area is: " + Math.PI * radius * radius);
    }
}

class Main2 {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.area();
    }
}
