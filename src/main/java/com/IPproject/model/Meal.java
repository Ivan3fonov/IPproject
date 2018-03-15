package com.IPproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "meal_id")
    private Integer id;


    private String name;

    private int calTarget;

    private int calsFromProteins;
    private int calsFromCarbs;
    private int calsFromFats;

    @OrderBy("id ASC")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "meal", cascade = CascadeType.ALL)
    private List<Food> foods;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diet_id"/*, nullable = false*/)
    private Diet diet;

    public Meal() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> food) {
        this.foods = food;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalTarget() {
        return calTarget;
    }

    public void setCalTarget(int calTarget) {
        this.calTarget = calTarget;
    }

    public int getCalsFromProteins() {
        return calsFromProteins;
    }

    public void setCalsFromProteins(int calsFromProteins) {
        this.calsFromProteins = calsFromProteins;
    }

    public int getCalsFromCarbs() {
        return calsFromCarbs;
    }

    public void setCalsFromCarbs(int calsFromCarbs) {
        this.calsFromCarbs = calsFromCarbs;
    }

    public int getCalsFromFats() {
        return calsFromFats;
    }

    public void setCalsFromFats(int calsFromFats) {
        this.calsFromFats = calsFromFats;
    }
}