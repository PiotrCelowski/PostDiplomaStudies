public class Demo {
    public static void main(String[] args) {
        Point first = new Point();
        Point second = new Point(3,3);

        System.out.println(first.calculateDistanceTo(second));

        System.out.println(Point.calculateDistanceBetween(first, second));

        System.out.println(first.toString());

        System.out.println(second.toString());
    }
}
