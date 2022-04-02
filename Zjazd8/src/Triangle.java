
public class Triangle {
    public static boolean isTrianglePossible(int a, int b, int c) {
        if(a>=b && a>=c) {
            return b+c>a;
        } else if (b>=a && b>=c) {
            return a+c>b;
        } else {
            return a+b>c;
        }
    }

    public static void main(String[] args) {
        System.out.println(isTrianglePossible(3,5,8));
        System.out.println(isTrianglePossible(11,1,3));
        System.out.println(isTrianglePossible(4,9,6));
        System.out.println(isTrianglePossible(5,5,5));
    }
}
