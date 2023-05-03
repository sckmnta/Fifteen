package g214.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Tag("remote")
public class g214ValidationTests extends TestBase {


    @Test
    @Feature("Header Phone Test")
    @Story("Open main page and check if phone link s available on main page")
    @Owner("sckmnta")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Header phone link should be clickable")
    void phoneNumberIsAvaliableOnMain() {

        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("check if phone link is available", () -> {
            registrationPage.findPhoneLink();
            ;
        });


    }


    @Test
    @Feature("Header Modal Form Test")
    @Story("Open header modal form, fill header modal form, submit header modal form")
    @Owner("sckmnta")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Positive Header Modal Form Test")
    void headerApplicationFormPositiveTest() {

        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Open header modal form", () -> {
            registrationPage.openHeaderModalForm();
        });
        step("Verify header modal form is opened", () -> {
            registrationPage.verifyHeaderModalFormIsVisible();
        });
        step("Fill header form and click submit button", () -> {
            registrationPage.setHeaderName(userName)
                    .setHeaderPhone(phoneNumber)
                    .clickHeaderSubmitButton();
        });
        step("Verify response form is visible", () -> {
            registrationPage.verifyResponseForm();
        });
    }

    @Test
    @Feature("Header Modal Form Test")
    @Story("Open header modal form, not fill form, submit header modal form, verify")
    @Owner("sckmnta")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Negative Header Modal Form Test")
    void headerApplicationFormNegativeTest() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Open header modal form", () -> {
            registrationPage.openHeaderModalForm();
        });
        step("Verify header modal form is opened", () -> {
            registrationPage.verifyHeaderModalFormIsVisible();
        });
        step("Click submit button with unfilled modal form", () -> {
            registrationPage.clickHeaderSubmitButton();
        });
        step("Verify response form is visible", () -> {
            registrationPage.verifyResponseFormNegative();
        });

    }

    @Test
    @Feature("Subscription Form Test")
    @Story("Fill subscribe form in footer, click submit, verify")
    @Owner("sckmnta")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Positive Subscription Test")
    void footerSubscriptionPositiveTest() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Fill mail form and click subscribe button", () -> {
            registrationPage.setFooterMail(userMail)
                    .clickSubscribeButton();
        });
        step("Verify", () -> {
            registrationPage.verifySubscribtion();
        });
    }

    @Test
    @Feature("Subscription Form Test")
    @Story("Fill subscribe form in footer, click submit, verify")
    @Owner("sckmnta")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Negative Subscription Test")
    void footerSubscriptionNegativeTest() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Fill mail form and click subscribe button", () -> {
            registrationPage.clickSubscribeButton();
        });
        step("Verify", () -> {
            registrationPage.verifySubscribtionNegative();
        });
    }

    @Test
    @Feature("Selection Modal Form Test")
    @Story("Open selection modal form, fill selection modal form, submit selection modal form")
    @Owner("sckmnta")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Positive Selection Modal Form Test")
    void selectionFormPositiveTest() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Open selection modal form", () -> {
            registrationPage.clickSelectionButton();
        });
        step("Verify selection modal form is opened", () -> {
            registrationPage.verifySelectionModalFormIsVisible();
        });
        step("Fill selection form and click submit button", () -> {
            registrationPage.setSelectionPrice(price)
                    .setSelectionName(userName)
                    .setSelectionPhone(phoneNumber)
                    .clickSelectionSubmitButton();
        });
        step("Verify response form is visible", () -> {
            registrationPage.verifyResponseForm();
        });


    }

    @Test
    @Feature("Selection Modal Form Test")
    @Story("Open selection modal form, not fill form, submit selection modal form, verify")
    @Owner("sckmnta")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Negative Selection Modal Form Test")
    void selectionFormNegativeTest() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Open selection modal form", () -> {
            registrationPage.clickSelectionButton();
        });
        step("Verify selection modal form is opened", () -> {
            registrationPage.verifySelectionModalFormIsVisible();
        });
        step("Click submit button with unfilled modal form", () -> {
            registrationPage.clickSelectionSubmitButton();
        });
        step("Verify response form is visible", () -> {
            registrationPage.verifyResponseFormNegative();
        });
    }

    @Test
    @Feature("Mortgage Modal Form Test")
    @Story("Open mortgage modal form, fill mortgage modal form, submit mortgage modal form")
    @Owner("sckmnta")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Positive Mortgage Modal Form Test")
    void mortgageFormPositiveTest() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Open mortgage modal form", () -> {
            registrationPage.clickMortgageButton();
        });
        step("Verify mortgage modal form is opened", () -> {
            registrationPage.verifyMortgageModalFormIsVisible();
        });
        step("Fill mortgage form and click submit button", () -> {
            registrationPage.setMortgageName(userName)
                    .setMortgagePhone(phoneNumber)
                    .setMortgagePrice(price)
                    .clickMortgageSubmitButton();
        });
        step("Verify response form is visible", () -> {
            registrationPage.verifyResponseForm();
        });


    }

    @Test
    @Feature("Mortgage Modal Form Test")
    @Story("Open mortgage modal form, not fill form, submit mortgage modal form, verify")
    @Owner("sckmnta")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Negative Mortgage Modal Form Test")
        //негативный тест на форму ипотечной подборки
    void mortgageFormNegativeTest() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Open mortgage modal form", () -> {
            registrationPage.clickMortgageButton();
        });
        step("Verify mortgage modal form is opened", () -> {
            registrationPage.verifySelectionModalFormIsVisible();
        });
        step("Click submit button with unfilled modal form", () -> {
            registrationPage.clickMortgageSubmitButton();
        });
        step("Verify response form is visible", () -> {
            registrationPage.verifyResponseFormNegative();
        });

    }

    @Test
    @Feature("DataBase is working")
    @Story("Open first displayed complex on main page, in new tab check if first layout is available")
    @Owner("sckmnta")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Main Page", url = "https://214g.ru")
    @DisplayName("Layout Test")
        //блокер на работу бд
    void flatBaseIsAvaliable() {
        step("Open main page", () -> {
            registrationPage.openPage();
        });
        step("Click on first complex in listing", () -> {
            registrationPage.clickFirstComplexPage();
            ;
        });
        step("Change tab to newly opened", () -> {
            switchTo().window(1);
        });
        step("Click on first apartment in listing", () -> {
            registrationPage.clickFirstApartmentsPage();
        });
        step("Verify apartments response form is visible", () -> {
            registrationPage.verifyApartmentsModalFormIsVisible();
        });


    }
}
//todo прикрутить registrationModal