package exceptions;

public class SenhaUsuarioIncorretaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public SenhaUsuarioIncorretaException() {
		super("Senha ou matr�cula de usu�rio incorreta");
	}
}
