package io.ar.metechium.domain;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by lakue on 04-Jan-16.
 * class to run specific code once the SpringApplication has started
 */
public class StartupRunner implements CommandLineRunner {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger("StartupRunner");

    @Autowired
    private VegetableRepository vegetableRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Startup Runner in action");
//        // save couple of vegetables;
//        vegetableRepository.save(new Vegetable("onions", "red", 2));
//        vegetableRepository.save(new Vegetable("avocado", "green", 4));
//        vegetableRepository.save(new Vegetable("lettuce", "green", 1));
//        vegetableRepository.save(new Vegetable("carrot", "orange", 3));
//
//        // fetch all vegetables
//        logger.info("Vegetables using CrudRepository findAll()");
//        logger.info("-------------------------------------------");
//        for (Vegetable veg : vegetableRepository.findAll()) {
//            logger.info(String.format("%d: {%s, %s, %d}\n", veg.getId(), veg.getName(), veg.getColor(), veg.getPrice()));
//        }
//        logger.info("-------------------------------------------");
//        logger.info("Vegetables using CrudRepository findOne()");
//        logger.info("-------------------------------------------");
//        Vegetable veg = vegetableRepository.findOne(1L);
//        logger.info(String.format("%d: {%s, %s, %d}\n", veg.getId(), veg.getName(), veg.getColor(), veg.getPrice()));
//
//        logger.info("-------------------------------------------");
//        logger.info("Vegetables using our own defined findByName");
//        logger.info("-------------------------------------------");
//        for (Vegetable vegg : vegetableRepository.findByName("avocado")) {
//            logger.info(String.format("%d: {%s, %s, %d}\n", vegg.getId(), vegg.getName(), vegg.getColor(), vegg.getPrice()));
//        }
    }

    //example of scheduling executors
    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run() {
        logger.info("Number of fresh vegetables: " + vegetableRepository.count());
    }
}
