import java.util.Arrays;
import java.util.List;

public class MultiTest {

    public static void main(String[] args) {

        //sum of square of even numbers
        List<Integer> list = List.of(1,2,3,4,5,6);
        sumSquareEvenNumbers(list);

        //Devide List into multiple parts
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
        divide(list2, 4);

        //Check Leap Year
        checkLeapYear(2100);

        //Check Palindrome String
        checkPalindrome("12321");

        //Check odd numbers in list
        checkOddNumbers(list);

        //Check Anagrams of two string
        String string1 = "TRIANGLE";
        String string2 = "INTEGRAL";
        checkAnagram(string1, string2);

        //Check pair for target output
        int arr[] = {0, -1, 2, -3, 1};
        int targetSumValue = -2;
        boolean validPairExists = checkPairForTargetSumValue(arr, targetSumValue);
        if(validPairExists) {
            System.out.println("Valid pair exists");
        } else {
            System.out.println("Valid pair does not exist");
        }

    }

    private static void sumSquareEvenNumbers(List<Integer> list) {
        //Integer sumSquareEven = list.stream().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, Integer::sum);
        int sum = list.stream().filter(t -> t % 2 == 0).mapToInt(t -> t * t).sum();
        System.out.println("Sum = " + sum);
    }

    public static void divide(List<Integer> list, int count) {
        for(int i=0;i<list.size();i+=count) {
            if (list.size()-i <count) {
                System.out.println(list.subList(i, list.size()));
            } else {
                System.out.println(list.subList(i, i+count));
            }
        }
    }

    private static void checkLeapYear(int year) {
        boolean leapYear;
        if(year%4==0) {
            leapYear = true;
            if(year%100==0) {
                if(year%400==0) {
                    leapYear = true;
                } else {
                    leapYear = false;
                }
            }
        } else {
            leapYear = false;
        }

        if(leapYear) {
            System.out.println("Given year : " + year + " is a leap year");
        } else {
            System.out.println("Given year : " + year + " is not a leap year");
        }
    }

    private static void checkPalindrome(String s) {
        char[] arr = s.toCharArray();
        char[] revArr = new char[arr.length];
        int j=0;
        for (int i = arr.length-1; i>=0; i--) {
            revArr[j] = arr[i];
            j++;
        }

        if(String.valueOf(revArr).equals(s)) {
            System.out.println("Given string : " + s + " is a Palindrome String");
        } else {
            System.out.println("Given string : " + s + " is not a Palindrome String");
        }
    }

    private static void checkOddNumbers(List<Integer> list) {
        System.out.println("Odd numbers in the list are : ");
        list.stream().filter(t -> t % 2 != 0).forEach(t-> System.out.println(t));
    }

    private static void checkAnagram(String string1, String string2) {
        char arr1[] = string1.toCharArray();
        char arr2[] = string2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(String.valueOf(arr1).equals(String.valueOf(arr2))) {
            System.out.println("Given strings - " + string1 + " and " + string2 + " are anagrams");
        } else {
            System.out.println("Given strings - " + string1 + " and " + string2 + " are not anagrams");
        }
    }

    private static boolean checkPairForTargetSumValue(int[] arr, int targetSumValue) {

        for(int i=0; i< arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] + arr[j] == targetSumValue) {
                    System.out.println("Valid pair is : " + arr[i] + " and " + arr[j] + " for the target value " + targetSumValue);
                    return true;
                }
            }
        }

        return false;
    }

}
