package g214.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import g214.tests.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class g214ValidationTests {



    @Test
        //телефон на главной отображается и является кликабельным
    void phoneNumberIsAvaliableOnMain() {

        RegistrationPage.openPage();

        $$("div.Header_Main_Content_Contacts").findBy(Condition.href("tel:+78129202297"));
    }


    @Test
        //позитивный тест окна заявок в хэдере

    void headerApplicationFormPositiveTest() {
        open("https://214g.ru");
        $("div.Header_Main_Content_Contacts_Call").$(byText("Заказать звонок")).click();
        $("#callback-popup").shouldBe(Condition.visible);
        $("#callback_form_name").setValue("тест");
        $("#callback_form_phone").setValue("+79216534530");
        $$("Button.Button_block.Button_green").findBy(Condition.name("callback_form[submit]")).click();
        $("div.Notify.Notify_info").shouldHave(Condition.text("Ваша заявка принята! Специалист отдела продаж свяжется с Вами в течение 10 минут и ответит на все интересующие Вас вопросы"));

    }

    @Test
        //негативный тест окна заявок в хедере
    void headerApplicationFormNegativeTest() {
        open("https://214g.ru");
        $("div.Header_Main_Content_Contacts_Call").$(byText("Заказать звонок")).click();
        $$("Button.Button_block.Button_green").findBy(Condition.name("callback_form[submit]")).click();
        $("div.Notify.Notify_info").shouldHave(Condition.text("Ваша заявка принята! Специалист отдела продаж свяжется с Вами в течение 10 минут и ответит на все интересующие Вас вопросы"));
    }

    @Test
        //позитивный тест на подписку в футере
    void footerSubscriptionPositiveTest() {
        open("https://214g.ru");
        $("#news_subscription_form_email").setValue("test@test.test");
        $("button.Footer_Main_News_Input_SubmitButton").click();
        $("p.Text_blue").shouldHave(Condition.text("Вы успешно подписаны!"));

    }

    @Test
        //негативный тест на подписку в футере
    void footerSubscriptionNegativeTest() {
        open("https://214g.ru");
        $("button.Footer_Main_News_Input_SubmitButton").click();
        $("p.Text_blue").shouldHave(Condition.text("Вы успешно подписаны!"));
    }

    @Test
        //позитивный тест на форму персональной подборки
    void selectionFormPositiveTest() {
        open("https://214g.ru");
        $$("button.Button.Button_block.Button_green").findBy(Condition.text("Оставить заявку на подбор квартир")).click();
        $("#personal-selection-flats").shouldBe(Condition.visible);
        $("#front_personal_selection_form_budgetflats").setValue("100");
        $("#front_personal_selection_form_nameflats").setValue("Тест");
        $("#front_personal_selection_form_phoneflats").setValue("+79216534530");
        //$$("select.Form_LabelBlock_Select.Form_Control.Form_Control_noBorder").findBy(Condition.text("Прямо сейчас")).click(); //todo
        $$("Button.Button_block.Button_green").findBy(Condition.name("front_personal_selection_form[submit]")).click();
        $("div.Notify.Notify_info").shouldHave(Condition.text("Ваша заявка принята! Специалист отдела продаж свяжется с Вами в течение 10 минут и ответит на все интересующие Вас вопросы"));

    }

    @Test
        //негативный тест на форму персональной поборки
    void selectionFormNegativeTest() {
        open("https://214g.ru");
        $$("button.Button.Button_block.Button_green").findBy(Condition.text("Оставить заявку на подбор квартир")).click();
        $("#personal-selection-flats").shouldBe(Condition.visible);
        //$$("select.Form_LabelBlock_Select.Form_Control.Form_Control_noBorder").findBy(Condition.text("Прямо сейчас")).click(); //todo
        $$("Button.Button_block.Button_green").findBy(Condition.name("front_personal_selection_form[submit]")).click();
        $("div.Notify.Notify_info").shouldHave(Condition.text("Ваша заявка принята! Специалист отдела продаж свяжется с Вами в течение 10 минут и ответит на все интересующие Вас вопросы"));
    }

    @Test
        //позитивный тест на форму ипотечной подборки
    void mortgageFormPositiveTest() {
        open("https://214g.ru");
        $$("button.Button.Button_block.Button_green").findBy(Condition.text("Оставить заявку на подбор ипотечной программы")).click();
        $("#mortgage-help-popup").shouldBe(Condition.visible);
        $("#front_mortgage_help_form_name").setValue("Тест");
        $("#front_mortgage_help_form_phone").setValue("+79216534530");
        $("#front_mortgage_help_form_price").setValue("100");
        $$("Button.Button_block.Button_green").findBy(Condition.name("front_mortgage_help_form[submit]")).click();
        $("div.Notify.Notify_info").shouldHave(Condition.text("Ваша заявка принята! Специалист отдела продаж свяжется с Вами в течение 10 минут и ответит на все интересующие Вас вопросы"));


    }

    @Test
        //негативный тест на форму ипотечной подборки
    void mortgageFormNegativeTest() {
        open("https://214g.ru");
        $$("button.Button.Button_block.Button_green").findBy(Condition.text("Оставить заявку на подбор ипотечной программы")).click();
        $("#mortgage-help-popup").shouldBe(Condition.visible);
        $$("Button.Button_block.Button_green").findBy(Condition.name("front_mortgage_help_form[submit]")).click();
        $("div.Notify.Notify_info").shouldHave(Condition.text("Ваша заявка принята! Специалист отдела продаж свяжется с Вами в течение 10 минут и ответит на все интересующие Вас вопросы"));

    }

    @Test
        //блокер на работу бд
    void flatBaseIsAvaliable() {
        open("https://214g.ru");
        $$("div.ComplexesSearch_ResultList_Item").first().$("a.Button.Button_block.Button_gray").click();
        switchTo().window(1);
        $$("div.ApartmentsSearch_ResultList_Item").first().click();
        $("div.ApartmentCard_ContentBody_Row").shouldBe(Condition.visible);


    }


}
//todo разбить на пейджобджекты