package project;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import project.pages.MainPage;

public class TestRegistration {
    @Rule
    public DriverRule driverRule = new DriverRule();
    @Test
    public void RegistrationTest(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open();
        mainPage.typeInputFirstName();
        mainPage.typeInputLastName();
        mainPage.typeInputEmail();
        mainPage.clickOnGender();
        mainPage.typeInputMobile();
        mainPage.typeInputDateOfBirth();
        mainPage.typeInputSubjects();
        mainPage.scrollStateAndCity();
        mainPage.typeInputAddress();
        mainPage.clickOnState();
        mainPage.clickOnCity();
        mainPage.uploadPicture();
        mainPage.clickOnSubmitButton();
        mainPage.waitForSuccessPopup();
        Assert.assertTrue(MainPage.getEnteredValuesTable().isDisplayed());
    }
}
