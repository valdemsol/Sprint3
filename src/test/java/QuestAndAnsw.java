import Samokat.SamokatMainPage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.Matchers.*;


public class QuestAndAnsw {

    private WebDriver driver;

    @Test
    public void checkFirstQuest() {

        driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickFirstQuest();

        String firstAnswerTxt = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        String firstText = objSamMainPage.textInFirstAnsw();
        MatcherAssert.assertThat(firstText, is(firstAnswerTxt));

        objSamMainPage.tearDown();
    }

    @Test
    public void checkSecQuest() {

        driver = new ChromeDriver();

        // driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickSecQuest();

        String secondAnswerTxt = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        String secondText = objSamMainPage.textInSecAnsw();
        MatcherAssert.assertThat(secondText, is(secondAnswerTxt));

        objSamMainPage.tearDown();
    }

    @Test
    public void checkThirdQuest() {

        driver = new ChromeDriver();

        // driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickThirdQuest();

        String thirdAnswerTxt = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

        String thirdText = objSamMainPage.textInThirdAnsw();
        MatcherAssert.assertThat(thirdText, is(thirdAnswerTxt));

        objSamMainPage.tearDown();
    }

    @Test
    public void checkFourQuest() {

        driver = new ChromeDriver();

        // driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickFourQuest();

        String fourAnswerTxt = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

        String fourText = objSamMainPage.textInFourAnsw();
        MatcherAssert.assertThat(fourText, is(fourAnswerTxt));

        objSamMainPage.tearDown();
    }


    @Test
    public void checkFifthQuest() {

        driver = new ChromeDriver();

        //driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickFifthQuest();

        String fifthAnswerTxt = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

        String fifthText = objSamMainPage.textInFifthAnsw();
        MatcherAssert.assertThat(fifthText, is(fifthAnswerTxt));

        objSamMainPage.tearDown();
    }

    @Test
    public void checkSixQuest() {

        driver = new ChromeDriver();

        //driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickSixQuest();

        String sixAnswerTxt = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

        String sixText = objSamMainPage.textInSixAnsw();
        MatcherAssert.assertThat(sixText, is(sixAnswerTxt));

        objSamMainPage.tearDown();
    }

    @Test
    public void checkSevQuest() {

        driver = new ChromeDriver();

        // driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickSevenQuest();

        String sevAnswerTxt = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

        String sevText = objSamMainPage.textInSevAnsw();
        MatcherAssert.assertThat(sevText, is(sevAnswerTxt));

        objSamMainPage.tearDown();
    }

    @Test
    public void checkEightQuest() {

        driver = new ChromeDriver();

        //driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        SamokatMainPage objSamMainPage = new SamokatMainPage(driver);

        objSamMainPage.scrollAndClickEightQuest();

        String eightAnswerTxt = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        String eightText = objSamMainPage.textInEightAnsw();
        MatcherAssert.assertThat(eightText, is(eightAnswerTxt));

        objSamMainPage.tearDown();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
