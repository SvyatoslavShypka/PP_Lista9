import java.util.Objects;

public class City {
    private String name;
    private Long population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }


    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "'" + name + '\'' +
                '}';
    }
}
