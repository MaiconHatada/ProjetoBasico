package br.ce.wcaquino.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.core.Propriedades;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // define ordem de execu��o p massa dados
public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	
	@Test
	public void test1_InserirConta() {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!" , 
				contasPage.obterMensagemSucesso());
		
		
		
	}
	
	
	@Test
	public void test2_AlterarConta()  {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do teste");
		contasPage.setNome("Conta do teste alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!" , 
				contasPage.obterMensagemSucesso());

		
		
	}
	 @Test
	 public void test3_InserirContaMesmoNome() {
		 menuPage.acessarTelaInserirConta();
		 
		 contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		 contasPage.salvar();
		 
		 Assert.assertEquals("J� existe uma conta com esse nome!" , 
					contasPage.obterMensagemErro());
}
	
	 
	 }

