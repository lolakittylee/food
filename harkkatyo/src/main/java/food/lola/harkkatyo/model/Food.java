package food.lola.harkkatyo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import food.lola.harkkatyo.domain.FoodType;
import food.lola.harkkatyo.domain.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dish;
    private String restaurant;
    private double price;
    private String dietaryRestriction;

    @ManyToOne
    @JoinColumn(name = "foodtype_id")
    private FoodType foodType;

    @JsonIgnore 
    @OneToMany (mappedBy = "dish")
    private List <Food> foodlist;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Food() {
    }

    public Food(String dish, String restaurant, String dietaryRestriction, double price, FoodType foodType) {
        this.dish = dish;
        this.restaurant = restaurant;
        this.dietaryRestriction = dietaryRestriction;
        this.price = price;
        this.foodType = foodType;
     }

    public Food(String dish, String restaurant, String dietaryRestriction, double price, FoodType foodType,
            Category category) {
        this.dish = dish;
        this.restaurant = restaurant;
        this.dietaryRestriction = dietaryRestriction;
        this.price = price;
        this.foodType = foodType;
        this.category = category;
    }

    //food type and category optional

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }


    public String getDietaryRestriction() {
        return dietaryRestriction;
    }

    public void setDietaryRestriction(String dietaryRestriction) {
        this.dietaryRestriction = dietaryRestriction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Food [id=" + id + ", dish=" + dish + ", restaurant=" + restaurant
                + ", dietaryRestriction=" + dietaryRestriction + ", price=" + price + "]";
    }

}