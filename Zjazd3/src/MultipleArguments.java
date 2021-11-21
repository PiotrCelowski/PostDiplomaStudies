public class MultipleArguments {
    public static void findMaxNumberFromMultipleNumbers(int ... number) {
        int maxValue = number[0];

        for(int index=0; index < number.length; index++ ) {
            if(maxValue < number[index]) {
                maxValue = number[index];
            }
        }

        System.out.println("Max value is: " + maxValue);
    }

    public static void main(String[] args) {
        findMaxNumberFromMultipleNumbers(1,-10,3,4,5,6);
    }
}
