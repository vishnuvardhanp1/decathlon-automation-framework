package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddToCartPage;


public class AddToCartStep  extends Base {
	private static final Logger logger =
			LogManager.getLogger(AddToCartStep.class);
	AddToCartPage addToCartPage;
	String productName;
	String quantity;
	int sellingPrice;
	int mrp;
	@When("User searches for {string} category")
	public void user_searches_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try {
		 	Thread.sleep(5000);
		 	getDriver().get(this.getFrameworkUrl());
		 	//getDriver().manage().window().maximize();
		   // Thread.sleep(5000);
		    if(addToCartPage == null){
		        addToCartPage = new AddToCartPage(getDriver());
		    }
		    addToCartPage.getSearchBar().sendKeys(string, Keys.ENTER);

		    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

		    wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//div[@data-test-id='filter-sidebar-desktop:slider-thumb-max-outer']")));

		   // Thread.sleep(5000);

	        logger.info("Title : " + getDriver().getTitle());
	        logger.info("URL : " + getDriver().getCurrentUrl());
	}
	catch(Exception ex)
	{
		logger.error("Exception occurred", ex);
		Assert.fail(ex.getMessage());
	}
	}
	@And("User selects the maximum price filter less than {string}")
	public void user_selects_the_maximum_price_filter_less_than(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User applies the maximum price filter as {}", string);
		try {
		 	
			if(addToCartPage == null){
			    addToCartPage = new AddToCartPage(getDriver());
			}
		    
		    WebElement maxSlider=addToCartPage.getSlider();
		  
		    WebElement maxPrice=addToCartPage.getMaxPrice();
		   // Thread.sleep(5000);
		    Actions actions = new Actions(getDriver());

	        while (true) {

	           String value = maxPrice.getAttribute("value");

	            logger.info(value);

	            int price = Integer.parseInt(value.replaceAll("[^0-9]", ""));

	            logger.info("Current Price : " + price);
                int selectedPrice=Integer.parseInt(string);
	            if (price <= selectedPrice) {
	                break;
	            }
	            actions.clickAndHold(maxSlider)
	                   .moveByOffset(-40, 0)
	                   .release()
	                   .perform();
	           Thread.sleep(50);
	        }
	        	 Thread.sleep(5000);
	        logger.info("Title : " + getDriver().getTitle());
	        logger.info("URL : " + getDriver().getCurrentUrl());
		}
		catch(Exception ex)
		{
			logger.error("Exception occurred", ex);
			Assert.fail(ex.getMessage());
		}
	}
	@And("User clicks the product {string}")
	public void user_clicks_the_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User selects the product" + string);
		try {
		 	
			if(addToCartPage == null){
			    addToCartPage = new AddToCartPage(getDriver());
			}
			WebElement product=addToCartPage.getProductName();
			productName = product.getText()
                    .replace("DECATHLON", "")
                    .trim();
			logger.info("productName " + productName);
			if(productName.equals(string)) {
				sellingPrice=Integer.parseInt(
					    addToCartPage.getSellingPrice().getText()
		                 .replace("₹", "")
		                 .trim());
				mrp=Integer.parseInt(
					    addToCartPage.getMRP().getText()
		                 .replace("MRP", "")
		                 .replace("₹", "")
		                 .trim());
				logger.info("sellingPrice " + sellingPrice);
				logger.info("mrp " + mrp);
				
				addToCartPage.getProductName().click();
				 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
				    wait.until(ExpectedConditions.visibilityOf(addToCartPage.getAddToCart()));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			logger.error("Exception occurred", ex);
			Assert.fail(ex.getMessage());
		
		}
	}
	
	
	@And("User clicks Add to Cart button")
	public void user_clicks_add_to_cart_button() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User adds the product to the cart");
		
		try {
		 	
			if(addToCartPage == null){
			    addToCartPage = new AddToCartPage(getDriver());
			}
			addToCartPage.getAddToCart().click();
			
			
	
			
			
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOfElementLocated(
			addToCartPage.getProductAddedToast()));
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
			logger.error("Exception occurred", ex);
			Assert.fail(ex.getMessage());
		
		}
	}
	
	@And("User navigates to the cart")
	public void user_navigates_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Validate correct item is added");
		try {
		 	
			if(addToCartPage == null){
			    addToCartPage = new AddToCartPage(getDriver());
			}
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

			wait.until(ExpectedConditions.invisibilityOfElementLocated(
			        addToCartPage.getProductAddedToast()));

			addToCartPage.getCartIcon().click();
			Thread.sleep(5000);
           
		}catch(Exception ex)
		{
			logger.error("Exception occurred", ex);
			Assert.fail(ex.getMessage());
		
		}
	}
	
	@And("User increases the quantity to {string}")
	public void user_increases_the_quantity_to(String string) {
		logger.info("Validate correct item is added");

		try {

		    if (addToCartPage == null) {
		        addToCartPage = new AddToCartPage(getDriver());
		    }

		    int initialQuantity = Integer.parseInt(addToCartPage.getQuantity().getText());
		    int incQty = Integer.parseInt(string);

		    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		    for (int i = 0; i < incQty; i++) {

		        int expectedQuantity = initialQuantity + i + 1;

		        addToCartPage.getIncreaseQuantity().click();

		        wait.until(ExpectedConditions.textToBePresentInElement(
		                addToCartPage.getQuantity(),
		                String.valueOf(expectedQuantity)));
		    }

		    quantity = String.valueOf(initialQuantity + incQty);
		    Thread.sleep(5000);

		} catch (Exception ex) {
		
			logger.error("Exception occurred", ex);
			Assert.fail(ex.getMessage());
		
		}
	}
	
	@Then("The cart should display correct quantity")
	public void the_cart_should_display_correct_quantity() {
		logger.info("Validate correct item is added");
		try {
			if(addToCartPage == null){
			    addToCartPage = new AddToCartPage(getDriver());
			}

		    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		    wait.until(ExpectedConditions.textToBePresentInElement(
		            addToCartPage.getQuantity(),
		            quantity));

			
		 	int actualCount=Integer.parseInt(addToCartPage.getQuantity().getText());
		 	logger.info("Expected Cart Count : " + quantity);
		    logger.info("Actual Cart Count : " + actualCount);
		    Assert.assertEquals(actualCount, Integer.parseInt(quantity));
			Thread.sleep(5000);
		}catch(Exception ex)
		{
			logger.error("Exception occurred", ex);
			Assert.fail(ex.getMessage());
		
		}
	}
	
	@And("The cart should display the correct selling price, MRP, discount and total price")
	public void validate_selling_price_discount_mrp() {
		logger.info("Validate correct item is added");

		try {

		    int qty = Integer.parseInt(quantity);

		    int totalSellingPrice = qty * sellingPrice;
		    int totalPrice = qty * mrp;
		    int discount = totalPrice - totalSellingPrice;

		    logger.info("Expected Selling Price : {}", totalSellingPrice);
		    logger.info("Expected Total Price : {}", totalPrice);
		    logger.info("Expected Discount : {}", discount);

		    if (addToCartPage == null) {
		        addToCartPage = new AddToCartPage(getDriver());
		    }

		    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		    // Wait until cart total is updated
		    wait.until(ExpectedConditions.textToBePresentInElement(
		            addToCartPage.getCartTotalPrice(),
		            String.valueOf(totalPrice)));

		    logger.info("Actual Selling Price : {}",
		            addToCartPage.getPrice(addToCartPage.getCartProductPrice().getText()));

		    logger.info("Actual Total Price : {}",
		            addToCartPage.getCartTotalPriceValue());

		    logger.info("Actual Discount : {}",
		            addToCartPage.getPrice(addToCartPage.getCartDiscount().getText()));

		    Assert.assertEquals(
		            addToCartPage.getPrice(addToCartPage.getCartProductPrice().getText()),
		            totalSellingPrice);

		    Assert.assertEquals(
		            addToCartPage.getCartTotalPriceValue(),
		            totalPrice);

		    Assert.assertEquals(
		            addToCartPage.getPrice(addToCartPage.getCartDiscount().getText()),
		            discount);

		} catch (Exception ex) {

		    logger.error("Exception occurred", ex);
		    Assert.fail(ex.getMessage());
		
		
		}
	}
	
}
