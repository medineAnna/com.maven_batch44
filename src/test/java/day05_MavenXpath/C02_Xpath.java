package day05_MavenXpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.navigate().to("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3. Login alanine  “username” yazdirin
        WebElement loginBox=driver.findElement(By.id("user_login"));

        //4. Password alanine “password” yazdirin
        WebElement passwordBox=driver.findElement(By.id("user_password"));
        loginBox.sendKeys("username");
        passwordBox.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();


        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='pay_bills_tab']")).click();


        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement value=driver.findElement(By.xpath("//input[@id='sp_amount']"));
        value.sendKeys("50" );


        //8. tarih kismina “2020-09-10” yazdirin
        WebElement date=driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-10");


        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();


        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        System.out.println( driver.findElement(By.xpath("//div[@id='alert_content']")).isDisplayed() ? "Test PASS"
                : "Test FAİLED ");

    }
}
