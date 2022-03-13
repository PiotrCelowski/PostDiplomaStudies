import java.util.Arrays;
import java.util.stream.Stream;

public class DataStreams {
    public static String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

    public static void main(String[] args) {
        Arrays.stream(DataStreams.data)
                .flatMap(Stream::of)
                .filter(element -> element.equals("a"))
                .forEach(System.out::println);
    }
}
