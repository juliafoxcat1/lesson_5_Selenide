package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class SelenideRepository {

    @Test
    void shouldFindSelenideAsRepository(){

        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // нажимаем на линк от первого результата поиска
        $("ul.repo-list li").$("a").click();
        // переходим на таб Wiki
        $("#wiki-tab").click();
        // проверяем, что есть текст Soft assertions
        $("#wiki-body").shouldHave(text("Soft assertions"));
        // переходим на Soft assertions
        $("#wiki-body").find(byText("Soft assertions")).click();
        // ищем пример кода для JUnit5
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));
        // задержка для просмотра экрана
        sleep(5000);
    }
}