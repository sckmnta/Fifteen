package g214.tests;


import g214.tests.pages.RegistrationPage;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static g214.tests.TestData.*;


public class g214ValidationTests {


    @Test
        //телефон на главной отображается и является кликабельным
    void phoneNumberIsAvaliableOnMain() {

        new RegistrationPage()
                .openPage()
                .findPhoneLink();
    }


    @Test
        //позитивный тест окна заявок в хэдере

    void headerApplicationFormPositiveTest() {
        new RegistrationPage()
                .openPage()
                .openHeaderModalForm()
                .verifyHeaderModalFormIsVisible()
                .setHeaderName(userName)
                .setHeaderPhone(phoneNumber)
                .clickHeaderSubmitButton()
                .verifyResponseForm();
    }

    @Test
        //негативный тест окна заявок в хедере
    void headerApplicationFormNegativeTest() {
        new RegistrationPage()
                .openPage()
                .openHeaderModalForm()
                .verifyHeaderModalFormIsVisible()
                .clickHeaderSubmitButton()
                .verifyResponseForm();
    }

    @Test
        //позитивный тест на подписку в футере
    void footerSubscriptionPositiveTest() {
        new RegistrationPage()
                .openPage()
                .setFooterMail(userMail)
                .clickSubscribeButton()
                .verifySubscribtion();
    }

    @Test
        //негативный тест на подписку в футере
    void footerSubscriptionNegativeTest() {
        new RegistrationPage()
                .openPage()
                .clickSubscribeButton()
                .verifySubscribtion();
    }

    @Test
        //позитивный тест на форму персональной подборки
    void selectionFormPositiveTest() {
        new RegistrationPage()
                .openPage()
                .clickSelectionButton()
                .verifySelectionModalFormIsVisible()
                .setSelectionPrice(price)
                .setSelectionName(userName)
                .setSelectionPhone(phoneNumber)
                .clickSelectionSubmitButton()
                .verifyResponseForm();

    }

    @Test
        //негативный тест на форму персональной поборки
    void selectionFormNegativeTest() {
        new RegistrationPage()
                .openPage()
                .clickSelectionButton()
                .verifySelectionModalFormIsVisible()
                .clickSelectionSubmitButton()
                .verifyResponseForm();
    }

    @Test
        //позитивный тест на форму ипотечной подборки
    void mortgageFormPositiveTest() {
        new RegistrationPage()
                .openPage()
                .clickMortgageButton()
                .verifyMortgageModalFormIsVisible()
                .setMortgageName(userName)
                .setMortgagePhone(phoneNumber)
                .setMortgagePrice(price)
                .clickMortgageSubmitButton()
                .verifyResponseForm();


    }

    @Test
        //негативный тест на форму ипотечной подборки
    void mortgageFormNegativeTest() {
        new RegistrationPage()
                .openPage()
                .clickMortgageButton()
                .verifyMortgageModalFormIsVisible()
                .clickMortgageSubmitButton()
                .verifyResponseForm();


    }

    @Test
        //блокер на работу бд
    void flatBaseIsAvaliable() {
        new RegistrationPage()
                .openPage()
                .clickFirstComplexPage();
        switchTo().window(1);
        new RegistrationPage()
                .clickFirstApartmentsPage()
                .verifyApartmentsModalFormIsVisible();


    }


}
//todo прикрутить owner, allure, теги, обернуть тест, добавить аннотации