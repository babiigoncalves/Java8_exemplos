package br.com.exemplos.testes;

import java.time.LocalDate;
import java.util.Calendar;

public class Capitulo10 {

	public static void main(String[] args) {
		
		//Foram antiga de de criar uma data com um mês a partir da data atual.
		Calendar mesQvemAntigo = Calendar.getInstance();
		mesQvemAntigo.add(Calendar.MONTH, 1);
		
		System.out.println(mesQvemAntigo.getTime());
		
		System.out.println("-------Novo--------");
		
		LocalDate mesQvem = LocalDate.now().plusMonths(1);

		System.out.println(mesQvem.toString());
	}

}
