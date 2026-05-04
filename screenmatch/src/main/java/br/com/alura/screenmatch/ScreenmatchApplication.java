package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverterDados;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication {

	public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
	}

    public void run(String... args) throws Exception{
        var consumoapi = new ConsumoApi();
        var json = consumoapi.obterDados("http://www.omdbapi.com/?i=Divertidamente&apikey=55c1ce18");
        System.out.println(json);
        ConverterDados conversor = new ConverterDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);
    }
}
