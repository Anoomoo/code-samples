import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        CourseGradebook gradebook2 = new CourseGradebook();
        HashSet<Tuple<Integer, String, Double>> test = new HashSet<>();
        test.add(new Tuple(9999, "Homework 1", 69.0));
        System.out.println(test.equals(new Tuple(9999, "Homework 1", 69.0)));
    }
}