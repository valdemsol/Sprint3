import Samokat.SamokatMainPage;
import Samokat.SamokatOrderPage;
import Samokat.SamokatRentPage;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.containsString;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class OrderFlow {

    private WebDriver driver;

    @Test
    public void firstOrder() { //Тест с первичными данными

        driver = new ChromeDriver(); //Подключаем Хром

        driver.get("https://qa-scooter.praktikum-services.ru/");// Переходим на сайт Самоката

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver); //Создаем объект главной страницы

        objSamMainPage.clickUpperOrderButton(); //Нажимаем на верхнюю кнопку заказа

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));// Ждем, когда появится заголовок страницы Заказа

        SamokatOrderPage objSamOrdPage = new SamokatOrderPage(driver); //Создаем объект страницы заказа

        String name = "Артем";  //Первичные входные данные
        String surname = "Бобов";
        String address = "Московская";
        String phone = "88005553535";

        objSamOrdPage.firstOrderPageFilling(name, surname, address, phone); //Передаем данные в метод заполения страницы заказа

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Про аренду']"))); // Ждем, когда появится заголовок страницы аренды

        SamokatRentPage objSamRentPage = new SamokatRentPage(driver); //Создаем объект страницы аренды

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");//Форматируем дату

        String date = LocalDate.now().plusDays(2).format(formatter); //Первичные вводные данные для полей Дата и Комментарий
        String comment = "Спасибо";

        objSamRentPage.firstRentPageFilling(date, comment);//Передаем данные в метод заполнения полей страницы аренды

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Заказ оформлен']"))); //Ждем появления страницы, что заказ оформлен

        String finalHeaderText = "Заказ оформлен"; //Проверочная переменная

        String finalHeader = objSamRentPage.textAfterOrder();//Получаем текст из заголовка

        MatcherAssert.assertThat(finalHeader, containsString(finalHeaderText));//Сравниваем, что текст из заголовка включает в себя значение переменной
    }

    @Test
    public void secondOrder() { //Тест с вторичными данными

        driver = new ChromeDriver();

        //driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickLowerOrderButton(); //Метод нажатия на нижнюю большую кнопку Заказать

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));

        SamokatOrderPage objSamOrdPage = new SamokatOrderPage(driver);

        String name = "Иванов";// Вторичные данные
        String surname = "Иван";
        String address = "Пушкинская";
        String phone = "89993334433";

        objSamOrdPage.secondOrderPageFilling(name, surname, address, phone);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='Order_Header__BZXOb' and text()='Про аренду']")));

        SamokatRentPage objSamRentPage = new SamokatRentPage(driver);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String date = LocalDate.now().plusDays(5).format(formatter);//Втроичные данные
        String comment = "Быстрее везите пожажа";

        objSamRentPage.secondRentPageFilling(date, comment);

        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Заказ оформлен']")));

        String finalHeaderText = "Заказ оформлен";

        String finalHeader = objSamRentPage.textAfterOrder();

        MatcherAssert.assertThat(finalHeader, containsString(finalHeaderText));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
