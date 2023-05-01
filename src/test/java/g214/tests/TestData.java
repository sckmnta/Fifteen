package g214.tests;

import com.github.javafaker.Faker;

import static g214.tests.utils.RandomUtils.*;

public class TestData {

    static Faker faker;

    public static String userName = randomHeaderName(),
            phoneNumber = randomPhone(),
            userMail = randomMail(),
            price = randomPrice(),
            notifyInfo = "Ваша заявка принята! Специалист отдела продаж свяжется с Вами в течение 10 минут и ответит на все интересующие Вас вопросы",
            phoneHref = "tel:+78129202297",
            headerButtonText = "Заказать звонок",
            headerSubmitName = "callback_form[submit]",
            subText = "Вы успешно подписаны!",
            selectionButtonName = "front_personal_selection_form[submit]",
            selectionButtonText = "Оставить заявку на подбор квартир",
            mortgageButtonText = "Оставить заявку на подбор ипотечной программы",
            mortgageButtonName = "front_mortgage_help_form[submit]";


}
