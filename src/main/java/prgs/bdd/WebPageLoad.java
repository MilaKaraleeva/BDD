package prgs.bdd;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URLClassLoader;
import java.time.Duration;

public class WebPageLoad {

    private final WebDriver webDriver;
    private final int wait;

    // web driver load
    public WebPageLoad(WebDriver webDriver, int wait) {
        this.webDriver=webDriver;
        this.wait=wait;
    }

    //url load + find element + click
    public void clickButton(String webUrl,String htmlButton){
        WebDriver.Timeouts timeouts;
        timeouts = webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        webDriver.get(webUrl);
        WebElement enterButton=webDriver.findElement(By.xpath(htmlButton));
        enterButton.click();
    }

    //url load+find element + type in
    public String enterTextInField(String webUrl,String htmlField, String textToWrite){
        WebDriver.Timeouts timeouts;
        timeouts = webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        webDriver.get(webUrl);
        WebElement inputField = webDriver.findElement(By.xpath(htmlField));
        inputField.clear();
        inputField.sendKeys(textToWrite);
        return inputField.getAttribute("value");
    }

    public String findElementDoExist(String webUrl,String elementText ){
        WebDriver.Timeouts timeouts;
        timeouts = webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        webDriver.get(webUrl);
        WebElement messageText=webDriver.findElement(By.xpath(elementText));
        return messageText.getText();
        }

    }






