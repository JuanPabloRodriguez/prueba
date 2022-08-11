package prueba;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class prue1 {

	By btnSoloIda = By.xpath("//span[text()='Solo ida']");
	
	By chkbox  = By.xpath("//span[text()='Solo ida']");
	
	
	
	@Test
	
	public void ConfiguracionPrevia() throws InterruptedException {
		
		this.PruebaChrome();
		this.PruebaMozilla();
		
	}
	public void PruebaChrome() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		WebDriver driverChrome = new ChromeDriver();
		driverChrome.manage().window().maximize();
		driverChrome.get("https://www.vivaair.com/");
		driverChrome.findElement(btnSoloIda);
		driverChrome.findElement(btnSoloIda).click();
		Thread.sleep(3000);
		this.pantallazo(driverChrome,"IngresoChrome");
		this.cerrar(driverChrome);
		
	}

	public void PruebaMozilla() {
	
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
		WebDriver driverMozilla = new FirefoxDriver();
		driverMozilla.manage().window().maximize();
		driverMozilla.get("https://www.vivaair.com/");
		this.pantallazo(driverMozilla,"Ingresofirefox");
		this.cerrar(driverMozilla);
	}
	
	public void pantallazo (WebDriver driver , String name) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src,new File (name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar(WebDriver driver) {
		
		driver.close();
	}
}
