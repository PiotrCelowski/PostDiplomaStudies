public class ArrayAnalyst {
    public int[][] createArrayOfRandomValues() {
        int[][] myArray = new int[4][4];

        for(int row = 0; row<4; row++) {
            for(int column=0; column<4; column++) {
                if (Math.random() < 0.5) {
                    myArray[row][column] = 1;
                } else {
                    myArray[row][column] = 0;
                }
            }
        }
        return myArray;
    }

    public void printArray(int[][] array) {
        int rowWithMostOnes = 0;
        int rowWithMostZeros = 0;
        int maxOnes = 0;
        int maxZeros = 0;

        System.out.println("Generated array: ");
        System.out.println();

        for(int row=0; row<array[0].length; row++){
            int countOnes = 0;
            int countZeros = 0;

            System.out.print("[");

            for(int column=0; column<array[1].length; column++){
                if(array[row][column] == 1) {
                    countOnes++;
                } else {
                    countZeros++;
                }


                if(column == array[1].length-1) {
                    System.out.print(array[row][column]);
                } else {
                    System.out.print(array[row][column] + ", ");
                }
            }

            System.out.print("]");
            System.out.println();

            if(checkIfRowHasMostOnes(maxOnes, countOnes)) {
                rowWithMostOnes = row;
                maxOnes = countOnes;
            }
            if(checkIfRowHasMostZeros(maxZeros, countZeros)) {
                rowWithMostZeros = row;
                maxZeros = countZeros;
            }
        }

        System.out.println("\nThe biggest amount of ones is in a: " + (rowWithMostOnes + 1) + " row of a given array." );
        System.out.println("The biggest amount of zeros is in a: " + (rowWithMostZeros + 1) + " row of a given array." );
    }

    private boolean checkIfRowHasMostZeros(int currentMaxZeros, int countedZeros) {
        if(currentMaxZeros<countedZeros) {
            return true;
        }
        return false;
    }

    private boolean checkIfRowHasMostOnes(int currentMaxOnes, int countedOnes) {
        if(currentMaxOnes<countedOnes) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayAnalyst arrayAnalyst = new ArrayAnalyst();
        int[][] array = arrayAnalyst.createArrayOfRandomValues();

        arrayAnalyst.printArray(array);

    }
}
