package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;;
import static com.codeborne.selenide.Selenide.*;

public class SimpleJUnitTest {

     @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="3840x2160";
    }

    @Test
    void gitHover(){
        open("https://github.com/");
        $("nav").$(byTagAndText("button","Solutions")).hover();
        $("a[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldBe(Condition.text("The AI-powered"));
    }
}
