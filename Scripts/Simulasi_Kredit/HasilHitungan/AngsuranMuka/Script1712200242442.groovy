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

String baseDir = System.getProperty('user.dir')
String id = 'com.vq.mbrochuregp.client.android:id'

// Navtab Angsuran Muka
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@text=' Angsuran di Muka']"]), 0)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Angsuran_Muka' + '/' + 'AngsuranMukaResult') + '.png', FailureHandling.STOP_ON_FAILURE)

// Ambil Value DP dan Angsuran
String TotalDP1 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[2]]"]), 0)
String TotalAngsuran1 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[3]]"]), 0)

String TotalDP2 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.view.ViewGroup[1]/android.widget.TextView[2]]"]), 0)
String TotalAngsuran2 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.view.ViewGroup[1]/android.widget.TextView[3]]"]), 0)

String TotalDP3 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.view.ViewGroup[1]/android.widget.TextView[2]]"]), 0)
String TotalAngsuran3 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.view.ViewGroup[1]/android.widget.TextView[3]]"]), 0)

String TotalDP4 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.view.ViewGroup[1]/android.widget.TextView[2]]"]), 0)
String TotalAngsuran4 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.view.ViewGroup[1]/android.widget.TextView[3]]"]), 0)

String TotalDP5 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.view.ViewGroup[1]/android.widget.TextView[2]]"]), 0)
String TotalAngsuran5 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.view.ViewGroup[1]/android.widget.TextView[3]]"]), 0)

String TotalDP6 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.view.ViewGroup[1]/android.widget.TextView[2]]"]), 0)
String TotalAngsuran6 = Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[6]/android.view.ViewGroup[1]/android.widget.TextView[3]]"]), 0)

// Pilih Masa Tenor
for(int i = 1; i <= 6; i++) {
	// Halaman Rincian
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[${i}]"]), 0)
	Mobile.delay(1)
	Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Angsuran_Muka' + '/' + i + ' tahun') + '.png', FailureHandling.STOP_ON_FAILURE)
	Mobile.delay(1)
	// Kembali ke Halaman Pilih Masa Tenor
	Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btn_simulasi_close']"]), 0)
}