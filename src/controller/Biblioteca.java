package controller;
import java.util.ArrayList;

import exceptions.SenhaAdminIncorretaException;
import model.Usuario;
import model.Livro;
import model.Reserva;

public class Biblioteca {
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	private ArrayList<Livro> livros = new ArrayList <Livro> ();
	private ArrayList<Reserva> reservas = new ArrayList <Reserva> ();
	
	public void cadastrarUsuario(String matricula, String nome, String curso, String senha) {
		Usuario u = new Usuario(matricula, nome, curso, senha);
		usuarios.add(u);
	}
	
	public Usuario acessarUsuario(String matricula, String senha) {
		Usuario usuarioAcessado = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getMatricula().equals(matricula)) && (usuarios.get(i).getSenha().equals(senha)) ) {
				usuarios.get(i);
				usuarioAcessado = usuarios.get(i);
			}
		}
		return usuarioAcessado;
	}
	
	public boolean removerUsuario(String matricula, int senhaAdmin) throws SenhaAdminIncorretaException {
		boolean usuarioExcluido = false;
		if (senhaAdmin == 0001) {
			for (int i = 0; i < usuarios.size(); i++) {
				if(usuarios.get(i).getMatricula().equals(matricula)) {
					usuarios.remove(i);
					usuarioExcluido = true;
				}
			}
		}else {
			throw new SenhaAdminIncorretaException(); 
		}
		return usuarioExcluido;
	}
	
	
	
}
