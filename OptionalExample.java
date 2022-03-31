import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalExample {

    public static List<Customer> getAllCustomers(){
        return Stream.of(
                        new Customer(101, "Rakib", "rakib@gmail.com", Arrays.asList("7864085342", "8670028194")),
                        new Customer(102, "Mosharrof", "mosharrof@gmail.com", Arrays.asList("9903932760", "7450391845")),
                        new Customer(103, "Prasenjit", "prasenjit@gmail.com", Arrays.asList("8793205143", "9874561290")),
                        new Customer(102, "Tapas", "tapas@gmail.com", Arrays.asList("9167826843", "8820713691"))
                )
                .collect(Collectors.toList());

    }

    public static void main(String[] args) throws Exception {
        Customer customer1 = new Customer(101, "Rakib", "rakib@gmail.com", Arrays.asList("7864085342", "8670028194"));

        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String> emailOptional = Optional.of(customer1.getEmail());
        System.out.println(emailOptional);

        Optional<String> optionalEmail1 = Optional.ofNullable(customer1.getEmail());
        if(optionalEmail1.isPresent()) {
            System.out.println(optionalEmail1.get());
        }

        Customer customer2 = new Customer(101, "Rajesh", null, Arrays.asList("7864085342", "8670028194"));
        Optional<String> optionalEmail2 = Optional.ofNullable(customer2.getEmail());
        System.out.println(optionalEmail2.orElse("rajesh@gmail.com"));

        Customer customer3 = new Customer(101, "Rajesh", "abc@gmail.com", Arrays.asList("7864085342", "8670028194"));
        Optional<String> optionalEmail3 = Optional.ofNullable(customer3.getEmail());
        //System.out.println(optionalEmail3.orElseThrow(() -> new IllegalArgumentException("email is not present")));
        System.out.println(optionalEmail3.map(String::toUpperCase).orElseGet(() -> "default@gmail.com"));

        getCustomerByEmailId("abc");
    }

    public static Customer getCustomerByEmailId(String emailId) throws Exception {
        List<Customer> customers = getAllCustomers();
        return customers.stream()
                .filter(
                        c-> c.getEmail().equals(emailId)).findAny()
                .orElseThrow(() -> new Exception("no customer present with this email id")
                );
    }

}
