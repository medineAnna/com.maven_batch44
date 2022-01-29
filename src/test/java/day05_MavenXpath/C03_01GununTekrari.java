package day05_MavenXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C03_01GununTekrari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // 2- arama kutusunu locate edelim
        WebElement arananKelime=driver.findElement(By.id("twotabsearchtextbox"));

        //3- “Samsung headphones” ile arama yapalim
        arananKelime.sendKeys("Samsung headphones" + Keys.ENTER);
        
        // 4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayiYazdir=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucSayiYazdir.getText());

        //5- Ilk urunu tiklayalim
        WebElement ilkUrunBul=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrunBul.click();

        //6- Sayfadaki tum basliklari yazdiralim
        List<WebElement> tumBasliklar=driver.findElements(By.xpath("//a[@class='a-link-normal s-navigation-item']"));
        System.out.println("Sayfadaki tum basliklar: " + tumBasliklar.size());

        driver.quit();
    }
}
