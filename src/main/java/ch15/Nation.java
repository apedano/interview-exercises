package ch15;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Alex on 21/08/2017.
 */
@XmlType(propOrder = {"name", "language", "population", "foundation", "cities"})
@XmlRootElement(name = "Nazione")
public class Nation {

    private String name;
    private int population;
    private String language;
    private LocalDate foundation;
    private List<City> cities;

    public String getName() {
        return name;
    }

    @XmlElement(name = "nazione_nome", required = true)
    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    @XmlElement(name = "nazione_popolazione")
    public void setPopulation(int population) {
        this.population = population;
    }

    @XmlElement(name = "nazione_lingua")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getFoundation() {
        return foundation;
    }


    @XmlElement( name = "nazione_fondazione" )
    @XmlJavaTypeAdapter( DateAdapter.class )
    public void setFoundation( LocalDate foundation )
    {
        this.foundation = foundation;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nation nation = (Nation) o;

        if (population != nation.population) return false;
        if (cities != null ? !cities.equals(nation.cities) : nation.cities != null) return false;
        if (foundation != null ? !foundation.equals(nation.foundation) : nation.foundation != null) return false;
        if (language != null ? !language.equals(nation.language) : nation.language != null) return false;
        if (name != null ? !name.equals(nation.name) : nation.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + population;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (foundation != null ? foundation.hashCode() : 0);
        result = 31 * result + (cities != null ? cities.hashCode() : 0);
        return result;
    }
}
