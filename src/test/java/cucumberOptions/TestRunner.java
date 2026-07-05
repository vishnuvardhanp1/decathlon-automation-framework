package cucumberOptions;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = { "src//test//resources//features"},
glue= {"stepDefinitions","hooks" },tags="@AddToCart" )
/**
 * 
 */
public class TestRunner extends AbstractTestNGCucumberTests{

}