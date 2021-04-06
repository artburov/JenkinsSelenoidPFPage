package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    Faker faker = new Faker();

    //Form page data
    private final String FORM_URL = "https://demoqa.com/automation-practice-form";
    private final String FORM_TITLE = "Student Registration Form";
    private final String USER_NAME = faker.name().firstName();
    private static String USER_NAME_ASSERT = "";
    private final String USER_SURNAME = faker.name().lastName();
    private static String USER_SURNAME_ASSERT = "";
    private final String USER_EMAIL = faker.internet().emailAddress();
    private static String USER_EMAIL_Assert = "";
    private final String USER_GENDER = "Male";
    private final String USER_PHONE = faker.phoneNumber().subscriberNumber(10);
    private static String USER_PHONE_ASSERT = "";
    private final String USER_BIRTHDAY = "15";
    private final String USER_BIRTHMONTH = "May";
    private final String USER_BIRTHYEAR = "1980";
    private final String USER_IMAGE = "robot.png";
    private final String USER_ADDRESS = faker.address().fullAddress();
    private static String USER_ADDRESS_ASSERT = "";
    private final String MODAL_TITLE = "Thanks for submitting the form";

    private final String[] USER_SUBJECTS = new String[]{"Computer Science", "Physics", "English"},
            USER_HOBBIES = new String[]{"Sports", "Music"},
            USER_STATE_CITY = new String[]{"Haryana", "Panipat"};

    //Form page objects
    private SelenideElement
            pageTitle = $(".practice-form-wrapper"),
            nameInput = $("#firstName"),
            surnameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            imageInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            userState = $("#state"),
            userCity = $("#city"),
            formSubmit = $("#submit"),
            userBirthday = $("#dateOfBirthInput"),
            userBirthMonth = $(".react-datepicker__month-select"),
            userBirthYear = $(".react-datepicker__year-select");

    //Result modal page objects
    private SelenideElement
            modalTitle = $(".modal-header"),
            modalNameSurname = $("tbody tr:nth-child(1)"),
            modalEmail = $("tbody tr:nth-child(2)"),
            modalGender = $("tbody tr:nth-child(3)"),
            modalPhone = $("tbody tr:nth-child(4)"),
            modalUserBirthDay = $("tbody tr:nth-child(5)"),
            modalUserSubjects = $("tbody tr:nth-child(6)"),
            modalUserHobbies = $("tbody tr:nth-child(7)"),
            modalUserImage = $("tbody tr:nth-child(8)"),
            modalUserAddress = $("tbody tr:nth-child(9)"),
            modalUserStateCity = $("tbody tr:nth-child(10)");


    public PracticeFormPage openForm() {
        open(FORM_URL);
        pageTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public PracticeFormPage setBirthDate() {
        userBirthday.click();
        userBirthMonth.selectOptionContainingText(USER_BIRTHMONTH);
        userBirthYear.selectOptionByValue(USER_BIRTHYEAR);
        $(byText(USER_BIRTHDAY)).click();
        return this;
    }

    public PracticeFormPage setName() {
        nameInput.val(USER_NAME);
        USER_NAME_ASSERT = USER_NAME;
        return this;
    }

    public PracticeFormPage setSurname() {
        surnameInput.val(USER_SURNAME);
        USER_SURNAME_ASSERT = USER_SURNAME;
        return this;
    }

    public PracticeFormPage setEmail() {
        emailInput.val(USER_EMAIL);
        USER_EMAIL_Assert = USER_EMAIL;
        return this;
    }

    public PracticeFormPage setGender() {
        $(byText(USER_GENDER)).click();
        return this;
    }

    public PracticeFormPage setPhone() {
        phoneInput.val(USER_PHONE);
        USER_PHONE_ASSERT = USER_PHONE;
        return this;
    }

    public PracticeFormPage setSubjects() {
        for (String subject : USER_SUBJECTS) {
            subjectsInput.click();
            subjectsInput.val("i");
            $(byText(subject)).click();
        }
        return this;
    }

    public PracticeFormPage setHobbies() {
        for (String hobby : USER_HOBBIES) {
            $(byText(hobby)).click();
        }
        return this;
    }

    public PracticeFormPage imageAdd() {
        imageInput.uploadFromClasspath(USER_IMAGE);
        return this;
    }

    public PracticeFormPage addressSet() {
        addressInput.val(USER_ADDRESS);
        USER_ADDRESS_ASSERT = USER_ADDRESS;
        return this;
    }

    public PracticeFormPage userState() {
        userState.click();
        $(byText(USER_STATE_CITY[0])).click();
        return this;
    }

    public PracticeFormPage userCity() {
        userCity.click();
        $(byText(USER_STATE_CITY[1])).click();
        return this;
    }

    public PracticeFormPage formSubmit() {
        formSubmit.click();
        return this;
    }

    //Modal assertions
    public PracticeFormPage modalTitleAssert() {
        modalTitle.shouldHave(text(MODAL_TITLE));
        return this;
    }

    public PracticeFormPage modalNameSurnameAssert() {
        modalNameSurname.shouldHave(text(USER_NAME_ASSERT + " " + USER_SURNAME_ASSERT));
        return this;
    }

    public PracticeFormPage modalEmailAssert() {
        modalEmail.shouldHave(text(USER_EMAIL_Assert));
        return this;
    }

    public PracticeFormPage modalGenderAssert() {
        modalGender.shouldHave(text(USER_GENDER));
        return this;
    }

    public PracticeFormPage modalPhoneAssert() {
        modalPhone.shouldHave(text(USER_PHONE_ASSERT));
        return this;
    }

    public PracticeFormPage modalUserBirthDayAssert() {
        modalUserBirthDay.shouldHave(text(USER_BIRTHDAY + " " + USER_BIRTHMONTH + "," + USER_BIRTHYEAR));
        return this;
    }

    public PracticeFormPage modalUserSubjectAssert() {
        for (String subject : USER_SUBJECTS) {
            modalUserSubjects.shouldHave(text(subject));
        }
        return this;
    }

    public PracticeFormPage modalUserHobbiesAssert() {
        for (String hobby : USER_HOBBIES) {
            modalUserHobbies.shouldHave(text(hobby));
        }
        return this;
    }

    public PracticeFormPage modalUserImageAssert() {
        modalUserImage.shouldHave(text(USER_IMAGE));
        return this;
    }

    public PracticeFormPage modalUserAddress() {
        modalUserAddress.shouldHave(text(USER_ADDRESS_ASSERT));
        return this;
    }

    public PracticeFormPage modalStateCityAssert() {
        for (String hobby : USER_STATE_CITY) {
            modalUserStateCity.shouldHave(text(hobby));
        }
        return this;
    }
}