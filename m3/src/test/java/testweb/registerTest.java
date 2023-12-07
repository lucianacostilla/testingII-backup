package testweb;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.example.registerPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.extentFactory;

import java.time.Duration;

public class registerTest {
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
        registerPage registerPage = new registerPage(driver, wait);
        registerPage.setUp();
        registerPage.url("http://testing.ctd.academy/login");
    }

    @Test
    public void RegistrarseTest() throws InterruptedException{
registerPage registerPage = new registerPage(driver, wait);
ExtentTest test = extent.createTest("Registrandome como Baekhyun");
test.log(Status.INFO, "Iniciando el test de registro como Baekhyun");
registerPage.clickearBotonRegistro();
registerPage.escribirNombre("Baekhyun");
Assertions.assertEquals("Baekhyun", "Baekhyun");
test.log(Status.PASS, "Escribiendo el nombre");
registerPage.escribirApellido("Byun");
test.log(Status.PASS, "Escribiendo el apellido");
registerPage.escribirEmail("byunbaekhyun@gmail.com");
test.log(Status.PASS, "Escribiendo el email");
registerPage.escribirPassword("Paranoia");
test.log(Status.PASS, "Escribiendo la contraseña");
registerPage.escribirRepassword("Paranoia");
test.log(Status.PASS, "Confirmando la contraseña");
registerPage.registrarse();
test.log(Status.PASS, "Registro exitoso");
    }

    @AfterEach
    public void close(){
        registerPage registerPage = new registerPage(driver, wait);
        registerPage.close();
    }
    @AfterAll
    public static void guardarReporte(){
        extent.flush();
    }
}
