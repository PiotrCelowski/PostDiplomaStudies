import java.util.Arrays;
import java.util.Scanner;

public class MyArray {
    private Scanner scanner;
    private int[] generatedArray;

    public MyArray() {
        this.scanner = new Scanner(System.in);
    }

    public void createArrayOfLength() {
        System.out.println("Podaj długość tablicy: ");
        generatedArray = new int[scanner.nextInt()];
        System.out.println("Stworzono tablice.");
    }

    public void askForNumbers() {
        System.out.println("Teraz podaj liczby: ");
        for(int i=0; i<generatedArray.length; i++) {
            generatedArray[i] = scanner.nextInt();
            System.out.println("Dodano liczbę.");
        }
    }

    public void printSortedArray() {
        System.out.println("Wygenerowana i posortowana tablica: ");
        Arrays.stream(generatedArray).sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();

        myArray.createArrayOfLength();
        myArray.askForNumbers();
        myArray.printSortedArray();
    }
}
