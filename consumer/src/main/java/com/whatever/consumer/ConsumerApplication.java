package com.whatever.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Consumer Application
 */
@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main( String[] args )
    {
        logger.debug("main() started.");

        // Disable the banner
        SpringApplication app = new SpringApplication(ConsumerApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.debug("run() started.");
    }


}
