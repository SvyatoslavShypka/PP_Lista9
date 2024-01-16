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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(getName(), city.getName()) && Objects.equals(getPopulation(), city.getPopulation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPopulation());
    }
}
