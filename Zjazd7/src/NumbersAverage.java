import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class NumbersAverage {
    List<String> strings = Arrays.asList("a1", "a2", "b3", "b4", "c5", "c6");

    public void printAverage() {
        System.out.println(strings.stream()
                .collect(Collectors.averagingInt(getSuffixNumber)));
    }

    ToIntFunction<String> getSuffixNumber = string -> Integer.valueOf(string.substring(1));

    public static void main(String[] args) {
        NumbersAverage numbersAverage = new NumbersAverage();
        numbersAverage.printAverage();
    }
}
