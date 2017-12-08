package view;
import java.util.Scanner;

import controller.ListaLivros;
import controller.Biblioteca;
import exceptions.SenhaAdminIncorretaException;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
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
						ler = new Scanner(System.in); 
						
						System.out.println("Digite sua matricula: ");
						String acessarMatricula = ler.nextLine();
						
						System.out.println("Digite sua senha: ");
						String acessarSenha = ler.nextLine();
						
						biblioteca.acessarUsuario(acessarMatricula, acessarSenha);
						System.out.println(biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getMatricula());
						break;
					case 2:
						ler = new Scanner(System.in);
						
						System.out.println("Digite sua matricula: ");
						String cadastrarMatricula = ler.nextLine();
						
						System.out.println("Digite seu nome: ");
						String cadastrarNome = ler.nextLine();
						
						System.out.println("Digite seu curso: ");
						String cadastrarCurso = ler.nextLine();
						
						System.out.println("Digite sua senha: ");
						String cadastrarSenha = ler.nextLine();
						
						texto.confirmarCadastro();
						int confirmar = ler.nextInt();
						switch(confirmar) {
						case 1:
							biblioteca.cadastrarUsuario(cadastrarMatricula, cadastrarNome, cadastrarCurso, cadastrarSenha);
						}
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
								listaDeLivros.emprestimo();
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
							//listaDeUsuarios.buscarUsuario();
							break;
						case 2:
							//listaDeUsuarios.mostrarUsuarios();
							break;
						case 3:
							listaDeLivros.cadastrarLivro();
							break;
						case 4:
						    ler = new Scanner(System.in);
							System.out.println("Digite a matr�cula do usu�rio a ser excluido: ");
							String alunoExcluido = ler.nextLine();
							System.out.println("Digite a senha de administrador para confirmar a a��o:");
							int senha = ler.nextInt();
						try {
							boolean result = biblioteca.removerUsuario(alunoExcluido, senha);
							if(result) {
								System.out.println("Usuario removido.");
							}else {
								System.out.println("Usuario n�o foi removido.");
							}
							
						} catch (SenhaAdminIncorretaException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
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

