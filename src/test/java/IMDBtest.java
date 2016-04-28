
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




/**
 * Created by Ruben on 28/04/2016.
 */
public class IMDBtest {

    private static final String SEARCHTERM = "Blade Runner";
    private WebDriver driver;
    private String baseUrl;
    @Before
    public void
    setUp()
            throws Exception {driver = new HtmlUnitDriver();
        baseUrl = "http://www.imdb.com/";
    }
    @Test
    public void
    testIMDBSearch()
            throws Exception {driver.get(baseUrl);
        WebElement searchbox = (new WebDriverWait(driver, 10)).until(
                ExpectedConditions.presenceOfElementLocated(By.id("navbar-query")));
        searchbox.click();
        searchbox.clear();
        searchbox.sendKeys(SEARCHTERM);
        WebElement submitButton =
                (new WebDriverWait(driver, 10)).until(
                        ExpectedConditions.presenceOfElementLocated(By.id("navbar-submit-button")));
        submitButton.click();
        WebElement topSearchResult =
                (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//td[2]/a")));
        topSearchResult.click();
        Assert.assertTrue(driver.getTitle().matches(".*" + SEARCHTERM + ".*"));
    }
    @After
    public void tearDown() throws Exception {driver.quit();}
}

