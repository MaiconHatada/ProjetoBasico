package br.ce.wcaquino.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.wcaquino.pages.LoginPage;



public class BaseTest extends DriverFactory {
	
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		
		
		page.setEmail("maicon.hatada17@gmail.com");
		page.setSenha("bm12040707");
		page.entrar();
		
	}
	
 @After
 public void finaliza() throws IOException {
	 
	 TakesScreenshot ss = (TakesScreenshot) getDriver();
	 
	 File arquivo = ss.getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(arquivo, new File ("target"+ File.separator + "screenshot" + File.separator + 
	 testName.getMethodName() + "jpg"));
	 
//	 if(Propriedades.FECHAR_BROWSER) {
//	 killDriver();
 }
 
}
