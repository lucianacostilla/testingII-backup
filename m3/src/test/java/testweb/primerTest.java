package testweb;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.searchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.extentFactory;

import java.time.Duration;


public class primerTest {
  /*  // Importante: Instanciar el driver para testear.
   public WebDriver driver;
   public WebDriverWait wait;
   // Antes de testear es imprescindible crear precondiciones: empezar a preparar el driver para que sea de tipo SearchPage(que es lo que estaremos testeando).
@BeforeEach
     public void precondiciones(){
     driver= new ChromeDriver();
     wait= new WebDriverWait(driver, Duration.ofMillis(2000));
     searchPage searchPage = new searchPage(driver, wait);
     searchPage.setUp();
     searchPage.url("http://youtube.com");
}
    // Una vez abierta la ventana y estando en la página, a testear: En este caso queremos escribir una búsqueda, apretar el botón de buscar Y ver el resultado.
    // Recordar que en cada función debemos instanciar el driver como SearchPage.
  @Test
  public void cancionEXO_Obsession() throws InterruptedException{
     searchPage searchPage = new searchPage(driver, wait);
     searchPage.escribirBusqueda ("Groove - EXO");
     searchPage.clickear();
     searchPage.visualizacion();
    }

    @AfterEach
    public void cerrar(){
        searchPage searchPage = new searchPage(driver, wait);
        searchPage.close();
    }
   */
    public WebDriver driver;
    public WebDriverWait wait;
    //Creamos una variable de tipo ExtentSparkReportes que lo que hará será guardar toda la información del test dentro de ella, y estará guardada en reportes.html en la carpeta target.
    static ExtentSparkReporter info = new ExtentSparkReporter("target/reportes.html");
    //Traemos la variable extent de extentFactory. Se puso el static en la función porque está fuera de la carpeta de los tests. Si no fuese static no podría usarse.
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        //llamamos a la variable extent traida de extentFactory y la volvemos a instanciar, guardando la función de obtener instancia dentro de ella. Es decir, guardamos la instancia creada en extent.
        extent = extentFactory.getInstance();
        //La instancia que se guardará tendrá como contenido la variable info, de tipo ExtentSparkReporter.
        //La variable extent ahora tendrá todos los métodos de ExtentReports además de tener la información de .getInstance(), entonces podrá de gozar de métodos como .attachReporter()
        extent.attachReporter(info);
    }

    @BeforeEach
    public void preconditions() throws InterruptedException{
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        searchPage searchPage = new searchPage(driver, wait);
        searchPage.setUp();
        searchPage.url("http://google.com");
    }
    @org.junit.jupiter.api.Test
    @Tag("Busqueda")
    public void busquedaObsession() throws InterruptedException {
        //En el test podremos utilizar extentTest para crear variable llamada test y, en ella, guardar los logs que estarán en el reporte.html.
        ExtentTest test = extent.createTest("Búsqueda de canción");
        searchPage searchPage = new searchPage(driver, wait);
        //Empezamos con el primer log:
        test.log(Status.INFO, "Empieza la búsqueda de la canción Groove.");
        searchPage.escribirBusqueda("Groove - EXO");
        searchPage.clickearparaBuscar();
        //Segundo log:
        test.log(Status.PASS, "Se hizo la búsqueda.");
        searchPage.visualizacionDeBusqueda();
        //Tercer log:
        test.log(Status.PASS, "Búsqueda exitosa.");
        searchPage.clickearParaMirar();
        test.log(Status.PASS, "Video en página.");
      /* NO FUNCIONA POR LOS ADS
        searchPage.visualizacionDeResultado();
        test.log(Status.PASS, "Búsqueda completada.");
       */
    }

    @Test
    @Tag("Busqueda")
    public void busquedaEXIST() throws InterruptedException {
        ExtentTest test = extent.createTest("Búsqueda de canción");
        searchPage searchPage = new searchPage(driver, wait);
        test.log(Status.INFO, "Empieza la búsqueda de la canción Love Fool.");
        searchPage.escribirBusqueda("Love Fool - EXO");
        searchPage.clickearparaBuscar();
        test.log(Status.PASS, "Se hizo la búsqueda.");
        searchPage.visualizacionDeBusqueda();
        test.log(Status.PASS, "Búsqueda exitosa");
        searchPage.clickearParaMirar();
        test.log(Status.PASS, "Video en página.");
        /* NO FUNCIONA POR LOS ADS
        searchPage.visualizacionDeResultado();
        test.log(Status.PASS, "Búsqueda completada.");
         */
    }

    @AfterEach
    public void close() {
        searchPage searchPage = new searchPage(driver, wait);
        searchPage.close();
    }
    
    @AfterAll
    public static void saveReports(){
        extent.flush();
    }
}


