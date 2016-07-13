package br.com.exemplos.testes;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import br.com.exemplos.usuario.Usuario;

public class Capitulo4 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Babi", 150);
		Usuario user2 = new Usuario("Diego", 140);
		Usuario user3 = new Usuario("Efraim", 120);
		
		List<Usuario> usuarios = Arrays.asList(user1,user2,user3);
		
		Consumer<Usuario> mostraMensagem = u->System.out.println("Antes de imprimir nomes");
		
		Consumer<Usuario> imprimeNome = u->System.out.println(u.getNome());
		usuarios.forEach(mostraMensagem.andThen(imprimeNome));
	

	}

}
