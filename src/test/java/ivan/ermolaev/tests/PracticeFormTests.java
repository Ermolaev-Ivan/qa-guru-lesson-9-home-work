package ivan.ermolaev.tests;

import org.junit.jupiter.api.Test;
import ivan.ermolaev.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class PracticeFormTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void formTest() {

        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.Email)
                .choiceGender(testData.gender)
                .setPhone(testData.phone)
                .setBirthDate(testData.date)
                .setSubjects("Physics")
                .setSubjects("English")
                .choiceCheckbox("Sports")
                .choiceCheckbox("Reading")
                .choiceCheckbox("Music")
                .setCurrentAddress(testData.fullAddress)
//                .uploadPicture("Gordon.jpg")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .sendFormButton();

// Validation form
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table").shouldHave(text(testData.firstName + " " + testData.lastName),
                text(testData.Email),
                text(testData.gender),
                text(testData.phone),
                text(format("%s %s,%s", testData.date[0],testData.date[1],testData.date[2])),
                text("Physics, English"),
                text("Sports, Reading, Music"),
//                text("Gordon.jpg"),
                text(testData.fullAddress),
                text("Rajasthan Jaiselmer"));

// Close form
        registrationPage.closeModal();
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}
