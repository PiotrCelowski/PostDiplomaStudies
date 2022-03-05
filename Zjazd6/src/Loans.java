import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Loans {
    /*
     * This exercise is not finished, there are no inputs provided by university
     */
    public List<Loan> loans = new ArrayList<>();

    private class Loan {
        Integer number;
        int amount;
        String type;

        public Loan(int number, int amount, String type) {
            this.number = number;
            this.amount = amount;
            this.type = type;
        }
    }

    public void generateLoans() {
        Loan kredytHipoteczny = new Loan(123, 5000000, "hipoteczny");
        Loan kredytGotowkowy = new Loan(456, 1000, "gotowkowy");
        Loan kredytInwestycyjny = new Loan(789, 100000000, "inwestycyjny");

        loans.add(kredytGotowkowy);
        loans.add(kredytHipoteczny);
        loans.add(kredytInwestycyjny);
    }

    public void countLoans() {
        System.out.println(loans.stream().count());
    }

    public void printLoanNumbers() {
        loans.stream()
                .flatMap(loan -> Stream.of(loan.number))
                .forEach(number -> System.out.print("Loan number: " + number.toString() + "\n"));
    }

    public List<Loan> sortLoansByNumber() {
        return loans.stream().sorted(new Comparator<Loan>() {
            @Override
            public int compare(Loan o1, Loan o2) {
                if (o1.number < o2.number) {
                    return -1;
                }else if (o1.number == o2.number) {
                    return 0;
                }else {
                    return 1;
                }
            }
        }).collect(Collectors.toList());
    }

    public void groupLoans() {
    }

    Function<Loan, String> getType = loan -> loan.type;


    public static void main(String[] args) {
        Loans kredyty = new Loans();
        kredyty.generateLoans();
        kredyty.countLoans();
        kredyty.printLoanNumbers();
        List<Loan> listaKredytow = kredyty.sortLoansByNumber();
        System.out.println("---------- sorted ------------");
        listaKredytow.stream().forEach(loan -> System.out.println("Loan number: " + loan.number));
    }
}
