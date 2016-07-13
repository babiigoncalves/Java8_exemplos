package br.com.exemplos.testes;

import br.com.exemplos.interfaces.Validator;

public class Capitulo3 {

	public static void main(String[] args) {
		Validator<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");
		validadorCEP.valida("53150-400");

	}

}
