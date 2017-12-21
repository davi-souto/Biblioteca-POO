package model;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Reserva {
	private Usuario usuario;
	private Livro livro;
	private GregorianCalendar dataEmprestimo;
	private GregorianCalendar dataDevolucao;

	
	public Reserva(Usuario usuario, Livro livro, GregorianCalendar dataEmprestimo, GregorianCalendar dataDevolucao) {
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
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

	public GregorianCalendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(GregorianCalendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public GregorianCalendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(GregorianCalendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	public GregorianCalendar renovarDevolucao() {
		dataDevolucao.add(Calendar.DAY_OF_MONTH, 7);
		return dataEmprestimo;
	}

}