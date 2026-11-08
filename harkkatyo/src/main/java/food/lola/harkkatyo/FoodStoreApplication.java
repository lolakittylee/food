package food.lola.harkkatyo;

//Lisää loggerin log-tulostusta varten
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;

// import food.lola.harkkatyo.domain.FoodRepository;
// import food.lola.harkkatyo.domain.FoodType;
import food.lola.harkkatyo.domain.FoodTypeRepository;
// import food.lola.harkkatyo.model.Food;


@SpringBootApplication
public class FoodStoreApplication {

	private final FoodTypeRepository foodTypeRepository;

    FoodStoreApplication(FoodTypeRepository foodTypeRepository) {
        this.foodTypeRepository = foodTypeRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(FoodStoreApplication.class, args);
	}

}
