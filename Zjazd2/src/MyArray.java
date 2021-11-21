import java.util.Arrays;

public class MyArray {
    // print - funkcja wypisuje elemety tablicy;
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    //    min - funkcja znajduje najmniejszy element tablicy
    public static int getMinFromArray(int[] array) {
        return array[getMinIndexFromArray(array)];
    }

    //    max - funkcja znajduje największy element tablicy
    public static int getMaxFromArray(int[] array) {
        return array[getMaxIndexFromArray(array)];
    }

    //    minIndex - funkcja znajduje indeks (pozycję) na której w tablicy znajduje się najmniejszy element
    public static int getMinIndexFromArray(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Something went wrong...");
        }

        int indexOfMin = 0;

        for (int element = 0; element < array.length; element++) {
            if (array[element] < array[indexOfMin]) {
                indexOfMin = element;
            }
        }

        return indexOfMin;
    }

    //    maxIndex - funkcja znajduje indeks (pozycję) na której w tablicy znajduje sie największy element
    public static int getMaxIndexFromArray(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Something went wrong...");
        }

        int indexOfMax = 0;

        for (int element = 0; element < array.length; element++) {
            if (array[element] > array[indexOfMax]) {
                indexOfMax = element;
            }
        }

        return indexOfMax;
    }

    //    sum - funkcja zwraca sumię wszystkich elementów w tablicy
    public static int getSumOfElements(int[] array) {
        int sum = 0;

        for (int element = 0; element < array.length; element++) {
            sum += array[element];
        }

        return sum;
    }

    //    prod - funkcja zwraca iloczyn wszystich elementów w tabliczy
    public static int getProductOfElements(int[] array) {
        int product = 0;

        for (int element = 0; element < array.length; element++) {
            product *= array[element];
        }

        return product;
    }

    //    smooth - funkcja wygładza elementy w tablicy, tzn. sprawia, że nie odstają one znacząco od średniego zachowania,
    //    w ten sposób, że dla każdego elementu w tablicy zastępuje do średnią z niego oraz elementu go poprzedzającego i
    //    elementu po nim następującego, czyli wylicza (tab[i-1]+tab[i]+tab[i+1])/3.
    public static int[] smoothArray(int[] array) {
        int[] newArray = new int[array.length];

        for (int element = 0; element < array.length; element++) {
            int currentElement = array[element];
            int newCurrentElement = array[element];

            if (element > 0 && element < array.length - 1) {
                newCurrentElement = (array[element - 1] + array[element] + array[element + 1]) / 3;
            } else {
                newCurrentElement = currentElement;
            }

            newArray[element] = newCurrentElement;

        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] myArray = {1, 19, 2, 24, 2222, 56};

        printArray(myArray);
        System.out.println("Min: " + getMinFromArray(myArray));
        System.out.println("Max: " + getMaxFromArray(myArray));
        System.out.println("Max index: " + getMaxIndexFromArray(myArray));
        System.out.println("Min index: " + getMinIndexFromArray(myArray));
        System.out.println("Sum: " + getSumOfElements(myArray));
        System.out.println("Product: " + getProductOfElements(myArray));
        printArray(smoothArray(myArray));
    }
}
