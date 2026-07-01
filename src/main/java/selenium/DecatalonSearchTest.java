/**
 * 
 */
package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */
public class DecatalonSearchTest {

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
              .sendKeys("Backpack", Keys.ENTER);

        Thread.sleep(5000);

        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL : " + driver.getCurrentUrl());
        driver.findElement(By.xpath("//span[@data-test-id='title:Gender']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@data-test-id='filter-checkbox-gender_id_en-MEN']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//img[@alt='50 L Trekking Backpack - MT100']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@data-test-id='pdp:add-to-cart-button']")).click();
        Thread.sleep(5000);
        driver.quit();
	}

}
