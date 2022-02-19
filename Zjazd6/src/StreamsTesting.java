import java.util.Arrays;
import java.util.List;

public class StreamsTesting {
    List<Integer> list = Arrays.asList(46, 83, -36, 64, 2, -67);

    public void oldWay() {
        for(Integer n : list) {
            System.out.println(n);
        }
    }

    public void streamsWay() {
        list.stream()
                .forEach(System.out::println);
    }

    public void labmdaWay() {
//        (list) -> (element -> System.out::println);
    }

    public static void main(String[] args) {
        StreamsTesting streamsTesting = new StreamsTesting();
        System.out.println("-----OLD WAY-------");
        streamsTesting.oldWay();
        System.out.println("-----NEW WAY-------");
        streamsTesting.streamsWay();
    }
}
