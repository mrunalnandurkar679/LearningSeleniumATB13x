package com.thetestingacademy.ex01_Selenium_Basics.SVGImages;

import com.thetestingacademy.ex01_Selenium_Basics.Utilities.BaseClassMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SVG_Maps extends BaseClassMethods {

    @Test
    public  void testGetLocationsOnMap()
    {
        getURL(driver, "https://www.amcharts.com/svg-maps/?map=india");
        new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> states = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for (WebElement state : states) {
            if (state.getDomAttribute("aria-label").contains("Chhattisgarh") ) {
                state.click();
                System.out.println(state.getDomAttribute("aria-label"));

            }
            break;

        }
    }
}
