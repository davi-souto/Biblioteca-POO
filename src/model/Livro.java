package model;

public class Livro {
	private String nomeLivro;
	private String curso;
	
	public Livro(String nomeLivro, String curso) {
		this.nomeLivro = nomeLivro;
		this.curso = curso;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
