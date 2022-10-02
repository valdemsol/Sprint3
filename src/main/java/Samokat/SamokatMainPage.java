package Samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



// Главная страница
public class SamokatMainPage {

    // Создаем драйвер для страницы
    private WebDriver driver;
    //Локаторы вопросов
 private By firstQuestion = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
 private By secondQuestion = By.xpath(".//div[@class='accordion__button' and starts-with(text(),'Хочу')]");
 private By thirdQuestion = By.xpath(".//div[@class='accordion__button' and starts-with(text(),'Как')]");
 private By fourthQuestion = By.xpath(".//div[@class='accordion__button' and starts-with(text(),'Можно ли заказать')]");
 private By fifthQuestion = By.xpath(".//div[@class='accordion__button' and starts-with(text(),'Можно ли продлить')]");
 private By sixthQuestion = By.xpath(".//div[@class='accordion__button' and starts-with(text(),'Вы привозите')]");
 private By seventhQuestion = By.xpath(".//div[@class='accordion__button' and starts-with(text(),'Можно ли отменить')]");
 private By eighthQuestion = By.xpath(".//div[@class='accordion__button' and starts-with(text(),'Я')]");

    //Локаторы ответов на вопросы
 private By firstAnswer = By.xpath(".//p[starts-with(text(),'Сутки')]");
 private By secondAnswer = By.xpath(".//p[starts-with(text(),'Пока что у нас')]");
 private By thirdAnswer = By.xpath(".//p[starts-with(text(),'Допустим')]");
 private By fourthAnswer = By.xpath(".//p[starts-with(text(),'Только')]");
 private By fifthAnswer = By.xpath(".//p[starts-with(text(),'Пока что нет!')]");
 private By sixthAnswer = By.xpath(".//p[starts-with(text(),'Самокат приезжает')]");
 private By seventhAnswer = By.xpath(".//p[starts-with(text(),'Да, пока самокат не привезли')]");
 private By eighthAnswer = By.xpath(".//p[starts-with(text(),'Да, обязательно.')]");

 private By upperOrderButton = By.className("Button_Button__ra12g"); //Верхняя кнопка "Заказать"
 private By lowerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"); // Нижняя кнопка "Заказать"


 public SamokatMainPage(WebDriver driver){
  this.driver = driver;
 }

 // Метод нажатия по верхней кнопке "Заказать"

 public void clickUpperOrderButton() {
  driver.findElement(upperOrderButton).click();
 }

 // Метод прокрутки до нижней кнопки "Заказать" и последующее нажатие на нее

 public void scrollAndClickLowerOrderButton() {
  WebElement element = driver.findElement(lowerOrderButton);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  new WebDriverWait(driver, 5)
          .until(ExpectedConditions.visibilityOfElementLocated(lowerOrderButton));

  driver.findElement(lowerOrderButton).click();

 }


// 2 метода к кадому вопросу:
 // 1. Для прокрутки к элементу, нажатию на элемент и ожиданию появления элемента ответа
 // 2. Метод для получения текста из элемента ответа
 // Ко всем вопросам одинаковый подход, различие только в локаторах

 // Вопрос 1
 public void scrollAndClickFirstQuest(){

  WebElement element = driver.findElement(firstQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(firstQuestion).click();

   new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(firstAnswer));
 }
 public String textInFirstAnsw(){
  return driver.findElement(firstAnswer).getText();
 }

 // Вопрос 2
 public void scrollAndClickSecQuest(){

  WebElement element = driver.findElement(secondQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(secondQuestion).click();

   new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(secondAnswer));
 }
 public String textInSecAnsw(){
  return driver.findElement(secondAnswer).getText();
 }

 // Вопрос 3
 public void scrollAndClickThirdQuest(){

  WebElement element = driver.findElement(thirdQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(thirdQuestion).click();

  new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(thirdAnswer));
 }
 public String textInThirdAnsw(){
  return driver.findElement(thirdAnswer).getText();
 }

 // Вопрос 4
 public void scrollAndClickFourQuest(){

  WebElement element = driver.findElement(fourthQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(fourthQuestion).click();

  new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(fourthAnswer));
 }
 public String textInFourAnsw(){
  return driver.findElement(fourthAnswer).getText();
 }

 // Вопрос 5
 public void scrollAndClickFifthQuest(){

  WebElement element = driver.findElement(fifthQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(fifthQuestion).click();

  new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(fifthAnswer));
 }
 public String textInFifthAnsw(){
  return driver.findElement(fifthAnswer).getText();
 }

 // Вопрос 6
 public void scrollAndClickSixQuest(){

  WebElement element = driver.findElement(sixthQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(sixthQuestion).click();

  new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(sixthAnswer));
 }
 public String textInSixAnsw(){
  return driver.findElement(sixthAnswer).getText();
 }

 // Вопрос 7
 public void scrollAndClickSevenQuest(){

  WebElement element = driver.findElement(seventhQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(seventhQuestion).click();

  new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(seventhAnswer));
 }
 public String textInSevAnsw(){
  return driver.findElement(seventhAnswer).getText();
 }

 // Вопрос 8
 public void scrollAndClickEightQuest(){

  WebElement element = driver.findElement(eighthQuestion);
  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

  driver.findElement(eighthQuestion).click();

  new WebDriverWait(driver, 3)
          .until(ExpectedConditions.visibilityOfElementLocated(eighthAnswer));
 }
 public String textInEightAnsw(){
  return driver.findElement(eighthAnswer).getText();
 }

 public void tearDown() {
  driver.quit();
 }//Метод закрытия браузера

}


