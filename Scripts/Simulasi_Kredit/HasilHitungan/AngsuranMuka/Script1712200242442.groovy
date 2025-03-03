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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable

import jxl.*
import jxl.write.*
import jxl.read.biff.BiffException

import excel.WriteExcel

String baseDir = System.getProperty('user.dir')
String id = 'com.vq.mbrochuregp.client.android:id'

// Navtab Angsuran Muka
Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@text=' Angsuran di Muka']"]), 0)
Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathKredit)) + '/' + No + '/' + 'Angsuran_Muka' + '/' + 'AngsuranMukaResult') + '.png', FailureHandling.STOP_ON_FAILURE)

// Buat variabel DP dan Angsuran buat di fetch di debit 
def DP_Angsuran = [
    ["MukaDP1", "//android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[2]"],
    ["MukaDP2", "//android.widget.LinearLayout[2]/android.view.ViewGroup[1]/android.widget.TextView[2]"],
    ["MukaDP3", "//android.widget.LinearLayout[3]/android.view.ViewGroup[1]/android.widget.TextView[2]"],
    ["MukaDP4", "//android.widget.LinearLayout[4]/android.view.ViewGroup[1]/android.widget.TextView[2]"],
    ["MukaDP5", "//android.widget.LinearLayout[5]/android.view.ViewGroup[1]/android.widget.TextView[2]"],
    ["MukaDP6", "//android.widget.LinearLayout[6]/android.view.ViewGroup[1]/android.widget.TextView[2]"],
    ["MukaAngsuran1", "//android.widget.LinearLayout[1]/android.view.ViewGroup[1]/android.widget.TextView[3]"],
    ["MukaAngsuran2", "//android.widget.LinearLayout[2]/android.view.ViewGroup[1]/android.widget.TextView[3]"],
    ["MukaAngsuran3", "//android.widget.LinearLayout[3]/android.view.ViewGroup[1]/android.widget.TextView[3]"],
    ["MukaAngsuran4", "//android.widget.LinearLayout[4]/android.view.ViewGroup[1]/android.widget.TextView[3]"],
    ["MukaAngsuran5", "//android.widget.LinearLayout[5]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"],
    ["MukaAngsuran6", "//android.widget.LinearLayout[6]/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"]
]

WriteExcel excelKeyword = new WriteExcel()

DP_Angsuran.each { columnValue ->
    def columnHeader = columnValue[0]
    def xpath = columnValue[1]
    
    String cellValue = findTextValue(xpath)
    excelKeyword.writeToExcel(columnHeader, cellValue, No)
}

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

@Keyword
def findTextValue(String xpath) {
	Mobile.getText(findTestObject('Object Repository/xpath', ['xpath' : xpath]), 0)
}