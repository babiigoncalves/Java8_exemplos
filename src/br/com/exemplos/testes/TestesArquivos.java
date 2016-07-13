package br.com.exemplos.testes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Manipulação de arquivos
 * @author barbara.goncalves
 *
 */
public class TestesArquivos {

	public static void main(String[] args) throws IOException {
		
		String fileName= "./src/br/com/exemplos/testes";
		Files.list(Paths.get(fileName)).forEach(System.out::println);
		
		System.out.println("----------------------------------");
		Files.list(Paths.get(fileName)).filter(p->p.toString().endsWith(".java")).forEach(System.out::println);

	}

}
