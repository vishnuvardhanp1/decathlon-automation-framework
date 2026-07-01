package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriceBrandFilterPage {
	WebDriver driver;
By searchBar=By.xpath("//input[@type='search']");
By brandsMenu=By.xpath("//span[@data-test-id='title:Brand']");
By brandSelected=By.xpath("//input[@data-test-id='filter-checkbox-manufacturer_en-Decathlon']");
By slider=By.xpath("//div[@data-test-id='filter-sidebar-desktop:slider-thumb-max-outer']");
By price=By.xpath("//input[@data-test-id='filter-sidebar-desktop:max-price-input']");
By prices=By.xpath("//div[@data-test-id='product-card-product-card:selling-price']");
By brands=By.xpath("//span[@data-test-id='product-card:product-card:brand']");

public PriceBrandFilterPage(WebDriver driver)
{
	this.driver=driver;
}

public WebElement getSearchBar() {
	return this.driver.findElement(this.searchBar);
}

public WebElement getBrandsMenu() {
	return this.driver.findElement(this.brandsMenu);
}

public WebElement getBrandSelected() {
	return this.driver.findElement(this.brandSelected);
}

public WebElement getSlider() {
    return driver.findElement(slider);
}

public WebElement getPrice() {
	return this.driver.findElement(this.price);
}

public List<WebElement> getPrices() {
	return this.driver.findElements(this.prices);
}

public List<WebElement> getBrands() {
	return this.driver.findElements(this.brands);
}
}
