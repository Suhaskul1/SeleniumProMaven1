package Libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilityClass {

	//@Author: Suhas
	//This method is use to get the data from excel
	//need to pass 2 inputs: 1- roIndex, 2-colIndex
	public static String getTestData(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\SeleniumProMaven1\\TestData\\WithDDF.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}
	
	public static void captureSS(WebDriver driver, int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("C:\\Users\\Dell\\eclipse-workspace\\SeleniumProMaven1\\FailedTCasesSS"+TCID+".jpg");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
	}
	
	public static String getPFData(String key) throws FileNotFoundException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\SeleniumProMaven1\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		
		String value = p.getProperty(key);
		return value;
	}
}
