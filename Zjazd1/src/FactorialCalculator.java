import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //collect number
        System.out.println("Podaj liczbę: ");
        int number = scanner.nextInt();

        //calculate factorial
        int factorial = 0;
        try {
            factorial = calculateFactorial(number);
        } catch (Exception ex) {
            System.out.println("Błąd: " + ex);
        }

        //return factorial if it was calculated, otherwise message that calculation failed
        if (factorial > 0 || (factorial == 0 && number == 0)) {
            System.out.format("Silnia %s to %s", number, factorial);
        } else {
            System.out.println("Coś poszło nie tak. Spróbuj mniejszą liczbę.");
        }

    }

    private static int calculateFactorial(int number) throws Exception {
        int factorial;

        if(number == 0) {
            return 1;
        }

        factorial = number * calculateFactorial(number-1);

        //check if factorial is withing int range
        if(!checkIfCanContinue(number, factorial)) {
            throw new Exception("Silnia przekracza maksymalny zakres dla typu integer.");
        }

        return factorial;
    }

    private static boolean checkIfCanContinue(int number, int currentFactorial) {
        int maxPossibleMultiplier = Integer.MAX_VALUE/currentFactorial;

        if(maxPossibleMultiplier < number) {
            return false;
        }

        return true;
    }
}
