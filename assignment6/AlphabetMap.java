import java.util.*;
import java.util.stream.Collectors;

public class AlphabetMap {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "avocado", "date", "grape", "lemon", "orange", "kiwi", "mango"};

        Map<Character, List<String>> map = new HashMap<>();
        for (String word : words) {
            char key = word.charAt(0);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }


        for (Map.Entry<Character, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        char letter = 'b';
        List<String> words2 = map.getOrDefault(letter, Collections.emptyList());
        System.out.println("Words starting with " + letter + ": " + words2);
    }
}

