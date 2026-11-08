package food.lola.harkkatyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import food.lola.harkkatyo.domain.FoodRepository;
import food.lola.harkkatyo.model.Food;
import food.lola.harkkatyo.domain.FoodType;
import food.lola.harkkatyo.domain.FoodTypeRepository;
import food.lola.harkkatyo.domain.Category;
import food.lola.harkkatyo.domain.CategoryRepository;


@Configuration
public class DataBaseInitializer {

	@Bean
	public CommandLineRunner initializeDatabase(
			FoodRepository foodRepository,
			CategoryRepository categoryRepository,
			FoodTypeRepository foodTypeRepository) {

		
		return (args) -> {

			// issuing Categories
			Category starter = categoryRepository.save(new Category("Starter"));
			Category mainDish = categoryRepository.save(new Category("Main Dish"));
			Category dessert = categoryRepository.save(new Category("Dessert"));

			//issuing food types
			FoodType sweet = foodTypeRepository.save(new FoodType("Sweet"));
			FoodType pasta = foodTypeRepository.save(new FoodType("Pasta"));
			FoodType pizza = foodTypeRepository.save(new FoodType("Pizza"));
			FoodType soup = foodTypeRepository.save(new FoodType("Soup"));

			//test data
			foodRepository.save(new Food(
				"Pizza",
				"Yo mama's",
				"vegetarian",
				15.00,
				pizza)); 
			
			foodRepository.save(new Food(
				"Carbonara",
				"Still yo mama",
				"lactose free",
				20.00,
				pasta,
				mainDish
			));

			foodRepository.save(new Food(
				"Tiramisu",
				"Still yo mama",
				"vegan",
				8.00,
				sweet,
				dessert
			));

			foodRepository.save(new Food(
				"Tomato soup",
				"Somebody's mama",
				"vegan",
				10.00,
				soup,
				starter
			));

		};
	}
}
