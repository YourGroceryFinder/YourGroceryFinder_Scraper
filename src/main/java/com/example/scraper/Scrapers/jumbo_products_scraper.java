package com.example.scraper.Scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class jumbo_products_scraper {
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
                String price = product.select(".whole").text() +"."+ product.select(".fractional").text();

                System.out.println(name);
                System.out.println(image);
                System.out.println(price);
                //_db.InsertNewProducts(name, image, price, "Jumbo");
            }
        }
    }
}
