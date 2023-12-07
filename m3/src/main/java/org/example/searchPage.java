package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchPage extends basePage{
    //Se crean variables para almacenar los elemtentos HTML en ellas.
    private By campoBusqueda = By.name("q");
    private By botonBusqueda = By.name("btnK");
    private By busquedaResultado = By.xpath("//*[@id=\"rcnt\"]/div[2]/div/div/div[3]");
    /*
    public searchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }
        //Método para buscar
        public void escribirBusqueda(String texto) throws InterruptedException{
            this.sendText(texto, campoBusqueda);
            this.teclado(Keys.ENTER, campoBusqueda);
        }

        //Método para clickear
    public void clickear() throws InterruptedException{
        this.click(botonBusqueda);}

        //Método para ver resultado
    public String visualizacion(){
       return "El resultado de la búsqueda es: " + this.getText(busquedaResultado);}
}*/
    private By videoYoutube = By.xpath("//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div/div[2]/h3/div/span/a");

    //funciona bien pero por los ads de youtube no termina de dar bien el test. comentado.
    //private By titulo = By.xpath("//*[@id=\"title\"]/h1");

    public searchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    public void escribirBusqueda(String texto) throws InterruptedException{
        this.sendText(texto, campoBusqueda);
        this.sendKey(Keys.ESCAPE, campoBusqueda);
    }
    public void clickearparaBuscar() throws InterruptedException {
        this.click(botonBusqueda);
    }

    public String visualizacionDeBusqueda() throws InterruptedException {
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(busquedaResultado));
        return this.getText(busquedaResultado);
    }

    //funciona bien pero por los ads de youtube no termina de dar bien el test. comentado.
   /* public String visualizacionDeResultado() throws InterruptedException {
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(titulo));
        return this.getText(titulo);
    }*/

    public void clickearParaMirar() throws InterruptedException {
        this.click(videoYoutube);
    }

}
