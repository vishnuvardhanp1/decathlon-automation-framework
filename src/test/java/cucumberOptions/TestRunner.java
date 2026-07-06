package cucumberOptions;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = { "src//test//resources//features"},
glue= {"stepDefinitions","hooks" },tags="@PriceBrandFilter or @AddToCart" 
,

plugin = {

        "pretty",

        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"

})
/**
 * 
 */
public class TestRunner extends AbstractTestNGCucumberTests{

}