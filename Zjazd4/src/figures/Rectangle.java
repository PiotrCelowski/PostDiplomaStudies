package figures;

public class Rectangle {
    protected int x;
    protected int y;
    private int szer;
    private int dl;

    public Rectangle(int x, int y, int szer, int dl) {
        this.x = x;
        this.y = y;
        this.szer = szer;
        this.dl = dl;
    }

    public Rectangle(int x, int y, int dl) {
        this.x = x;
        this.y = y;
        this.szer = dl;
        this.dl = dl;
    }

    public int pole() {
        System.out.println("Pole: " + this.dl * this.szer);
        return this.dl * this.szer;
    }

    public int obwod() {
        System.out.println("Obwod: " + (2*this.dl + 2*this.szer));
        return (2*this.dl + 2*this.szer);
    }

    public int[][] wierzcholki() {
        int[][] wierzcholki = new int[4][2];
        wierzcholki[0][0] = this.x;
        wierzcholki[0][1] = this.y;
        wierzcholki[1][0] = this.x + dl;
        wierzcholki[1][1] = this.y;
        wierzcholki[2][0] = this.x + szer;
        wierzcholki[2][1] = this.y + dl ;
        wierzcholki[3][0] = this.x;
        wierzcholki[3][1] = this.y + szer;

        System.out.println("Wierzcholki: " + "{" + wierzcholki[0][0] + ", " + wierzcholki[0][1] + "}, "
                + "{" + wierzcholki[1][0] + ", " + wierzcholki[1][1] + "}, "
                + "{" + wierzcholki[2][0] + ", " + wierzcholki[2][1] + "}, "
                + "{" + wierzcholki[3][0] + ", " + wierzcholki[3][1] + "}");

        return wierzcholki;
    }

    public static void testRectangle() {
        Rectangle rectangle = new Rectangle(0,0, 1, 2);
        test(assertTwoValues(rectangle.obwod(), 6));
        test(assertTwoValues(rectangle.pole(), 2));
        test(assertTwoArrays(rectangle.wierzcholki(), new int[][] {{0,0},{2,0},{1,2},{0,1}}));
    }

    public static void testSquare() {
        Rectangle rectangle = new Square(0,0,2);
        test(assertTwoValues(rectangle.obwod(), 8));
        test(assertTwoValues(rectangle.pole(), 4));
        test(assertTwoArrays(rectangle.wierzcholki(), new int[][] {{0,0},{2,0},{2,2},{0,2}}));
    }

    private static void test(boolean value) {
        if(value) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    private static boolean assertTwoArrays(int[][] first, int[][] second) {
        for(int i=0; i<first.length; i++) {
            for(int j=0; j<first[i].length; j++) {
                if(assertTwoValues(first[i][j], second[i][j])) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean assertTwoValues(int first, int second) {
        if(first == second) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("------------TEST RECTANGLE---------------");
        testRectangle();
        System.out.println("-------------TEST SQUARE-----------------");
        testSquare();
        System.out.println("-----------------------------------------");
    }
}