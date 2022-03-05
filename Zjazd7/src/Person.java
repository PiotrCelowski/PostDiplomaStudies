import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Person {
    private String name;
    public static List<Person> people = new ArrayList<>();

    public Person(String name) {
        this.name = name;
        people.add(this);
        countGroupedNames();
    }

    public String getName() {
        return name;
    }

    private void countGroupedNames() {
        getGroupedNames().forEach((name, persons) -> System.out.println(name +": " + persons.stream().count()));
    }

    private Map<String, List<Person>> getGroupedNames() {
         return  people.stream()
                 .collect(groupingBy(Person::getName));
    }

    public static void main(String[] args) {
        System.out.println("--------- Creating first Jan ---------");
        Person jan1 = new Person("Jan");
        System.out.println("--------- Creating Krzysztof ---------");
        Person krzysztof = new Person("Krzysztof");
        System.out.println("--------- Creating second Jan ---------");
        Person jan2 = new Person("Jan");
        System.out.println("--------- Creating third Jan ---------");
        Person jan3 = new Person("Jan");

    }
}
