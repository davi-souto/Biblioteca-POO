package controller;
import java.util.ArrayList;

import exceptions.CursoBuscadoException;
import exceptions.SenhaAdminIncorretaException;
import exceptions.SenhaUsuarioIncorretaException;
import model.Usuario;
import model.Livro;
import model.Reserva;

public class Biblioteca {
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	private ArrayList<Livro> livros = new ArrayList <Livro> ();
	private ArrayList<Reserva> reservas = new ArrayList <Reserva> ();
	
	
	// USU�RIOS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public void cadastrarUsuario(String matricula, String nome, String cursoUsuario, String senha) {
		Usuario u = new Usuario(matricula, nome, cursoUsuario, senha);
		usuarios.add(u);
	}
	
	public Usuario acessarUsuario(String matricula, String senha) throws SenhaUsuarioIncorretaException {
		Usuario usuarioAcessado = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getMatricula().equals(matricula)) && (usuarios.get(i).getSenha().equals(senha)) ) {
				usuarios.get(i);
				usuarioAcessado = usuarios.get(i);
			}else {
				throw new SenhaUsuarioIncorretaException();
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
	
	public int quantidadeUsuarios() {
		return usuarios.size();
	}
	
	public void mostrarUsuariosExistentes() {
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getNome());
		}
	}
	
	public Usuario buscarUsuarioExistenteNomeOuMatricula(String nomeOuMatricula) {
		Usuario usuarioBuscadoNomeMatricula = null;
		for (int i =0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getMatricula().equals(nomeOuMatricula)) || (usuarios.get(i).getNome().equals(nomeOuMatricula))) {
				usuarios.get(i);
				usuarioBuscadoNomeMatricula = usuarios.get(i);
				
			}
		}
		return usuarioBuscadoNomeMatricula;
	}
	
	public void mostrarUsuariosDoCurso(String curso) {
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getCursoUsuario().equals(curso)) {
				System.out.println(usuarios.get(i).getNome() + ":" + usuarios.get(i).getMatricula());
			}
		}
	}

	public Usuario buscarUsuarioExistenteCurso(String curso) {
		Usuario usuarioBuscadoCurso = null;
		for (int i =0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getCursoUsuario().equals(curso)) {
				usuarios.get(i);
				usuarioBuscadoCurso = usuarios.get(i);
			}
		}
		return usuarioBuscadoCurso;
	}
	
	
	//LIVROS-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public void cadastrarLivro(String nomeLivro, String codigoLivro, String curso) {
		Livro l = new Livro(nomeLivro, codigoLivro, curso);
		livros.add(l);
	}
	
	public Livro buscarCurso(String curso) throws CursoBuscadoException {
		Livro cursoBuscado = null;
		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getCurso().equals(curso)) {
				livros.get(i);
				cursoBuscado = livros.get(i);
			}else {
				throw new CursoBuscadoException();
			}
		}
		return cursoBuscado;
	}
	
	public void mostrarLivros() {
		for (int i = 0; i < livros.size(); i++) {
			System.out.println(livros.get(i).getNomeLivro());
		}
	}
	
	
	// RESERVAS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
}
