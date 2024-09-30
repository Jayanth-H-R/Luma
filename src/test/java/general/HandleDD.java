package general;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDD {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement ramDropDown = driver.findElement(By.xpath("//select[@title='Search in']"));
		Select select = new Select(ramDropDown);
		List<WebElement> searchInOptions = select.getOptions();
		for (int i = 0; i < searchInOptions.size(); i++) {
			if (i % 2 == 0)
				System.out.println(searchInOptions.get(i).getText());
		}
		driver.manage().window().minimize();
		driver.quit();

	}
}
