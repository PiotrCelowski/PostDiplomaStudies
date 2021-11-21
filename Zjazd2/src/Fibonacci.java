import java.util.Scanner;

public class Fibonacci {
    public static int calculateFibonacci(int number) {
        if(number == 1) {
            return 1;
        }
        if(number == 0) {
            return 0;
        }

        return calculateFibonacci(number-1) + calculateFibonacci(number-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe: ");
        int givenNumber = scanner.nextInt();
        int f = calculateFibonacci(givenNumber);
        System.out.format("%s element ciągu fibonnaciego to: %s",givenNumber,f);
    }
}
