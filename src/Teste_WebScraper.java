import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Teste_WebScraper {

	public static void main(String[] args) throws IOException {
		
		//conecta na url passada no connect, utilizando a biblioteca Jsoup
		Document doc = Jsoup.connect("https://www.kabum.com.br/cgi-local/site/produtos/descricao_ofertas.cgi?codigo=104734").get();
		String tituloProduto = doc.title(); //traz o titulo do produto
		System.out.println(tituloProduto); 
		
		Elements ele = doc.select("div#pag-detalhes"); //seleciona a div de detalhes

		//traz uma lista de elementos da classe da descrição do produto(tab_)
		for (Element element : ele.select("div.tab_")) { 

			String descricao = element.select("div.content_tab").text(); //retorna a descriçao
			String tituloDecricao = element.select("div.bot_tab").text(); // retorna o titulo da (descrição)
			
			System.out.println(tituloDecricao); //reponsavel por imprimir (DESCRIÇÃO DO PRODUTO)
			System.out.println(descricao); // responsavel por imprimir detalhes do produto

		}

	}

}
