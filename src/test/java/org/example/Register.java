package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Register {

    static WebDriver driver;

    //Reusable method for Thread.sleep
    public static void sleep(int a) {
        try {
            Thread.sleep(a * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Reusable method to click On Element
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Reusable method to get text from the element
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //Reusable method to wait until element is clickable
    public static void waitUntilElementClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Reusable method to typeText from text box
    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

//    //Reusable method to //Reusable method to wait until element is visible
//    public static void waitUntilElementToBeVisible(By by, int time) {
//
//        WebDriverWait wait = new WebDriverWait(driver, time);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//    }

    //Reusable method to select from dropDown is visible
    public static void selectFromDropDownByVisibleText(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }

    //Reusable method to select from dropDown is index
    public static void selectFromDropDownByIndex(By by, int index) {

        new Select(driver.findElement(by)).selectByIndex(index);
    }

    //Reusable method to select from dropDown is value
    public static void selectFromDropDownByValu(By by, String value) {

        new Select(driver.findElement(by)).selectByValue(value);
    }

    //Reusable method to timeStamp use for print current time
    public static long timeStamp() {
        return (System.currentTimeMillis());
    }

    @BeforeTest
    public static void setChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Soft\\CromeDriver\\83\\chromedriver.exe");//chrome driver path setup
        driver = new ChromeDriver();//objrct of chrome driver or chrome driver open
        driver.manage().window().maximize();//run time windows size maximize
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait for 10 second before all test case
        driver.get("https://demo.nopcommerce.com/");//type URL
    }

    @Test(priority = 1)//test annotation ,priority 1 use for first test run
    public static void userShouldBeAbleToRegisterSuccessfully() {
        //Click On REGISTER(Link Text).
        clickOnElement(By.xpath("//li/a[contains(@class, \"ico\") and contains(@href,\"reg\")]"));
        //Wait until 10 second click on gender male [Radio Button].
        waitUntilElementClickable(By.xpath("//input[@id=\"gender-male\"]"), 10);
        clickOnElement(By.xpath("//input[@id=\"gender-male\"]"));//Click Gender (Male) [Radio Button].
        sleep(3);//sleep process 3 second.
        //Type Text First name (Text Box).
        typeText(By.xpath("//div[@class=\"fieldset\"]//div[2]/div[2]/input"), "Raj");
        //Type Text Last name (Text Box).
        typeText(By.xpath("//div[@class=\"fieldset\"]//div[2]/div[3]/input"), "Patel");
        sleep(3);//sleep process 3 second.
        //select by day use by (22) index (Drop Down).
        selectFromDropDownByIndex(By.xpath("//select[@name=\"DateOfBirthDay\"]"), 22);
        //select by month use by visible text (Drop Down).
        selectFromDropDownByVisibleText(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), "November");
        //select by day use by value (Drop Down).
        selectFromDropDownByValu(By.xpath("//select[@name=\"DateOfBirthYear\"]"), "1990");
        //Type Text (Text Box).
        typeText(By.xpath("//div[@class=\"fieldset\"]//div[2]/div[5]/input"), "testing+" + timeStamp() + "@gmail.com");//Type Text Email (Text Box)
        //Type Text  (Text Box).
        typeText(By.xpath("//input[@id=\"Company\"]"), "T Group Of Company");
        //Wait until 10 second select newsletter (check box).
        waitUntilElementClickable(By.xpath("//input[@id=\"Newsletter\"]"), 10);
        //select newsletter (check box).
        clickOnElement(By.xpath("//input[@id=\"Newsletter\"]"));
        //Type Text password (Text Box).
        typeText(By.xpath("//div/form[@method=\"post\"]/div[4]/div[2]/div/input"), "Test@123");
        //Type Text conform password (Text Box).
        typeText(By.xpath("//div/form[@method=\"post\"]/div[4]/div[2]/div[2]/input"), "Test@123");
        //Wait until 10 second click on register (Button).
        waitUntilElementClickable(By.xpath("//input[@id=\"register-button\"]"), 10);
        //Wait until 10 second click on register (Button).
        clickOnElement(By.xpath("//input[@id=\"register-button\"]"));
        //print string value
        System.out.println(getTextFromElement(By.xpath("//div[@class=\"result\"]")));


    }

    @Test(priority = 2)//test annotation ,priority 2 use for after First test run
    public static void registerUserShouldBeAbleToReferAProductToAFriendSuccessfully() {
        //Wait until 20 second click On COMPUTERS(Link Text).
        waitUntilElementClickable(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"), 20);
        //Click On COMPUTERS(Link Text).
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li/a[@href=\"/computers\"]"));
        //Wait until 10 second click On Desktops(Link Text).
        waitUntilElementClickable(By.xpath("//ul[@class=\"sublist\"]/li/a[@href=\"/desktops\"]"), 10);
        //Click On Desktops(Link Text).
        clickOnElement(By.xpath("//ul[@class=\"sublist\"]/li/a[@href=\"/desktops\"]"));
        //Wait until 10 second click On Digital Storm (Link Text).
        waitUntilElementClickable(By.xpath("//div[@class=\"item-grid\"]/div[2]/div/div[2]/h2/a"), 10);
        //Click On Digital Storm(Link Text).
        clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[2]/div/div[2]/h2/a"));
        //Wait until 10 second click On Email a friend(Button).
        waitUntilElementClickable(By.xpath("//input[@value=\"Email a friend\"]"), 10);
        //Click On Email a friend(Button).
        clickOnElement(By.xpath("//input[@value=\"Email a friend\"]"));
        sleep(5);//sleep process 5 second
        //type text email id
        typeText(By.xpath("//div[@class=\"fieldset\"]/div[1]/div[1]/input"), "test+" + timeStamp() + "@gmail.com");
        //type text message for sand friend email
        typeText(By.xpath("//textarea[@class=\"your-email\"]"), "Your Favourite Products Are 50% Off !!!");
        //Wait until 10 second click On send email (Button).
        waitUntilElementClickable(By.xpath("//input[@value=\"Send email\"]"), 10);
        //Click On send email (Button).
        clickOnElement(By.xpath("//input[@value=\"Send email\"]"));
        //print string value
        System.out.println(getTextFromElement(By.xpath("//div[@class=\"result\"]")));

    }

    @Test(priority = 3)//test annotation ,priority 3 use for after second test run
    public static void userShouldBeAbleToAddProductToBasketSuccessfully() {
        //Wait until 20 second click on ELECTRONICS(Link Text).
        waitUntilElementClickable(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"), 20);
        //Click on ELECTRONICS(Link Text).
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"));
        //Wait until 10 second click on Cellphone(Link Text).
        waitUntilElementClickable(By.xpath("//ul[@class=\"sublist\"]/li[2]/a"), 10);
        //Click on Cellphone(Link Text).
        clickOnElement(By.xpath("//ul[@class=\"sublist\"]/li[2]/a"));
        sleep(3);//sleep process 3 second

        String expectFirstText = getTextFromElement(By.xpath("//h2[@class=\"product-title\"]/a[text () =\"HTC One M8 Android L 5.0 Lollipop\"]"));
        //Wait until 10 second click on HTC mobile Cart (Button)
        waitUntilElementClickable(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/input[1]"), 10);
        //Click on HTC mobile Cart (Button)
        clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[1]/div/div[2]/div[3]/div[2]/input[1]"));
        sleep(5);//sleep process 5 second

        String expectResultSecondProduct = getTextFromElement(By.xpath("//div[@class=\"item-grid\"]/div[3]/div/div[2]/h2/a"));
        //Wait until 10 second click on NOKIA Cart (Button).
        waitUntilElementClickable(By.xpath("//div[@class=\"item-grid\"]/div[3]/div/div[2]/div[3]/div[2]/input[1]"), 10);
        //Click on NOKIA Cart (Button).
        clickOnElement(By.xpath("//div[@class=\"item-grid\"]/div[3]/div/div[2]/div[3]/div[2]/input[1]"));
        //Wait until 10 second click On Shaping cart (Link Text).
        waitUntilElementClickable(By.xpath("//a[text () =\"Shopping cart\"]"), 10);
        //Click on shopping cart (Button).
        clickOnElement(By.xpath("//a[text () =\"Shopping cart\"]"));
        sleep(3);//sleep process 3 second
        //String variable by get text
        String actualFiestCartText = getTextFromElement(By.xpath("//td[@class=\"product\"]/a[text () = \"HTC One M8 Android L 5.0 Lollipop\"]"));
        //Compare Actual text and expect text
        Assert.assertEquals(actualFiestCartText, expectFirstText, "Product Does Not Match");
        //string value print
        System.out.println(actualFiestCartText);
        //Compare Actual text and expect text
        String acualResultSecondProduct = getTextFromElement((By.xpath("//td[@class=\"product\"]/a[text () = \"Nokia Lumia 1020\"]")));
        //Compare Actual text and expect text
        Assert.assertEquals(acualResultSecondProduct, expectResultSecondProduct, "Product Does Not Match");
        //string value print
        System.out.println(acualResultSecondProduct);
    }

    @AfterTest//annotation after run all test

    public static void closeBrowser() {
        driver.close();//close process
    }


}
