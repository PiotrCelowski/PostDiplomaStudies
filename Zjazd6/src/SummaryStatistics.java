import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SummaryStatistics {
    List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

    public void generate() {
        System.out.println(primes.stream()
                .collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine).getAverage());

        System.out.println(primes.stream()
                .collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine).getMin());

        System.out.println(primes.stream()
                .collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine).getMax());

        System.out.println(primes.stream()
                .collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine).getSum());
    }

    public static void main(String[] args) {
        SummaryStatistics summaryStatistics = new SummaryStatistics();
        summaryStatistics.generate();
    }

}
