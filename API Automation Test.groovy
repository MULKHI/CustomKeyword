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
	def GetMassage () {

		KeywordUtil.logInfo("http://pretest-qa.dcidev.id/api/v1/message/88c086c9-80b5-46d5-92d9-cfe896f2f2b7")

		def builder = new RestRequestObjectBuilder()
		def requestObject = builder
				.withRestRequestMethod("GET")
				.withRestUrl("http://pretest-qa.dcidev.id/api/v1/message/88c086c9-80b5-46d5-92d9-cfe896f2f2b7)
				.withHttpHeaders([
					new TestObjectProperty("Authorization", ConditionType.EQUALS, "bearer 82c50ed84ab303a5a5a3357b0ae6e1cf8cf936774c61c32bdb49c479ee3f2918"),
				])
				.build()

		'Send a request'
		def responseJson = WS.sendRequest(requestObject, FailureHandling.STOP_ON_FAILURE)
		def responseBody = responseJson.getResponseBodyContent()
		def parseJson = new JsonSlurper().parseText(responseBody)

		WS.comment("Get Response Body")
		String pretty = println JsonOutput.prettyPrint(responseBody.toString())
		String responseString = responseBody.toString()
		responseCode = responseJson.getStatusCode()
		println("Response Code = " + responseCode)

		if (responseCode == '200') {

			status = parseJson.status
			response_name = parseJson.data.response.name

			println("Status = " + status)
			println("Response = " + response_name)

		} else {

			println("Response Code = " + responseCode)

			status = parseJson.status
			println("Status = " + status)

			error_code = parseJson.error_code
			println ("Error code : " + error_code)

			error_message = parseJson.errors.message
			println ("Message Error : " + error_message)
		}
}
