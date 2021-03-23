package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryCard {
    TestData testData = new TestData();

    @Test
    public void shouldSubmitRequest() {
        Configuration.headless=true;
        open("http://localhost:9999");
        $("[placeholder='Город']").sendKeys(testData.getCity());
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(testData.getDatePlusThree());
        $("[name='name']").sendKeys(testData.enterName());
        $("[name='phone']").sendKeys(testData.enterPhone());
        $("[class='checkbox__box']").click();
        $(byText("Запланировать")).click();
        $(withText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(16));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(testData.getDatePlusThree());
        $(byText("Запланировать")).click();
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(testData.getDatePlusSix());
        $(byText("Перепланировать")).click();
        $(withText("Встреча успешно запланирована на")).shouldBe(Condition.visible, Duration.ofSeconds(15));
        $(withText(testData.getDatePlusSix())).shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

}

