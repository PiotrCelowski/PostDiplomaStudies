import java.util.Arrays;
import java.util.List;

public class LoopModification {
    List<Integer> list = Arrays.asList(11, -2, 42, -7, 56);

    public void oldWay() {
        int x, sum = 0;
        for(Integer n : list) {
            x = 2 * n * n - 5 * n + 6;
            sum = sum + x;
        }
        System.out.println(sum);
    }

    public Integer newWay() {
        return list.stream()
                .map(n -> (2 * n * n - 5 * n + 6))
                .reduce(0, Integer::sum);
    }

    private int calculateX(int n) {
        return  (2 * n * n - 5 * n + 6);
    }

    public static void main(String[] args) {
        LoopModification loopModification = new LoopModification();
        loopModification.oldWay();
        System.out.println("-----------------");
        System.out.println(loopModification.newWay());
    }
}
