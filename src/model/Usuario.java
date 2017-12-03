package model;

public class Usuario {
	private String nome;
	private String matricula;
	private String senha;
	
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
}
