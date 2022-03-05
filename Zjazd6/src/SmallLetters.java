import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
