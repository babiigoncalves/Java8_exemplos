package br.com.exemplos.testes;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Capitulo9 {

	public static void main(String[] args) throws IOException {
		String fileName = "./src/br/com/exemplos/testes";
		Stream<String> strings = Files.list(Paths.get(fileName)).filter(p -> p.toString().endsWith("vos.java"))
				.flatMap(p -> lines(p));

		LongStream lines = Files.list(Paths.get(fileName)).filter(p -> p.toString().endsWith(".java"))
				.mapToLong(p -> lines(p).count());

		lines.forEach(l -> System.out.println(l));

		System.out.println("----------------");

		Map<Path, Long> linesPerFile = new HashMap<>();
		Files.list(Paths.get(fileName)).filter(p -> p.toString().endsWith(".java"))
				.forEach(p -> linesPerFile.put(p, lines(p).count()));
		System.out.println(linesPerFile);
	}

	static Stream<String> lines(Path p) {
		try {
			return Files.lines(p);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}
