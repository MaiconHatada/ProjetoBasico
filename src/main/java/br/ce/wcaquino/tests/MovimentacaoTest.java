package br.ce.wcaquino.tests;



import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;

public class MovimentacaoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage() ;
	
	
	@Test
	public void testInserirMovimentacao() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
		movPage.setDescricao("Movimenta��o do teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("350");
		movPage.setConta("Conta do teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimenta��o adicionada com sucesso!", 
				movPage.obterMensagemSucesso());
	}

	@Test
	public void testCamposObrigatorios() {
		
		menuPage.acessarTelaInserirMovimentacao();
		
		
		movPage.salvar();
		List<String> erros = movPage.obterErros();
		
		Assert.assertTrue(erros.containsAll(Arrays.asList
				("Data da Movimenta��o � obrigat�rio", "Data do pagamento � obrigat�rio",
						"Descri��o � obrigat�rio", "Interessado � obrigat�rio",
						"Valor � obrigat�rio", "Valor deve ser um n�mero")));
		Assert.assertEquals(6, erros.size());
		
	
	}
	@Test
	public void testInserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = new DataUtils().obterDataComDiferencaDias(5);
		
		movPage.setDataMovimentacao(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDataPagamento(DataUtils.obterDataFormatada(dataFutura));
		movPage.setDescricao("Movimenta��o do teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("350");
		movPage.setConta("Conta do teste alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		
	
		List<String> erros = movPage.obterErros();
		
		Assert.assertTrue(erros.contains
				("Data da Movimenta��o deve ser menor ou igual � data atual"));
		Assert.assertEquals(1, erros.size());
	}
	
}
