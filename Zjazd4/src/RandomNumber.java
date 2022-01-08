import java.util.Scanner;

public class RandomNumber {
    private int generatedNumber;

    public int getAttempts() {
        return attempts;
    }

    private int attempts = 10;

    public int getRandomNumber(int min, int max) {
        generatedNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return  generatedNumber;
    }

    public boolean checkNumber(int guessedNumber) {
        if (guessedNumber == generatedNumber) {
            System.out.println("Yes!");
            return true;
        }

        if (guessedNumber > generatedNumber && attempts > 0) {
            System.out.println("Less...");
        } else if (guessedNumber < generatedNumber && attempts > 0) {
            System.out.println("More...");
        }

        if (attempts <= 0) {
            System.out.println("You have taken too many attempts...");
            return true;
        }
        attempts--;
        System.out.println("Attempts left: " + attempts);
        return false;
    }

    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.getRandomNumber(1, 500);

        Scanner skanner = new Scanner(System.in);

        System.out.println("Number was generated, now guess!");

        while(true) {
            int guessedNumber = skanner.nextInt();
            if(randomNumber.checkNumber(guessedNumber)) {
                break;
            }
        }
    }
}
