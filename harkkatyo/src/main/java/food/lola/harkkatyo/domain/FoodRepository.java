package food.lola.harkkatyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import food.lola.harkkatyo.model.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {
    List<Food> findByDish(String dish);
}

