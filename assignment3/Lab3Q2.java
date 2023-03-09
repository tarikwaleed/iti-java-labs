import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Lab3Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        BiFunction<Double, Double, Double> add = Lab3Q2::add;
        BiFunction<Double, Double, Double> subtract = Lab3Q2::subtract;
        Function<Double, Double> squareRoot = Math::sqrt;


        double root1 = divide(subtract.apply(-b, squareRoot.apply(add.apply(Math.pow(b, 2), -4 * a * c))), 2 * a);
        double root2 = divide(add.apply(-b, squareRoot.apply(add.apply(Math.pow(b, 2), -4 * a * c))), 2 * a);
        System.out.printf("The quadratic equation has two real roots: %.2f and %.2f", root1, root2);
    }

    private static double add(double x, double y) {
        return x + y;
    }

    private static double subtract(double x, double y) {
        return x - y;
    }

    private static double divide(double dividend, double divisor) {
        return dividend / divisor;
    }
}

