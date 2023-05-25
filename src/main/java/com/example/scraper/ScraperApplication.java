package com.example.scraper;

import com.example.scraper.DAL.ProductRepository;
import com.example.scraper.Scrapers.jumbo_products_scraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ScraperApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ScraperApplication.class, args);
    }

}
