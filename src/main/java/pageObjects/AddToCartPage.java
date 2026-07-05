package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {
	WebDriver driver;
	
	By searchBar=By.xpath("//input[@type='search']");
	By slider=By.xpath("//div[@data-test-id='filter-sidebar-desktop:slider-thumb-max-outer']");
	By maxPrice=By.xpath("//input[@data-test-id='filter-sidebar-desktop:max-price-input']");
	By productName = By.xpath("//a[@data-test-id='product-card-link' and contains(.,'Granola Bar Cashew Berry "
			+ "- Healthy Nutrition Energy & Breakfast Bar')]//div[@data-test-id='product-card:product-card:title']");
	By sellingPrice = By.xpath("//a[@data-test-id='product-card-link'"
			+ " and contains(.,'Granola Bar Cashew Berry - Healthy Nutrition Energy & Breakfast Bar')]"
			+ "//div[@data-test-id='product-card-product-card:selling-price']");
	By mrp = By.xpath("//a[@data-test-id='product-card-link' "
			+ "   and contains(.,'Granola Bar Cashew Berry - Healthy Nutrition Energy & Breakfast Bar')]"
			+ "//div[@data-test-id='product-card-product-card:mrp']");
	By firstProduct =By.xpath("//a[@data-test-id='product-card-link' and contains(@aria-label,'Granola Bar Cashew Berry')]");
	
	By firstColor = By.xpath("(//img[@data-test-id='pdp-color-selector-desktop:option-image'])[1]");
	By pincode = By.xpath("//span[@data-test-id='pdp-delivery-options-desktop:pincode-value']");
	By addToCartButton = By.xpath("//button[@data-test-id='pdp:add-to-cart-button']");
	By addToCartButtonPLP = By.xpath("//button[@data-test-id='add-to-cart-button']");
	By cartCountBadge = By.xpath("//span[@data-test-id='header-desktop:cart-count-badge']");
	
	By cartIcon = By.xpath("//span[@data-test-id='header-desktop-cart:text']");
	By productAddedToast = By.xpath("//h3[text()='Product(s) added to cart']");
	By increaseQty =  By.xpath("//button[@data-test-id='qty-increase-button']");
	By quantity = By.xpath("//span[@data-test-id='qty-display']");
	By cartTotalPrice = By.xpath("//div[@data-test-id='cart:cart-checkout-total-price']");
	By cartProductPrice = By.xpath("//span[@data-test-id='cart:product-selling-price']");
	By cartDiscount = By.xpath("//div[@data-test-id='cart:cart-checkout-discount']");
	By cartSubTotal = By.xpath("//div[@data-test-id='cart:cart-checkout-total-cart-value']/p");
	
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public int getCartCount() {

		 List<WebElement> badges = driver.findElements(cartCountBadge);

		    if (badges.isEmpty()) {
		        return 0;
		    }

		    return Integer.parseInt(badges.get(0).getText().trim());
	}
	
	public By getProductAddedToast() {
	    return productAddedToast;
	}
	public WebElement getSearchBar() {
		return this.driver.findElement(this.searchBar);
	}
	public WebElement getSlider() {
	    return driver.findElement(slider);
	}

	public WebElement getMaxPrice() {
		return this.driver.findElement(this.maxPrice);
	}
	public WebElement getSellingPrice() {
		 return driver.findElement(this.sellingPrice);
	}
	public WebElement GetMRP() {
		 return driver.findElement(this.mrp);
	}
	public WebElement getProduct() {
		
		return this.driver.findElement(this.firstProduct);
	}
	public WebElement getProductName() {
		
		return this.driver.findElement(this.productName);
	}
	
	public WebElement getColor() {
		return this.driver.findElement(this.firstColor);
	}
	public WebElement getPincode() {
		return this.driver.findElement(this.pincode);
	}
	public WebElement getAddToCart() {

	  /*  By addToCart = By.xpath(
	        "//a[@data-test-id='product-card-link' and contains(.,\"" + productName + "\")]//button[@data-test-id='add-to-cart-button']");

	    return driver.findElement(addToCart);*/
		return this.driver.findElement(this.addToCartButton);
	}
	public int getCartCountBadge() {
	    return Integer.parseInt(driver.findElement(cartCountBadge).getText().trim());
	}
	
	public WebElement getCartIcon() {
		return this.driver.findElement(this.cartIcon);
	}
	public WebElement getIncreaseQuantity() {
		return this.driver.findElement(this.increaseQty);
	}
	
	public WebElement getCartTotalPrice() {
		return this.driver.findElement(this.cartTotalPrice);
	}
	public WebElement getCartProductPrice() {
		return this.driver.findElement(this.cartProductPrice);
	}
	public WebElement getCartDiscount() {
		return this.driver.findElement(this.cartDiscount);
	}
	public WebElement getCartSubTotal() {
		return this.driver.findElement(this.cartSubTotal);
	}
	public WebElement getQuantity() {
		return this.driver.findElement(this.quantity);
	}
}
