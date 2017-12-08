package controller;
import java.util.ArrayList;
import java.util.Scanner;

import model.Livro;
import model.Usuario;
import model.Reserva;
import view.Textos;

public class ListaLivros {
	
	public ArrayList<Livro> livros = new ArrayList <Livro> ();
	public ArrayList<Reserva> reservas = new ArrayList <Reserva> ();
	private int quantidadeLivros;
	private int quantidadeReserva;
	Textos texto = new Textos();
	Usuario usuario = new Usuario();
	
	
	public ListaLivros() {
		quantidadeLivros = 0;
	}
	
	public void cadastrarLivro() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o nome do livro: ");
		String nomeLivro = ler.nextLine();
		
		System.out.println("Digite o código do livro: ");
		String codigoLivro = ler.next();
		
		System.out.println("Digite o curso ao qual pertence o livro: ");
		String curso = ler.next();
		
		Livro l = new Livro(nomeLivro, codigoLivro, curso);
		
		System.out.println("O nome do livro é: " + l.getNomeLivro());
		System.out.println("O código do livro é: " + l.getCodigoLivro());
		System.out.println("O livro pertence ao curso: " + l.getCurso());
		texto.confirmarCadastro();
		int confirma = ler.nextInt();
		switch(confirma) {
			case 1:
				livros.add(l);
				quantidadeLivros++;
				System.out.println("Livro cadastrado!");
				break;
		}
	}
	
	public void buscarCurso() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o curso do livro");
		String cursoDoLivro = ler.next();
		
		for(int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getCurso().equals(cursoDoLivro)) {
				System.out.println("Livros: "+ livros.get(i).getNomeLivro());
		
			}else {
				System.out.println("Livros não encontrados");
			}
		}	
	}			
	
	
	public void emprestimo() {
	
		Scanner ler = new Scanner(System.in);
		
		// ListaUsuarios listaUsuarios = new ListaUsuarios();
		
		texto.emprestimoLivro();
		int opcao = ler.nextInt();
		switch(opcao) {
		
		case 1:
			System.out.println("Digite o nome do livro desejado:");
			String livroEmprestado = ler.next();
			System.out.println("Digite sua matrícula:");
			String matricula = ler.next();
			System.out.println("Digite sua senha:");
			String senha = ler.next();
			if(senha.equals("123")) {
				for (int i = 0; i < livros.size(); i++) {
					if(livros.get(i).getNomeLivro().equals(livroEmprestado)) {
						Reserva e = new Reserva();
						e.setNomeLivro(livros.get(i).getNomeLivro());
						e.setCodigoLivro(livros.get(i).getCodigoLivro());
						e.setCursoLivro(livros.get(i).getCurso());
						reservas.add(e);
						quantidadeReserva ++;
						livros.remove(i);
						quantidadeLivros --;
						System.out.println("Concluido!");
					}else {
						System.out.println("erro");
					}
				}
			} else {
				System.out.println("erro!!");
			}
		}
		
	}
	
	public void devolução() {
	}
	
	public void buscarNome() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o nome do livro");
		String nomeDoLivro = ler.next();
		
		for(int i = 0; i < quantidadeLivros; i++) {
			if(livros.get(i).getNomeLivro().equals(nomeDoLivro)) {
				texto.emprestimoLivro();
			int opcao = ler.nextInt();
			switch(opcao) {
			
			case 1:
				System.out.println("Digite sua senha:");
				int senha = ler.nextInt();
				if(senha == 123) {
					for (int e = 0; e < livros.size(); e++) {
						if(livros.get(e).getNomeLivro().equals(nomeDoLivro)) {
							livros.remove(e);
							quantidadeLivros --;
							System.out.println("Concluido!");
						}else {
							System.out.println("erro");
						}
					}
				} else {
					System.out.println("erro!!");
				}
			}
		}else {
			System.out.println("Livros não encontrados");
			}
		}
	}
	
}
