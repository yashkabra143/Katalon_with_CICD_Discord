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

// Call common login
WebUI.callTestCase(findTestCase('Common/Common_Login'), [:], FailureHandling.STOP_ON_FAILURE)

// Test specific steps
WebUI.click(findTestObject('Object Repository/Quantam_AI_Page/Page_QuantumTrades/p_Quantum AI'))
WebUI.click(findTestObject('Object Repository/Quantam_AI_Page/Page_QuantumTrades/div_Explain Iron condor options strategy'))
WebUI.click(findTestObject('Object Repository/Quantam_AI_Page/Page_QuantumTrades/path_path'))
WebUI.verifyElementPresent('Object Repository/Quantam_AI_Page/Page_QuantumTrades/p_Sure The Iron Condor is an options trading st', 0)

// Call common logout
WebUI.callTestCase(findTestCase('Common/Common_Login'), [:], FailureHandling.STOP_ON_FAILURE)

