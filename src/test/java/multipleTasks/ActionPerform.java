package multipleTasks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionPerform {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	@Before
	public void setPath()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		
		driver.navigate().to("https://www.meesho.com/");
		
		act = new Actions(driver);
		wait = new WebDriverWait(driver,20);
		
	}
	
	@Test
	public void Action() throws InterruptedException
	{
		WebElement downloadAppEle = driver.findElement(By.xpath("//span[text()='Download App']"));
		wait.until(ExpectedConditions.visibilityOf(downloadAppEle));
		downloadAppEle.click();
		
		WebElement profileEle = driver.findElement(By.xpath("//div[@class='sc-jSUZER igEZJF TabWrapper-sc-1edf3ww-0 Header__StyledProfileMenu-sc-1qdannb-2 kyKAmE HCCmz TabWrapper-sc-1edf3ww-0 Header__StyledProfileMenu-sc-1qdannb-2 kyKAmE HCCmz']"));
		profileEle.click();
		
		WebElement WomenEthicEle = driver.findElement(By.xpath("//span[text()='Women Ethnic']"));
		
		act.moveToElement(WomenEthicEle).build().perform();
		Thread.sleep(1000);
		
		WebElement WomenWesternEle = driver.findElement(By.xpath("//span[text()='Women Western']"));
		
		act.moveToElement(WomenWesternEle).build().perform();
		Thread.sleep(1000);
		WebElement MenEle = driver.findElement(By.xpath("//span[text()='Men']"));
		
		act.moveToElement(MenEle).build().perform();
		Thread.sleep(1000);
		WebElement KidsEle = driver.findElement(By.xpath("//span[text()='Kids']"));
		
		act.moveToElement(KidsEle).build().perform();
		Thread.sleep(1000);
		WebElement HomeKitchenEle = driver.findElement(By.xpath("//span[text()='Home & Kitchen']"));
		
		act.moveToElement(HomeKitchenEle).build().perform();
		Thread.sleep(1000);
		WebElement BeautyHealthEle = driver.findElement(By.xpath("//span[text()='Beauty & Health']"));
		
		act.moveToElement(BeautyHealthEle).build().perform();
		Thread.sleep(1000);
		WebElement JewelleryAccessoriesEle = driver.findElement(By.xpath("//span[text()='Jewellery & Accessories']"));
		
		act.moveToElement(JewelleryAccessoriesEle).build().perform();
		Thread.sleep(1000);
		WebElement BagsFootwearEle = driver.findElement(By.xpath("//span[text()='Bags & Footwear']"));
		
		act.moveToElement(BagsFootwearEle).build().perform();
		Thread.sleep(1000);
		
		WebElement ElectronicsEle = driver.findElement(By.xpath("//span[text()='Electronics']"));
		ElectronicsEle.click();
		Thread.sleep(1000);
		
		WebElement SubOptionSmartwatchEle = driver.findElement(By.xpath("//p[text()='Smartwatches']"));
		
		/**
		 * This Print Statement Is used For Check The Color of Text
		 * For Checking Font Size
		 * For Checking Font Family
		 */
		
		System.out.println("The Font Colour Is : " +SubOptionSmartwatchEle.getCssValue("color"));
		
		String ActualColorOfText = SubOptionSmartwatchEle.getCssValue("color");
		
		System.out.println("After Converting The Text \"Smart Watches\" The Color Should be : " +CovertRGBAtoHex(ActualColorOfText));
		
		System.out.println("The Font Size Is : " +SubOptionSmartwatchEle.getCssValue("font-size"));
		
	   // Assert.assertEquals("24px",SubOptionSmartwatchEle.getCssValue("font-size"));
	    
	    System.out.println("The font Family Name Is : " +SubOptionSmartwatchEle.getCssValue("font-family"));
		
		System.out.println("The Test Is : " +SubOptionSmartwatchEle.getText());
		
		//Assert.assertEquals("Smart Watches", SubOptionSmartwatchEle.getText());
		
		WebElement color = driver.findElement(By.xpath("//span[text()='Color']"));
		color.click();
		
		List<WebElement> ListOfColorEle = driver.findElements(By.xpath("//div[@class='DeskopSortFilterStyled__StyledCard-sc-18gw3z1-6 dhauwt']//span"));
		
		System.out.println("The colour size is : " +ListOfColorEle.size());
		
		for(int i=0; i<ListOfColorEle.size();i++)
		{
			System.out.println(ListOfColorEle.get(i).getText());
		}
		List<WebElement> ListOfColorEle1 = driver.findElements(By.xpath("//div[@class='DeskopSortFilterStyled__StyledCard-sc-18gw3z1-6 dhauwt']//span"));
	
		for(int i=0; i<ListOfColorEle1.size();i++)
		if(ListOfColorEle1.get(i).getText().equalsIgnoreCase("Blue"))
		{
			Assert.assertTrue(true);
			System.out.println("This Colour Wachtches are Available ");
			ListOfColorEle1.get(i).click();
			Thread.sleep(2000);
			break;	
		}
	}	
	
	public static String CovertRGBAtoHex(String rgbaColor)
	{
		return Color.fromString(rgbaColor).asHex();
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
