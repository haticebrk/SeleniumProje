package SeleniumProjee;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _03_Soru3 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement eBook = driver.findElement(By.xpath("/html/body/div[2]/div/div/a[2]"));
        eBook.click();


        WebElement addToCart = driver.findElement(By.xpath("//button[text()=' Add To Cart']"));
        addToCart.click();


        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']")));

        WebElement iframe1=driver.findElement(By.cssSelector("iframe[class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);

        WebElement usingDebitCart= driver.findElement(By.cssSelector("button[class='Payment-Button CC']"));
        usingDebitCart.click();

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='Stripe-Element'] iframe")));

        WebElement frame=driver.findElement(By.cssSelector("div[id='Stripe-Element'] iframe"));
        driver.switchTo().frame(frame);


        WebElement cardNo=driver.findElement(By.cssSelector("input[placeholder='Card number']"));
        cardNo.sendKeys("1111 1111 1111 1111");


        driver.switchTo().defaultContent();
        driver.switchTo().frame(5);

        WebElement invalidCartNoconfirmation= driver.findElement(By.id("SnackBar"));
        Assert.assertTrue(invalidCartNoconfirmation.getText().contains("Your card number"));

        driverKapat();


    }
}