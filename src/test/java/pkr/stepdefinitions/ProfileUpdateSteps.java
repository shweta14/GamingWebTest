package pkr.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.PendingException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import pkr.Elements;
import pkr.Pages;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.*;
import static pkr.Elements.getElementByName;
import static pkr.Pages.getPageByName;
import static org.junit.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: shweta
 * Date: 15/09/13
 * Time: 01:30
 * To change this template use File | Settings | File Templates.
 */
public class ProfileUpdateSteps {
    public static final String FIELD_NAME = "fieldName";
    public static final String TITLE = "title";
    public static final String F_NAME = "fieldName";
    public static final String FIELD_VALUE = "fieldValue";


    private static WebDriver webDriver;

    @Before
    public void setup() throws Exception {
        webDriver = new ChromeDriver();
    }

    @Given("^I (?:visit|go to) (.*) (?:website|page)$")
    public void I_go_to_page(String pageName) {
        Pages page = getPageByName(pageName);
        webDriver.get(page.getPageUrl());
        WebElement title = webDriver.findElement(tagName(TITLE));
        System.out.println(title.getText());
//        assertEquals(page.getPageTitle(), title.getText());
    }


    @When("^I click on (.*) (?:button|element|link)$")
    public void I_click_on_element(String elementName) {
        Elements htmlElement = getElementByName(elementName);
        webDriver.findElement(id(htmlElement.getId())).click();
    }

    @Then("^I input the following information:$")
    public void I_input_following_information_in_the_login_popup(List<Map<String, String>> fieldList) {
        String fieldName;
        String fieldValue;
        for (Map<String, String> valueMap : fieldList) {
            fieldName = valueMap.get(F_NAME);
            fieldValue = valueMap.get(FIELD_VALUE);
            Elements htmlElement = Elements.getElementByName(fieldName);
            WebElement webElement = webDriver.findElement(id(htmlElement.getId()));
            webElement.sendKeys(fieldValue);
        }
    }

    @Then("^I see the message '(.*)'$")
    public void I_see_the_update_message(String message) {
        Elements htmlElement = Elements.getElementByName(message);
        String id = htmlElement.getId();
        String selector = "#" + id + "+ p";
        WebElement userStatusElement = webDriver.findElement(cssSelector(selector));
        Assert.assertEquals("Profile updated", userStatusElement.getText());
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Then("^I see the information:$")
    public void I_see_the_information(List<Map<String, String>> fieldList) {
        String fieldName;
        String fieldValue;
        for (Map<String, String> valueMap : fieldList) {
            fieldName = valueMap.get(F_NAME);
            fieldValue = valueMap.get(FIELD_VALUE);
            Elements htmlElement = Elements.getElementByName(fieldName);
            WebElement webElement = new Select(webDriver.findElement(id(htmlElement.getId()))).getFirstSelectedOption();
            Assert.assertEquals(webElement.getText(),fieldValue);
        }
    }
}

