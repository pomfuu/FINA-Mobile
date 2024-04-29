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


switch(JenisSimulasi) {
	case "Budget":
		// Start Application
		Mobile.startExistingApplication(packageName)
		AndroidDriver<?> driver = MobileDriverFactory.getDriver()
		
		String id = 'com.vq.mbrochuregp.client.android:id'
		
		Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathBudget)) + '/' + 'Home_Page') + '.png', FailureHandling.STOP_ON_FAILURE)
		
		// Tutup Modal Popup
	
		TestObject modalCloseButton = findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = 'qa-closeButton']"])
		
		if (Mobile.verifyElementExist(modalCloseButton, 2, FailureHandling.OPTIONAL)) {
			Mobile.tap(modalCloseButton, 0)
		} else {
			try {
				Mobile.waitForElementPresent(findTestObject('Object Repository/xpath', ['xpath' : "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]"]), 0)
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = 'qa-closeButton']"]), 0)
			} catch (Exception e) {
				System.out.println("Modal not Shown: " + e.getMessage());
			}
		}
		
		// Buka Simulasi Budget
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"]), 1)
		Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathBudget)) + '/' + 'Simulasi_Budget') + '.png', FailureHandling.STOP_ON_FAILURE)
		
		// Pilih Kondisi Mobil
		switch(KondisiKendaraan) {
			case "New":
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/rl_simulasi_new']"]), 0)
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_harga_kendaraan']"]), 0)
				String HargaKendaraan = HargaKendaraan
						
				for (int i = 0; i < HargaKendaraan.length(); i++) {
					char digit = HargaKendaraan.charAt(i)
					int keyCode = Character.getNumericValue(digit) + 7
					driver.pressKeyCode(keyCode)
				}
				
				Mobile.hideKeyboard()
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tv_tipe_pencarian']"]), 0)
				// Pilih Simulasi
				switch(Simulasi) {
					case "BayarPertama":
					case "Bayar Pertama":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"]), 0)
						switch(LoanType) {
							case "ADDM":
								String BayarPertama = MukaDP2
								Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
								
								for (int i = 0; i < BayarPertama.length(); i++) {
									char digit = BayarPertama.charAt(i)
									int keyCode = Character.getNumericValue(digit) + 7
									driver.pressKeyCode(keyCode)
								}
								
								Mobile.hideKeyboard()
								break;
							case "ADDB":
								String BayarPertama = BelakangDP2
								Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
								
								for (int i = 0; i < BayarPertama.length(); i++) {
									char digit = BayarPertama.charAt(i)
									int keyCode = Character.getNumericValue(digit) + 7
									driver.pressKeyCode(keyCode)
								}
								
								Mobile.hideKeyboard()
								break;
						}
						break;
					case "Angsuran":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"]), 0)
						switch(LoanType) {
							case "ADDM":
								String BayarPertama = MukaAngsuran2
								Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
								
								for (int i = 0; i < BayarPertama.length(); i++) {
									char digit = BayarPertama.charAt(i)
									int keyCode = Character.getNumericValue(digit) + 7
									driver.pressKeyCode(keyCode)
								}
								Mobile.hideKeyboard()
								break;
							case "ADDB":
								String BayarPertama = BelakangAngsuran2
								Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_uang_muka']"]), 0)
								
								for (int i = 0; i < BayarPertama.length(); i++) {
									char digit = BayarPertama.charAt(i)
									int keyCode = Character.getNumericValue(digit) + 7
									driver.pressKeyCode(keyCode)
								}
								Mobile.hideKeyboard()
								break;
						}
						break;
				}
				
				// Droplist Asuransi
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tv_tipe_asuransi']"]), 0)
				
				// Pilih Asuransi
				switch(Asuransi) {
					case "TLO":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"]), 0)
						break;
					case "Comprehensive":
					case "All Risk":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"]), 0)
						break;
					case "Combine":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"]), 0)
						break;
				}
				
				// Droplist Wilayah
				Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tv_zona_wilayah']"]), 0)
				
				// Pilih Zona Wilayah
				switch(ZonaWilayah) {
					case "1":
					case "WILAYAH 1":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"]), 0)
						break;
					case "2":
					case "WILAYAH 2":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"]), 0)
						break;
					case "3":
					case "WILAYAH 3":
						Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"]), 0)
						break;
				}
					
				Mobile.hideKeyboard()
				Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathBudget)) + '/' + Simulasi + '/' + No + '/'  + 'Tenor2' + '/' + 'New_Car') + '.png', FailureHandling.STOP_ON_FAILURE)
				
				break;
			case "Used":
				 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/rl_simulasi_used']"]), 0)
				 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_tahun_kendaraan']"]), 0)
				 String TahunKendaraan = Tahun
						  
				  for (int i = 0; i < TahunKendaraan.length(); i++) {
					  char digit = TahunKendaraan.charAt(i)
					  int keyCode = Character.getNumericValue(digit) + 7
					  driver.pressKeyCode(keyCode)
				  }
				 
				 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_simulasi_harga_kendaraan']"]), 0)
				 String HargaKendaraan = HargaKendaraan
						 
				 for (int i = 0; i < HargaKendaraan.length(); i++) {
					 char digit = HargaKendaraan.charAt(i)
					 int keyCode = Character.getNumericValue(digit) + 7
					 driver.pressKeyCode(keyCode)
				 }
				 
				 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/et_input_persen']"]), 0)
				 String Persentase = DP
				 for (int i = 0; i < Persentase.length(); i++) {
					 char digit = Persentase.charAt(i)
					 int keyCode = Character.getNumericValue(digit) + 7
					 driver.pressKeyCode(keyCode)
				 }
				 
				 Mobile.hideKeyboard()
				 
				 // Droplist Asuransi
				 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tv_tipe_asuransi']"]), 0)
				 
				 // Pilih Asuransi
				 switch(Asuransi) {
					 case "TLO":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"]), 0)
						 break;
					 case "Comprehensive":
					 case "All Risk":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"]), 0)
						 break;
					 case "Combine":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"]), 0)
						 break;
				 }
				 
				 // Droplist Wilayah
				 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/tv_zona_wilayah']"]), 0)
				 
				 // Pilih Zona Wilayah
				 switch(ZonaWilayah) {
					 case "1":
					 case "WILAYAH 1":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]"]), 0)
						 break;
					 case "2":
					 case "WILAYAH 2":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]"]), 0)
						 break;
					 case "3":
					 case "WILAYAH 3":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]"]), 0)
						 break;
				 }
					 
				 Mobile.hideKeyboard()
				 
				 // Warranty Machine
				 switch(GaransiMesin) {
					 case "Yes":
					 case "ya":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/radio_button_kredit_yes']"]), 0)
						 break;
					 case "No":
					 case "tidak":
						 Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/radio_button_kredit_no']"]), 0)
						 break;
				 }
				 
				 Mobile.takeScreenshot((((baseDir + GlobalVariable.screenshotPathBudget)) + '/' + Simulasi + '/' + No + '/'  + 'Tenor2' + '/' + 'Used_Car') + '.png', FailureHandling.STOP_ON_FAILURE)
				 
				break;
		}
		
		// Hitung Sekarang
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btn_simulasi_budget']"]), 0)
		
		// Halaman Tenor
		Mobile.callTestCase(findTestCase('Test Cases/Simulasi_Budget/HasilHitungan/AngsuranMuka2'), ['No' : No, 'Simulasi' : Simulasi ], null)
		Mobile.callTestCase(findTestCase('Test Cases/Simulasi_Budget/HasilHitungan/AngsuranBelakang2'), ['No' : No, 'Simulasi' : Simulasi ], null)
		
		Mobile.tap(findTestObject('Object Repository/xpath', ['xpath' : "//*[@resource-id = '$id/btn_simulasi_close']"]), 0)
		
		break;
	default:
		break;
}