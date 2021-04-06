package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormTests {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1280x1024";
    }


    @Test
    void successFillForm() {
        practiceFormPage.openForm()
                .setName()
                .setSurname()
                .setEmail()
                .setGender()
                .setPhone()
                .setBirthDate()
                .setSubjects()
                .setHobbies()
                .imageAdd()
                .addressSet()
                .userState()
                .userCity()
                .formSubmit()
                .modalTitleAssert()
                .modalNameSurnameAssert()
                .modalEmailAssert()
                .modalGenderAssert()
                .modalPhoneAssert()
                .modalUserBirthDayAssert()
                .modalUserSubjectAssert()
                .modalUserHobbiesAssert()
                .modalUserImageAssert()
                .modalUserAddress()
                .modalStateCityAssert();
    }
}