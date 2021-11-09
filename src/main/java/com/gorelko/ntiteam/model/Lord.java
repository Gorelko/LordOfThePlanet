package com.gorelko.ntiteam.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "LORD")
public class Lord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "lord")
    @JsonIgnoreProperties({"lord"})
    private List<Planet> planets = new ArrayList<>();


    public Lord() {
    }

    public Lord(String name, int age, List<Planet> planets) {
        this.name = name;
        this.age = age;
        this.planets = planets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lord lord = (Lord) o;
        return age == lord.age &&
                id.equals(lord.id) &&
                name.equals(lord.name) &&
                planets.equals(lord.planets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, planets);
    }
}
