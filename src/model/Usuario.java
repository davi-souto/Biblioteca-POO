package model;



public class Usuario {
	private String nome;
	private String matricula;
	private String senha;
	private String livrosEmprestados;
	
	
	public String getLivrosEmprestados() {
		return livrosEmprestados;
	}

	public void setLivrosEmprestados(String livrosEmprestados) {
		this.livrosEmprestados = livrosEmprestados;
	}

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
