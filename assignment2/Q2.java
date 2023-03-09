import java.util.StringTokenizer;
public class Q2 {
    public static void main(String[] args) {

        String sentence = "ITI develops people and ITI house of developers and ITI for people";
        String delimiter = "ITI";
        String[] words = sentence.split(" ");

        //Way1
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(delimiter)) {
                count++;
            }
        }
        System.out.println("The word '" + delimiter + "' occurs " + count + " times.");

        //Way 2
        int startIndex = 0;
        int endIndex = sentence.indexOf(delimiter);

        while (endIndex >= 0) {
            String token = sentence.substring(startIndex, endIndex);
            System.out.println(token);

            startIndex = endIndex + delimiter.length();
            endIndex = sentence.indexOf(delimiter, startIndex);
        }

        String lastToken = sentence.substring(startIndex);
        System.out.println(lastToken);


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
