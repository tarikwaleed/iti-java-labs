import java.util.function.BiPredicate;

public class Lab5Q3 {
    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "banana";

        String longer = betterString(s1, s2, (str1, str2) -> str1.length() > str2.length());
        String first = betterString(s1, s2, (str1, str2) -> true);

        System.out.println("Longer string: " + longer); // Output: Longer string: banana
        System.out.println("First string: " + first); // Output: First string: apple
    }

    public static String betterString(String s1, String s2, BiPredicate<String, String> predicate) {
        if (predicate.test(s1, s2)) {
            return s1;
        } else {
            return s2;
        }
    }
}
