package stepDefinitions;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.AddToCartPage;
import pageObjects.DiscountFilterPage;
import base.Base;
public class DiscountFilterStepDefinition extends Base {
	private static final Logger logger =
			LogManager.getLogger(DiscountFilterStepDefinition.class);
	DiscountFilterPage discountFilterPage;
	
	
    @Given("User launches the Decathlon application")
    public void user_launches_the_decathlon_application()  {
    	 try {
             Thread.sleep(5000);

             getDriver().get(getFrameworkUrl());

             if (discountFilterPage == null) {
                 discountFilterPage =
                         new DiscountFilterPage(getDriver());
             }

         } catch (Exception e) {
        	 logger.error("Exception occurred", e);
     		Assert.fail(e.getMessage());
    }
    }

    @When("User search for {string}")
    public void user_searches_for(String product) {
    	 try {
             Thread.sleep(5000);

             getDriver().get(getFrameworkUrl());

             if (discountFilterPage == null) {
                 discountFilterPage =
                         new DiscountFilterPage(getDriver());
             }
            discountFilterPage
             .getSearchBox().sendKeys(product, Keys.ENTER);

         } catch (Exception e) {
        	 logger.error("Exception occurred", e);
     		Assert.fail(e.getMessage());
    }
    }
    
    @When("User opens the Discount filter")
    public void user_opens_the_discount_filter() {
    	  try {
    	        Thread.sleep(2000);

    	       discountFilterPage.getDiscountSection().click();

    	        Thread.sleep(2000);

    	    } catch (InterruptedException e) {
    	    	logger.error("Exception occurred", e);
         		Assert.fail(e.getMessage());
    	    }
    }

    @When("User selects the {string} discount filter")
    public void user_selects_the_discount_filter(String discount) {
    	  try {
    	        Thread.sleep(2000);

    	        if (discount.equalsIgnoreCase("40% and above")) {
    	            discountFilterPage.getDiscount40().click();
    	        }

    	        Thread.sleep(3000);

    	    } catch (InterruptedException e) {
    	        logger.error("Exception occurred", e);
    	        Assert.fail(e.getMessage());
    	    }
    }

    @Then("All applicable discount options from 40% and above should be selected")
    public void all_applicable_discount_options_from_40_percent_and_above_should_be_selected() {

        try {
            Thread.sleep(2000);

            Assert.assertTrue(
                    discountFilterPage.getDiscount40().isSelected(),
                    "40% and above discount option is not selected"
            );

            Assert.assertTrue(
                    discountFilterPage.getDiscount50().isSelected(),
                    "50% and above discount option is not selected"
            );

            Assert.assertTrue(
                    discountFilterPage.getDiscount60().isSelected(),
                    "60% and above discount option is not selected"
            );

            Assert.assertTrue(
                    discountFilterPage.getDiscount70().isSelected(),
                    "70% and above discount option is not selected"
            );

            Assert.assertTrue(
                    discountFilterPage.getDiscount80().isSelected(),
                    "80% and above discount option is not selected"
            );

        } catch (InterruptedException e) {
            logger.error("Exception occurred", e);
            Assert.fail(e.getMessage());
        }
    }

   

    @Then("Every displayed bag should have a discount of 40% or above")
    public void every_displayed_bag_should_have_a_discount_of_40_percent_and_above() {

        try {
            Thread.sleep(3000);

            List<WebElement> discounts =
                    discountFilterPage.getProductDiscounts();

            Assert.assertTrue(
                    discounts.size() > 0,
                    "No discounted products are displayed"
            );

            for (WebElement discount : discounts) {

                String discountText = discount.getText();

                int discountValue = Integer.parseInt(
                        discountText.replaceAll("[^0-9]", "")
                );

                Assert.assertTrue(
                        discountValue >= 40,
                        "Product has discount of "
                                + discountValue
                                + "%, expected 40% or above"
                );
            }

        } catch (InterruptedException e) {
            logger.error("Exception occurred", e);
            Assert.fail(e.getMessage());
        }
    }
}
