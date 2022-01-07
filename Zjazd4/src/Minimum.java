public class Minimum {
    public static int calculateMin(int[] array, int n) {
        if(n == 1) {
            return array[0];
        }
        return Math.min(array[n-1], calculateMin(array, n-1));
    }

    public static void main(String[] args) {
        int[] newArray = {5,2,4,553};

        System.out.println(calculateMin(newArray, newArray.length));
    }
}
