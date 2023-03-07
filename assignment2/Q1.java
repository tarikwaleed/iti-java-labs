import java.util.Arrays;
import java.util.Random;

public class Q1 {
    public static void main(String[] args) {
        int[] randomArray = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rand.nextInt(100); // generates a random integer between 0 and 99
        }
//        for (int i = 0; i < randomArray.length; i++) {
//            System.out.println(randomArray[i]);
//        }

        int min = randomArray[0];
        int max = randomArray[0];

        long startTime = System.currentTimeMillis();
        // Linear Search
//        for (int i = 1; i < randomArray.length; i++) {
//            if (randomArray[i] < min) {
//                min = randomArray[i];
//            }
//            if (randomArray[i] > max) {
//                max = randomArray[i];
//            }
//        }

        // BinarySearch
        Arrays.sort(randomArray);
        int searchValue = rand.nextInt(100);
        int index = Arrays.binarySearch(randomArray, searchValue);
        if (index >= 0) {
            System.out.println("Found " + searchValue + " at index " + index);
        } else {
            System.out.println(searchValue + " not found in array");
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        // print the results
        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Search time: " + totalTime + " milliseconds");


    }
}
