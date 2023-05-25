package com.example.scraper.Scrapers;

import com.example.scraper.Classes.Product;
import com.example.scraper.Classes.ProductService;
import com.example.scraper.DAL.ProductRepository;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "api/v1/students")
@AllArgsConstructor
public class jumbo_products_scraper {

    private final ProductService productService;

    @GetMapping
    public void JumboProducts() throws IOException{
        for(int i = 0; i <= 18744; i += 24){
            // Parse an HTML document from a URL
            Document doc = Jsoup.connect("https://www.jumbo.com/producten/?offSet=" + i).get();

            // Extract links from the document
            Elements products = doc.select(".product-container");

            // Print the text content of the links
            for (Element product : products) {
                String name = product.select(".title-link").text();
                String image = product.select(".image").attr("src");
                Double price = Double.parseDouble(product.select(".whole").text() +"."+ product.select(".fractional").text());

                System.out.println(name);
                System.out.println(image);
                System.out.println(price);

                Product itemProduct = new Product(name, image, price, "Jumbo");

                productService.AddUser(itemProduct);

                //_db.InsertNewProducts(name, image, price, "Jumbo");
            }
        }
    }
}
