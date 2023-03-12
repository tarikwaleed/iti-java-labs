import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Country {
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private int population;
    private double gnp;
    private int capital;
    private List<City> cities;

    public Country(String code, String name, String continent, double surfaceArea, int population, double gnp, int capital, List<City> cities) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.population = population;
        this.gnp = gnp;
        this.capital = capital;
        this.cities = cities;
    }


    public List<City> getCities() {
        return cities;
    }


    public static void main(String[] args) {
        Country[] countries = new Country[3];

        City newYork = new City(1, "New York", 8623000, "USA");
        City losAngeles = new City(2, "Los Angeles", 3990000, "USA");
        City london = new City(3, "London", 8980000, "GBR");
        City manchester = new City(4, "Manchester", 545500, "GBR");
        City paris = new City(5, "Paris", 2244000, "FRA");
        City lyon = new City(6, "Lyon", 513300, "FRA");

        Country usa = new Country("USA", "United States", "North America", 9826675.00, 327167434, 19390604.00, 1, Arrays.asList(newYork, losAngeles));
        Country gbr = new Country("GBR", "United Kingdom", "Europe", 242495.00, 66435600, 2824345.00, 3, Arrays.asList(london, manchester));
        Country fra = new Country("FRA", "France", "Europe", 643801.00, 66991000, 2582500.00, 5, Arrays.asList(paris, lyon));

        countries[0] = usa;
        countries[1] = gbr;
        countries[2] = fra;


        Map<String, City> highestPopulatedCitiesByCountry = Arrays.stream(countries)
                .flatMap(country -> country.getCities().stream())
                .collect(Collectors.toMap(City::getCountryCode, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(City::getPopulation))));

        highestPopulatedCitiesByCountry.forEach((countryCode, city) -> System.out.println(city.getName() + " (" + city.getPopulation() + ") - " + countryCode));
    }
}
