package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page12th extends ResultPage {
	
	public Page12th(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr")
	List<WebElement> rows;
	public int totalNumberOfRows() {		
		return rows.size();
	}	
	
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr[7]/td[2]")
	WebElement totalMarks;
	public String getTotalMarks() {
		String tm = totalMarks.getText();
		return tm;
	}
	
//	for optional subject.
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr[8]/td[2]")
	WebElement totalMarksExtra;
	public String getTotalMarksExtra() {
		String tm = totalMarksExtra.getText();
		return tm;
	}
		
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr[8]/td[2]")
	WebElement resultStatus;
	public String getResultStatus() {
		String rs = resultStatus.getText();
		return rs;
	}
	
//	for optional subject.
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr[9]/td[2]")
	WebElement resultStatusExtra;
	public String getResultStatusExtra() {
		String rs = resultStatusExtra.getText();
		return rs;
	}
	
}
