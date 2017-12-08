package exceptions;

public class SenhaUsuarioIncorretaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SenhaUsuarioIncorretaException() {
		super("Senha de usuário incorreta");
	}
}
