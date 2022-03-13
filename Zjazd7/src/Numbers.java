import java.util.Arrays;
import java.util.List;

public class Numbers {
    List<String> strings = Arrays.asList("a1", "a2", "b3", "b4", "c5", "c6");

    public void printOutNumbersFromList() {
        strings.stream()
                .map(string -> string.substring(1))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.printOutNumbersFromList();
    }
}
