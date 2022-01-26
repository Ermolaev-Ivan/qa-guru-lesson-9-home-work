package ivan.ermolaev.tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

//    faker data
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String Email = faker.internet().emailAddress();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String fullAddress = faker.address().fullAddress();
    String gender = "Male"; // Male, Female, Other
    String[] date = {"12","November", "2000"};
}
