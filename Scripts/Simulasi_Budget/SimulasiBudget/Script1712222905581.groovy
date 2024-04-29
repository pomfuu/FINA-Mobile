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
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.model.FailureHandling

import org.openqa.selenium.Keys as Keys

String baseDir = System.getProperty('user.dir')

String packageName = 'com.vq.mbrochuregp.client.android'
String launcherActivity = 'com.example.bcafrevamp.screen.splash.SplashActivity'

Mobile.startExistingApplication(packageName)
AndroidDriver<?> driver = MobileDriverFactory.getDriver()
		
String id = 'com.vq.mbrochuregp.client.android:id'

Map<String, Object> variableMap = [
	'No': No,
	'JenisSimulasi': JenisSimulasi,
	'KondisiKendaraan': KondisiKendaraan,
	'HargaKendaraan': HargaKendaraan,
	'Simulasi': Simulasi,
	'DP': DP,
	'Tahun': Tahun,
	'Tenor': Tenor,
	'GaransiMesin': GaransiMesin,
	'Asuransi': Asuransi,
	'ZonaWilayah': ZonaWilayah,
	'LoanType': LoanType,
	'BiayaFidusia': BiayaFidusia,
	'BiayaCP': BiayaCP,
	'BiayaProvinsi': BiayaProvinsi,
	'BiayaAsuransi': BiayaAsuransi,
	'BiayaAdmin': BiayaAdmin,
	'MukaDP1': MukaDP1,
	'MukaDP2': MukaDP2,
	'MukaDP3': MukaDP3,
	'MukaDP4': MukaDP4,
	'MukaDP5': MukaDP5,
	'MukaDP6': MukaDP6,
	'MukaAngsuran1': MukaAngsuran1,
	'MukaAngsuran2': MukaAngsuran2,
	'MukaAngsuran3': MukaAngsuran3,
	'MukaAngsuran4': MukaAngsuran4,
	'MukaAngsuran5': MukaAngsuran5,
	'MukaAngsuran6': MukaAngsuran6,
	'BelakangDP1': BelakangDP1,
	'BelakangDP2': BelakangDP2,
	'BelakangDP3': BelakangDP3,
	'BelakangDP4': BelakangDP4,
	'BelakangDP5': BelakangDP5,
	'BelakangDP6': BelakangDP6,
	'BelakangAngsuran1': BelakangAngsuran1,
	'BelakangAngsuran2': BelakangAngsuran2,
	'BelakangAngsuran3': BelakangAngsuran3,
	'BelakangAngsuran4': BelakangAngsuran4,
	'BelakangAngsuran5': BelakangAngsuran5,
	'BelakangAngsuran6': BelakangAngsuran6
]

List<String> variablesToPass = []
for (String columnHeader : variableMap.keySet()) {
	Object value = variableMap.get(columnHeader)
	if (value != null) {
		variablesToPass.add(columnHeader)
	}
}

Map<String, Object> variables = [:]
for (String variableName : variablesToPass) {
	variables.put(variableName, variableMap.get(variableName))
}

switch(Tenor) {
	case "Tenor 12 - Tenor 72":
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor1'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor2'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor3'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor4'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor5'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor6'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		break;
	case "Tenor 12 - Tenor 48":
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor1'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor2'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor3'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		Mobile.callTestCase(TestCaseFactory.findTestCase('Test Cases/Simulasi_Budget/Tenor/Tenor4'), variables, FailureHandling.CONTINUE_ON_FAILURE)
		break;
	default:
		break;
}
		