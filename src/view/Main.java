package view;
import java.util.Scanner;

//import controller.ListaLivros;
import controller.Biblioteca;
import exceptions.SenhaAdminIncorretaException;
import exceptions.SenhaUsuarioIncorretaException;

public class Main {

	public static void main(String[] args) throws SenhaUsuarioIncorretaException {
		Scanner ler = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
	//	ListaLivros listaDeLivros = new ListaLivros();
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
						// aceso ao usuario
						ler = new Scanner(System.in); 
						
						System.out.println("Digite sua matricula: ");
						String acessarMatricula = ler.nextLine();
						
						System.out.println("Digite sua senha: ");
						String acessarSenha = ler.nextLine();
						
						
						System.out.println("-------------------------------------");
						System.out.println("Olá, "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getNome());
						System.out.println("Matricula: "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getMatricula());
						System.out.println("Usuario: "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getNome());
						System.out.println("Curso: "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getCursoUsuario());
						//System.out.println("Livros em posse: " );
						System.out.println("-------------------------------------");
						
						
						break;
					case 2:
						// cadastro de usuário.
						ler = new Scanner(System.in);
						
						System.out.println("Digite sua matricula: ");
						String cadastrarMatricula = ler.nextLine();
						
						System.out.println("Digite seu nome: ");
						String cadastrarNome = ler.nextLine();
						
						System.out.println("Digite seu curso: ");
						String cadastrarCurso = ler.nextLine();
						
						System.out.println("Digite sua senha: ");
						String cadastrarSenha = ler.nextLine();
						
						System.out.println("Matricula: " + cadastrarMatricula);
						System.out.println("Nome: " + cadastrarNome);
						System.out.println("Curso: " + cadastrarCurso);
						
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
							//	listaDeLivros.buscarNome();
								break;
							case 2:
							//	listaDeLivros.buscarCurso();
							//	listaDeLivros.emprestimo();
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
							System.out.println("Quantidade de usuários: " + biblioteca.quantidadeUsuarios());
							biblioteca.mostrarUsuariosExistentes();
							//listaDeUsuarios.mostrarUsuarios();
							break;
						case 3:
						//	listaDeLivros.cadastrarLivro();
							break;
						case 4:
						    ler = new Scanner(System.in);
							System.out.println("Digite a matrícula do usuário a ser excluido: ");
							String alunoExcluido = ler.nextLine();
							System.out.println("Digite a senha de administrador para confirmar a ação:");
							int senha = ler.nextInt();
						try {
							boolean result = biblioteca.removerUsuario(alunoExcluido, senha);
							if(result) {
								System.out.println("Usuario removido.");
							}else {
								System.out.println("Usuario não foi removido.");
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

