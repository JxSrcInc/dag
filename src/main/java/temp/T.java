package temp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class T {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Sum all numbers using reduce
        Optional<Integer> sum = numbers.stream()
                                       .reduce((a, b) -> a + b);

        System.out.println("Original Numbers: " + numbers);
        System.out.println("Sum of Numbers: " + sum.orElse(0));
    }
}