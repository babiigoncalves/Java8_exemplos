package br.com.exemplos.testes;

import java.util.stream.IntStream;

import br.com.exemplos.fibonacci.Fibonacci;
/**
 * Classe de testes que gera os 10 primeiros números da sequência de Fibonacci.
 * @author barbara.goncalves
 *
 */
public class TesteFibonacci {

	public static void main(String[] args) {
		//Pega os primeiros 10 elementos da sequencia.
		IntStream.generate(new Fibonacci()).limit(10).forEach(System.out::println);
		
		System.out.println("-------------------------------");
		//pega o primeiro elemento da sequência maior que 100.
		int maiorQue100 = IntStream.generate(new Fibonacci()).filter(f->f>100).findFirst().getAsInt();
		System.out.println(maiorQue100);

	}

}
