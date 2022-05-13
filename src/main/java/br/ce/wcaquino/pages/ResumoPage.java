package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ResumoPage extends BasePage {
	public void excluirMovimentacao() {
		clicarBotao(By.xpath("//*[@id=\"tabelaExtrato\"]/tbody/tr/td[6]/a/span"));
	}
public String obterMensagemSucesso() {
	return obterTexto(By.xpath("/html/body/div[1]"));
	
}

public void selecionarAno(String ano) {
	selecionarCombo("ano", ano);
}

public void buscar() {
	clicarBotao(By.xpath("//input[@value='Buscar']"));
}

}
