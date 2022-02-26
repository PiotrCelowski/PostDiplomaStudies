import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class LambdaList {
    public static void oldWay(List<Integer> list) {
        for(Integer n: list) {
            System.out.println(n);
        }
    }

    public static void newWay(List<Integer> list) {
        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(46, 83, -36, 64, 2, -67);
        oldWay(list);
        System.out.println("-------------");
        newWay(list);
    }
}
