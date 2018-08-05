package com.whatever;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;

@SpringBootApplication   // Equivalent to @Configuration, @EnableAutoConfiguration, and @ComponentScan
@EnableScheduling
public class SpringBootKafkaApp implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootKafkaApp.class);

    @Value("${app.mode}")
    private String appMode;

    /*****************************************************************
     * main() first entry point of this java program
     *****************************************************************/
    public static void main(String[] args) throws Exception {
        logger.debug("main started.");

        // Disabled the banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootKafkaApp.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


    /*****************************************************************
     * init() called is called before the run() method
     *****************************************************************/
    @PostConstruct
    private void init(){
        logger.debug("app.mode={}", this.appMode);
    }

    /*****************************************************************
     * run() with args is called next
     *****************************************************************/
    @Override
    public void run(String... args) throws Exception {
        logger.debug("run() started.");

        logger.debug("run() finished.");
    }


    /*****************************************************************
     * run()
     *   initialDelay and fixedRate are in milliseconds
     *   this method is called once every 5 seconds
     *****************************************************************/
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void run() {
        logger.debug("run() called from scheduler.");
    }
}
