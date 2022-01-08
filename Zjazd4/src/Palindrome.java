import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        char[] wordArray = word.toLowerCase().toCharArray();
        String reversedWord = "";

        //reverse word
        for(int i=wordArray.length-1; i>=0; i--) {
            reversedWord += wordArray[i];
        }

        char[] reversedWordArray = reversedWord.toCharArray();

        //compare each character
        for(int i=0; i<wordArray.length; i++) {
            if(wordArray[i] != reversedWordArray[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type some word:");
        String potentialPalindrome = scanner.nextLine();

        if (isPalindrome(potentialPalindrome)) {
            System.out.println("Given word is a palindrome");
        } else {
            System.out.println("Given word is not a palindrome");
        }
    }
}
