import java.util.function.Function;

public class Lab3Q1 {
    public static void main(String[] args) {
        Function<Double, Double> celsiusToFahrenheit = Lab3Q1::convertCelsiusToFahrenheit;

        double celsius = 25.0;
        double fahrenheit = celsiusToFahrenheit.apply(celsius);

        System.out.println(celsius + " degrees Celsius = " + fahrenheit + " degrees Fahrenheit");
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}

