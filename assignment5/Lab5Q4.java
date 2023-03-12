public class Lab5Q4 {
    public static void main(String[] args) {
        String str1 = "HelloWorld";
        String str2 = "Hello123";

        boolean containsOnlyAlphabets1 = containsOnlyAlphabets(str1);
        boolean containsOnlyAlphabets2 = containsOnlyAlphabets(str2);

        System.out.println(str1 + " contains only alphabets? " + containsOnlyAlphabets1); // Output: HelloWorld contains only alphabets? true
        System.out.println(str2 + " contains only alphabets? " + containsOnlyAlphabets2); // Output: Hello123 contains only alphabets? false
    }

    public static boolean containsOnlyAlphabets(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

