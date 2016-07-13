package br.com.exemplos.testes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.exemplos.usuario.Usuario;

public class Capitulo8 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Babi", 150);
		Usuario user2 = new Usuario("Diego", 140);
		Usuario user3 = new Usuario("Efraim", 120);
		Usuario user4 = new Usuario("Jaci", 135);

		List<Usuario> usuarios = Arrays.asList(user2, user1, user3, user4);

		usuarios.stream().filter(u -> u.getPontos() > 120).sorted(Comparator.comparing(Usuario::getNome));

		List<Usuario> filtradosOrdenados = usuarios.stream().filter(u -> u.getPontos() > 140)
				.sorted(Comparator.comparing(Usuario::getNome)).collect(Collectors.toList());
		
		filtradosOrdenados.forEach(f->System.out.println(f.getNome()));
		
	//	usuarios.stream().filter(u->u.getPontos() > 120).peek(System.out::println).findAny();
		
	//	usuarios.stream().sorted(Comparator.comparing(Usuario::getNome)).peek(System.out::println).findAny();
		
		int total = usuarios.stream().mapToInt(Usuario::getPontos).sum();
		
		System.out.println(total);
		
		int soma = usuarios.stream().mapToInt(Usuario::getPontos).reduce(0, (a,b)-> a+b);
		System.out.println(soma);
		
		usuarios.stream().iterator().forEachRemaining(System.out::println);
		
		Random random = new Random(0);
		List<Integer> list = IntStream.generate(()-> random.nextInt()).limit(100).boxed().collect(Collectors.toList());
	
	}

}
