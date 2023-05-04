package g214.tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import g214.tests.TestData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends TestData {

    private ElementsCollection
            submitButton = $$("button.Button.Button_block.Button_green"),
            phoneFinder = $$("div.Header_Main_Content_Contacts"),
            flatBaseFinder = $$("div.ComplexesSearch_ResultList_Item"),
            apartmentsBaseFinder = $$("div.ApartmentsSearch_ResultList_Item");


    private SelenideElement
            headerFinder = $("div.Header_Main_Content_Contacts_Call"),
            headerNameInput = $("#callback_form_name"),
            headerPhoneInput = $("#callback_form_phone"),
            headerModalForm = $("#callback-popup"),
            modalResponse = $("div.Notify.Notify_info"),
            footerMailInput = $("#news_subscription_form_email"),
            subscribeButton = $("button.Footer_Main_News_Input_SubmitButton"),
            subscribeText = $("p.Text_blue"),
            selectionModalForm = $("#personal-selection-flats"),
            selectionPriceInput = $("#front_personal_selection_form_budgetflats"),
            selectionNameInput = $("#front_personal_selection_form_nameflats"),
            selectionPhoneInput = $("#front_personal_selection_form_phoneflats"),
            mortgageModalForm = $("#mortgage-help-popup"),
            mortgageNameInput = $("#front_mortgage_help_form_name"),
            mortgagePhoneInput = $("#front_mortgage_help_form_phone"),
            mortgagePriceInput = $("#front_mortgage_help_form_price"),
    //flatBaseButton = $("a.Button.Button_block.Button_gray"), does not work somehow
    apartmentsModalForm = $("div.ApartmentCard_ContentBody_Row");

    public RegistrationPage openPage() {
        open("");
        return this;

    }

    public RegistrationPage findPhoneLink() {
        phoneFinder.findBy(Condition.href(phoneHref));
        return this;
    }

    public RegistrationPage openHeaderModalForm() {
        headerFinder.$(byText(headerButtonText)).click();
        return this;
    }

    public RegistrationPage verifyHeaderModalFormIsVisible() {
        headerModalForm.shouldBe(Condition.visible);
        return this;
    }


    public RegistrationPage setHeaderName(String value) {
        headerNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setHeaderPhone(String value) {
        headerPhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage clickHeaderSubmitButton() {
        submitButton.findBy(Condition.name(headerSubmitName)).click();
        return this;
    }

    public RegistrationPage verifyResponseForm() {
        modalResponse.shouldHave(Condition.text(notifyInfo));
        return this;

    }

    public RegistrationPage verifyResponseFormNegative() {
        modalResponse.shouldNotBe(Condition.visible);
        return this;

    }

    public RegistrationPage setFooterMail(String value) {
        footerMailInput.setValue(value);
        return this;
    }

    public RegistrationPage clickSubscribeButton() {
        subscribeButton.click();
        return this;
    }

    public RegistrationPage verifySubscribtion() {
        subscribeText.shouldHave(Condition.text(subText));
        return this;

    }

    public RegistrationPage verifySubscribtionNegative() {
        subscribeText.shouldNot(Condition.appear);
        return this;

    }

    public RegistrationPage clickSelectionButton() {
        submitButton.findBy(Condition.text(selectionButtonText)).click();
        return this;
    }

    public RegistrationPage verifySelectionModalFormIsVisible() {
        selectionModalForm.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage setSelectionPrice(String value) {
        selectionPriceInput.setValue(value);
        return this;
    }

    public RegistrationPage setSelectionName(String value) {
        selectionNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setSelectionPhone(String value) {
        selectionPhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage clickSelectionSubmitButton() {
        submitButton.findBy(Condition.name(selectionButtonName)).click();
        return this;
    }

    public RegistrationPage clickMortgageButton() {
        submitButton.findBy(Condition.text(mortgageButtonText)).click();
        return this;
    }

    public RegistrationPage verifyMortgageModalFormIsVisible() {
        mortgageModalForm.shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage setMortgageName(String value) {
        mortgageNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setMortgagePhone(String value) {
        mortgagePhoneInput.setValue(value);
        return this;
    }

    public RegistrationPage setMortgagePrice(String value) {
        mortgagePriceInput.setValue(value);
        return this;
    }

    public RegistrationPage clickMortgageSubmitButton() {
        submitButton.findBy(Condition.name(mortgageButtonName)).click();
        return this;
    }

    public RegistrationPage clickFirstComplexPage() {
        flatBaseFinder.first().$("a.Button.Button_block.Button_gray").click();
        return this;
    }

    public RegistrationPage clickFirstApartmentsPage() {
        apartmentsBaseFinder.first().click();
        return this;
    }

    public RegistrationPage verifyApartmentsModalFormIsVisible() {
        apartmentsModalForm.shouldBe(Condition.visible);
        return this;
    }


}
