import java.util.StringTokenizer;
public class Q2 {
    public static void main(String[] args) {

        String sentence = "ITI develops people and ITI house of developers and ITI for people";
        String word = "ITI";
        String[] words = sentence.split(" ");

        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        System.out.println("The word '" + word + "' occurs " + count + " times.");

        StringTokenizer tokenizer=new StringTokenizer(sentence,"ITI");
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
        String ipAddress="192.168.10.0";
//        StringTokenizer tokenizer2=new StringTokenizer(ipAddress,".");
//        while (tokenizer.hasMoreTokens()) {
//            System.out.println(tokenizer2.nextToken());
//        }
        String[]tokens= ipAddress.split("\\.");
        for (String token : tokens) {
            System.out.println(token);
        }




    }
}
