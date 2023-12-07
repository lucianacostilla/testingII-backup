package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends basePage{
    private static By email = By.id("email");
    private By password = By.id("password");
    private By login = By.className("btn-primario");
    private By emailRequerido = By.xpath("//*[@id=\"root\"]/main/div/form/div[1]/small");
    private By passwordRequerida = By.xpath("//*[@id=\"root\"]/main/div/form/div[2]/small");
    private By credencialesIncorrectas = By.className("form-feedback");
    private By saludo = By.className("txt-hola");
    private By nombreSaludo = By.name("txt-nombre");
    public loginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    public void escribirEmail(String correo) throws InterruptedException{
        this.sendText(correo, email);
    }
    public void escribirContraseña(String contraseña) throws InterruptedException{
        this.sendText(contraseña, password);
    }
    public void iniciarSesion() throws InterruptedException{
        this.click(login);
    }
    public String correoObligatorio() throws InterruptedException{
        return "Error: " + this.getText(emailRequerido);
    }
    public String contraseñaObligatoria() throws InterruptedException{
        return "Error: " + this.getText(passwordRequerida);
    }
    public String saludo() throws InterruptedException{
        return "Mensaje de saludo: " + this.getText(saludo);
    }
    public String nombreSaludo() throws InterruptedException{
        return "Nombre en el saludo: " + this.getText(nombreSaludo);
    }
    public String credencialesInv() throws InterruptedException{
        return "Error: " + this.getText(credencialesIncorrectas);
    }

}
