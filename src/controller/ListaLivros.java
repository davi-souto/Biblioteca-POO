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
	Textos texto = new Textos();
	Usuario usuarios = new Usuario();
	
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
			String livroEmprestado = ler.nextLine();
			System.out.println("Digite sua senha:");
			String senha = ler.next();
			
			
			// Ainda em andamento, com erro
			if(senha.equals(usuarios.getSenha())) {
				for (int i = 0; i < livros.size(); i++) {
					if(livros.get(i).getNomeLivro().equals(livroEmprestado)) {
						String nomeLivro = livros.get(i).getNomeLivro();
						String codigoLivro = livros.get(i).getCodigoLivro();
						String curso = livros.get(i).getCurso();
						Livro l = new Livro(nomeLivro, codigoLivro, curso);
						
						livros.remove(i);
						quantidadeLivros --;
						reservas.add(l);
						
						
						
						
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
			if(livros.get(i).getNomeLivro().equals(nomeDoLivro))
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
		}
	}
	
}
