package view;
import java.util.Scanner;

import controller.ListaLivros;
import controller.ListaUsuarios;
import model.Livro;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		ListaUsuarios listaDeUsuarios = new ListaUsuarios();
		ListaLivros listaDeLivros = new ListaLivros();
		Textos texto = new Textos();
		int opcaoUsuario = -1;
		
		System.out.println("Seja bem vindo!");
		System.out.println("De novo!!!");
		
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
								listaDeLivros.buscarNome();
								break;
							case 2:
								listaDeLivros.buscarCurso();
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
							listaDeLivros.cadastrarLivro();
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

