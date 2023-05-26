package cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helpers.ChromeHelper;
import helpers.ScreenshotHelper;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastrarContasStepDefinitions {

	WebDriver driver;
	
	@Quando("Acessar a página de cadastro de contas")
	public void acessar_a_pagina_de_cadastro_de_contas() {
		driver = ChromeHelper.create("http://appcontascoti-001-site1.dtempurl.com/Contas/Cadastro");
	}

	@E("Informar o nome da conta {string}")
	public void informar_o_nome_da_conta(String nome) {
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys(nome);
	}

	@E("Informar o valor da conta {string}")
	public void informar_o_valor_da_conta(String valor) {
		driver.findElement(By.xpath("//*[@id=\"Valor\"]")).sendKeys(valor);
	}

	@E("Informar a data da conta {string}")
	public void informar_a_data_da_conta(String data) {
		driver.findElement(By.xpath("//*[@id=\"Data\"]")).sendKeys(data);
	}

	@E("Selecionar o tipo da conta {string}")
	public void selecionar_o_tipo_da_conta(String tipo) {
		if(tipo.equals("Conta a Receber")) {
			driver.findElement(By.xpath("//*[@id=\"Tipo\"]")).click();
		}
		else if(tipo.equals("Conta a Pagar")) {
			driver.findElement(By.xpath("//*[@id=\"Tipo\"]")).click();
		}
	}

	@E("Selecionar a categoria da conta {string}")
	public void selecionar_a_categoria_da_conta(String categoria) {
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"IdCategoria\"]")));
		select.selectByVisibleText(categoria);
	}

	@E("Preencher as observações da conta {string}")
	public void preencher_as_observacoes_da_conta(String observacoes) {
		driver.findElement(By.xpath("//*[@id=\"Observacoes\"]")).sendKeys(observacoes);
	}

	@Quando("Solicitar a realização do cadastro da conta")
	public void solicitar_a_realizacao_do_cadastro_da_conta() {
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[4]/div/input")).click();
	}

	@Então("Sistema informa que a conta foi cadastrada com sucesso")
	public void sistema_informa_que_a_conta_foi_cadastrada_com_sucesso() {
		
		ScreenshotHelper.create(driver, "Cadastrar conta.png");
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertTrue(mensagem.contains("cadastrada com sucesso"));
	}
}
