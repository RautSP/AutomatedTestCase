package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;


public class CommonUtilities {
	public static Properties loadPropertiesFile() {

		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Projectdata.properties");
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;

	}

	
	public static String generateBrandNewEmail() {
		

		
		Date date = new Date();
		String dateString = date.toString();
		String dateStringWithoutSpaces = dateString.replaceAll("\\s","");
		String dateStringWithoutSpacesAndColons = dateStringWithoutSpaces.replaceAll("\\:","");
		String brandNewEmail = dateStringWithoutSpacesAndColons+"@gmail.com";
		return brandNewEmail;
		
	}
	
	public static boolean compareTwoScreenshots(String actualImagePath,String expectedImagePath) throws IOException {
		
		//public static boolean compareTwoScreenshots(String actualImagePath, String expectedImagePath) {
			BufferedImage acutualBImg = null;
			BufferedImage expectedBImg = null;
			try {
				acutualBImg = ImageIO.read(new File(actualImagePath));
				expectedBImg = ImageIO.read(new File(expectedImagePath));
			} catch (IOException e) {
				e.printStackTrace();
			}

			ImageDiffer imgDiffer = new ImageDiffer();
			ImageDiff imgDifference = imgDiffer.makeDiff(expectedBImg, acutualBImg);

			return imgDifference.hasDiff();

		}

	
	
	public static void takeScreenshot(WebDriver driver,String screenshotPath) {
        
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcScreenshot,new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*public static String getTextFromMessage(Message message) throws Exception {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("text/html")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }
	
	private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        StringBuilder result = new StringBuilder();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result.append(bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {
                result.append(bodyPart.getContent());
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
            }
        }
        return result.toString();
 }*/
	
	

}