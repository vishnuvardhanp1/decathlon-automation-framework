package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.Base;
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
		 	getDriver().manage().window().maximize();
		    Thread.sleep(5000);
		    addToCartPage = new AddToCartPage(getDriver());
		    addToCartPage.getSearchBar().sendKeys(string, Keys.ENTER);
		    Thread.sleep(5000);

	        logger.info("Title : " + getDriver().getTitle());
	        logger.info("URL : " + getDriver().getCurrentUrl());
	}
	catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	logger.debug("Exception occurred:"+ex.getMessage());
	}
	}
	@When("User selects the maximum price filter less than {string}")
	public void user_selects_the_maximum_price_filter_less_than(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User applies the maximum price filter as {string}");
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
		    
		    WebElement maxSlider=addToCartPage.getSlider();
		  
		    WebElement maxPrice=addToCartPage.getMaxPrice();
		    Thread.sleep(5000);
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
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	@When("User clicks the product {string}")
	public void user_clicks_the_product(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User selects the product" + string);
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
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
				Thread.sleep(5000);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	
	
	@When("User clicks Add to Cart button in product details page")
	public void user_clicks_add_to_cart_button() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User adds the product to the cart");
		
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
			addToCartPage.getAddToCart().click();
			
			
	
			
			Thread.sleep(5000);
		
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	@Then("User clicks on view cart icon")
	public void validate_correct_item_is_added() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Validate correct item is added");
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
			addToCartPage.getCartIcon().click();
			Thread.sleep(5000);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	
	@When("User increases quantity to {string}")
	public void user_increases_quantity_to(String string) {
		logger.info("Validate correct item is added");
		try {
			addToCartPage=new AddToCartPage(getDriver());
			int intialQuantity=Integer.parseInt(addToCartPage.getQuantity().getText());
			//String qty=string;
		 	int IncQty=Integer.parseInt(string);
		 	for(int i=0;i<IncQty;i++) {
		 		addToCartPage.getIncreaseQuantity().click();
		 		Thread.sleep(3000);
		 	}
		 	IncQty=IncQty+intialQuantity;
		 	quantity=String.valueOf(IncQty);
		 	
			Thread.sleep(5000);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	
	@Then("Validate correct quantity is added")
	public void validate_correct_quantity_added() {
		logger.info("Validate correct item is added");
		try {
			addToCartPage=new AddToCartPage(getDriver());
			
			
		 	int actualCount=Integer.parseInt(addToCartPage.getQuantity().getText());
		 	logger.info("Expected Cart Count : " + quantity);
		    logger.info("Actual Cart Count : " + actualCount);
		 	Assert.assertTrue(quantity.equals(String.valueOf(actualCount)));
			Thread.sleep(5000);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	
	@Then("Validate selling price,discount,mrp")
	public void validate_selling_price_discount_mrp() {
		logger.info("Validate correct item is added");
		try {
		int qty=Integer.parseInt(quantity);
		int totalSellingPrice=qty*sellingPrice;
		int totalPrice=qty*mrp;
		int discount=totalPrice - totalSellingPrice;
		
		logger.info("totalSellingPrice : " + totalSellingPrice);
	    logger.info("totalPrice : " + totalPrice);
	    logger.info("discount : " + discount);
	  
	    
	    logger.info("totalSellingPrice : " + addToCartPage.getPrice(addToCartPage.getCartProductPrice().getText()));
	    logger.info("totalPrice : " + addToCartPage.getPrice(addToCartPage.getCartTotalPrice().getText()));
	    logger.info("discount : " + addToCartPage.getPrice(addToCartPage.getCartDiscount().getText()));

	    Assert.assertEquals(addToCartPage.getPrice(addToCartPage.getCartProductPrice().getText()), totalSellingPrice);
	    Assert.assertEquals(addToCartPage.getCartTotalPriceValue(), totalPrice);
	    Assert.assertEquals(addToCartPage.getPrice(addToCartPage.getCartDiscount().getText()), discount);
	    

	   
		Thread.sleep(5000);
		}catch(Exception ex)
		{
			 ex.printStackTrace();
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	/*@Then("Validate correct quantity is added")
	public void validate_correct_quantity_is_added() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("Validate correct quantity is added");
		try {
			Thread.sleep(5000);
			addToCartPage=new AddToCartPage(getDriver());
			
		   int actualCount = addToCartPage.getCartCountBadge();
		   addToCartPage.getCartIcon().click();
			 logger.info("Expected Cart Count : " + quantity);
			    logger.info("Actual Cart Count : " + actualCount);
			    Assert.assertTrue(quantity.equals(actualCount));

			    logger.info("Expected Cart Count : " + quantity);
			    logger.info("Actual Cart Count : " + actualCount);
			    Thread.sleep(5000);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}*/
/*	@When("User increases the product quantity to {string}")
	public void user_increases_the_product_quantity_to(String string) {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User increases the product quantity to " + string);
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	@Then("User verifies the cart selling price is equal to product selling price multiplied by quantity")
	public void user_verifies_the_cart_selling_price_is_equal_to_product_selling_price_multiplied_by_quantity() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User verifies the cart selling price is equal to product selling price multiplied by quantity");
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	@Then("User verifies the cart MRP is equal to product MRP multiplied by quantity")
	public void user_verifies_the_cart_mrp_is_equal_to_product_mrp_multiplied_by_quantity() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User verifies the cart MRP is equal to product MRP multiplied by quantity");
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	@Then("User verifies the cart discount is displayed correctly")
	public void user_verifies_the_cart_discount_is_displayed_correctly() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User verifies the cart discount is displayed correctly");
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}
	@Then("User verifies the cart total is equal to cart MRP minus discount")
	public void user_verifies_the_cart_total_is_equal_to_cart_mrp_minus_discount() {
	    // Write code here that turns the phrase above into concrete actions
		logger.info("User verifies the cart total is equal to cart MRP minus discount");
		try {
		 	
			addToCartPage=new AddToCartPage(getDriver());
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		logger.debug("Exception occurred:"+ex.getMessage());
		
		}
	}*/
}
