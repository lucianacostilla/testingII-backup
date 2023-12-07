package reportes;

import com.aventstack.extentreports.ExtentReports;

/* pasos para generar reportes:
agregar en el pom:
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
</dependency>
crear paquete en src/test/java llamado extentFactory.
 */
public class extentFactory {
    //creamos función para obtener instancia de reporte:
    public static ExtentReports getInstance(){
        //creamos variable de tipo ExtentReports para poder usarla:
        ExtentReports extent = new ExtentReports();
        extent.createTest("Sistema Operativo", "Windows");
        extent.createTest("Ambiente", "QA");
        extent.createTest("Navegador", "Chrome");
        //como la función es public class EXTENTREPORTS, claramente necesitamos retornar algo de ese tipo, osea:
        return extent;
    }
    //Luego debemos irnos para los Tests y seguir ahí.
}
