package ivan.ermolaev.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {

    public void setDate(String[] args) {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(args[1]);
        $(".react-datepicker__year-select").selectOption(args[2]);
//        $(".react-datepicker__day--0" + day +
//                ":not(.react-datepicker__day--outside-month)").click();
        String dayLocator = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", args[0]);
        $(dayLocator).click();
    }
}