
public class Login {
	/**
	 * UI Automation for the login feature uses Custom Keyword Katalon Studio
	 * just add the Object Repository and add Global variable/Data Driven
	 * Why use Custom Keyword? because its easier when debugging
	 */
	@Keyword
	def LoginFeature(String action) {

		KeywordUtil.logInfo("===Open Login Page===")
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.Url_login)
		WebUI.delay(10)

		if	(action == "Valid") {
			
			KeywordUtil.logInfo("=====Verify Elemet Text Sign In======")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/text_Sign In'), 10)
			
			KeywordUtil.logInfo("=====Input Valid Email======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email_Address'), GlobalVariable.Email )

			KeywordUtil.logInfo("=====Input Valid Password======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.Password )

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation Successful Login===")
			//here I make it as navigation to the Account Page
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Account_Page/text_Selamat Datang'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()

		}

		else if (action == "Valid_Checking_Remind_Me") {
			
			KeywordUtil.logInfo("=====Verify Elemet Text Sign In======")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/text_Sign In'), 10)

			KeywordUtil.logInfo("=====Input Valid Email Address======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email_Address'), GlobalVariable.Email )

			KeywordUtil.logInfo("=====Input Valid Password======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.Password )
			
			KeywordUtil.logInfo("=====Click Radio Button Remember Me======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_RememberMe'))

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation Successful Login===")
			//here I make it as navigation to the Account Page
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Account_Page/text_Selamat Datang'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
		
		else if (action == "Invalid_Email_Address") {
			
			KeywordUtil.logInfo("=====Verify Elemet Text Sign In======")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/text_Sign In'), 10)

			KeywordUtil.logInfo("=====Input Invalid Email Address======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email_Address'), GlobalVariable.InvalidEmail )

			KeywordUtil.logInfo("=====Input Valid Password======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.Password )

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation gets warning message 'Incorrect email or password'===")
			//here I make it as if user gets warning message
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/Msg_Incorrect email address or password'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
		
		else if (action == "Invalid_Password") {
			
			KeywordUtil.logInfo("=====Verify Elemet Text Sign In======")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/text_Sign In'), 10)

			KeywordUtil.logInfo("=====Input Valid Email Address======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email_Address'), GlobalVariable.Email )

			KeywordUtil.logInfo("=====Input Invalid Password======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.InvalidPassword )

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation gets warning message 'Incorrect email or password'===")
			//here I make it as if user gets warning message
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/Msg_Incorrect email address or password'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
		
		else if (action == "Without_Input_Email") {
			
			KeywordUtil.logInfo("=====Verify Elemet Text Sign In======")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/text_Sign In'), 10)

			KeywordUtil.logInfo("=====Input Valid Password======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Password'), GlobalVariable.Password )

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation gets warning message 'Please enter email address'===")
			//here I make it as if user gets warning message
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/Msg_Please enter email address'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
		
		else if (action == "Without_Input_Password") {
			
			KeywordUtil.logInfo("=====Verify Elemet Text Sign In======")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/text_Sign In'), 10)

			KeywordUtil.logInfo("=====Input Valid Email Address======")
			//here I save the Test Data in Global Variable
			//can also be taken from Data-driven which is save in folder Data File in excel form
			WebUI.setText(findTestObject('Object Repository/Page/Login_Page/field_Email_Address'), GlobalVariable.Email )

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation gets warning message 'Please enter password'===")
			//here I make it as if user gets warning message
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/Msg_Please enter password'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
		
		else if (action == "Without_Input_Email_And_Password") {
			
			KeywordUtil.logInfo("=====Verify Elemet Text Sign In======")
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/text_Sign In'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot====")
			WebUI.takeScreenshot()

			KeywordUtil.logInfo("=====Click Button Submit======")
			WebUI.click(findTestObject('Object Repository/Page/Login_Page/btn_Submit'))

			KeywordUtil.logInfo("===Validation gets 2 warning message===")
			//here I make it as if user gets warning message
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/Msg_Please enter email address'), 10)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Page/Login_Page/Msg_Please enter password'), 10)

			KeywordUtil.logInfo("=====Take Screen Shoot======")
			WebUI.takeScreenshot()
		}
	}
}
