package food.lola.harkkatyo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import food.lola.harkkatyo.domain.Category;
import food.lola.harkkatyo.domain.FoodType;
import food.lola.harkkatyo.model.Food;

@SpringBootTest
class HarkkatyoApplicationTests {

	@Test
	void contextLoads() {
	}

	// Checks that Food.java contents are stored correctly
	// 
	@Test
    void foodConstructorSetsFoodDetails() {
        FoodType type = new FoodType("Pizza");

        Food food = new Food("Margherita", "Cafe", "vegetarian", 12.50, type);

        assertEquals("Margherita", food.getDish());
        assertEquals("Cafe", food.getRestaurant());
        assertEquals("vegetarian", food.getDietaryRestriction());
        assertEquals(12.50, food.getPrice(), 0.001);
        assertSame(type, food.getFoodType());
    }
	//Creates a Food.java with a food type and category
	//Checks they're stored correctly
    @Test
    void foodConstructorSetsCategory() {
        FoodType type = new FoodType("Pasta");
        Category category = new Category("Main Dish");

        Food food = new Food("Carbonara", "Cafe", "gluten", 15.00, type, category);

        assertSame(type, food.getFoodType());
        assertSame(category, food.getCategory());
    }

	//Category name check and update check
    @Test
    void categoryStoresItsName() {
        Category category = new Category("Dessert");

        assertEquals("Dessert", category.getName());

        category.setName("Starter");
        assertEquals("Starter", category.getName());
    }

	//FoodType name check and update check
    @Test
    void foodTypeStoresItsName() {
        FoodType type = new FoodType("Soup");

        assertEquals("Soup", type.getMyFoodType());

        type.setMyFoodType("Pizza");
        assertEquals("Pizza", type.getMyFoodType());
    }
}
