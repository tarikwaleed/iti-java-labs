public class Lab1 {
    public static void main(String[] args) {
        //Problem1
        System.out.println("Hello,World!");
        //Problem2
        if (Integer.parseInt(args[0]) == 5) {
            System.out.println("The input we've got is 5");
        } else {
            System.out.println("we've got something else");
        }
        //Problem3
        for (int i = Integer.parseInt(args[0]); i > 0; i--) {
            System.out.println(args[1]);

        }
    }
}
