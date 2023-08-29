package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class GridStepDefs {

    WebDriver driver;

    @Given("kullanici {string} adresine {string} ile gider")
    public void kullanici_adresine_ile_gider(String url, String browser) throws MalformedURLException {

        URL remoteUrl = new URL("http://192.168.0.111:4444");

        if (browser.equalsIgnoreCase("chrome")){
            driver = new RemoteWebDriver(remoteUrl, new ChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new RemoteWebDriver(remoteUrl, new FirefoxOptions());
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new RemoteWebDriver(remoteUrl, new EdgeOptions());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get(url);


    }

    @When("kullanici basligin {string} icerdigini dogrular")
    public void kullanici_basligin_icerdigini_dogrular(String title) {

        assertTrue(title.contains(driver.getTitle()));




    }

    @Then("kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {

        driver.quit();


    }
}