import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {

    public static void main(String[] args) {
        List<Customer> customers = getAllCustomers();

        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail()).collect(Collectors.toList());
        System.out.println(emails);

        List<List<String>> phoneNumbers = customers.stream()
                .map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(phoneNumbers);

        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phones);
    }

    public static List<Customer> getAllCustomers(){
        return Stream.of(
                        new Customer(101, "Rakib", "rakib@gmail.com", Arrays.asList("7864085342", "8670028194")),
                        new Customer(102, "Mosharrof", "mosharrof@gmail.com", Arrays.asList("9903932760", "7450391845")),
                        new Customer(103, "Prasenjit", "prasenjit@gmail.com", Arrays.asList("8793205143", "9874561290")),
                        new Customer(102, "Tapas", "tapas@gmail.com", Arrays.asList("9167826843", "8820713691"))
                )
                .collect(Collectors.toList());

    }

}
