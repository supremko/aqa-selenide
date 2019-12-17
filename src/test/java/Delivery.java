import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Delivery {
    LocalDate localDate = LocalDate.now();

    @Test
    void reserveDelivery() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[placeholder='Город']").setValue("Санкт-Петербург");
        form.$("[placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        form.$("[placeholder='Дата встречи']").setValue(localDate.plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.YYYY")));
        form.$("[name='name']").setValue("Джон Коннор");
        form.$("[name='phone']").setValue("+79990000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class='button__content']").click();
        $(withText("Встреча успешно забронирована на")).waitUntil(visible, 15000);
    }

    @Test
    void reserveDelivery2() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[placeholder='Город']").setValue("Санкт-Петербург");
        form.$("[placeholder='Дата встречи']").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        form.$("[placeholder='Дата встречи']").setValue(localDate.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")));
        form.$("[name='name']").setValue("Джон Коннор");
        form.$("[name='phone']").setValue("+79990000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class='button__content']").click();
        form.$(withText("Заказ на выбранную дату невозможен")).shouldBe(visible);
    }

}
