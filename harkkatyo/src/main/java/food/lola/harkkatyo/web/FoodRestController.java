package food.lola.harkkatyo.web;

import java.util.Optional;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import food.lola.harkkatyo.model.Food;
import food.lola.harkkatyo.domain.FoodRepository;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class FoodRestController {
    
    private final FoodRepository foodRepository;

    public FoodRestController(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    // returns all foods
    @GetMapping("/foods")
    public Iterable<Food> findAllFoods() {
        return foodRepository.findAll();
    }

    // looking up a food item by ID
    @GetMapping("/food/{id}")
    public Optional<Food> findById(@PathVariable Long id) {
        return foodRepository.findById(id);
    }

}
