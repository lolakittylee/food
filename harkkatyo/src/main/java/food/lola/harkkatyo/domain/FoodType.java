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
public class FoodType {
    // SOUP, PIZZA, PASTA, SWEET

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodtypeid;
    private String myFoodType;

    @JsonIgnoreProperties ("foodType")
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "foodType")
    private List<Food> foods;

    public FoodType() {}

    public FoodType(String myFoodType){
        this.myFoodType = myFoodType;
    }

    public Long getId() {
        return foodtypeid;
    }

    public void setId(Long foodtypeid) {
        this.foodtypeid = foodtypeid;
    }

    public String getMyFoodType() {
        return myFoodType;
    }

    public void setMyFoodType(String myFoodType) {
        this.myFoodType = myFoodType;
    }

        public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
