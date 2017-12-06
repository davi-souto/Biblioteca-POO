package model;

public class Reserva {
	private String nomeLivro;
	private String codigoLivro;
	private String curso;
	
	public Reserva(String nomeLivro, String codigoLivro, String curso) {
		this.nomeLivro = nomeLivro;
		this.codigoLivro = codigoLivro;
		this.curso = curso;
	}
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public String getCodigoLivro() {
		return codigoLivro;
	}
	public void setCodigoLivro(String codigoLivro) {
		this.codigoLivro = codigoLivro;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
}
