package controller;
import java.util.ArrayList;
import java.util.Scanner;

import model.Livro;
import model.Usuario;
import view.Textos;

public class ListaLivros {
	
	private ArrayList<Livro> livros = new ArrayList <Livro> ();
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
	
	public Livro buscarCurso() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o curso do livro");
		String cursoDoLivro = ler.next();
		
		for(int i = 0; i < quantidadeLivros; i++) {
			if(livros.get(i).getCurso().equals(cursoDoLivro))
				for(int e = 0; e < livros.size(); e++) {
					System.out.println("Livros: "+ livros.get(e).getNomeLivro());
					
					texto.emprestimoLivro();
					int opcao = ler.nextInt();
					switch(opcao) {
					
					case 1:
						System.out.println("Digite o nome do livro desejado:");
						String livroEmprestado = ler.next();
						System.out.println("Digite sua senha:");
						String senha = ler.next();
						if(senha == usuarios.getSenha()) {
							for (int d = 0; d < livros.size(); d++) {
								if(livros.get(d).getNomeLivro().equals(livroEmprestado)) {
									livros.remove(d);
									System.out.println("Concluido!");
								}
							}
						}	
					}
				}
		}
		return null;
	}
	
	public Livro buscarNome() {
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
					String senha = ler.nextLine();
					if (senha == usuarios.getSenha()) {
						for (i = 0; i < livros.size(); i++) {
							if (livros.get(i).getNomeLivro().equals(nomeDoLivro)) {
								livros.remove(i);
								System.out.println("Concluido!");
							}
						}
					}
				}
				return livros.get(i);
		}
		return null;
	}
	
	public void mostrarLivros() {
		for (int i = 0; i < livros.size(); i++) {
			System.out.println("Livro: "+ livros.get(i).getNomeLivro());
		}
	
	}

	
	

}
