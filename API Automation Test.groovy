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
	def LoginFeature(String action) {

		KeywordUtil.logInfo("===Open Login Page===")
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.Url_login)
		WebUI.delay(10)

		if	(action == "Valid") {
			
			KeywordUtil.logInfo("=====Input Valid Email======")
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email'), GlobalVariable.email )

			KeywordUtil.logInfo("=====Input Valid Password======")
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.password )

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation Successful Login===")
			WebUI.verifyElementExist(findTestObject('Object Repository/Page/Account_Page/text_Selamat Datang'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

		}

		else if (action == "Valid_checking_remind_me") {

			KeywordUtil.logInfo("=====Input Valid Email Address======")
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email'), GlobalVariable.email )

			KeywordUtil.logInfo("=====Input Valid Password======")
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.password )
			
			KeywordUtil.logInfo("=====Click Radio Button Remember Me======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_RememberMe'))

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation Successful Login===")
			WebUI.verifyElementExist(findTestObject('Object Repository/Page/Account_Page/text_Selamat Datang'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
		
		else if (action == "Invalid_Email_Address") {

			KeywordUtil.logInfo("=====Input Invalid Email Address======")
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email'), GlobalVariable.email )

			KeywordUtil.logInfo("=====Input Valid Password======")
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.password )
			
			KeywordUtil.logInfo("=====Click Radio Button Remember Me======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_RememberMe'))

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation gets warning message 'Incorrect email or password'===")
			WebUI.verifyElementExist(findTestObject('Object Repository/Page/Account_Page/text_Incorrect email or password'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
	}
}



===================================================================
		if (Mobile.verifyElementExist(findTestObject('Object Repository/Login/Landing_Page/obj_LewatiTur'), 10, FailureHandling.OPTIONAL)) {

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()

			KeywordUtil.logInfo("=====Click LewatiTur======")
			Mobile.tap(findTestObject('Object Repository/Login/Landing_Page/obj_LewatiTur'), 10)
		}

		KeywordUtil.logInfo("=====Verify Elemet Text Login======")
		Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login_Page/text_Login'), 10)

		if (Invalid == "InvalidEmail") {
			KeywordUtil.logInfo("=====Input Ivalid Email======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputEmail'), email, 10)

			KeywordUtil.logInfo("=====Input Valid Password======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputPassword'), password, 10)

			KeywordUtil.logInfo("=====Click Button Login======")
			Mobile.tap(findTestObject('Object Repository/Login/Login_Page/btn_Login'), 10)

			KeywordUtil.logInfo("=====Validasi Akun Atau Kata Sandi Salah======")
			Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login_Page/text_AkunAtauKataSandiSalah'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()
		}

		else if (Invalid == "InvalidPassword") {

			KeywordUtil.logInfo("=====Input Valid Email======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputEmail'), email, 10)

			KeywordUtil.logInfo("=====Input Invalid Password======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputPassword'), password, 10)

			KeywordUtil.logInfo("=====Click Button Login======")
			Mobile.tap(findTestObject('Object Repository/Login/Login_Page/btn_Login'), 10)

			KeywordUtil.logInfo("=====Validasi Akun Atau Kata Sandi Salah======")
			Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login_Page/text_AkunAtauKataSandiSalah'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()
		}

		else if (Invalid == "NoInput") {

			KeywordUtil.logInfo("=====Click Button Login======")
			Mobile.tap(findTestObject('Object Repository/Login/Login_Page/btn_Login'), 10)

			KeywordUtil.logInfo("=====Validasi Akun Atau Kata Sandi Salah======")
			Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login_Page/text_AkunAtauKataSandiSalah'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()
		}

		else if (Invalid == "NoInputEmail") {
			KeywordUtil.logInfo("=====No Input Email======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputEmail'), email, 10)

			KeywordUtil.logInfo("=====Input Valid Password======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputPassword'), password, 10)

			KeywordUtil.logInfo("=====Click Button Login======")
			Mobile.tap(findTestObject('Object Repository/Login/Login_Page/btn_Login'), 10)

			KeywordUtil.logInfo("=====Validasi Akun Atau Kata Sandi Salah======")
			Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login_Page/text_AkunAtauKataSandiSalah'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()
		}

		else if (Invalid == "NoInputPassword") {

			KeywordUtil.logInfo("=====Input Valid Email======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputEmail'), email, 10)

			KeywordUtil.logInfo("=====No Input Password Password======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputPassword'), password, 10)

			KeywordUtil.logInfo("=====Click Button Login======")
			Mobile.tap(findTestObject('Object Repository/Login/Login_Page/btn_Login'), 10)

			KeywordUtil.logInfo("=====Validasi Akun Atau Kata Sandi Salah======")
			Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login_Page/text_AkunAtauKataSandiSalah'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()
		}

		else if (Invalid == "Valid") {

			KeywordUtil.logInfo("=====Input Email======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputEmail'), email, 10)


			KeywordUtil.logInfo("=====Input Password======")
			Mobile.setText(findTestObject('Object Repository/Login/Login_Page/field_InputPassword'), password, 10)


			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Login======")
			Mobile.tap(findTestObject('Object Repository/Login/Login_Page/btn_Login'), 10)

			if (Mobile.verifyElementExist(findTestObject('Object Repository/Login/Login_Page/text_SaveCredentials'), 10, FailureHandling.OPTIONAL)) {
				Mobile.tap(findTestObject('Object Repository/Login/Login_Page/btn_MaybeLater'), 10)
			}

			if (Mobile.verifyElementExist(findTestObject('Home_Page/text_SelectYourAccount'), 10, FailureHandling.OPTIONAL)) {


				KeywordUtil.logInfo("=====Take Screen Shoot======")
				Mobile.takeScreenshot()

				if (PilihAkun == "Live") {

					KeywordUtil.logInfo("=====Click Akun Live======")
					//					Mobile.tap(findTestObject('Object Repository/Home_Page/btn_AkunLive'), 10)
					account_id = new com.database.client().getClientId(email)

					live_id = new com.database.client().getAccountLive(account_id)

					def account_live_id = new object.dynamic().appiumObjtext(live_id)
					account_live_id.click()


				}else {

					KeywordUtil.logInfo("=====Click Button Demo======")
					Mobile.tap(findTestObject('Home_Page/obj_Demo'), 10)
				}

				KeywordUtil.logInfo("=====Click Button Trading Sekarang======")
				Mobile.tap(findTestObject('Home_Page/btn_TradingSekarang'), 10)
			}

			if (Mobile.verifyElementExist(findTestObject('Home_Page/text_SudahTahuCaraPakai'), 10, FailureHandling.OPTIONAL)) {


				KeywordUtil.logInfo("=====Click Button Tidak Perlu. Saya sudah Paham======")
				Mobile.tap(findTestObject('Home_Page/btn_TidakPerlu'), 10)

				KeywordUtil.logInfo("=====Wait Elemet Button Mengerti======")
				Mobile.verifyElementExist(findTestObject('Home_Page/text_KerenKamuSudahBisaTrading'), 10, FailureHandling.STOP_ON_FAILURE)

				KeywordUtil.logInfo("=====Click Button Mengerti======")
				Mobile.tap(findTestObject('Home_Page/btn_Mengerti'), 10)

				KeywordUtil.logInfo("=====Verify elemet Text Informasi dana akun anda======")
				Mobile.verifyElementExist(findTestObject('Home_Page/text_InformasiDanaAkunAnda'), 10, FailureHandling.STOP_ON_FAILURE)

				KeywordUtil.logInfo("=====Click Button Lewati======")
				Mobile.tap(findTestObject('Home_Page/btn_Lewati'), 10)
			}

			KeywordUtil.logInfo("=====Verify Elemet Text Balance======")
			Mobile.verifyElementExist(findTestObject('Home_Page/text_Balance'), 10, FailureHandling.STOP_ON_FAILURE)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			Mobile.takeScreenshot()
		}
	}
}
