package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final static String WRONG_ORDER = "1234";
    private final static String ORDER_NUM = "408128";
    private final SelenideElement mainHeaderlogo = $x("//a[contains(@class,\"Header_LogoScooter\")]");
    private final SelenideElement orderButtonHeader = $x("//div[contains(@class,\"Header_Nav\")]/button[contains(text(),\"Заказать\")]");
    private final SelenideElement orderStatusButton = $x("//button[contains(text(),\"Статус заказа\")]");
    private final SelenideElement logoScooter = $x("//a[contains(@class,\"Header_LogoScooter\")]");
    private final SelenideElement logoYandex = $x("//a[contains(@class,\"Header_LogoYandex\")]");
    private final SelenideElement questionsAbout = $x("//div[contains(text(),\"Вопросы о важном\")]");
    // Вопросы - элементы ///////////////////////////////////////////////
    private final SelenideElement question0 = $x("//div[@id=\"accordion__heading-0\"]");
    private final SelenideElement question1 = $x("//div[@id=\"accordion__heading-1\"]");
    private final SelenideElement question2 = $x("//div[@id=\"accordion__heading-2\"]");
    private final SelenideElement question3 = $x("//div[@id=\"accordion__heading-3\"]");
    private final SelenideElement question4 = $x("//div[@id=\"accordion__heading-4\"]");
    private final SelenideElement question5 = $x("//div[@id=\"accordion__heading-5\"]");
    private final SelenideElement question6 = $x("//div[@id=\"accordion__heading-6\"]");
    private final SelenideElement question7 = $x("//div[@id=\"accordion__heading-7\"]");
    // Ответы элементы ///////////////////////////////////////////////
    private final SelenideElement answerElem0 = $x("//div[@id=\"accordion__panel-0\"]/p");
    private final SelenideElement answerElem1 = $x("//div[@id=\"accordion__panel-1\"]/p");
    private final SelenideElement answerElem2 = $x("//div[@id=\"accordion__panel-2\"]/p");
    private final SelenideElement answerElem3 = $x("//div[@id=\"accordion__panel-3\"]/p");
    private final SelenideElement answerElem4 = $x("//div[@id=\"accordion__panel-4\"]/p");
    private final SelenideElement answerElem5 = $x("//div[@id=\"accordion__panel-5\"]/p");
    private final SelenideElement answerElem6 = $x("//div[@id=\"accordion__panel-6\"]/p");
    private final SelenideElement answerElem7 = $x("//div[@id=\"accordion__panel-7\"]/p");
    // Ответы для сравнения ///////////////////////////////////////////////
    private final String answer0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String answer1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String answer2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String answer3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String answer4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String answer5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String answer6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String answer7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    /**
     * Конструктор, где сразу задан URL и проверяется, что главная страница загрузилась.
     *
     * @param url
     */
    public MainPage(String url) {
        Selenide.open(url);
        header().shouldBe(Condition.visible);
    }

    public SelenideElement header() {
        return $x("//div[contains(text(),\"Самокат \")]");
    }

    public MainPage checkLogoHref() {
        header().click();
        return this;
    }

    /**
     * Метод вводит НЕ ВЕРНЫЙ номер заказа и выполняет поиск
     *
     * @return
     */
    public WrongOrderSearchPage statusErrorOrderClick() {
        $x("//button[contains(@class,\"Header_Link\")][contains(text(),\"Статус\")]").click();
        $x("//input[contains(@class,\"Input_Input\")][contains(@placeholder,\"Введите номер\")]").sendKeys(WRONG_ORDER);
        $x("//button[contains(@class,\"Header_Button\")][contains(text(),\"Go!\")]").click();
        return new WrongOrderSearchPage();
    }

    /**
     * Метод вводит ВЕРНЫЙ номер заказа и выполняет поиск
     *
     * @return
     */
    public StatusOrderPage statusOrderClick() {
        $x("//button[contains(@class,\"Header_Link\")][contains(text(),\"Статус\")]").click();
        $x("//input[contains(@class,\"Input_Input\")][contains(@placeholder,\"Введите номер\")]").sendKeys(ORDER_NUM);
        $x("//button[contains(@class,\"Header_Button\")][contains(text(),\"Go!\")]").click();
        return new StatusOrderPage();
    }

    public YandexMainPage yandexLogoClick() {
        logoYandex.should(Condition.exist).shouldBe(Condition.visible).click();
        return new YandexMainPage();
    }

    public String getHeader() {
        return header().shouldBe(Condition.visible).getText();
    }

    public Boolean getHeaderPresents() {
        return header().shouldBe(Condition.visible).exists();
    }


    public OrderPage makeOrderButtonClick() {
        orderButtonHeader.shouldBe(Condition.visible).click();
        return new OrderPage();
    }


    /**
     * Метод возвращает True или False при сравнении.
     *
     * @param question
     * @param answerExpected
     * @param answerActual
     * @return
     */
    public boolean checkAnswerQuestion(SelenideElement question, String answerExpected, SelenideElement answerActual) {
        question.scrollTo(); // скролим вниз до нужного элемента - Вопрос
        question.should(Condition.exist).shouldBe(Condition.visible).click(); // проверяем наличие элемента и кликаем по нему.
        //Проверяем: наличие элемента ответа, достаем текст, сравниваем его текст с ожидаемым текстом.
        return answerActual.should(Condition.exist).shouldBe(Condition.visible).getText().contains(answerExpected);
    }

    /**
     * Метод с запуском метода с проверками. Case позволяет в дальнейшем обращаться к нужной проверке.
     *
     * @param setQuestion
     * @return
     */
    public boolean setQuestions(String setQuestion) {
        switch (setQuestion) {
            case "Вопрос-1:":
                return checkAnswerQuestion(question0, answer0, answerElem0);
            case "Вопрос-2:":
                return checkAnswerQuestion(question1, answer1, answerElem1);
            case "Вопрос-3:":
                return checkAnswerQuestion(question2, answer2, answerElem2);
            case "Вопрос-4:":
                return checkAnswerQuestion(question3, answer3, answerElem3);
            case "Вопрос-5:":
                return checkAnswerQuestion(question4, answer4, answerElem4);
            case "Вопрос-6:":
                return checkAnswerQuestion(question5, answer5, answerElem5);
            case "Вопрос-7:":
                return checkAnswerQuestion(question6, answer6, answerElem6);
            case "Вопрос-8:":
                return checkAnswerQuestion(question7, answer7, answerElem7);
            default:
                return false;
        }
    }


}
