package io.ar.metechium;

import io.ar.metechium.domain.StartupRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VeggieApplication {

    private static Logger logger = LoggerFactory.getLogger("VeggieApplication");

    public static void main(String[] args) {
        SpringApplication.run(VeggieApplication.class);
    }

    //to run a specific code once the springBoot application has started
    @Bean
    public StartupRunner schedulerRunner() {
        return new StartupRunner();
    }

}
