public class PointExtended {
    private double[] coordinates;

    public PointExtended() {
        this.coordinates = new double[]{0, 0};
    }

    public PointExtended(double... coordinates) {
        this.coordinates = coordinates;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public static double calculateDistanceBetween(PointExtended firstPoint, PointExtended secondPoint) {
        double sumOfSquares = 0;
        if (checkDimensions(firstPoint, secondPoint)) {
            for (int index = 0; index < firstPoint.coordinates.length; index++) {
                sumOfSquares += Math.pow(secondPoint.coordinates[index] - firstPoint.coordinates[index], 2);
            }
        } else {
            throw new RuntimeException("Given points are in different coordinate systems.");
        }
        return Math.sqrt(sumOfSquares);
    }

    public double calculateDistanceTo(PointExtended secondPoint) {
        double sumOfSquares = 0;
        if (checkDimensions(this, secondPoint)) {
            for (int index = 0; index < this.coordinates.length; index++) {
                sumOfSquares += Math.pow(secondPoint.coordinates[index] - this.coordinates[index], 2);
            }
        } else {
            throw new RuntimeException("Given points are in different coordinate systems.");
        }
        return Math.sqrt(sumOfSquares);
    }

    private static boolean checkDimensions(PointExtended pointExtended, PointExtended secondPoint) {
        return pointExtended.coordinates.length == secondPoint.coordinates.length;
    }

    @Override
    public String toString() {
        String coordinates = "[";

        for (int index = 0; index < this.coordinates.length; index++) {
            coordinates += this.coordinates[index] + ", ";
        }
        coordinates = coordinates.substring(0, coordinates.length() - 2);
        coordinates += ("]");
        return coordinates;
    }

    public static void main(String[] args) {
        PointExtended firstPoint = new PointExtended(1,1,1,7,8);
        PointExtended secondPoint = new PointExtended(1,1,5,6,8);

        System.out.println(calculateDistanceBetween(firstPoint, secondPoint));
        System.out.println(firstPoint.calculateDistanceTo(secondPoint));
        System.out.println(firstPoint.toString());
    }

}
