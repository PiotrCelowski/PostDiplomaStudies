import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    public void generate() {
        Employee employee1 = new Employee(1, 67, "M", "Jan", "Kowalski");
        Employee employee2 = new Employee(2, 28, "F", "Janina", "Proc");
        Employee employee3 = new Employee(3, 41, "M", "Amadeusz", "Mozart");
        Employee employee4 = new Employee(1, 18, "M", "Krzysztof", "Krawczyk");
    }

    public static Predicate<Employee> isAdultMale()
    {
        return p -> p.getAge() > 65 && p.getGender().equalsIgnoreCase("M");
    }
}
