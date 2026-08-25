package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountFilterPage {
	WebDriver driver;
    // Search
   By searchBox =
    		By.xpath("//input[@type='search']");

    // Discount section
    By discountSection =
            By.cssSelector("[data-test-id='title:Discount']");

    // Discount checkboxes
    By discount40 =
            By.cssSelector(
                    "[data-test-id='filter-checkbox-discountRoundOff-40% and above']");

    By discount50 =
            By.cssSelector(
                    "[data-test-id='filter-checkbox-discountRoundOff-50% and above']");

 By discount60 =
            By.cssSelector(
                    "[data-test-id='filter-checkbox-discountRoundOff-60% and above']");

     By discount70 =
            By.cssSelector(
                    "[data-test-id='filter-checkbox-discountRoundOff-70% and above']");

 By discount80 =
            By.cssSelector(
                    "[data-test-id='filter-checkbox-discountRoundOff-80% and above']");

    // 40% and above filter count
  By discount40Count =
            By.xpath(
                    "//label[@data-test-id='filter-item-discountRoundOff-40% and above']"
                            + "//span[@data-test-id='filter-sidebar-desktop:count']");

    // Product titles
 By productTitles =
            By.cssSelector(
                    "[data-test-id='product-card:product-card:title']");

    // Product discount
  By productDiscounts =
            By.cssSelector(
                    "[data-test-id='product-card-product-card:discount']");


    // Getters
    public DiscountFilterPage(WebDriver driver)
	{
		this.driver=driver;
	}
    public WebElement getSearchBox() {
        return this.driver.findElement(this.searchBox);
    }
    public WebElement getDiscountSection() {
        return this.driver.findElement(this.discountSection);
    }

    public WebElement getDiscount40() {
        return this.driver.findElement(this.discount40);
    }


    public WebElement getDiscount50() {
        return this.driver.findElement(this.discount50);
    }


    public WebElement getDiscount60() {
        return this.driver.findElement(this.discount60);
    }


    public WebElement getDiscount70() {
        return this.driver.findElement(this.discount70);
    }


    public WebElement getDiscount80() {
        return this.driver.findElement(this.discount80);
    }


    public WebElement getDiscount40Count() {
        return this.driver.findElement(this.discount40Count);
    }


    public List<WebElement> getProductTitles() {
        return this.driver.findElements(this.productTitles);
    }


    public List<WebElement> getProductDiscounts() {
        return this.driver.findElements(this.productDiscounts);
    }
}
