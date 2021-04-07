package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Suite for student practice form")
public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @Tag("positive")
    @Owner("Arthur Burov")
    @Feature("UI verification of student practice form")
    @Story("Possitive smoke test of student practice form")
    @DisplayName("Successful flow of testing")
    @Epic("Practice form")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "StudentPracticeForm", url = "https://jira.studentpf.com")
    void successFillForm() {
        step("Filling out the student practice form", () -> {
            step("Open students registration form", () -> {
                practiceFormPage.openForm();
            });
            step("Set up student name", () -> {
                practiceFormPage.setName();
            });
            step("Set up student surname", () -> {
                practiceFormPage.setSurname();
            });
            step("Set up student e-mail", () -> {
                practiceFormPage.setEmail();
            });
            step("Set up student gender", () -> {
                practiceFormPage.setGender();
            });
            step("Set up student phone", () -> {
                practiceFormPage.setPhone();
            });
            step("Set up student birth date", () -> {
                practiceFormPage.setBirthDate();
            });
            step("Set up student subjetcs", () -> {
                practiceFormPage.setSubjects();
            });
            step("Set up student hobbies", () -> {
                practiceFormPage.setHobbies();
            });
            step("Attach student image", () -> {
                practiceFormPage.imageAdd();
            });
            step("Setup student address", () -> {
                practiceFormPage.addressSet();
            });
            step("Setup student state", () -> {
                practiceFormPage.userState();
            });
            step("Setup student city", () -> {
                practiceFormPage.userCity();
            });
            step("Submit student form", () -> {
                practiceFormPage.formSubmit();
            });
        });
        step("Verifying the completed student practice form in the modal window", () -> {
            step("Verify modal title", () -> {
                practiceFormPage.modalTitleAssert();
            });
            step("Verify student name and surname", () -> {
                practiceFormPage.modalNameSurnameAssert();
            });
            step("Verify student email", () -> {
                practiceFormPage.modalEmailAssert();
            });
            step("Verify student gender", () -> {
                practiceFormPage.modalGenderAssert();
            });
            step("Verify student phone", () -> {
                practiceFormPage.modalPhoneAssert();
            });
            step("Verify student date of birth", () -> {
                practiceFormPage.modalUserBirthDateAssert();
            });
            step("Verify student subjects", () -> {
                practiceFormPage.modalUserSubjectAssert();
            });
            step("Verify student hobbies", () -> {
                practiceFormPage.modalUserHobbiesAssert();
            });
            step("Verify student image", () -> {
                practiceFormPage.modalUserImageAssert();
            });
            step("Verify student address", () -> {
                practiceFormPage.modalUserAddress();
            });
            step("Verify student state and city", () -> {
                practiceFormPage.modalStateCityAssert();
            });
        });
    }

    @Test
    @Tag("negative")
    @Owner("Arthur Burov")
    @Feature("UI verification of student practice form")
    @Story("Negative smoke test of student practice form")
    @DisplayName("Unsuccessful flow of testing")
    @Epic("Practice form")
    void negativeFillForm() {
        step("Filling out the student practice form", () -> {
            step("Open students registration form", () -> {
                practiceFormPage.openForm();
            });
            step("Set up student name", () -> {
                practiceFormPage.setName();
            });
            step("Set up student surname", () -> {
                practiceFormPage.setSurname();
            });
            step("Set up student e-mail", () -> {
                practiceFormPage.setEmail();
            });
            step("Set up student gender", () -> {
                practiceFormPage.setGender();
            });
            step("Set up student phone", () -> {
                practiceFormPage.setPhone();
            });
            step("Set up student birth date", () -> {
                practiceFormPage.setBirthDate();
            });
            step("Set up student subjetcs", () -> {
                practiceFormPage.setSubjects();
            });
            step("Set up student hobbies", () -> {
                practiceFormPage.setHobbies();
            });
            step("Attach student image", () -> {
                practiceFormPage.imageAdd();
            });
            step("Setup student address", () -> {
                practiceFormPage.addressSet();
            });
            step("Setup student state", () -> {
                practiceFormPage.userState();
            });
            step("Setup student city", () -> {
                practiceFormPage.userCity();
            });
            step("Submit student form", () -> {
                practiceFormPage.formSubmit();
            });
        });
        step("Verifying the completed student practice form in the modal window", () -> {
            step("Verify modal title", () -> {
                practiceFormPage.modalTitleAssert();
            });
            step("Verify student name and surname", () -> {
                practiceFormPage.modalNameSurnameAssert();
            });
            step("Verify student email", () -> {
                practiceFormPage.modalEmailAssert();
            });
            step("Verify student gender", () -> {
                practiceFormPage.modalGenderAssert();
            });
            step("Verify student phone", () -> {
                practiceFormPage.modalPhoneAssert();
            });
            step("Verify student date of birth", () -> {
                practiceFormPage.modalUserBirthDateAssert();
            });
            step("Verify student subjects", () -> {
                practiceFormPage.modalUserSubjectAssert();
            });
            step("Verify student hobbies", () -> {
                practiceFormPage.modalUserHobbiesAssert();
            });
            step("Verify student image", () -> {
                practiceFormPage.modalUserImageAssert();
            });
            step("Verify student address", () -> {
                practiceFormPage.modalUserAddress();
            });
            step("Verify student state and city", () -> {
                practiceFormPage.modalStateCityNegativeAssert();
            });
        });
    }
}