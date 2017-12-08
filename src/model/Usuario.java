package model;



public class Usuario {
	private String nome;
	private String matricula;
	private String cursoUsuario;
	private String senha;
	
	public Usuario(String matricula, String nome, String cursoUsuario, String senha) {

		this.matricula = matricula;
		this.nome = nome;
		this.cursoUsuario = cursoUsuario;
		this.senha = senha;
	}
	
	public Usuario() {
		
	}
	
	
	public String getCursoUsuario() {
		return cursoUsuario;
	}

	public void setCursoUsuario(String cursoUsuario) {
		this.cursoUsuario = cursoUsuario;
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
