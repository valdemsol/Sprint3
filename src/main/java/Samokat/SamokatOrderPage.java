package Samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SamokatOrderPage {

    private WebDriver driver;

    private By nameField = By.xpath(".//input[@placeholder='* Имя']"); // поле "Имя"
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']"); // поле "Фамилия"
    private By orderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']"); // поле "Адрес"
    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']"); // Поле с dropdown списком "Станция метро"
    private By firstStation = By.xpath(".//div[@class='select-search__select']/ul/li/button[@value='2']");

    private By secondStation = By.xpath(".//div[@class='select-search__select']/ul/li/button[@value='5']");
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']"); // поле "Телефон"

    private By nextButton = By.xpath(".//button[text()='Далее']"); //Кнопка "Далее"


    public SamokatOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы


    //Заполнение поля с именем
    public void setName(String name) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }


    //Заполнение поля с фамилией
    public void setSurname(String surname) {
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surname);
    }


    //Заполнение поля с адресом
    public void setAddress(String address) {
        driver.findElement(orderAddress).click();
        driver.findElement(orderAddress).sendKeys(address);
    }


    //Выбор станции для перивчных данных
    public void selectFirstMetro() {
        driver.findElement(metroStation).click();
        driver.findElement(firstStation).click();
    }


    //Выбор станции для вторичных данных
    public void selectSecondMetro() {
        driver.findElement(metroStation).click();
        driver.findElement(secondStation).click();
    }


    //Заполнение поля с телефоном
    public void setPhoneNumber(String phone) {
        driver.findElement(phoneNumber).click();
        driver.findElement(phoneNumber).sendKeys(phone);
    }
//Нажатие кнопки "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }


    //Метод для заполнения страницы заказа с первичными данными
    public void firstOrderPageFilling(String name, String surname, String address, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectFirstMetro();
        setPhoneNumber(phone);
        clickNextButton();
    }

    //Также и для вторичных данных
    public void secondOrderPageFilling(String name, String surname, String address, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectSecondMetro();
        setPhoneNumber(phone);
        clickNextButton();

    }

}