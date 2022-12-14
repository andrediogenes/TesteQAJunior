import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automacao {

    @Test
    public void especificacaoProduto(){
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
        WebDriver navegar = new ChromeDriver();

        navegar.get("https://advantageonlineshopping.com/");

        String text = "Redesigned with you in mind, the HP Pavilion keeps getting better. Our best-selling notebook is now more powerful so you can watch more, play more, and store more, all in style.";


        //Foi colocado um wait entre os get pois estava dando erro. Tentava se executar o comando antes da página carregar
        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        navegar.findElement(By.id("see_offer_btn")).click();

        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        //Fazendo a validação
        String bodyText = navegar.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(text));
    }

    @Test
    public void alteracaoCor(){
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
        WebDriver navegar = new ChromeDriver();

        navegar.get("https://advantageonlineshopping.com/");

        String text = "PURPLE";

        //Foi colocado um wait entre os get pois estava dando erro. Tentava se executar o comando antes da página carregar
        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        navegar.findElement(By.id("see_offer_btn")).click();

        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        navegar.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[1]/div[2]/span[4]")).click();

        navegar.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[4]/button")).click();

        navegar.findElement(By.id("menuCart")).click();

        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        //Fazendo a validação
        String bodyText = navegar.findElement(By.xpath("/html/body/div[3]/section/article/div[2]/tool-tip-cart/div/table/tbody/tr/td[2]/a/label[2]/span")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(text));
    }

    @Test
    public void paginaCheckout(){
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
        WebDriver navegar = new ChromeDriver();

        navegar.get("https://advantageonlineshopping.com/");

        String text = "$299.99";

        //Foi colocado um wait entre os get pois estava dando erro. Tentava se executar o comando antes da página carregar
        try { Thread.sleep (5000); } catch (InterruptedException ex) {}
        navegar.findElement(By.id("menuSearch")).click();

        try { Thread.sleep (2000); } catch (InterruptedException ex) {}
        navegar.findElement(By.xpath("/html/body/header/nav/ul/li[4]/a/div/div[1]/div/div/input")).sendKeys("chrome");

        try { Thread.sleep (2000); } catch (InterruptedException ex) {}
        navegar.findElement(By.xpath("//*[@id=\"output\"]/div/div[2]/a[2]")).click();

        try { Thread.sleep (2000); } catch (InterruptedException ex) {}
        navegar.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[1]/div[1]/span[2]")).click();
        navegar.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[4]/button")).click();

        try { Thread.sleep (2000); } catch (InterruptedException ex) {}
        navegar.findElement(By.xpath("/html/body/header/nav/ul/li[2]/ul/li/tool-tip-cart/div/table/tfoot/tr[2]/td/button")).click();

        try { Thread.sleep (2000); } catch (InterruptedException ex) {}
        //Validacoes
        String bodyText = navegar.findElement(By.xpath("/html/body/div[3]/section/article/div/div[2]/div[2]/label[2]/span")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(text));
    }

    @Test
    public void removerProduto(){
        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
        WebDriver navegar = new ChromeDriver();

        navegar.get("https://advantageonlineshopping.com/");

        String text = "Your shopping cart is empty";

        //Foi colocado um wait entre os get pois estava dando erro. Tentava se executar o comando antes da página carregar
        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        navegar.findElement(By.id("see_offer_btn")).click();

        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        navegar.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[1]/div[2]/span[4]")).click();

        navegar.findElement(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[4]/button")).click();

        navegar.findElement(By.id("menuCart")).click();

        try { Thread.sleep (5000); } catch (InterruptedException ex) {}

        navegar.findElement(By.xpath("/html/body/div[3]/section/article/div[1]/table/tbody/tr/td[6]/span/a[3]")).click();

        //Validacoes
        String bodyText = navegar.findElement(By.xpath("/html/body/div[3]/section/article/div[1]/div/label")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(text));
    }
}
