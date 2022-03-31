import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(3,7,8, 1,5,9);
        int sum1 = integers.stream().mapToInt(i->i).sum();
        System.out.println(sum1);

        int sum2 = integers.stream().reduce(0, (a,b) -> a+b);
        System.out.println(sum2);

        Optional<Integer> sumOptional = integers.stream().reduce(Integer::sum);
        System.out.println(sumOptional.get());

        int maxValue = integers.stream().reduce(0, (a, b) -> a>b?a:b);
        System.out.println(maxValue);

        List<String> stringList = Arrays.asList("CoreJava", "Spring", "Hibernate");
        String maxLen = stringList.stream().reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).get();
        System.out.println(maxLen);

    }

}
