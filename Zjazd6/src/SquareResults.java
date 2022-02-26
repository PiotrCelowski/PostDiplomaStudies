import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareResults {
    public void calculateImperativeWay(List<Integer> list) {
        int sumOfSquares = 0;
        int counter = 0;
        for(Integer el : list) {
            if(counter > 4) {
                break;
            }
            if(isNumberEven(el) && isNumberHigherThan10(el)) {
                printToScreen(el);
                sumOfSquares+=exp2(el);
                counter++;
            }
        }
        printToScreen(sumOfSquares);
    }

    private boolean isNumberHigherThan10(Integer el) {
        if(el > 10) {
            return true;
        }
        return false;
    }

    private boolean isNumberEven(Integer el) {
        if(el%2==0) {
            return true;
        }
        return false;
    }

    private int exp2(Integer el) {
        return (int) Math.pow(el, 2);
    }

    public void printToScreen(Integer el) {
        System.out.println(el);
    }

    public void calculateFunctionalWay(List<Integer> list) {
        Integer integer = list.stream()
                .filter(el -> isNumberEven(el) && isNumberHigherThan10(el))
                .limit(5)
                .peek(this::printToScreen)
                .map(this::exp2)
                .reduce(0, Integer::sum);

        System.out.println(integer);
    }

    private Predicate<Integer> isEvenPredicate = el -> el%2==0;
    private Predicate<Integer> isNumberHigherThan10Predicate = el -> el>10;
    private UnaryOperator<Integer> exp2UnaryOperator = this::exp2;
    private Consumer<Integer> printToScreenConsumer = this::printToScreen;

    public void calculateFunctionalWayWithPredicates(List<Integer> list) {
        Integer integer = list.stream()
                .filter(isEvenPredicate)
                .filter(isNumberHigherThan10Predicate)
                .peek(printToScreenConsumer)
                .limit(5)
                .map(exp2UnaryOperator)
                .reduce(0, Integer::sum);

        System.out.println(integer);
    }

    Function<Integer, Predicate<Integer>> limitWithPredicate = (limit -> new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer>limit;
        }
    });

    Function<Integer, Predicate<Integer>> evenWithPredicate = (number -> new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer%number==0;
        }
    });

    public void calculateFunctionalWayWithFunctions(List<Integer> list) {
        Integer integer = list.stream()
                .filter(el -> evenWithPredicate.apply(el))
                .filter(limitWithPredicate)
                .peek(printToScreenConsumer)
                .limit(5)
                .map(exp2UnaryOperator)
                .reduce(0, Integer::sum);

        System.out.println(integer);
    }

    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(0, 20).boxed().collect(Collectors.toList());
        SquareResults squareResults = new SquareResults();

        squareResults.calculateImperativeWay(integers);
        System.out.println("------------------------------------");
        squareResults.calculateFunctionalWay(integers);
        System.out.println("------------------------------------");
        squareResults.calculateFunctionalWayWithPredicates(integers);
        System.out.println("------------------------------------");

    }

}
