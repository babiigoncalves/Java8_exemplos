package br.com.exemplos.testes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.exemplos.usuario.Usuario;

public class Capitulo5 {

	// Comparators

	public static void main(String[] args) {

		Usuario user1 = new Usuario("Babi", 150);
		Usuario user2 = new Usuario("Diego", 140);
		Usuario user3 = new Usuario("Efraim", 120);

		List<Usuario> usuarios = Arrays.asList(user2, user1, user3);

		usuarios.forEach(u -> System.out.println(u.getNome()));
		// Primeira maneira
		Comparator<Usuario> comparator = (u1, u2) -> u1.getNome().compareTo(u2.getNome());
		Collections.sort(usuarios, comparator);
		System.out.println("------Ordenando--------");
		// Segunda maneira
		usuarios.sort((u1, u2) -> u1.getNome().compareTo(u2.getNome()));

		usuarios.forEach(u -> System.out.println(u.getNome()));

		System.out.println("------Ordenando List-------");
		
		List<String> palavras = Arrays.asList("Casa do Codigo","Alura","Caelum");
		Collections.sort(palavras);
		System.out.println(palavras);

		System.out.println("-----Ordenando por pontos--------");
		
		usuarios.sort(Comparator.comparing(u-> u.getPontos()));
		usuarios.forEach(u -> System.out.println(u.getNome() +" "+ u.getPontos()));
		
	}

}
