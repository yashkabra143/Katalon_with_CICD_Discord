import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Open browser and navigate to the application
WebUI.openBrowser('')
WebUI.navigateToUrl('https://dev-portal.quantumtrades.com/')

// Wait for the page to load
WebUI.waitForPageLoad(10)

// Click on the Google sign-in button
WebUI.waitForElementPresent(findTestObject('Object Repository/Login_page/Page_QuantumTrades/svg_MuiSvgIcon-root MuiSvgIcon-fontSizeMedium cs'), 10)
WebUI.click(findTestObject('Object Repository/Login_page/Page_QuantumTrades/svg_MuiSvgIcon-root MuiSvgIcon-fontSizeMedium cs'))

// Switch to the Google sign-in window
WebUI.switchToWindowTitle('Sign in - Google Accounts')

// Wait for and enter Google email
WebUI.waitForElementPresent(findTestObject('Object Repository/Login_page/Page_Sign in - Google Accounts/input_identifier'), 10)
WebUI.setText(findTestObject('Object Repository/Login_page/Page_Sign in - Google Accounts/input_identifier'), 'yashkabra143@gmail.com')
WebUI.delay(10)
WebUI.sendKeys(findTestObject('Object Repository/Login_page/Page_Sign in - Google Accounts/input_identifier'), Keys.chord(Keys.ENTER))

// Wait for password field and enter password
WebUI.waitForElementPresent(findTestObject('Object Repository/Login_page/Page_Sign in - Google Accounts/input_password'), 10)
WebUI.setEncryptedText(findTestObject('Object Repository/Login_page/Page_Sign in - Google Accounts/input_password'), 'cvW8qx4B2o1WegCEDy41Xg==')
WebUI.sendKeys(findTestObject('Object Repository/Login_page/Page_Sign in - Google Accounts/input_password'), Keys.chord(Keys.ENTER))

// Switch back to the main window
WebUI.switchToWindowTitle('QuantumTrades')

// Wait for and verify successful login
WebUI.waitForElementPresent(findTestObject('Object Repository/Login_page/Page_QuantumTrades/p_user-welcome'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_page/Page_QuantumTrades/p_user-welcome'), 10)

// Close browser
WebUI.closeBrowser()

