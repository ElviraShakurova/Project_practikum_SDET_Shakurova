package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private static final By inputFirstName = By.id("firstName"); // Поле "First Name"
    private static final By inputLastName = By.id("lastName"); //  поле "Last Name"
    private static final By inputEmail = By.xpath("//*[@id=\'userEmail\']"); //  поле "Email"
    private static final By inputGender = By.cssSelector("label[for=\'gender-radio-2\']"); // значение "Femail" в поле "Gender"
    private static final By inputMobile = By.id("userNumber"); // поле "Mobile"
    private static final By inputDateOfBirth = By.id("dateOfBirthInput"); // Поле "Date of birth"
    private static final By inputMonth = By.className("react-datepicker__month-select"); // Поле "Месяц" в всплывающем календаре
    private static final By chooseMonth = By.cssSelector(".react-datepicker__month-select option[value='2']"); // Месяц "Март" в дропдауне, после клика на поле "Месяц"
    private static final By inputYear = By.className("react-datepicker__year-select"); // Поле "Год" в всплывающем календаре
    private static final By chooseYear = By.cssSelector(".react-datepicker__year-select option[value='2002']"); // Выбор "2002" в дропдауне, после клика на поле "Год"
    private static final By chooseDay = By.cssSelector(".react-datepicker__day.react-datepicker__day--011"); // Дата на всплывающем календаре
    private static final By inputSubjects = By.cssSelector("div.subjects-auto-complete__value-container input#subjectsInput"); // поле "Subjects"
    private static final By inputAddress = By.id("currentAddress"); // поле "Current Address"
    private static final By stateAndCity = By.id("stateCity-label"); // заголовок "State fnd City"
    private static final By state = By.xpath("//*[@id=\'state\']/div/div[2]/div"); // Поле "Select State"
    private static final By chooseState = By.className("css-1n7v3ny-option"); // Выбор значения в выпадающем списке в Select State
    private static final By city = By.xpath("//*[@id=\'city\']/div/div[2]/div"); // Поле "Select City"
    private static final By chooseCity = By.cssSelector("div.css-1uccc91-singleValue"); // Выбор значения в выпадающем списке в Select City
    private static final By inputPicture = By.id("uploadPicture"); // поле для загрузки изображения "Picture"
    private static final By submitButton = By.id("submit"); // Кнопка "Submit"
    private static final By successPopup = By.id("example-modal-sizes-title-lg"); //  всплывающее окно с заголовком "Thanks for submitting the form"
    private static final By enteredValuesTable = By.cssSelector("div.table-responsive table.table"); // таблица на окне "Thanks for submitting the form" с введенными ранее значениями

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {                       // Загрузка страницы

        driver.get("https://demoqa.com/automation-practice-form");
    }
    public void typeInputFirstName(){                 // ввод значения в поле "First Name"
        driver.findElement(inputFirstName).sendKeys("Мэрилин");
    }

     public void typeInputLastName(){                // ввод значения в поле "Last Name"
        driver.findElement(inputLastName).sendKeys("Монро");
    }
    public void typeInputEmail(){                    // ввод значения в поле "Email"

        driver.findElement(inputEmail).sendKeys("Marylin@mail.com");
    }
    public void clickOnGender(){

        driver.findElement(inputGender).click();   // клик на в поле Gender с помощью переключателя
    }
    public void typeInputMobile(){

        driver.findElement(inputMobile).sendKeys("8999999999"); // ввод значения в поле "Mobile"
    }
    public void typeInputDateOfBirth(){         // ввод даты с поле "Date of birth" с помощью всплывающего календаря

        driver.findElement(inputDateOfBirth).click();
        driver.findElement(inputMonth).click();
        driver.findElement(chooseMonth).click();
        driver.findElement(inputYear).click();
        driver.findElement(chooseYear).click();
        driver.findElement(chooseDay).click();
    }
    public void typeInputSubjects(){
        driver.findElement(inputSubjects).sendKeys("Тест"); // ввод значения в поле "Subjects"
    }
    public void scrollStateAndCity() {      // скрол до заголовка "State fnd City"
        WebElement element = driver.findElement(stateAndCity);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void typeInputAddress(){          // ввод значения в поле "Current Address"
        driver.findElement(inputAddress).sendKeys("Сан-Франциско, ул. Звездная 12");
    }
    public void clickOnState(){            // выбор значения в Select State с помощью выпадающего списка
        driver.findElement(state).click();
        driver.findElement(chooseState).click();
    }
    public void clickOnCity(){             // выбор значения в Select City с помощью выпадающего списка
        driver.findElement(city).click();
        driver.findElement(chooseCity).click();
    }
    public void uploadPicture(){           // загрузка изображения в поле Picture
        driver.findElement(inputPicture).sendKeys("C:/Users/3060/Pictures/bfoto_ru_4761.jpg");
    }
    public void clickOnSubmitButton() {     // клик на кнопку "Submit"
        driver.findElement(submitButton).click();
    }
    public void waitForSuccessPopup(){       //  ожидание появления окна с заголовком "Thanks for submitting the form"
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(successPopup));
    }
    public static WebElement getEnteredValuesTable() { // появление таблицы на окне с заголовком "Thanks for submitting the form" с введенными ранее значениями
        return (WebElement) enteredValuesTable;
    }
}
