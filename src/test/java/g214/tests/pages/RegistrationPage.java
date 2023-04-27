package g214.tests.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import g214.tests.TestData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends TestData {

    private ElementsCollection
            submitButton = $$("Button.Button_block.Button_green"),
            phoneFinder = $$("div.Header_Main_Content_Contacts");



    private SelenideElement
            headerFinder = $("div.Header_Main_Content_Contacts_Call"),
            headerNameInput = $("#callback_form_name"),
            headerPhoneInput = $("#callback_form_phone");

    public RegistrationPage openPage() {
        open("https://214g.ru");
        return this;

    }

    public RegistrationPage openHeaderModalForm(){
        headerFinder.$(byText("Заказать звонок")).click();
        return this;
    }

    public RegistrationPage setHeaderName(String value){
        headerNameInput.setValue(value);
                return this;
    }

    public RegistrationPage setHeaderPhone(String value){
        headerPhoneInput.setValue(value);
        return this;
    }










}
