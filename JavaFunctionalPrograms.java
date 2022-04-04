import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class JavaFunctionalPrograms {
    public static void main(String[] args) {

        startThreadUsingLambda();

        List<Double> costBeforeTax = Arrays.asList(100.00, 200.00, 300.00, 400.00, 500.00);
        applyVATusingStream(costBeforeTax);

        sumOfCostAfterVATsuingMapReduce(costBeforeTax);

        List<String> stringList = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        convertAndJoinStrings(stringList);

        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        createSuqaresOfDistinctNumbers(numbers);

        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        createSummaryStats(primes);
    }

    private static void startThreadUsingLambda() {
        new Thread(()->{
            System.out.println("Creating new thread using Lambda expression");
        }).start();
    }

    private static void applyVATusingStream(List<Double> costBeforeTax) {
        costBeforeTax.stream().map(cost -> cost + .12*cost)
                .forEach(costWithVAT -> System.out.println("Cost after applying 12 % VAT = " + costWithVAT));
    }

    private static void sumOfCostAfterVATsuingMapReduce(List<Double> costBeforeTax) {
        Double sumAfterVAT = costBeforeTax.stream().map(cost -> cost + .12 * cost)
                .reduce((sum, cost) -> sum + cost).get();
        System.out.println("Sum after applying VAT = " + sumAfterVAT);
    }

    private static void convertAndJoinStrings(List<String> stringList) {
        String countries = stringList.stream().map(String::toUpperCase)
                .collect(Collectors.joining(", "));

        System.out.println("Joined String is : " + countries);
    }

    private static void createSuqaresOfDistinctNumbers(List<Integer> numbers) {
        List<Integer> squares = numbers.stream().map(n -> n * n).distinct().collect(Collectors.toList());
        System.out.println("Square of distinct numbers are : " + squares);
    }

    private static void createSummaryStats(List<Integer> numbers) {
        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(i -> i).summaryStatistics();
        System.out.println("Largest number in list : " + intSummaryStatistics.getMax());
        System.out.println("Smallest number in list : " + intSummaryStatistics.getMin());
        System.out.println("Sum of all numbers : " + intSummaryStatistics.getSum());
        System.out.println("Average of all numbers : " + intSummaryStatistics.getAverage());
    }

}
