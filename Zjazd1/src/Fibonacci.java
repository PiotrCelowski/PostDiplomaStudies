import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Podaj liczbę: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int fibonacciResult = calculateFibonacci(number);

        System.out.format("%s element ciągu Fibonacciego to %s", number, fibonacciResult);
    }

    private static int calculateFibonacci(int number) {
        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
    }
}

