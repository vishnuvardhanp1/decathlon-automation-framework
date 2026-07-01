/**
 * 
 */
package selenium;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 */
public class DecathlonSearchTest2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.decathlon.in/");

        Thread.sleep(5000);

        // Search for Backpack
        driver.findElement(By.xpath("//input[@type='search']"))
              .sendKeys("nutrition", Keys.ENTER);

        Thread.sleep(5000);

        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL : " + driver.getCurrentUrl());
        
        driver.findElement(By.xpath("//span[@data-test-id='title:Brand']")).click();
        Thread.sleep(1000);
        driver.findElement(
        	    By.xpath("//input[@data-test-id='filter-checkbox-manufacturer_en-Decathlon']")
        	).click();
        WebElement maxSlider = driver.findElement(
        	    By.xpath("//div[@data-test-id='filter-sidebar-desktop:slider-thumb-max-outer']")
        	);
        WebElement maxPrice = driver.findElement(
        	    By.xpath("//input[@data-test-id='filter-sidebar-desktop:max-price-input']")
        	);

        	// Create Actions object
        Actions actions = new Actions(driver);

        while (true) {

           String value = maxPrice.getAttribute("value");

            System.out.println(value);

            int price = Integer.parseInt(value.replaceAll("[^0-9]", ""));

            System.out.println("Current Price : " + price);

            if (price <= 250) {
                break;
            }
            actions.clickAndHold(maxSlider)
                   .moveByOffset(-5, 0)
                   .release()
                   .perform();
            Thread.sleep(300);
        }
        	 Thread.sleep(5000);
        	 List<WebElement> prices = driver.findElements(
        			    By.xpath("//div[@data-test-id='product-card-product-card:selling-price']")
        			);
        	 for (WebElement priceElement : prices) {

        		    String priceText = priceElement.getText();

        		    int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));

        		    if (price <= 250) {
        		        System.out.println("PASS : ₹" + price);
        		    } else {
        		        System.out.println("FAIL : ₹" + price);
        		    }
        		}
        	 Thread.sleep(5000);
        	 List<WebElement> brands = driver.findElements(
        			    By.xpath("//span[@data-test-id='product-card:product-card:brand']")
        			);

        	 for (WebElement brand : brands) {

        		    String actualBrand = brand.getText().trim();

        		    if (actualBrand.equalsIgnoreCase("Decathlon")) {
        		        System.out.println("PASS : " + actualBrand);
        		    } else {
        		        System.out.println("FAIL : " + actualBrand);
        		    }
        		}
        	 Thread.sleep(5000);
        	 driver.quit();
	}

}
