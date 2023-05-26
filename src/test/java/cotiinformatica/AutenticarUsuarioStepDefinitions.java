package cotiinformatica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.ChromeHelper;
import io.cucumber.java.pt.Dado;

public class AutenticarUsuarioStepDefinitions {

	@Dado("O usuário está autenticado no sistema")
	public void usuario_esta_autenticado_no_sistema() {

		//acessando a página do sistema para autenticação do usuário
		WebDriver driver = ChromeHelper.create("http://appcontascoti-001-site1.dtempurl.com/");
		
		//informar o email e senha do usuário
		driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("sergio.coti@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"Senha\"]")).sendKeys("@Admin123");
		
		//clicar no botão para realizar a autenticação
		driver.findElement(By.xpath("/html/body/div/div/div/div/form/div[3]/input")).click();
	}
}
