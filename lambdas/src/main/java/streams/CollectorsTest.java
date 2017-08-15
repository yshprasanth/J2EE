package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsTest {

    public static void main(String... args) {
        int o = Food.menu.stream().collect(Collectors.summingInt(Food::getCalories));
        System.out.println(o);

        Map<Type, List<Food>> foodItems
                = Food.menu.stream().collect(Collectors.groupingBy(Food::getType));

        List<Map.Entry<Type, List<Food>>> entries
                =  new ArrayList(foodItems.entrySet());

        entries.stream()
                .forEach(e -> {
                            System.out.println("Type: " + e.getKey());
                            e.getValue()
                                    .stream()
                                    .map(Food::getName)
                                    .forEach(f -> System.out.println(f)); });


        Map<Boolean, List<Food>> vMap =
                Food.menu.stream().collect(Collectors.partitioningBy(Food::isVegetarian));

        System.out.println(vMap);

        int calories = Food.menu.stream()
                .map(Food::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }
}
enum Type { MEAT, FISH, OTHER }
class Food {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Food(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
    @Override
    public String toString() {
        return name;
    }

    public static final List<Food> menu =
            Arrays.asList( new Food("pork", false, 1800, Type.MEAT),
                    new Food("beef", false, 7100, Type.MEAT),
                    new Food("chicken", false, 1400, Type.MEAT),
                    new Food("french fries", true, 1530, Type.OTHER),
                    new Food("rice", true, 3510, Type.OTHER),
                    new Food("season fruit", true, 1120, Type.OTHER),
                    new Food("pizza", true, 5150, Type.OTHER),
                    new Food("prawns", false, 1400, Type.FISH),
                    new Food("salmon", false, 4150, Type.FISH));
}