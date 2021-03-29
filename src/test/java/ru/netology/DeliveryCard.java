package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import lombok.Data;
import lombok.Value;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.impl.Html.text;

@Data
@Value
public class DeliveryCard {
//    TestData testData = new TestData();

    @Test
    public void shouldSubmitRequest() {
        Configuration.headless=true;
        open("http://localhost:9999");
        $("[placeholder='Город']").sendKeys(TestData.getCity());
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(TestData.setDate(3));
        $("[name='name']").sendKeys(TestData.enterName());
        $("[name='phone']").sendKeys(TestData.enterPhone());
        $("[class='checkbox__box']").click();
        $(byText("Запланировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(TestData.setDate(6));
        $(byText("Запланировать")).click();
        $(byText("Перепланировать")).click();
        $(Selectors.withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $("[data-test-id=success-notification] .notification__content").shouldHave(text(TestData.setDate(6)));

    }

}

