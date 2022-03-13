import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Employees {
    List<Employee> employees = new ArrayList<>();

    private class Employee {
        private Integer id;
        private Integer age;
        private String gender;
        private String firstName;
        private String lastName;

        public Employee(Integer id, Integer age, String gender, String firstName, String lastName) {
            this.id = id;
            this.age = age;
            this.gender = gender;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Integer getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }
    }

    public void generate() {
        Employee employee1 = new Employee(1, 67, "M", "Jan", "Kowalski");
        Employee employee2 = new Employee(2, 28, "F", "Janina", "Proc");
        Employee employee3 = new Employee(3, 41, "M", "Amadeusz", "Mozart");
        Employee employee4 = new Employee(1, 18, "M", "Krzysztof", "Krawczyk");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
    }

    public static Predicate<Employee> isAgeHigherThan(Integer age)
    {
        return p -> p.getAge() > age;
    }

    public static Predicate<Employee> isFemaleBelow30()
    {
        return p -> p.getAge() < 30 && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isManAndAgeIsLowerThan(Integer age)
    {
        return p -> p.getAge() > age && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAgeLowerThan(Integer age)
    {
        return p -> p.getAge() > age;
    }

    public static Predicate<Employee> isWoman() {
        return p -> p.getGender() == "F";
    }

    public static Predicate<Employee> isMan() {
        return p -> p.getGender() == "M";
    }

    public static List<Employee> filterEmployees (List<Employee> employees,
                                                  Predicate<Employee> predicate)
    {
        return employees.stream()
                .filter( predicate )
                .collect(Collectors.<Employee>toList());
    }

    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.generate();

        System.out.println("---------- 1 --------------");
        System.out.println("Is somebody older than 65?: ");

        if (filterEmployees(employees.employees, isAgeHigherThan(65)).size() > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("---------- 2 --------------");
        System.out.println("Are there any woman younger than 30?: ");

        if (filterEmployees(employees.employees, isFemaleBelow30()).size() > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        System.out.println("---------- 3 --------------");
        System.out.println("How many man are younger than 40?: ");

        System.out.println(filterEmployees(employees.employees, isManAndAgeIsLowerThan(40)).size());

        System.out.println("---------- 4 --------------");
        System.out.println("How many people is younger than 20: ");

        System.out.println(filterEmployees(employees.employees, isAgeLowerThan(20)).size());

        System.out.println("---------- 5 --------------");
        System.out.println("The average age of man is: ");

        System.out.println(filterEmployees(employees.employees, isMan()).stream()
                .collect(Collectors.averagingInt(e -> e.age)));

        System.out.println("---------- 6 --------------");
        System.out.println("The average age of woman is: ");

        System.out.println(filterEmployees(employees.employees, isWoman()).stream()
                .collect(Collectors.averagingInt(e -> e.age)));
    }


}
