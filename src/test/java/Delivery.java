import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Delivery {
//    DateFormat dtf = SimpleDateFormat.getDateInstance();
//    LocalDate localDate = LocalDate.now();

    @Test
    void reserveDelivery() {
        open("http://localhost:9999");
        SelenideElement form = $("form");
        form.$("[placeholder='Город']").setValue("Санкт-Петербург");
//        Тест падает при попытке перевода в дату, не получилось =(
//        int deliveryDay = Integer.parseInt(dtf.format(form.$("[placeholder='Дата встречи']").getValue()));
//        int localDay = Integer.parseInt(dtf.format(localDate.plusDays(3)));
//        if (deliveryDay < localDay){
//            form.$("[placeholder='Дата встречи']").setValue(localDate.plusDays(3).toString());
//        }
        form.$("[name='name']").setValue("Джон Коннор");
        form.$("[name='phone']").setValue("+79990000000");
        form.$("[data-test-id=agreement]").click();
        form.$("[class='button__content']").click();
        $(withText("Встреча успешно забронирована на")).waitUntil(visible, 15000);

    }

}
