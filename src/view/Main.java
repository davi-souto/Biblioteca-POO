package view;
import java.util.Scanner;

import controller.ListaUsuarios;
import ifrn.edu.poo.ListaLivros;
import ifrn.edu.poo.Livro;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ListaUsuarios listaDeUsuarios = new ListaUsuarios();
		ListaLivros listaDeLivros = new ListaLivros();
		Textos texto = new Textos();
		int opcaoUsuario = -1;
		
		while (opcaoUsuario != 0) {
			texto.tipoUsuario();
			opcaoUsuario = ler.nextInt();
			
			switch(opcaoUsuario) {
			case 1:
				texto.menuAluno();
				int menuA = ler.nextInt();
				switch(menuA) {
					case 1: 
					
						break;
					case 2:
						listaDeUsuarios.cadastrarUsuario();
						break;
					case 3:
						texto.buscadeLivros();
						int menuLivro = ler.nextInt();
						switch(menuLivro) {
							case 1:
								System.out.println("Digite o nome do livro");
								String nomeDoLivro = ler.next();
								listaDeLivros.buscarNome(nomeDoLivro);
								break;
							case 2:
								System.out.println("Digite o curso do livro");
								String cursoDoLivro = ler.next();
								listaDeLivros.buscarCurso(cursoDoLivro);
								break;
						}
							
						break;
					case 4:
							
						break;

					}
						
					break;
			case 2:
				System.out.println("Digite sua senha de administrador: ");
				int senhaAdm = ler.nextInt();
				if (senhaAdm == 0001) {
					texto.menuAdm();
					int menuB = ler.nextInt();
					switch(menuB) {
						case 1:
							listaDeUsuarios.buscarUsuario();
							break;
						case 2:
							System.out.println("Número de usuários cadastrados: "+ listaDeUsuarios.quantidadeAlunos());
							listaDeUsuarios.mostrarUsuarios();
							break;
						case 3:
							System.out.println("Digite o nome do livro: ");
							String nomeLivro = ler.next();
							
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
									listaDeLivros.cadastrarLivro(l);
									System.out.println("Livro cadastrado!");
									break;
							}
							break;
						case 4:
							listaDeUsuarios.removerUsuario();
							break;
					}
				}else {
					System.out.println("Acesso negado!");
					break;
				}
				break;
				
				
			}
		}
	}
}

