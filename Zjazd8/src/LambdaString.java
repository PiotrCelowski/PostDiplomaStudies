import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaString {
    private static final List<String> LIST = Arrays.asList("aab", "aab", "aac", "aac", "bbb", "ccc", "ddd", "dda");

    public static void main(String[] args) {
        String output = LIST.stream()
                .filter(str -> !hasSameLetters(str))
                .map(str -> str.substring(0,1).toUpperCase() + str.substring(1) + "#")
                .collect(Collectors.joining());

        System.out.println(output.substring(0, output.length()-1));
    }

    private static boolean hasSameLetters(String str) {
        int n = str.length();
        for (int i = 1; i < n; i++)
            if (str.charAt(i) != str.charAt(0))
                return false;

        return true;
    }
}
