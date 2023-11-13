package com_ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Project-5 - ProjectName : com-ultimateqa
 * BaseUrl = https://courses.ultimateqa.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Sign In’ link
 * 7. Print the current url
 * 8. Enter the email to email field.
 * 9. Enter the password to password field.
 * 10. Click on Login Button.
 * 11. Navigate to baseUrl.
 * 12. Navigate forward to Homepage.
 * 13. Navigate back to baseUrl.
 * 14. Refresh the page.
 * 15. Close the browser.
 */

public class UltiMateQa {
    static String browser = "Chrome";
    static String baseUrl = "https://courses.ultimateqa.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }
        driver.get(baseUrl);//Open Url
        driver.manage().window().maximize();//Print the title of page
        System.out.println(driver.getCurrentUrl());//Print the current url
        System.out.println(driver.getPageSource());// Print the page source

        //Click on sign Link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        System.out.println(driver.getCurrentUrl());//Print the current Url

        //Enter the email to email field
        WebElement emailFields = driver.findElement(By.id("user[email]"));
        emailFields.sendKeys("prime1234@gmail.com");

        //Enter Password To password Field
        WebElement passwordFields = driver.findElement(By.id("user[password]"));
        passwordFields.sendKeys("Prime123");

        //Click on signIn Button
        WebElement signInButton = driver.findElement(By.xpath("(//button [@type='submit'])"));
        signInButton.click();
        driver.navigate().to("https://courses.ultimateqa.com/users/sign_in");//Navigate to base Url
        driver.navigate().forward();//Navigate to forward
        driver.navigate().back();//Navigate back to baseUrl
        driver.navigate().refresh();//Reference the page
        driver.quit();//Close the driver


    }
}
