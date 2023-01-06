import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class Login {

	@Keyword
	def LoginApp(String action) {
		KeywordUtil.logInfo("===Open Website apps===")
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.Url)
		WebUI.delay(10)

		if	(WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_Push Notifications'), 10, FailureHandling.OPTIONAL)) {

			KeywordUtil.logInfo("====Click button No Thanks (receive Push Notifications)====")
			WebUI.click(findTestObject('Page/Home Page/button_Sign me up'))

			KeywordUtil.logInfo("====Click button OK (allow Cookie Policies)====")
			WebUI.click(findTestObject('Page/Home Page/button_Ok'))

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}

		KeywordUtil.logInfo("=====Click button (Gabung | Daftar)======")
		WebUI.click(findTestObject('Page/Home Page/a_Log in  Sign up'))

		KeywordUtil.logInfo("=====Verify Element text (Selamat datang!)======")
		WebUI.verifyElementPresent(findTestObject('Page/Home Page/span_Selamat datang'),10)

		if	(action == "InvalidEmail") {

			KeywordUtil.logInfo("=====Input Invalid Email======")
			WebUI.setText(findTestObject('Page/Home Page/input_email'), GlobalVariable.InvalidEmail)

			KeywordUtil.logInfo("=====Input Valid Password======")
			WebUI.setText(findTestObject('Page/Home Page/input_password'), GlobalVariable.Password)

			KeywordUtil.logInfo("=====Click Login button (Masuk)======")
			WebUI.click(findTestObject('Page/Home Page/button_Masuk'))

			KeywordUtil.logInfo("=====Validasi Email atau katasandi salah======")
			WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_errorMsg_Email atau kata sandi salah'),0)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Close Browser======")
			WebUI.closeBrowser()
		}

		else if (action == "InvalidPassword") {

			KeywordUtil.logInfo("=====Input Valid Email======")
			WebUI.setText(findTestObject('Page/Home Page/input_email'), GlobalVariable.Email)

			KeywordUtil.logInfo("=====Input Invalid Password======")
			WebUI.setText(findTestObject('Page/Home Page/input_password'), GlobalVariable.InvalidPassword)

			KeywordUtil.logInfo("=====Click Login button (Masuk)======")
			WebUI.click(findTestObject('Page/Home Page/button_Masuk'))

			KeywordUtil.logInfo("=====Validasi Email atau katasandi salah======")
			WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_errorMsg_Email atau kata sandi salah'),0)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Close Browser======")
			WebUI.closeBrowser()
		}

		else if (action == "NoInputEmail") {

			KeywordUtil.logInfo("=====No Input Email======")
			WebUI.setText(findTestObject('Page/Home Page/input_email'), GlobalVariable.NoEmail)

			KeywordUtil.logInfo("=====Input Valid Password======")
			WebUI.setText(findTestObject('Page/Home Page/input_password'), GlobalVariable.Password)

			KeywordUtil.logInfo("=====Click Login button (Masuk)======")
			WebUI.click(findTestObject('Page/Home Page/button_Masuk'))

			KeywordUtil.logInfo("=====Verify Element Text Warning Message (Silahkan masukan email yang valid)======")
			WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_errorMsg_Silakan masukkan email yang valid'),0)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Close Browser======")
			WebUI.closeBrowser()
		}

		else if (action == "NoInputPassword") {

			KeywordUtil.logInfo("=====Input Valid Email======")
			WebUI.setText(findTestObject('Page/Home Page/input_email'), GlobalVariable.Email)

			KeywordUtil.logInfo("=====No Input Password======")
			WebUI.setText(findTestObject('Page/Home Page/input_password'), GlobalVariable.NoPassword)

			KeywordUtil.logInfo("=====Click Login button (Masuk)======")
			WebUI.click(findTestObject('Page/Home Page/button_Masuk'))

			KeywordUtil.logInfo("=====Verify Element Text Warning Message (Masukan sandi)======")
			WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_errorMsg_Masukkan sandi'),0)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Close Browser======")
			WebUI.closeBrowser()
		}

		else if (action == "NoInput") {

			KeywordUtil.logInfo("=====Click Login button (Masuk)======")
			WebUI.click(findTestObject('Page/Home Page/button_Masuk'))

			KeywordUtil.logInfo("=====Verify Element Text Warning Message (Silahkan masukan email yang valid)======")
			WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_errorMsg_Silakan masukkan email yang valid'),0)

			KeywordUtil.logInfo("=====Verify Element Text Warning Message (Masukan sandi)======")
			WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_errorMsg_Masukkan sandi'),0)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Close Browser======")
			WebUI.closeBrowser()
		}

		else if (action == "Valid") {

			KeywordUtil.logInfo("=====Input Valid Email======")
			WebUI.setText(findTestObject('Page/Home Page/input_email'), GlobalVariable.Email)

			KeywordUtil.logInfo("=====Input Valid Password======")
			WebUI.setText(findTestObject('Page/Home Page/input_password'), GlobalVariable.Password)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Login button (Masuk)======")
			WebUI.click(findTestObject('Page/Home Page/button_Masuk'))

			KeywordUtil.logInfo("=====Validasi Users Successfully login======")
			WebUI.verifyElementPresent(findTestObject('Page/Home Page/div_Nama pengguna'), 0)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Close Browser======")
			WebUI.closeBrowser()
		}
	}
}