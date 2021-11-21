public class ForLoop {
    public static void printOddNumbersFromRange(int lower, int higher) {
        for(int number=lower; number<higher; number++) {
            if(number%2 != 0) {
                System.out.println(number);
            }
        }
    }

    public static void printEvenNumbersFromRange(int lower, int higher) {
        for(int number=lower; number<higher; number++) {
            if(number%2 == 0) {
                System.out.println(number);
            }
        }
    }

    public static void printSquareOfNumbersFromRange(int lower, int higher) {
        for(int number=lower; number<higher; number++) {
            System.out.println((int) Math.pow(number,2));
        }
    }

    public static void main(String[] args) {
        printOddNumbersFromRange(10, 35);
        printEvenNumbersFromRange(10,35);
        printSquareOfNumbersFromRange(10,35);
    }
}
