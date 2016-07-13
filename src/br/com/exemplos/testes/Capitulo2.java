package br.com.exemplos.testes;

import java.util.Arrays;
import java.util.List;

import br.com.exemplos.usuario.Usuario;

public class Capitulo2 {

	public static void main(String[] args) {
		Usuario user1 = new Usuario("Babi", 150);
		Usuario user2 = new Usuario("Diego", 120);
		Usuario user3 = new Usuario("Efraim", 110);

		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);
		/*
		 * Convencional for(Usuario u : usuarios){
		 * System.out.println(u.getNome()); }
		 */

		/*
		 * Método 2 usuarios.forEach(new Consumer<Usuario>() { public void
		 * accept(Usuario u){ System.out.println(u.getNome()); } });
		 */

		//Consumer<Usuario> mostrador =  u -> System.out.println(u.getNome());
		
		
		usuarios.forEach(u -> System.out.println(u.getNome()));
		usuarios.forEach(u ->u.tornaModerador());
	}

}
