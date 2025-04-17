package utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;

import static utilities.Driver.getDriver;

public class ReusableMethods {

    static Faker faker;
    static Actions actions;
    static LocalDateTime date;
    static String tarih;

    static Select select;
    static WebElement ddm;
    static Random random= new Random();

    public static void Date(){

        date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYYYMMddHHmmss");
        tarih = date.format(formater);
    }

    public static Faker getFaker() { // getFaker method
        return faker = new Faker();
    }

    public static Actions getActions() { //getActions method
        return actions = new Actions(getDriver());
    }

    public static Select select(WebElement ddm){ //select method

        return select = new Select(ddm);
    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
    //========Switching Window=====//
    public static void switchToWindow(String targetTitle) {
        String origin = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
            if (getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        getDriver().switchTo().window(origin);
    }
    //========Hover Over=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }
    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    //   HARD WAIT WITH THREAD.SLEEP
//   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====//
    public static WebElement fluentWait(final WebElement webElement, int timeout) {
        //FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver()).withTimeout(timeinsec, TimeUnit.SECONDS).pollingEvery(timeinsec, TimeUnit.SECONDS);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(3))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(1));//Check for the element every 1 second
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }

    //====== JS Scroll Click ====//
    public static void jsScrollClick(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        try {
            webElement.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);
            waitFor(1);
        }
    }

    //====== JS Scroll ====//
    public static void jsScroll(WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
    //========ScreenShot Web Element(Bir webelementin resmini alma)=====//
    public static String getScreenshotWebElement(String name,WebElement element) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        File source = element.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + date + ".png";
        File finalDestination = new File(wElementSS);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return  wElementSS;
    }

    //====== js ======//
    public static void jsclick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", webElement);
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", webElement);
        }
    }

    public static void bulveTikla(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", webElement);
    }
    public static Random random() { // Feyza

        Random random;
        return random = new Random();
    }

    public static WebElement waitForClickable(WebElement element, int timeout) {  // Feyza
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static String Tarih(){

        date = LocalDateTime.now();
        //DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tarih = date.format(formater);
        return tarih;
    }
    public static String ileriTarih(){

        date = LocalDateTime.now();
        //DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tarih = date.plusDays(10).format(formater);
        return tarih;
    }
    public static String gecmisTarih(){

        date = LocalDateTime.now();
        //DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tarih = date.minusDays(10).format(formater);
        return tarih;
    }
    public static String saat(){

        date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("HHmm");
        tarih = date.format(formater);
        return tarih;
    }
    public static String setTheDateByRandom (String format,int atMostYear, String direction)
    {
        int day = (int) (Math.random() * 366 + 1);
        int month = (int) (Math.random() * 13 + 1);
        int year = (int) (Math.random() * atMostYear + 1);
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        direction = direction.toUpperCase(Locale.ROOT);
        String dateF;
        switch (direction) {
            case "FEATURE":
                date = date.plusYears(year).plusMonths(month).plusDays(day);
                dateF = formatter.format(date);
                return dateF;
            case "PAST":
                date = date.minusYears(year).minusMonths(month).minusDays(day);
                dateF = formatter.format(date);
                return dateF;
            default:
                dateF = formatter.format(date);
                return dateF;
        }
    }

    //Auto gun ay yil secim
    public static void selectDropDown(WebElement element){

        List<WebElement> list = ReusableMethods.select(element).getOptions();
        int index = ReusableMethods.random().nextInt(list.size());
        while (index == 0){
            index = ReusableMethods.random().nextInt(list.size());
        }
        ReusableMethods.select(element).selectByIndex(index);
    }


    public static void selectDdmIndex(WebElement element) {

        List<WebElement> list = select(element).getOptions();

        int index = random().nextInt(list.size());

        select(element).selectByIndex(index);
    }

    public static String dateMonth() {

        String month;
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        return month = dateTime.format(formatter);
    }

    public static String dateYear() {

        String year;
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return year = localDateTime.format(formatter);

    }


    public static void visibilityOfWait(WebElement webElement) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static  WebElement titleSelected(List<WebElement> element){
        return element.get(random.nextInt(element.size()));
    }

    public static void selectBirthDate(WebElement day,WebElement month,WebElement year){
        Select daySelect = new Select(day);
        daySelect.selectByValue(String.valueOf(random.nextInt(31) + 1));
        Select monthSelect = new Select(month);
        monthSelect.selectByValue(String.valueOf(random.nextInt(12) + 1));
        Select yearSelect = new Select(year);
        yearSelect.selectByValue(String.valueOf(1900 + random.nextInt(122)));
    }

    public static void selectCountry(WebElement element){
        Select countrySelect = new Select(element);
        List<WebElement> options = countrySelect.getOptions();
        int randomIndex = random.nextInt(options.size());
        WebElement randomOption = options.get(randomIndex);
        countrySelect.selectByVisibleText(randomOption.getText());
    }
}