package com.bdd.actionPages;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.Set;

public class HomePage extends BaseClass {
    public WebDriver driver;

    @FindBy(xpath = "//*[@class='nav nav-pills main-navigation-list']/li")
	List<WebElement> menuTabs;

	@FindBy(xpath = "(//*[@data-categoryid = 'MM Men NewIn ViewAll L3 Link'])[1]/a")
	WebElement ViewAll;

	@FindBy(xpath = "//*[@class='c-refine__content-wrap']/ul/li")
	List<WebElement> filterOptions;

	@FindBy(xpath = "(//*[@class='c-refine__options'])[1]/div[2]/div/div")
	List<WebElement> brandOptions;

	@FindBy(xpath = "(//*[@class='c-refine__cta close'])[1]")
	WebElement Cancel;

	@FindBy(xpath = "(//*[@class='c-product-grid'])/li")
	List<WebElement> products;

	@FindBy(xpath = "//*[text()='Size guide']")
	WebElement sizeGuide;
	
	@FindBy(xpath = "//*[@class='radio-container']/label")
	List<WebElement> sizes;
	
	@FindBy(xpath = "//*[@id='addToCartButton']")
	WebElement addToCart;
	
	@FindBy(xpath = "//div[@id='miniCart']")
	WebElement cart;
	
	@FindBy(xpath = "//*[@class='container checkout-button-container']/a")
	WebElement checkout;
	
	@FindBy(xpath = "(//*[@class='checkout-tab-title'])[2]")
	WebElement checkoutAsGuest;
	
	@FindBy(xpath = "//*[@name = 'checkoutLoginSubmit']")
	WebElement checkoutSubmitButton;
	
	@FindBy(xpath = "//*[@id = 'j_username.errors']")
	WebElement ErrorMessege;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hoverOrClickOnAllTabs() {
		Actions actions = new Actions(driver);
		for (WebElement menuTab : menuTabs) {
			actions.moveToElement(menuTab).perform();

		}
	}

	public void selectMenuTab(String tabName) throws Exception {

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		for (WebElement menuTab : menuTabs) {
			if (menuTab.getText().equalsIgnoreCase(tabName)) {
				actions.moveToElement(menuTab).perform();
				break;
			}
		}
		Thread.sleep(2000);
		ViewAll.click();
		// actions.click(ViewAll);
	}

	public void selectFilter(String FilterName) throws Exception {

		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		for (WebElement filter : filterOptions) {
			if (filter.getText().equalsIgnoreCase(FilterName)) {
				actions.click(filter).perform();
				break;
			}
		}

	}

	public void selectBrandOptions() throws Exception {

		Thread.sleep(2000);
		for (int i = 0; i < 4; i++) {

			brandOptions.get(i).click();
		}

		Cancel.click();
	}

	public void selectProduct() {
		products.get(1).click();
	}

	public void selectsizeGuide() {
		sizeGuide.click();
	}

	public void switchToNewTab(WebDriver driver) {
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String windowHandle : allWindowHandles) {
			// Switch to the new tab (if not the current tab)
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

	}

	
	public void selectSize(String size) throws Exception {

		Thread.sleep(2000);
		for (WebElement s : sizes) {
			if (s.getText().equalsIgnoreCase(size)) {
				s.click();
				break;
			}
		}
		
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	public void clickViewBag() {
		cart.click();
	}
	
	
	public void clickOnCheckOut() {
		checkout.click();
	}
	
	
	public void clickonCheckoutAsGuest() {
		checkoutAsGuest.click();
	}
	
	
	public void validateErrorMessege(String expectedErrorMessage)
	{
		 String actualErrorMessage = ErrorMessege.getText().trim();
	        
	       assertEquals("Unexpected error message", expectedErrorMessage, actualErrorMessage);
	}
	
}


