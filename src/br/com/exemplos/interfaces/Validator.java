package br.com.exemplos.interfaces;

@FunctionalInterface
public interface Validator <T> {
	boolean valida(T t);

}
