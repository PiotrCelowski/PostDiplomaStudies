public class Point {
    private double x;
    private double y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "[" + x + ", " + y + ']';
    }

    public double calculateDistanceTo(Point secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getX() - this.getX(), 2) + Math.pow(secondPoint.getY() - this.getY(), 2));
    }

    public static double calculateDistanceBetween(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getX() - firstPoint.getX(), 2) + Math.pow(secondPoint.getY() - firstPoint.getY(), 2));
    }

}
