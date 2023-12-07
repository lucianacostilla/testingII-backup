package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class registerPage extends basePage{
    public registerPage(WebDriver driver, WebDriverWait wait) {
            super(driver, null);
    }
    private By nombre = By.id("firstName");
    private By apellido = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By repassword = By.id("repassword");
    private By btnRegistrarse = By.className("btn-primario");//*[@id="root"]/main/div/form/button
    private By btnCrearCuenta = By.linkText("Crear cuenta");
    private By gracias = By.className("txt-gracias");
    private By exito = By.className("txt-exito");
    private By mailRegister = By.className("form-feedback");
    private By passwordDis = By.className("small-feedback");

public void clickearBotonRegistro() throws InterruptedException{
    this.click(btnCrearCuenta);
}
public void escribirNombre(String name) throws InterruptedException{
    this.sendText(name, nombre);
}
public void escribirApellido(String surname) throws InterruptedException{
    this.sendText(surname, apellido);
}
public void escribirEmail(String mail) throws InterruptedException{
    this.sendText(mail, email);
}
public void escribirPassword(String contrasenia) throws InterruptedException{
    this.sendText(contrasenia, password);
    }
public void escribirRepassword(String recontrasenia)throws InterruptedException{
    this.sendText(recontrasenia, repassword);
}
public void registrarse() throws InterruptedException{
    this.click(btnRegistrarse);
}

}
