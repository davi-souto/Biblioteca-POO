package model;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Reserva {
	private Usuario usuario;
	private Livro livro;
	private GregorianCalendar data;

	
	public Reserva(Usuario usuario, Livro livro, GregorianCalendar data) {
		this.usuario = usuario;
		this.livro = livro;
		this.data = data;
	}
	
	public Reserva() {
		
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

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public int previsaoEntrega() {
		int devolucao = data.get(Calendar.DAY_OF_MONTH + 7);
		return devolucao;
	}
}
