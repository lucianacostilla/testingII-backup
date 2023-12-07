package testweb;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.loginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.extentFactory;

import java.time.Duration;

public class loginTest {
    public WebDriver driver;
    public WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/reporte1.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        extent = extentFactory.getInstance();
        extent.attachReporter(info);
    }
    @BeforeEach
    public void precondiciones(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        loginPage loginPage = new loginPage(driver, wait);
        loginPage.setUp();
        loginPage.url("http://testing.ctd.academy/login");
    }

    @Test
    public void login_success() throws InterruptedException {
        ExtentTest test = extent.createTest("Login Exitoso");
        test.log(Status.INFO, "Inicio de sesión exitoso.");
        loginPage loginPage = new loginPage(driver, wait);
        loginPage.escribirEmail("costillalu@gmail.com");
        test.log(Status.PASS, "Escribiendo email.");
        loginPage.escribirContraseña("taeminkai10");
        test.log(Status.PASS,"Escribiendo contraseña");
        test.log(Status.PASS, "Apretando botón de login");
        loginPage.iniciarSesion();
        test.log(Status.PASS, "Se inició sesión.");
        loginPage.saludo();
        test.log(Status.PASS, "Se verifican los datos.");
    }
    @Test
    public void  login_fail() throws InterruptedException {
        ExtentTest test = extent.createTest("Login fallido.");
        test.log(Status.INFO, "Inicio de sesión fallido.");
        loginPage loginPage = new loginPage(driver, wait);
        loginPage.escribirEmail("prueba@gmail.com");
        test.log(Status.PASS,"Escribiendo email incorrecto.");
        loginPage.escribirContraseña("taeminkai10");
        test.log(Status.PASS,"Escribiendo contraseña");
        loginPage.iniciarSesion();
        test.log(Status.PASS, "Apretando botón de login");
        test.log(Status.PASS, "Mensaje de error.");
        loginPage.credencialesInv();
        test.log(Status.PASS, "Se verifican los datos.");
    }
    @Test
    public void  login_fail2() throws InterruptedException {
        ExtentTest test = extent.createTest("Login fallido.");
        test.log(Status.INFO, "Inicio de sesión fallido.");
        loginPage loginPage = new loginPage(driver, wait);
        loginPage.escribirEmail("");
        test.log(Status.PASS,"Email vacío.");
        //loginPage.escribirContraseña("taeminkai10");
        test.log(Status.PASS,"Contraseña vacía");
        loginPage.iniciarSesion();
        test.log(Status.PASS, "Apretando botón de login");
        loginPage.correoObligatorio();
        loginPage.contraseñaObligatoria();
        test.log(Status.PASS, "Fallo. Mensaje de error.");
    }
    @AfterEach
    public void close () {
        loginPage loginPage = new loginPage(driver, wait);
        loginPage.close();
    }
    @AfterAll
    public static void saveReport(){
        extent.flush();
    }
}
