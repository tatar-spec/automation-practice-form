package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="3840x2160";
    }

    @Test
    void dragAndDropAandBActions(){
         open("/drag_and_drop");
         $("#column-a").shouldHave(text("A"));
         $("#column-b").shouldHave(text("B"));
        actions()
                .clickAndHold($("#column-b"))
                .moveByOffset(-200, 0)
                .release()
                .perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
      @Test
    void dragAndDropAandBActionsNew() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions()
                .dragAndDrop($("#column-a"),$("#column-b"))
                .perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
        closeWebDriver();
    }
    @Test
    void dragAndDropAandBSelenide() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
