import java.util.function.Function;
import java.util.stream.IntStream;

public class Power {
    Function<Integer, Double> twoToPowerOf = n -> Math.pow(2, n);

    public void generate() {
        IntStream.range(0,20).mapToObj(num -> twoToPowerOf.apply(num)).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Power power = new Power();
        power.generate();
    }
}
