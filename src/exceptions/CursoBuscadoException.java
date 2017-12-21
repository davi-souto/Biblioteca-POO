package exceptions;

public class CursoBuscadoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public CursoBuscadoException() {
		super("Curso de livro não encontrado");
	}
}
