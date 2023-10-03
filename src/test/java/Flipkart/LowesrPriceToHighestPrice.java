package Flipkart;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LowesrPriceToHighestPrice {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		System.out.println("Launch Browser");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/watches/wrist-watches/pr?sid=r18%2Cf13&otracker=categorytree&fm=neo%2Fmerchandising&iid=M_832158d0-9de1-4fd0-babc-e55a38e9c4bd_1_372UD5BXDFYS_MC.STURTSNOXQD2&otracker=hp_rich_navigation_1_1.navigationCard.RICH_NAVIGATION_Fashion%7EWatches%2Band%2BAccessories%7EMen%2B%2526%2BWomen%2BWatches_STURTSNOXQD2&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_1_L2_view-all&cid=STURTSNOXQD2");
		Thread.sleep(3000);
		
		
		//scroll the page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");
		
		//Filter Product by men
		WebElement men=driver.findElement(By.xpath("//div[@title='Men']/div/label"));
		men.click();
		
		Thread.sleep(5000);
		WebElement title=driver.findElement(By.xpath("//div[@title='TIMEX']/div/label"));
		title.click();
		Thread.sleep(2000);
		
		List<WebElement> sort=driver.findElements(By.xpath("//div[@class='_5THWM1']/div"));
		for(WebElement s:sort)
		{
			if(s.getText().contains("Price -- Low to High"))
			{
				s.click();
			}
		}
		
		//check lowest to highest price 
		
		List<WebElement> AllPrice=driver.findElements(By.xpath("//div[@class='_2B099V']/a[2]/div[1]/div[1]"));
		
		List<String> Addprice=new ArrayList<String>();
		
		for(WebElement p:AllPrice)
		{
			String s=p.getText().replaceAll("[^]","");
			System.out.println(s);
		}
	}
}
