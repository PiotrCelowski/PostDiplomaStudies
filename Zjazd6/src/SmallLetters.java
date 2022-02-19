import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallLetters {

    List<String> strings = Arrays.asList("Pawel", "Krzysztof", "Bartosz");

    public void find() {
        System.out.println(strings.stream()
                .max(Comparator.comparingInt(word -> (int) word.chars()
                        .filter(Character::isLowerCase)
                        .count()))
                .get());
    }

    public static void main(String[] args) {
        SmallLetters smallLetters = new SmallLetters();
        smallLetters.find();
    }
}
