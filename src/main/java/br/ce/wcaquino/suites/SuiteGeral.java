package br.ce.wcaquino.suites;

import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.tests.ContaTest;
import br.ce.wcaquino.tests.MovimentacaoTest;
import br.ce.wcaquino.tests.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.tests.ResumoTest;
import br.ce.wcaquino.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class, 
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})


public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();

	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		
		
		page.setEmail("maicon.hatada17@gmail.com");
		page.setSenha("bm12040707");
		page.entrar();
	
	}
@AfterClass
public static void finaliza() {
	killDriver();
}
}
