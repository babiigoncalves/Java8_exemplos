package br.com.exemplos.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.exemplos.usuario.Usuario;

public class Capitulo7 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Babi", 150);
		Usuario user2 = new Usuario("Diego", 140);
		Usuario user3 = new Usuario("Efraim", 120);
		Usuario user4 = new Usuario("Jaci", 135);

		List<Usuario> usuarios = Arrays.asList(user2, user1, user3, user4);

		System.out.println("-------Retornando usuario com maior pontuacao------------");
		Stream<Usuario> stream = usuarios.stream().filter(u -> u.getPontos() > 140);
		// stream.forEach(System.out::println);
		// stream.forEach(s -> System.out.println(s.getNome()));

		System.out.println("---------------");
		usuarios.stream().filter(u -> u.getPontos() > 140).forEach(Usuario::tornaModerador);
		usuarios.forEach(u -> System.out.println(u.getNome() + " " + u.isModerador()));

		System.out.println("-------Retornando usuario moderador------------");
		usuarios.stream().filter(Usuario::isModerador);
		stream.forEach(s -> System.out.println(s.getNome()));

		System.out.println("-------Retornando usuario com maior pontuacao------------");
		List<Usuario> listaRetorno = new ArrayList<>();

		usuarios.stream().filter(u -> u.getPontos() > 140).forEach(u -> listaRetorno.add(u));
		listaRetorno.forEach(u -> System.out.println(u.getNome()));

		System.out.println("-------------x---------------");
		// usuarios.stream().filter(u->u.getPontos() >
		// 140).collect(Collectors.toList());

		List<Usuario> listinha = usuarios.stream().filter(u -> u.getPontos() > 140).collect(Collectors.toList());
		listinha.forEach(l -> System.out.println(l.getNome()));

		System.out.println("------------Media de pontos---------------");
		double mediaPontos = usuarios.stream().mapToInt(Usuario::getPontos).average().orElse(0.0);
		
		System.out.println(mediaPontos);
		
		System.out.println("------------Maior qtd de pontos---------------");
		Optional<Usuario> max = usuarios.stream().max(Comparator.comparing(Usuario::getPontos));
		System.out.println(max.get().getNome());
	}

}
