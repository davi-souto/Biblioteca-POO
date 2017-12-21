package controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import exceptions.CursoBuscadoException;
import exceptions.CursoUsuarioNaoIdentificadoException;
import exceptions.LivroBuscadoException;
import exceptions.MatriculaNaoIdentificadaException;
import exceptions.SenhaAdminIncorretaException;
import exceptions.SenhaUsuarioIncorretaException;

import model.Usuario;
import model.Livro;
import model.Reserva;


public class Biblioteca {
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	private ArrayList<Livro> livros = new ArrayList <Livro> ();
	private ArrayList<Reserva> reservas = new ArrayList <Reserva> ();

	
	
	
	// USUï¿½RIOS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	public void cadastrarUsuario(String matricula, String nome, String cursoUsuario, String senha) {
		Usuario u = new Usuario(matricula, nome, cursoUsuario, senha);
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
	
	public void trocarSenhaUsuario(String senhaAtual, String senhaNova, String senhaNovaConfirmar) {
		for (int i = 0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getSenha().equals(senhaAtual)) ) {
				if (senhaNova.equals(senhaNovaConfirmar)) {
					usuarios.get(i).setSenha(senhaNova);
					System.out.println("Operacao concluida!");
				}
			}
		}
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
			System.out.println(usuarios.get(i).getNome() + " : " + usuarios.get(i).getCursoUsuario());
		}
	}
	
	public Usuario buscarUsuarioExistenteMatricula(String matriculaOuNome) throws MatriculaNaoIdentificadaException {
		Usuario usuarioBuscadoMatricula = null;
		for (int i =0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getMatricula().equals(matriculaOuNome)) ) {
				usuarios.get(i);
				usuarioBuscadoMatricula = usuarios.get(i);
				
			}else {
				throw new MatriculaNaoIdentificadaException();
			}
		}
		return usuarioBuscadoMatricula;
	}
	
	public void mostrarUsuariosDoCurso(String curso) throws CursoUsuarioNaoIdentificadoException{
		for (int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getCursoUsuario().equals(curso)) {
				System.out.println(usuarios.get(i).getNome() + ":" + usuarios.get(i).getMatricula());
			}else {
				throw new CursoUsuarioNaoIdentificadoException();
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
	
	
	public void cadastrarLivro(String nomeLivro, String curso)  {
			Livro l = new Livro(nomeLivro, curso);
			livros.add(l);
	}
	
	public Livro buscarNome(String nomeLivro) throws LivroBuscadoException {
		Livro nomeBuscado = null;
		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getNomeLivro().equals(nomeLivro)) {
				livros.get(i);
				nomeBuscado = livros.get(i);
			}else {
				throw new LivroBuscadoException();
			}
		}
		return nomeBuscado;
	}
	
	
	public void buscarCurso(String curso) { 
		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getCurso().equals(curso)) {
				System.out.println("Livro: " + livros.get(i).getNomeLivro());	
			}
		}
	}
	
	public void mostrarLivros() {
		for (int i = 0; i < livros.size(); i++) {
			System.out.println("Livros: " + livros.get(i).getNomeLivro());
		}
	}
	
	public boolean emprestimo(int senha, String nomeLivro) {
		boolean livroEmprestado = false;
		if(senha == 123) {
			for(int i = 0; i < livros.size(); i++) {
				if(livros.get(i).getNomeLivro().equals(nomeLivro)) {
					
					
					
				}
			}
		}	
		return livroEmprestado;
	}	
	
	// RESERVAS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	public void cadastrarReserva(String matriculaUsuario, String senhaUsuario, String nomeLivro) { 
		GregorianCalendar dataEmprestimo = new GregorianCalendar();
		GregorianCalendar dataDevolucao = new GregorianCalendar();
		int quantidadeRenovar = 0;
		dataDevolucao.add(Calendar.DAY_OF_MONTH, 7);
		for (int i = 0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getMatricula().equals(matriculaUsuario)) && (usuarios.get(i).getSenha().equals(senhaUsuario))) {
				for (int o = 0; o < livros.size(); o++) {
					if(livros.get(o).getNomeLivro().equals(nomeLivro)) {
						Reserva r = new Reserva(usuarios.get(i), livros.get(o), dataEmprestimo, dataDevolucao, quantidadeRenovar);
						reservas.add(r);
						livros.remove(o);
						System.out.println("Concluido!");
					}
				}
			}
		}
	}
	
	public void removerReserva(String matriculaUsuario, String senhaUsuario, String nomeLivro) {
		for (int i = 0; i < usuarios.size(); i++) {
			if ((usuarios.get(i).getMatricula().equals(matriculaUsuario)) && (usuarios.get(i).getSenha().equals(senhaUsuario))) {
				for (int r = 0; r < reservas.size(); r++) {
					if (reservas.get(r).getLivro().getNomeLivro().equals(nomeLivro)) {
						Livro l = new Livro(nomeLivro, reservas.get(r).getLivro().getCurso());
						livros.add(l);
						reservas.remove(r);
						System.out.println("Concluido");
					}
				}
			}
		}
	}
	
	public int quantidadeDeReservas() {
		return reservas.size();
	}
	
	public void mostrarReservasExistentes() {
		for (int i = 0; i < reservas.size(); i++) {
			System.out.println("Usuario em posse: " + reservas.get(i).getUsuario().getNome()  + " :Matricula do usuario: " + reservas.get(i).getUsuario().getMatricula());
			System.out.println("------------------------------------------");
			System.out.println("Livro emprestado: "	+ reservas.get(i).getLivro().getNomeLivro() + " :Curso do livro: " + reservas.get(i).getLivro().getCurso());
			System.out.println("------------------------------------------");
			System.out.println("Data de emprestimo: " + reservas.get(i).getDataEmprestimo().get(Calendar.DAY_OF_MONTH) + "/" + reservas.get(i).getDataEmprestimo().get(Calendar.MONTH) + "  Previsao de Devolucao " + reservas.get(i).getDataDevolucao().get(Calendar.DAY_OF_MONTH) + "/" + reservas.get(i).getDataDevolucao().get(Calendar.MONTH));
		}
	}
	
	public void livrosEmPosseUsuario(String matricula, String senha) { 
		System.out.println("Livros em posse: " );
		for (int i = 0; i < usuarios.size(); i++) {
			if((usuarios.get(i).getMatricula().equals(matricula)) && (usuarios.get(i).getSenha().equals(senha)) ) {
				usuarios.get(i);
				for(int o = 0; o < reservas.size(); o++) {
					if(usuarios.get(i).getMatricula().equals(reservas.get(o).getUsuario().getMatricula())) {
						System.out.println("Livro: " + reservas.get(o).getLivro().getNomeLivro() + " Curso: " + reservas.get(o).getLivro().getCurso() + " Data da Devolucao: " + reservas.get(o).getDataDevolucao().get(Calendar.DAY_OF_MONTH) + "/" + reservas.get(o).getDataDevolucao().get(Calendar.MONTH));
					}
				}
			}
		}
	}
	
	public void renovarLivroEmPosseUsuario(String nomeLivro, String matriculaUsuario) {
		GregorianCalendar dataEmprestimo = new GregorianCalendar();
		GregorianCalendar dataDevolucao = new GregorianCalendar();
		for (int i = 0; i < reservas.size(); i++) {
			if((nomeLivro.equals(reservas.get(i).getLivro().getNomeLivro())) && (matriculaUsuario.equals(reservas.get(i).getUsuario().getMatricula()))) {
				if(reservas.get(i).getQuantidadeRenovar() == 0) {
					reservas.get(i).setDataEmprestimo(dataEmprestimo);
					reservas.get(i).setDataDevolucao(dataDevolucao);
					reservas.get(i).renovarDevolucao();
					reservas.get(i).setQuantidadeRenovar(1);
					System.out.println("Operacao Concluida!");
					System.out.println("Nova data de devolucao: " + reservas.get(i).getDataDevolucao().get(Calendar.DAY_OF_MONTH) + "/" + reservas.get(i).getDataDevolucao().get(Calendar.MONTH));
				}else {
					System.out.println("Você não pode renovar um prazo de um mais de uma vez");
				}
			}
		}
	}
}