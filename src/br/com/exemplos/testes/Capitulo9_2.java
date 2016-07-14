package br.com.exemplos.testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.com.exemplos.usuario.Usuario;

public class Capitulo9_2 {

	public static void main(String[] args) {

		Usuario user1 = new Usuario("Babi", 150, true);
		Usuario user2 = new Usuario("Diego", 145, true);
		Usuario user3 = new Usuario("Efraim", 140);
		Usuario user4 = new Usuario("Jaci", 135);
		Usuario user5 = new Usuario("Andre", 130);

		List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5);
		Map<Integer, List<Usuario>> pontuacao = new HashMap<>();

		for (Usuario u : usuarios) {
			if (!pontuacao.containsKey(u.getPontos())) {
				pontuacao.put(u.getPontos(), new ArrayList<>());
			}
			pontuacao.get(u.getPontos()).add(u);
		}
		// System.out.println(pontuacao);

		// Mesmo procedimento em Java 8:

		Map<Integer, List<Usuario>> pontuacao2 = new HashMap<>();

		for (Usuario u : usuarios) {
			pontuacao2.computeIfAbsent(u.getPontos(), user -> new ArrayList<>()).add(u);
		}
		// System.out.println(pontuacao2);

		// Com streams:

		Map<Integer, List<Usuario>> pontuacao3 = usuarios.stream().collect(Collectors.groupingBy(Usuario::getPontos));
		// System.out.println(pontuacao3);

		// Partition
		Map<Boolean, List<Usuario>> moderadores = usuarios.stream()
				.collect(Collectors.partitioningBy(Usuario::isModerador));
				// System.out.println(moderadores);

		// mapping
		Map<Boolean, List<String>> nomesPorTipo = usuarios.stream().collect(Collectors
				.partitioningBy(Usuario::isModerador, Collectors.mapping(Usuario::getNome, Collectors.toList())));

		System.out.println(nomesPorTipo);

		// somatorio de pontos
		Map<Boolean, Integer> pontuacaoPorTipo = usuarios.stream()
				.collect(Collectors.partitioningBy(Usuario::isModerador, Collectors.summingInt(Usuario::getPontos)));
		System.out.println(pontuacaoPorTipo);

		// Filtrar os usuários com mais de 100 pontos, ordená-los e coletar o
		// resultado em uma lista
		List<Usuario> filtradosOrdenados = usuarios.stream().filter(u -> u.getPontos() > 140)
				.sorted(Comparator.comparing(Usuario::getPontos)).collect(Collectors.toList());

		filtradosOrdenados.forEach(f->System.out.println(f.getNome()));
		 System.out.println("-----------------------");
		//ParallelStream
		List<Usuario> filtrarOrdenados2 = usuarios.parallelStream().filter(u -> u.getPontos() > 140)
				.sorted(Comparator.comparing(Usuario::getNome)).collect(Collectors.toList());
		//System.out.println(filtrarOrdenados2.iterator().next().getNome());
		filtrarOrdenados2.forEach(f->System.out.println(f.getNome()));
	}

}
