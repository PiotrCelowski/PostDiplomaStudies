public class Polynomial {
    private int[] coefficients;
    private double[] numbers;

    public Polynomial(int ... coefficients) {
        this.coefficients = coefficients;
        numbers = new double[coefficients.length];
    }

    public double of(int x) {
        generateXes(x);
        return calculatePoly();
    }

    private double calculatePoly() {
        double result = 0;
        for(int i=0; i<numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }

    private void generateXes(int x) {
        for(int i=0; i<coefficients.length; i++) {
            numbers[i] = Math.pow(x, i);
        }
    }

    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(1,1);
        Polynomial p2 = new Polynomial(1,1,1);
        System.out.println(p1.of(3));
        System.out.println(p2.of(3));
    }
}
