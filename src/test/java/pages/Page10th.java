package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page10th extends ResultPage {
	
	public Page10th(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr[8]/td[2]")
	WebElement totalMarks;
	public String getTotalMarks() {
		String tm = totalMarks.getText();
		return tm;
	}
	
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr[9]/td[2]")
	WebElement resultStatus;
	public String getResultStatus() {
		String rs = resultStatus.getText();
		return rs;
	}
	
	@FindBy(xpath="/html/body/form/div/div/div[2]/table/tbody/tr[10]/td[2]")
	WebElement percentage;	
	public String getPercentage() {
		String percent = percentage.getText().trim()+"%";
		return percent;
	}
}
