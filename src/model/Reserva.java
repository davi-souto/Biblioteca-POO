package model;

public class Reserva {
	private Usuario usuario;
	private Livro livro;
	
	public Reserva(Usuario usuario, Livro livro) {
		this.usuario = usuario;
		this.livro = livro;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
