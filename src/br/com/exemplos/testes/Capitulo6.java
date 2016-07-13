package br.com.exemplos.testes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import br.com.exemplos.usuario.Usuario;

public class Capitulo6 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Babi", 150);
		Usuario user2 = new Usuario("Diego", 140);
		Usuario user3 = new Usuario("Efraim", 120);
		Usuario user4 = new Usuario("Jaci", 120);

		List<Usuario> usuarios = Arrays.asList(user2, user1, user3, user4);

		usuarios.forEach(u -> System.out.println(u.isModerador()));
		System.out.println("---------------");
		usuarios.forEach(Usuario::tornaModerador);
		usuarios.forEach(u -> System.out.println(u.isModerador()));
		System.out.println("---------------");
		usuarios.sort(Comparator.comparing(Usuario::getNome));
		System.out.println("---------------");
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos));
		usuarios.forEach(u -> System.out.println(u.getNome()));
		System.out.println("-----Compare com empate----------");
		usuarios.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome).reversed());
		usuarios.forEach(u -> System.out.println(u.getNome() + " " + u.getPontos()));
	}

}
