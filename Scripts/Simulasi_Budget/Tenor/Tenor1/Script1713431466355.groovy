import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidKeyCode

import org.openqa.selenium.Keys as Keys

AndroidDriver<?> driver = MobileDriverFactory.getDriver()
String id = 'com.vq.mbrochuregp.client.android:id'

switch(Simulasi) {
	case "BayarPertama":
	case "Bayar Pertama":
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"]), 0)
		switch(LoanType) {
			case "ADDM":
				String BayarPertama = MukaDP1
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
				
				for (int i = 0; i < BayarPertama.length(); i++) {
					char digit = BayarPertama.charAt(i)
					int keyCode = Character.getNumericValue(digit) + 7
					driver.pressKeyCode(keyCode)
				}
				break;
			case "ADDB":
				String BayarPertama = BelakangDP1
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
				
				for (int i = 0; i < BayarPertama.length(); i++) {
					char digit = BayarPertama.charAt(i)
					int keyCode = Character.getNumericValue(digit) + 7
					driver.pressKeyCode(keyCode)
				}
				break;
		}
		break;
	case "Angsuran":
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"]), 0)
		switch(LoanType) {
			case "ADDM":
				String BayarPertama = MukaDP1
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
				
				for (int i = 0; i < BayarPertama.length(); i++) {
					char digit = BayarPertama.charAt(i)
					int keyCode = Character.getNumericValue(digit) + 7
					driver.pressKeyCode(keyCode)
				}
				break;
			case "ADDB":
				String BayarPertama = BelakangDP1
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
				
				for (int i = 0; i < BayarPertama.length(); i++) {
					char digit = BayarPertama.charAt(i)
					int keyCode = Character.getNumericValue(digit) + 7
					driver.pressKeyCode(keyCode)
				}
				break;
		}
		break;
}