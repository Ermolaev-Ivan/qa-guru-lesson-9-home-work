package ivan.ermolaev.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
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

        String arr[] = new String[3];
        arr[0] = "12";
        arr[1] = "November";
        arr[2] = "2000";
//        String[] arr = {"19", "Jul", "1975"};

//        System.out.println(arr);
//        System.out.println(Arrays.toString(testData.date)); // Sat Jul 19 07:12:01 GMT+03:00 1975
//        System.out.println(testData.dateFaker); // Sat Jul 19 07:12:01 GMT+03:00 1975
        System.out.println(testData.dateFaker1);

        registrationPage
                .openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.Email)
                .choiceGender(testData.gender)
                .setPhone(testData.phone)
                .setBirthDate(arr)
                .setSubjects("Physics")
                .setSubjects("English")
                .choiceCheckbox("Sports")
                .choiceCheckbox("Reading")
                .choiceCheckbox("Music")
                .setCurrentAddress(testData.fullAddress)
                .uploadPicture("Gordon.jpg")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .sendFormButton();

// Validation form
        $("#example-modal-sizes-title-lg").shouldBe(visible);
        $(".table").shouldHave(text(testData.firstName + " " + testData.lastName),
                text(testData.Email),
                text(testData.gender),
                text(testData.phone),
                text(format("%s %s,%s", arr[0],arr[1],arr[2])),
                text("Physics, English"),
                text("Sports, Reading, Music"),
                text("Gordon.jpg"),
                text(testData.fullAddress),
                text("Rajasthan Jaiselmer"));

// Close form
        registrationPage.closeModal();
        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }
}
