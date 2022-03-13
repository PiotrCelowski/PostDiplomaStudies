import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private double salary;
    private String division;
    private DayJob dayJob;

    public Employee(int id, double salary, String division, DayJob dayJob) {
        this.id = id;
        this.salary = salary;
        this.division = division;
        this.dayJob = dayJob;
    }

    public enum DayJob {
        FULL_TIME("Full-time job"),
        PART_TIME("Part-time job");

        String dayJobDescription;

        DayJob(String dayJobDescription) {
            this.dayJobDescription = dayJobDescription;
        }
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Employee {");
        stringBuilder.append(" \nid: ").append(this.id);
        stringBuilder.append(", \nsalary: ").append(this.salary);
        stringBuilder.append(", \ndivision: ").append(this.division);
        stringBuilder.append(", \ndayJob: ").append(this.dayJob);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public static Predicate<Employee> salaryHigherThan = e -> e.salary>2600;

    public static void main(String[] args) {
        List<Employee> employees =
                Arrays.asList(
                        new Employee(1, 2000d, "Risk Department", Employee.DayJob.FULL_TIME),
                        new Employee(2,2500d, "Scoring Department", Employee.DayJob.FULL_TIME),
                        new Employee(3,2600d, "Scoring Department", Employee.DayJob.FULL_TIME),
                        new Employee(4,2700d, "Credit Department", Employee.DayJob.FULL_TIME),
                        new Employee(5,2700d, "Credit Department", Employee.DayJob.PART_TIME)
                );

        employees.stream().filter(salaryHigherThan).forEach(System.out::println);

        employees.stream().filter(salaryHigherThan).collect(Collectors.toList());
    }
}