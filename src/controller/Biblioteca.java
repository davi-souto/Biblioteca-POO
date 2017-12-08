package controller;
import java.util.ArrayList;
import model.Usuario;
import model.Livro;
import model.Reserva;

public class Biblioteca {
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	private ArrayList<Livro> livros = new ArrayList <Livro> ();
	private ArrayList<Reserva> reservas = new ArrayList <Reserva> ();
	
	public void adicionarUsuario(Usuario u) {
		usuarios.add(u);
	}
	
}
