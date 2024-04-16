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

String baseDir = System.getProperty('user.dir')

String packageName = 'com.vq.mbrochuregp.client.android'
String launcherActivity = 'com.example.bcafrevamp.screen.splash.SplashActivity'

// Start Application
Mobile.startExistingApplication(packageName)
AndroidDriver<?> driver = MobileDriverFactory.getDriver()

String id = 'com.vq.mbrochuregp.client.android:id'

Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + 'halaman-home') + '.png', FailureHandling.STOP_ON_FAILURE)

// Tutup Modal Popup
Mobile.waitForElementPresent(findTestObject('Object Repository/xpath', ['xpath' : "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]"]), 3)
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = 'qa-closeButton']"]), 0)

