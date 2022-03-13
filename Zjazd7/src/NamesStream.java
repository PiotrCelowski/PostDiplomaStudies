import java.util.function.Predicate;
import java.util.stream.Stream;

public class NamesStream {
    Stream<String> namesStream = Stream.of("John", "Marry", "George", "Paul", "Alice", "Ann");

    public void printOutNamesAlphabetically() {
        namesStream.sorted().filter(startingForLetterA()).forEach(System.out::println);
    }

    private Predicate<String> startingForLetterA() {
        return n -> n.startsWith("A");
    }

    public static void main(String[] args) {
        NamesStream namesStream = new NamesStream();
        namesStream.printOutNamesAlphabetically();
    }
}
