import java.util.ArrayList;
import java.util.Scanner;

public class Binary {
    public static int convertBinaryToDecimal(String binaryNumber) {
        return Integer.parseInt(binaryNumber, 2);
    }

    public static String addTwoBinaryNumbers(String first, String second) {
        String result = "";

        int carry = 0;

        int i = first.length() - 1;
        int j = second.length() - 1;

        while (i >= 0 || j >= 0) {
            int firstElement = i >= 0 ? Integer.parseInt(String.valueOf(first.charAt(i))) : 0;
            int secondElement = j >= 0 ? Integer.parseInt(String.valueOf(second.charAt(j))) : 0;

            int sumElements = firstElement + secondElement + carry;
            carry = 0;

            if (sumElements == 0) {
                result = '0' + result;
            } else if (sumElements == 1) {
                result = '1' + result;
            } else if (sumElements % 2 == 0) {
                result = '0' + result;
                carry = 1;
            } else {
                result = '1' + result;
                carry = 1;
            }

            i--;
            j--;
        }

        if (carry == 1) {
            result = '1' + result;
        }

        return result;
    }

    public static String addManyBinaryNumbers(ArrayList<String> numbers) {
        String result = "";

        int carry = 0;

        //get all provided binary number sizes
        int[] sizes = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            sizes[i] = numbers.get(i).length() - 1;
        }

        //why any of the binary number length is still bigger or equal to zero
        while (areAllArraysSizesBiggerThanZero(sizes)) {

            //get all elements with the specific column
            int[] elementsInNumber = new int[numbers.size()];
            for (int numberIndex = 0; numberIndex < numbers.size(); numberIndex++) {
                elementsInNumber[numberIndex] = sizes[numberIndex] >= 0 ? Integer.parseInt(String.valueOf(numbers.get(numberIndex).charAt(sizes[numberIndex]))) : 0;
            }

            //sum all elements in a given column
            int sumElements = 0;
            for (int numberIndex = 0; numberIndex < numbers.size(); numberIndex++) {
                sumElements += elementsInNumber[numberIndex];
            }

            //add the rest if exists
            sumElements += carry;

            //add proper number to result
            if (sumElements % 2 == 0) {
                result = (sumElements % 2) + result;
            } else if (sumElements % 2 != 0) {
                result = (sumElements % 2) + result;
            }

            carry = sumElements / 2;

            for (int i = 0; i < numbers.size(); i++) {
                sizes[i] = sizes[i] - 1;
            }
        }

        if (carry != 0) {
            while (carry > 0) {
                result = '1' + result;
                carry = carry / 2;
            }
        }

        return result;
    }

    private static boolean areAllArraysSizesBiggerThanZero(int[] sizes) {
        for (int i = 0; i <= sizes.length - 1; i++) {
            if (sizes[i] >= 0) {
                return true;
            }
        }
        return false;
    }

    public static String multiplyBinaryNumbers(String first, String second) {
        ArrayList<String> results = new ArrayList<>();


        for (int i = first.length() - 1; i >= 0; i--) {
            String result = "";

            for (int stringLength = first.length() - 1; stringLength > i; stringLength--) {
                result += '0';
            }

            for (int j = second.length() - 1; j >= 0; j--) {
                int firstElement = Integer.parseInt(String.valueOf(first.charAt(i)));
                int secondElement = Integer.parseInt(String.valueOf(second.charAt(j)));

                int productElement = firstElement * secondElement;

                result = productElement + result;
            }
            results.add(result);
        }
        return addManyBinaryNumbers(results);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write first binary number: ");
        String first = scanner.next();
        System.out.println("Write second binary number: ");
        String second = scanner.next();
        System.out.println("Do you want to do multiplication or addition? M/A");
        String action = scanner.next();
        if(action.equals("A")) {
            System.out.println(addTwoBinaryNumbers(first, second));
        } else if (action.equals("M")) {
            System.out.println(multiplyBinaryNumbers(first, second));
        } else {
            System.out.println("Wrong input!");
        }
    }
}
