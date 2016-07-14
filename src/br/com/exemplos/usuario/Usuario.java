package br.com.exemplos.usuario;

public class Usuario {
	private String nome;
	private int pontos;
	private boolean moderador;
	
	public Usuario(String nome, int pontos){
		this.pontos = pontos;
		this.nome = nome;
		this.moderador = false;
	}
	
	public Usuario(String nome, int pontos, boolean b) {
		this.pontos = pontos;
		this.nome = nome;
		this.moderador = b;
	}

	public String getNome() {
		return nome;
	}
	public int getPontos() {
		return pontos;
	}
	
	public void tornaModerador(){
		this.moderador = true;
	}
	
	public boolean isModerador(){
		return moderador;
	}

}
