import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrograms {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(10,15,8,49,25,98,32,40);

        findElementsStartingWithSpecificNumber(integerList, 4);

        List<Integer> integers = Arrays.asList(10,15,8,49,25,98,98,32,15);
        findDuplicateElements(integers);

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        findMaxValue(myList);

        String input = "Java Hungry Blog Alive is Awesome";
        Character result = findFirstNonRepeatedCharacter(input);
        if(result != null) {
            System.out.println("First non repeated char is : " + result);
        } else {
            System.out.println("No non repeated char available");
        }

        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int inputVal = 10;
        findMatchingValue(values, inputVal);

        //count each element in a String List
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        countElements(names);

        //find Only duplicate elements and its count
        List<String> namesInput = Arrays.asList("AA", "BB", "AA", "CC");
        findDuplicateElementsWithCount(namesInput);

        checkPrime(9);

        //Square root of first n prime numbers
        sqrtOfPrimeNumbers(10);
    }

    private static void findElementsStartingWithSpecificNumber(List<Integer> integerList, int searchPrefix) {

        System.out.println("Elements starting with " + searchPrefix + " are : ");
        integerList.stream()
                .map(i -> i+"")
                .filter(s -> s.startsWith(String.valueOf(searchPrefix)))
                .forEach(System.out::println);

    }

    private static void findDuplicateElements(List<Integer> integers) {
        Set<Integer> integerSet = new HashSet<Integer>();
        System.out.println("Duplicate elements are : ");
        integers.stream().filter(i->!integerSet.add(i)).forEach(System.out::println);
    }

    private static void findMaxValue(List<Integer> myList) {
        System.out.println("Max value element is : " + myList.stream().max(Integer::compare).get());
    }

    private static Character findFirstNonRepeatedCharacter(String input) {
        char[] charArr = input.toCharArray();

        for (char c : charArr) {
            if(input.indexOf(c) == input.lastIndexOf(c)){
                return c;
            }
        }

        return null;
    }

    private static void findMatchingValue(Integer[] values, int inputVal) {
        boolean matchFound = Arrays.stream(values).anyMatch(i -> i == inputVal);
        if(matchFound == true) {
            System.out.println("Match found");
        } else {
            System.out.println("Match not found");
        }
    }

    private static void countElements(List<String> names) {
        Map<String, Long> count = names.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(count);
    }

    private static void findDuplicateElementsWithCount(List<String> namesInput) {
        Map<String, Long> duplicateElements = namesInput.stream()
                .filter(s -> Collections.frequency(namesInput, s) > 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Duplicate elements are : "+ duplicateElements);
    }

    private static void checkPrime(int number) {
        boolean isPrime = false;
        isPrime = number>1 && IntStream.range(2, number).noneMatch(n->number%n==0);
        if(isPrime) {
            System.out.println("Given number : " + number + " is a prime number.");
        } else {
            System.out.println("Given number : " + number + " is not a prime number.");
        }
    }

    private static void sqrtOfPrimeNumbers(int numberOfPrimes) {
        List<Double> sqrts = Stream.iterate(1, i->i+1)
                .filter(i -> i>1 && IntStream.range(2, i).noneMatch(n->i%n==0)).peek(System.out::println)
                .map(Math::sqrt).limit(numberOfPrimes).collect(Collectors.toList());
        System.out.println("Sqrt are : " + sqrts);
    }

}
