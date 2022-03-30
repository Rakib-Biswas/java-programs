import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeStreamDemo {

    private static List<Employee> employeeList = new ArrayList<Employee>();

    public static void main(String args[]) {

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        //Query 1: How many male and female employees are there in the organization?
        countMaleAndFemale();
        System.out.println("\n");


        //Query 2: Print the name of all departments in the organization
        nameOfAllDepartments();
        System.out.println("\n");


        //Query 3: What is the average age of male and female employees?
        averageAgeOfMaleAndFemale();
        System.out.println("\n");


        //Query 4: Get the details of highest paid employee in the organization
        getHighestPaidEmployee();
        System.out.println("\n");


        //Query 5: Get the names of all employees who had joined after 2015
        namesOfEmployeesAfter2015();
        System.out.println("\n");


        //Query 6: Count the number of employees in each department
        countEmployeesEachDepartment();
        System.out.println("\n");

        //Query 7: What is the average salary of each department
        averageSalaryOfEachDepartment();
        System.out.println("\n");

        //Query 8: Get the details of youngest male employee in the product development department
        youngestMaleInProdDevTeam();
        System.out.println("\n");


        //Query 9: Who has the most working experience in the organization?
        mostExperiencedEmployee();
        System.out.println("\n");


        //Query 10: How many male and female employees are there in sales and marketing team
        numOfMaleFemaleEmployeeInSalesMarketing();
        System.out.println("\n");

        //Query 11: What is the average salary of male and female employees
        avgSalMaleAndFemale();
        System.out.println("\n");

        //Query 12: List down the names of all employees in each department
        employeesInEachDept();
        System.out.println("\n");

        //Query 13: What is the average salary and total salary of the whole organization
        averageSalAndTotalSal();
        System.out.println("\n");


        //Query 14: Seperate the employees who are younger or equal to 25 years
        employeesLE25years();
        System.out.println("\n");


        //Query 15: Who is the oldest employee in the organization and what is his age and what is his department
        oldestEmployeeAgeDept();
        System.out.println("\n");


    }

    private static void countMaleAndFemale() {
        Map<String, Long> employeeCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        employeeCount.entrySet().forEach((e-> System.out.println(e.getKey() + " emp count = " + e.getValue())));
    }

    private static void nameOfAllDepartments() {
        List<String> departments = (List<String>) employeeList.stream()
                .map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("All dept names are : ");
        departments.forEach(System.out::println);
    }

    private static void averageAgeOfMaleAndFemale() {
        Map<String, Double> avgAges = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        avgAges.entrySet().forEach(e-> System.out.println(e.getKey() + "Average age : " + e.getValue()));
    }

    private static void getHighestPaidEmployee() {
        Employee employee = employeeList.stream().
                sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst().get();

        System.out.println("Highest paid employee is " + employee);
    }

    private static void namesOfEmployeesAfter2015() {
        employeeList.stream().filter(e->e.getYearOfJoining() > 2015)
                .map(Employee::getName).forEach(System.out::println);
    }

    private static void countEmployeesEachDepartment() {
        Map<String, Long> deptEmpCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        deptEmpCount.entrySet().forEach(e-> System.out.println(e.getKey() + " - emp count : " + e.getValue()));
    }

    private static void averageSalaryOfEachDepartment() {
        Map<String, Double> deptAvgSal = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        deptAvgSal.entrySet().forEach(e-> System.out.println(e.getKey() + " - Avg Sal : " + e.getValue()));
    }

    private static void youngestMaleInProdDevTeam() {
        Employee youngestEmployee = employeeList.stream()
                .filter(
                        e->e.getGender().equalsIgnoreCase("Male")
                                && e.getDepartment().equalsIgnoreCase("Product Development"))
                .sorted(Comparator.comparingInt(Employee::getAge)).findFirst().get();

        System.out.println("Youngest male employee in Product Development Team is : " + youngestEmployee);
    }

    private static void mostExperiencedEmployee() {
        Employee mostExperiencedEmp = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();
        System.out.println("Most experienced employee is : " + mostExperiencedEmp);
    }

    private static void numOfMaleFemaleEmployeeInSalesMarketing() {
        Map<String, Long> sales_and_marketing = employeeList.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Sales marketing male female emp count : ");
        sales_and_marketing.entrySet().forEach(e-> System.out.println(e.getKey() + " - emp count : " + e.getValue()));
    }

    private static void avgSalMaleAndFemale() {
        Map<String, Double> avgSalMaleFemale = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

        avgSalMaleFemale.entrySet().forEach(e-> System.out.println(e.getKey() + " - avg sal : " + e.getValue()));
    }

    private static void employeesInEachDept() {
        Map<String, List<Employee>> deptEmpList = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String, List<Employee>>> entries = deptEmpList.entrySet();
        for (Map.Entry<String, List<Employee>> entry : entries) {
            System.out.println(entry.getKey() + " - Emp names : ");
            entry.getValue().stream().map(Employee::getName).forEach(System.out::println);
            System.out.println();
        }
    }

    private static void averageSalAndTotalSal() {
        DoubleSummaryStatistics avgTotalSal = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Avg sal : " + avgTotalSal.getAverage());
        System.out.println("Total sal : " + avgTotalSal.getSum());
    }

    private static void employeesLE25years() {
        Map<Boolean, List<Employee>> collect = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        Set<Map.Entry<Boolean, List<Employee>>> entries = collect.entrySet();

        for(Map.Entry<Boolean, List<Employee>> entry : entries) {
            if(entry.getKey()) {
                System.out.println("Emp older than 25 years : ");
            } else {
                System.out.println("Emp younger than 25 years : ");
            }
            entry.getValue().stream().map(Employee::getName).forEach(System.out::println);
            System.out.println();
        }
    }

    private static void oldestEmployeeAgeDept() {
        Employee oldestEmp = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst().get();
        System.out.println(oldestEmp);
    }

}
