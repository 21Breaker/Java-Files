+---------------------+
|   RegularPolygon    |
+---------------------+
| - n: int            |
| - side: double      |
| - x: double         |
| - y: double         |
+---------------------+
| + RegularPolygon()  |
| + RegularPolygon(n: int, side: double) |
| + RegularPolygon(n: int, side: double, x: double, y: double) |
| + getN(): int       |
| + setN(n: int): void|
| + getSide(): double |
| + setSide(side: double): void |
| + getX(): double    |
| + setX(x: double): void |
| + getY(): double    |
| + setY(y: double): void |
| + getPerimeter(): double |
| + getArea(): double |
+---------------------+
public class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    public RegularPolygon() {
    }

    public RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }

    public static void main(String[] args) {
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("Polygon 1: Perimeter = " + polygon1.getPerimeter() + ", Area = " + polygon1.getArea());
        System.out.println("Polygon 2: Perimeter = " + polygon2.getPerimeter() + ", Area = " + polygon2.getArea());
        System.out.println("Polygon 3: Perimeter = " + polygon3.getPerimeter() + ", Area = " + polygon3.getArea());
    }
}
