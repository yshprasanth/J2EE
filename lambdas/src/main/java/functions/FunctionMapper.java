package functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionMapper {

    public static void main(String args[]) {
        List<Person> people = Arrays.asList(
                                    new Person("B", 25, "Main Street"),
                                    new Person("A", 27, "Off Street"));

        List<String> lNames = processElements(people, p -> p.getLocation());
        System.out.println(lNames);

        lNames = people.stream().map(p -> p.getLocation()).collect(Collectors.toList());
        System.out.println(lNames);
    }

    private static <T, R> List<R> processElements(Iterable<T> iterable, Function<T, R> function) {

        List<R> lNames = new ArrayList<>();
        for(T t : iterable) {
            R r = function.apply(t);
            lNames.add(r);
        }

        return lNames;
    }
}

class Person {
    private String name;
    private int age;
    private String location;

    public Person(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }
}