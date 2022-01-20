package day05_MavenXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Maven {
    public static void main(String[] args) {
        //1- https://www.amazon.com/ sayfasina gidelim
        //2- arama kutusunu locate edelim
        //3- “Samsung headphones” ile arama yapalim
        //4- Bulunan sonuc sayisini yazdiralim
        //5- Ilk urunu tiklayalim
        //6- Sayfadaki tum basliklari yazdiralim

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.com/");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Samsung headphones" + Keys.ENTER);

        WebElement resultNumber=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(resultNumber.getText());

        WebElement firstProdukt=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        firstProdukt.click();

        driver.navigate().back();

        List<WebElement> allTitles=driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        System.out.println("There is Titles in page: " + allTitles.size());


        driver.quit();

    }
}

