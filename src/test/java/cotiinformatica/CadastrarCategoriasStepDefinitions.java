package cotiinformatica;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.ChromeHelper;
import helpers.ScreenshotHelper;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastrarCategoriasStepDefinitions {

	WebDriver driver;

	@Dado("Acessar a página de cadastro de categoria")
	public void acessar_a_pagina_de_cadastro_de_categoria() {
		driver = ChromeHelper.create("http://appcontascoti-001-site1.dtempurl.com/Categorias/Cadastro");
	}

	@E("Informar o nome da categoria")
	public void informar_o_nome_da_categoria() {
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Categoria Teste");
	}

	@Quando("Solicitar a realização do cadastro da categoria")
	public void solicitar_a_realizacao_do_cadastro_da_categoria() {
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input")).click();
	}

	@Então("Sistema informa que a categoria foi cadastrada com sucesso")
	public void sistema_informa_que_a_categoria_foi_cadastrada_com_sucesso() {
		
		ScreenshotHelper.create(driver, "Cadastrar categoria.png");
		
		String mensagem = driver.findElement(By.xpath("/html/body/div[1]")).getText();
		assertTrue(mensagem.contains("cadastrada com sucesso"));
	}
}
