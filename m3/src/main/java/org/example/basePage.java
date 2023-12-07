package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Este es el primer paso: crear un BasePage. En este estarán todos los métodos básicos que luego serán heredados en otros modelos.
public class basePage {
  /*  // Instanciamos un driver de tipo WebDriver, librería de Selenium.
    public WebDriver driver;
    public WebDriverWait wait;


    //Constructor
    protected basePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }

    //Primer método: set up. Instanciamos el driver de tipoWebDriver como tipo ChromeDriver. Abrimos la ventana y la maximizamos. Esto luego será parte de BeforeEach.
    public void setUp(){
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    //Método para escribir la url.
    public void url (String url){
        driver.get(url);
    }

    //Método para cerrar el navegador.
    public void close(){
        driver.quit();
    }

    //Método para buscar un elemento HTML mediante su localizador (ya sea id, className, xPath, etc.)
    protected WebElement findElement(By locator){
      return driver.findElement(locator);
    }

    //Método para escribir texto en un elemento HTML. Es buscado, primeramente, por su localizador. Luego se le escribe.
    protected void sendText(String text, By locator) throws InterruptedException{
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       this.findElement(locator).sendKeys(text);
    }


    //Método para escribir instrucciones mediante teclado. Se localiza el elemento HTML y se realiza la acción de teclado.
    protected void teclado(CharSequence key, By locator) throws InterruptedException{
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        this.findElement(locator).sendKeys(key);
    }

    //Método para hacer click. El locador será un botón, claramente. O un hipervínculo.
    protected void click(By locator) throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.findElement(locator).click();
    }

    //Método para obtener String como resultado.
    protected String getText(By locator){
        return this.findElement(locator).getText();
    }*/

  public WebDriver driver;
  public WebDriverWait wait;

    protected basePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(9000));
    }

    public void setUp() {
        driver.manage().window().maximize();
    }

    public void url(String url) {
        driver.get(url);
    }

    public void close() {
        driver.quit();
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void sendText(String imputText, By locator) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        this.findElement(locator).clear();
        this.findElement(locator).sendKeys(imputText);
    }

    protected void sendKey(CharSequence key, By locator) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        this.findElement(locator).sendKeys(key);
    }

    protected void click(By locator) throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.findElement(locator).click();
    }

    protected String getText(By locator) throws InterruptedException{
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this.findElement(locator).getText();
    }

}

