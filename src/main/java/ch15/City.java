package ch15;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Alex on 21/08/2017.
 */
@XmlType(propOrder = {"nome", "importance", "extension"})
@XmlRootElement(name = "Citta")
public class City {
    private String nome;
    private int extension;
    private int importance;

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlElement(name = "citta_nome", required = true)
    public String getNome() {
        return nome;
    }

    public int getExtension() {
        return extension;
    }

    @XmlElement(name = "citta_estensione")
    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getImportance() {
        return importance;
    }

    @XmlElement(name = "citta_importanza")
    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (extension != city.extension) return false;
        if (importance != city.importance) return false;
        if (nome != null ? !nome.equals(city.nome) : city.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + extension;
        result = 31 * result + importance;
        return result;
    }
}
