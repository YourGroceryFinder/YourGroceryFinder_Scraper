# YourGroceryFinder_Scraper
For the scraper i used the Jsoup library. Like most web scraper is consists of 3 main parts:
1. The HTTP Client. <br />
The HTTP Client is the part of a scraper where you define the web page you want to scrape from like seen in the code below.
```java
Document doc = Jsoup.connect("https://www.jumbo.com/producten/?offSet=" + i).get();
```
The i variable in this code stand for the number of the page to go to. 
The jumbo website has pages. This means that all the products are scattered over different pages. 
To overcome this problem i made a for loop. It starts at 0 and stops at the total amount of products are on the page(which is 18744 at this time).
Since there are 24 products on each page, every loop adds 24 to the 0.

2. The HTML Parser. <br />
With the HTML parser you indicate which part of the web page you want to scrape. 
In this case we start by selecting the product container, this whole item on the page:

![](https://i.imgur.com/n3yZsBT.png)

Then of that item you want to select the text, image and price. All of this is showed in the code below.

```java
 Elements products = doc.select(".product-container");

  // Print the text content of the links
  for (Element product : products) {
      String name = product.select(".title-link").text();
      String image = product.select(".image").attr("src");
      String price = product.select(".whole").text() +"."+ product.select(".fractional").text();
  }
```
3. Data Storage. <br />
Then when you get the data, you want to store it. This is done via the ```InsertNewProducts()``` function from our database.
```java
_db.InsertNewProducts(name, image, price, "Jumbo");
```
