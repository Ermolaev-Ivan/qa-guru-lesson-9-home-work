package ivan.ermolaev.pages;

import com.codeborne.selenide.SelenideElement;
import ivan.ermolaev.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        phoneInput = $("#userNumber"),
        genderRadio = $("#genterWrapper"),
        subjectsInput = $("#subjectsInput"),
        uploadPicture = $("input[id='uploadPicture']"),
        currentAddressInput = $("#currentAddress"),
        stateInput = $("#react-select-3-input"),
        cityInput = $("#react-select-4-input"),
        submitButton = $("#submit"),
        closeLargeModalButton = $("#closeLargeModal"),
        hobbiesCheckbox = $("#hobbiesWrapper");

    String url_page_form = "/automation-practice-form";

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage setBirthDate(String[] array) {
        calendarComponent.setDate(array); 
        return this;
    }

    public RegistrationPage openPage() {
        open(url_page_form);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String name){
        lastNameInput.setValue(name);
        return this;
    }

    public RegistrationPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage choiceGender(String gender){
        genderRadio.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhone(String phone){
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage setSubjects(String subjects){
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage choiceCheckbox(String hobby){
        hobbiesCheckbox.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String namePicture){
        uploadPicture.uploadFromClasspath(namePicture);
        return this;
    }

        public RegistrationPage setCurrentAddress(String address){
            currentAddressInput.setValue(address);
        return this;
    }

        public RegistrationPage setState(String state){
            stateInput.setValue(state).pressEnter();
        return this;
    }

        public RegistrationPage setCity(String city){
            cityInput.setValue(city).pressEnter();
        return this;
    }

        public RegistrationPage sendFormButton(){
            submitButton.scrollTo().click();
        return this;
    }

        public RegistrationPage closeModal(){
            closeLargeModalButton.scrollTo().click();
        return this;
    }
}
