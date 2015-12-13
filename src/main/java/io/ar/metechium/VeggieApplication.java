package io.ar.metechium;


import io.ar.metechium.domain.Vegetable;
import io.ar.metechium.service.VegetableRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeggieApplication {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger("VeggieApplication");


    public static void main(String[] args) {

        SpringApplication.run(VeggieApplication.class);
    }
    @Bean
    public CommandLineRunner demo(VegetableRepository vegetableRepository) {
        return args -> {
            // save couple of vegetables;
            vegetableRepository.save(new Vegetable("onions", "red", 2));
            vegetableRepository.save(new Vegetable("avocado", "green", 4));
            vegetableRepository.save(new Vegetable("lettuce", "green", 1));
            vegetableRepository.save(new Vegetable("carrot", "orange", 3));

            // fetch all vegetables
            logger.info("Vegetables using CrudRepository findAll()");
            logger.info("-------------------------------------------");
            for (Vegetable veg : vegetableRepository.findAll()) {
                logger.info(String.format("%d: {%s, %s, %d}\n", veg.getId(), veg.getName(), veg.getColor(), veg.getPrice()));
            }
            logger.info("-------------------------------------------");
            logger.info("Vegetables using CrudRepository findOne()");
            logger.info("-------------------------------------------");
            Vegetable veg = vegetableRepository.findOne(1L);
            logger.info(String.format("%d: {%s, %s, %d}\n", veg.getId(), veg.getName(), veg.getColor(), veg.getPrice()));

            logger.info("-------------------------------------------");
            logger.info("Vegetables using our own defined findByName");
            logger.info("-------------------------------------------");
            for (Vegetable vegg : vegetableRepository.findByName("avocado")) {
                logger.info(String.format("%d: {%s, %s, %d}\n", vegg.getId(), vegg.getName(), vegg.getColor(), vegg.getPrice()));
            }
        };
    }
}
