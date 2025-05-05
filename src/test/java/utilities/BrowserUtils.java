package utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;



public class BrowserUtils {
    static Random random = new Random();
    static Faker faker;

    public static Faker getFaker() { // getFaker method
        return faker = new Faker();
    }

    public static String getScreenshot(String name) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(By by) {
        try {
            Assert.assertTrue(Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + by);
        }
    }

    public static void verifyElementNotDisplayed(By by) {
        try {
            Assert.assertFalse( Driver.getDriver().findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue( element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);
        }
    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    public static void setAttribute(WebElement element, String attributeName, String attributeValue) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    public static void highlight(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        waitFor(1);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
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

    public static void executeJSCommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    public static void executeJSCommand(String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command);
    }

    public static void clickWithWait(By by, int attempts) {
        int counter = 0;
        while (counter < attempts) {
            try {
                clickWithJS(Driver.getDriver().findElement(by));
                break;
            } catch (WebDriverException e) {
                e.printStackTrace();
                ++counter;
                waitFor(1);
            }
        }
    }

    public static void waitForPresenceOfElement(By by, long time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
    }

    public static void selectOption(WebElement element, String option) {
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }


    public static void findAndClick(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", webElement);
    }

    public static WebElement randomSelected(List<WebElement> element) {
        return element.get(random.nextInt(element.size()));
    }

    public static void selectBirthDate(WebElement day, WebElement month, WebElement year) {
        Select daySelect = new Select(day);
        daySelect.selectByValue(String.valueOf(random.nextInt(31) + 1));
        Select monthSelect = new Select(month);
        monthSelect.selectByValue(String.valueOf(random.nextInt(12) + 1));
        Select yearSelect = new Select(year);
        yearSelect.selectByValue(String.valueOf(1900 + random.nextInt(122)));
    }


    public static String selectCountryAndGetName(WebElement element) {
        Select countrySelect = new Select(element);
        List<WebElement> options = countrySelect.getOptions();
        int randomIndex = random.nextInt(options.size());
        WebElement randomOption = options.get(randomIndex);
        String selectedCountry = randomOption.getText();
        countrySelect.selectByVisibleText(selectedCountry);
        return selectedCountry;
    }


    public static String convertTurkishCharsToEnglish(String text) {
        if (text == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            switch (currentChar) {
                case 'İ':
                    sb.append('I');
                    break;
                case 'ı':
                    sb.append('i');
                    break;
                case 'Ş':
                    sb.append('S');
                    break;
                case 'ş':
                    sb.append('s');
                    break;
                case 'Ç':
                    sb.append('C');
                    break;
                case 'ç':
                    sb.append('c');
                    break;
                case 'Ğ':
                    sb.append('G');
                    break;
                case 'ğ':
                    sb.append('g');
                    break;
                case 'Ö':
                    sb.append('O');
                    break;
                case 'ö':
                    sb.append('o');
                    break;
                case 'Ü':
                    sb.append('U');
                    break;
                case 'ü':
                    sb.append('u');
                    break;
                default:
                    sb.append(currentChar);
                    break;
            }
        }
        return sb.toString();

    }

    public static String textRegex(WebElement element) {
        String rawText = element.getText();
        return rawText.replaceAll("[0-9()]", "").trim();
    }

    public static void deleteIndexTxtFiles(String nameFile,String typeFile) {
        try {
            Path downloadsDir = Paths.get(System.getProperty("user.home"), "Downloads");
            Files.walk(downloadsDir, 1)
                    .filter(Files::isRegularFile)
                    .filter(file -> {
                        String fileName = file.getFileName().toString().toLowerCase();
                        return fileName.contains(nameFile) && fileName.endsWith("."+typeFile);
                    })
                    .forEach(file -> {
                        try {
                            Files.delete(file);
                        } catch (IOException e) {
                        }
                    });
        } catch (IOException e) {
        }
    }
    public static void slowScrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long windowHeight = (long) js.executeScript("return window.innerHeight");
        long currentPosition = 0;
        long documentHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (currentPosition < documentHeight) {
            currentPosition += windowHeight / 1;
            js.executeScript("window.scrollTo(0, " + currentPosition + ")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void slowScrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long currentPosition = (long) js.executeScript("return window.pageYOffset");

        while (currentPosition > 0) {
            currentPosition -= 1000;
            js.executeScript("window.scrollTo(0, " + Math.max(0, currentPosition) + ")");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


}





