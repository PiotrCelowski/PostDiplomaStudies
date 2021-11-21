public class DegreeConverter {
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9/5. + 32);
    }

    public static void main(String[] args) {
        System.out.println(convertCelsiusToFahrenheit(-40));
    }
}
