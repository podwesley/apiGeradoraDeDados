package br.com.generate.gen.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.com.generate.gen.entity.Pessoa;
import br.com.generate.gen.service.IPessoaService;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author podwesley@gmail.com
 */
public class PersistirDadosDo4Devs {

	private static String JSONFULL;
	private static WebDriver driver;
	
	@Autowired
	static IPessoaService iPessoaService;
	
	public PersistirDadosDo4Devs() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opcao = new ChromeOptions();
		opcao.addArguments("--headless"); // --headless
		driver = new ChromeDriver(opcao);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.4devs.com.br/gerador_de_pessoas");
	}
	
	public static Pessoa pessoa() throws InterruptedException {
		//System.out.println(gerarDados());
		String gerarDados = gerarDados();
		Pessoa pessoa = new Gson().fromJson(gerarDados, Pessoa.class);
		System.out.println(pessoa.getBairro());
		System.out.println(pessoa.getData_nasc());
		return pessoa;
		
	}
	
	public static String gerarDados() throws InterruptedException {

		clickBtn(By.id("bt_gerar_pessoa"));
		clickBtn(By.id("btn_json_tab"));
		Thread.sleep(100L);
		List<WebElement> findElement = driver.findElements(By.id("dados_json"));
		JSONFULL = findElement.get(0).getText();
		//System.out.println(JSONFULL);
		driver.quit();
		return JSONFULL;
	}


	public static void clickBtn(By locator) throws InterruptedException {
		Thread.sleep(1000L);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(locator));
		actions.click();
		actions.build().perform();
	}
	
	

}
