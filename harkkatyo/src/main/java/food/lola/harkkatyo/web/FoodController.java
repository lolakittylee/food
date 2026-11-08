package food.lola.harkkatyo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import food.lola.harkkatyo.model.Food;
import food.lola.harkkatyo.domain.FoodRepository;
import food.lola.harkkatyo.domain.FoodType;
import food.lola.harkkatyo.domain.FoodTypeRepository;
// import food.lola.harkkatyo.domain.Category;
import food.lola.harkkatyo.domain.CategoryRepository;

@Controller
public class FoodController {

    // Field nimeltään foodRepository
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Constructor injection
    public FoodController(FoodRepository foodRepository,
            FoodTypeRepository foodTypeRepository,
            CategoryRepository categoryRepository) {
        this.foodRepository = foodRepository;
        this.foodTypeRepository = foodTypeRepository;
        this.categoryRepository = categoryRepository;
    }

    /*
     * private FoodTypeRepository foodTypeRepository;
     * 
     * public FoodController(FoodTypeRepository foodTypeRepository){
     * this.foodTypeRepository = foodTypeRepository;
     * }
     */

    //Opens index page
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        List<Food> foods = (ArrayList<Food>) foodRepository.findAll();
        System.out.println(foods.toString());
        return "index";
    }

    // See the menu 
    @RequestMapping(value = "/foodlist", method = RequestMethod.GET)
    public String showBooks(Model model) {
        model.addAttribute("foods", foodRepository.findAll());
        List<Food> foods = (List<Food>) foodRepository.findAll();
        for (int i = 0; i < foods.size(); i++) {
            FoodType foodType = foods.get(i).getFoodType();
            System.out.println(foodType == null ? null : foodType.getMyFoodType());
        }
        return "foodlist";
    }

    //add new food item
    @RequestMapping(value = "/showmodifyform", method = RequestMethod.POST)
    public String addFood(Model model) {
        model.addAttribute("food", new Food());
        model.addAttribute("Foodtypes", foodTypeRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addFood";
    }

    //save new food item to menu
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFood(Food food) {
        foodRepository.save(food);
        return "redirect:foodlist";
    }

    //deleting food item from menu
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFood(@PathVariable("id") Long foodId, Model model) {
        foodRepository.deleteById(foodId);
        return "redirect:../foodlist";
    }

    //edit food item details (already in menu) 
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editFood(@PathVariable("id") Long foodId, Model model) {
        model.addAttribute("food", foodRepository.findById(foodId));
        return "editFood";
    }

    
}
