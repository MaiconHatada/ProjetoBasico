package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	
	@Test
	public void testInserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta do teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!" , 
				contasPage.obterMensagemSucesso());
		
		
		
	}
	
	
	@Test
	public void testAlterarConta()  {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do teste");
		contasPage.setNome("Conta do teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!" , 
				contasPage.obterMensagemSucesso());

		
		
	}

}