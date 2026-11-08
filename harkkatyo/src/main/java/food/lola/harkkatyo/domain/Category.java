package food.lola.harkkatyo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import food.lola.harkkatyo.model.Food;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnoreProperties ("category")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Food> foods;

    public Category() {
    //STARTER, MAIN DISH, DESSERT
    }

    public Category(String name){
        this.name = name;
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

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    

}
