package br.com.exemplos.testes;

import java.util.ArrayList;
import java.util.List;

import br.com.exemplos.usuario.Usuario;

public class Capitulo4_3 {

	public static void main(String[] args) {
		
		Usuario user1 = new Usuario("Babi", 150);
		Usuario user2 = new Usuario("Diego", 140);
		Usuario user3 = new Usuario("Efraim", 120);

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
		
		usuarios.removeIf(u->u.getPontos()>130);
		usuarios.forEach(u->System.out.println(u.getNome()));

	}

}
