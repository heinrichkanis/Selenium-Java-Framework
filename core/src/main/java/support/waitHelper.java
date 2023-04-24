package support;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitHelper extends driverHelper {

    public static boolean waitForElement(By element)
	{	
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofMinutes(3));
		wait.ignoring(NoSuchElementException.class); //make sure that this exception is ignored
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>()
			{
				public WebElement apply(WebDriver arg0) {
				System.out.println(commands.ConsoleColors.WHITE_BOLD +"Waiting for element to display !!" + commands.ConsoleColors.RESET);
				WebElement el = arg0.findElement(element);
				if(el != null)
				{
					System.out.println(commands.ConsoleColors.YELLOW_BRIGHT +"Element found" + element  + commands.ConsoleColors.RESET);
				}
				else {
					System.out.println("Element not found");
				}
					return el;
						}
			};

			wait.until(function);
			return true; 
	
	}

	public static void elementWait(By element){

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10, 1));
		
		/* Wait until */
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

}
