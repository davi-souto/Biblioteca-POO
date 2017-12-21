package exceptions;

public class LivroBuscadoException extends Exception {
	private static final long serialVersionUID = 1L;
	public LivroBuscadoException() {
		super("Livro não encontrado");
	}
}
