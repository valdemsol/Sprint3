package Samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SamokatRentPage {

    private WebDriver driver;

    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");// Поле даты доставки самоката
    private By rentTimeField = By.xpath(".//div[text()='* Срок аренды']"); // Поле срока аренды самоката

    private By oneDayRent = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']"); // Выбор заказа на сутки
    private By twoDaysRent = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']"); // Выбор заказа на двое суток

    private By blackCheckbox = By.xpath(".//label[@class='Checkbox_Label__3wxSf']/input[@id='black']"); // Выбор чекбокса с черным цветом
    private By greyCheckbox = By.xpath(".//label[@class='Checkbox_Label__3wxSf']/input[@id='grey']"); // Выбор чекбокса с серым цветом

    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']"); // Поле комментария для курьера
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']"); // Нижняя кнопка "Заказать"
    private By finalQuestion = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    private By acceptButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[text()='Да']"); // Кнопка "Да" для подтверждения заказа
    private By orderHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']"); // Текст о том, что заказ оформлен

    public SamokatRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение поля с датой
    public void fillDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }

    //Заполнение поля со сроком аренды для первичных данных
    public void setRentTimeOne() {
        driver.findElement(rentTimeField).click();
        driver.findElement(oneDayRent).click();
    }

    //Для вторичных данных
    public void setRentTimeTwo() {
        driver.findElement(rentTimeField).click();
        driver.findElement(twoDaysRent).click();
    }

    //Ставим черный чекбокс для первичных данных
    public void setBlackCheckbox() {
        driver.findElement(blackCheckbox).click();
    }

    //Ставим серый чекбокс для вторичных данных
    public void setGreyCheckbox() {
        driver.findElement(greyCheckbox).click();
    }

    //Заполняем комментарий
    public void setCommentField(String comment) {
        driver.findElement(commentField).click();
        driver.findElement(commentField).sendKeys(comment);
    }

    //Нажимаем кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Ждем, когда появится страница подтверждения
    public void waitForLoadFinalQuestion() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(finalQuestion));
    }

    //Подтверждаем заказ
    public void clickAcceptionButton() {
        driver.findElement(acceptButton).click();
    }

    //Получаем текст со страницы удачного оформления заказа
    public String textAfterOrder() {
        return driver.findElement(orderHeader).getText();
    }

    //Заполнение страницы аренды с первичными данными
    public void firstRentPageFilling(String date, String comment) {
        fillDateField(date);
        setRentTimeOne();
        setBlackCheckbox();
        setCommentField(comment);
        clickOrderButton();
        waitForLoadFinalQuestion();
        clickAcceptionButton();
    }

    //Вторичные данные
    public void secondRentPageFilling(String date, String comment) {
        fillDateField(date);
        setRentTimeTwo();
        setGreyCheckbox();
        setCommentField(comment);
        clickOrderButton();
        waitForLoadFinalQuestion();
        clickAcceptionButton();
    }

}
