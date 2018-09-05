package com.whatever.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * Consumer Application
 *
 */
@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner
{
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Resource
    private Dao dao;

    @Resource
    private MyProducer reportsProducer;


    public static void main( String[] args )
    {
        logger.debug("main() started.");

        // Disabled the banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.debug("run() started.");

    }



    /*****************************************************************
     * run()
     *   initialDelay and fixedRate are in milliseconds
     *   this method is called once every 2 seconds
     *****************************************************************/
    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void run() {
        logger.debug("run() called from scheduler.");
        String updates = dao.getUpdates();

        reportsProducer.send("updates", updates);
    }


}
