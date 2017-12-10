package view;
import java.util.Scanner;

//import controller.ListaLivros;
import controller.Biblioteca;
import controller.LivroBuscadoException;
import exceptions.CursoBuscadoException;
import exceptions.SenhaAdminIncorretaException;
import exceptions.SenhaUsuarioIncorretaException;

public class Main {

	public static void main(String[] args) throws SenhaUsuarioIncorretaException {
		Scanner ler = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
	//	ListaLivros listaDeLivros = new ListaLivros();
		int opcaoUsuario = -1;
		
		
		while (opcaoUsuario != 0) {
			Textos.tipoUsuario();
			opcaoUsuario = ler.nextInt();
			
			switch(opcaoUsuario) {
			case 1:
				Textos.menuAluno();
				int menuA = ler.nextInt();
				switch(menuA) {
					case 1: 
						// aceso ao usuario
						ler = new Scanner(System.in); 
						
						System.out.println("Digite sua matricula: ");
						String acessarMatricula = ler.nextLine();
						
						System.out.println("Digite sua senha: ");
						String acessarSenha = ler.nextLine();
						
						try {
						System.out.println("-------------------------------------");
						System.out.println("Olá, "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getNome());
						System.out.println("Matricula: "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getMatricula());
						System.out.println("Usuario: "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getNome());
						System.out.println("Curso: "  + biblioteca.acessarUsuario(acessarMatricula, acessarSenha).getCursoUsuario());
						//System.out.println("Livros em posse: " );
						System.out.println("-------------------------------------");
						}catch (SenhaUsuarioIncorretaException e3) {
							e3.printStackTrace();
						}
						
						
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
						
						Textos.confirmarCadastro();
						int confirmar = ler.nextInt();
						switch(confirmar) {
						case 1:
							biblioteca.cadastrarUsuario(cadastrarMatricula.toUpperCase(), cadastrarNome.toUpperCase(), cadastrarCurso.toUpperCase(), cadastrarSenha);
						}
						break;
					case 3:

						// buscar livros
						Textos.buscadeLivros();

						int menuLivro = ler.nextInt();
						switch(menuLivro) {
							case 1:
								System.out.println("Digite o nome do livro");
								String nomeDoLivro = ler.next();
							try {
								biblioteca.buscarNome(nomeDoLivro);
								System.out.println("Digite sua matricula: ");
								String matricula = ler.next();
								System.out.println("Digite sua senha: ");
								String senha = ler.next();
								System.out.println("Digite o nome do livro: ");
								String livro = ler.next();
								biblioteca.cadastrarReserva(matricula, senha, livro);
								System.out.println("Concluido!");
							} catch (LivroBuscadoException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
								break;
							case 2:
								System.out.println("Digite o curso do livro");
								String cursoDoLivro = ler.next();
							try {
								biblioteca.buscarCurso(cursoDoLivro);
								biblioteca.mostrarLivros();
								Textos.emprestimoLivro();
								int escolha = ler.nextInt();
								switch(escolha) {
								case 1:
									System.out.println("Digite sua matricula: ");
									String matricula = ler.next();
									System.out.println("Digite sua senha: ");
									String senha = ler.next();
									System.out.println("Digite o nome do livro: ");
									String livro = ler.next();
									biblioteca.cadastrarReserva(matricula, senha, livro);
									System.out.println("Concluido!");
								}
										
								
								
								// biblioteca.cadastrarReserva(matriculaUsuario, senhaUsuario, nomeLivro);
							} catch (CursoBuscadoException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							//	listaDeLivros.emprestimo();
								break;
						}
							
						break;
					case 4:
						System.out.println("Digite sua matricula: ");
						String devolverMatricula = ler.next();
						
						System.out.println("Digite sua senha: ");
						String devolverSenha = ler.next();
						
						System.out.println("Digite o nome do livro: ");
						String devolverLivro = ler.next();
						
						biblioteca.removerReserva(devolverMatricula, devolverSenha, devolverLivro);
						break;

					}
						
					break;
			case 2:
				System.out.println("Digite sua senha de administrador: ");
				int senhaAdm = ler.nextInt();
				if (senhaAdm == 0001) {
					Textos.menuAdm();
					int menuB = ler.nextInt();
					switch(menuB) {
						case 1:
							// buscar usuarios
								
								Textos.buscaDeUsuario();
								int menuBuscaUsuario = ler.nextInt();
								switch(menuBuscaUsuario) {
								case 1: 
									// buscar pelo nome ou matricula
									
									System.out.println("Digite a matricula do usuario:");
									String matriculaBuscarUsuario = ler.next();
								
									System.out.println("Matricula: " + biblioteca.buscarUsuarioExistenteMatricula(matriculaBuscarUsuario.toUpperCase()).getMatricula());
									System.out.println("Usuario: " + biblioteca.buscarUsuarioExistenteMatricula(matriculaBuscarUsuario.toUpperCase()).getNome());
									System.out.println("Curso: " + biblioteca.buscarUsuarioExistenteMatricula(matriculaBuscarUsuario.toUpperCase()).getCursoUsuario());
									break;
								case 2:
									// buscar pelo curso
									
									System.out.println("Digite o curso do usuario:");
									String cursoBuscarUsuario = ler.next();
									
									System.out.println("Usuarios do curso:");
									biblioteca.mostrarUsuariosDoCurso(cursoBuscarUsuario.toUpperCase());
									
									System.out.println("Digite o nome ou matrícula do usuário:");
									String matriculaBuscarUsuario2 = ler.next();
									
									System.out.println("Matricula: " + biblioteca.buscarUsuarioExistenteMatricula(matriculaBuscarUsuario2.toUpperCase()).getMatricula());
									System.out.println("Usuario: " + biblioteca.buscarUsuarioExistenteMatricula(matriculaBuscarUsuario2.toUpperCase()).getNome());
									System.out.println("Curso: " + biblioteca.buscarUsuarioExistenteMatricula(matriculaBuscarUsuario2.toUpperCase()).getCursoUsuario());
									break;
								}
							break;
						case 2:
							// mostrar quantidade de usuarios e usuarios
							
							System.out.println("Quantidade de usuários: " + biblioteca.quantidadeUsuarios());
							biblioteca.mostrarUsuariosExistentes();
						
							break;
						case 3:
							//	cadastro de livros
							
							System.out.println("Digite o nome do livro: ");
							String nomeLivro = ler.next();
							
							System.out.println("Digite o código do livro: ");
							String codigoLivro = ler.next();
							
							System.out.println("Digite o curso ao qual pertence o livro: ");
							String curso = ler.next();
							
							System.out.println("O nome do livro é: " + nomeLivro);
							System.out.println("O código do livro é: " + codigoLivro);
							System.out.println("O livro pertence ao curso: " + curso);
							
							Textos.confirmarCadastro();
							int confirmar = ler.nextInt();
							switch(confirmar) {
							case 1:
								biblioteca.cadastrarLivro(nomeLivro, codigoLivro, curso);
								System.out.println("Livro cadastrado!");
							}
							break;
						case 4:
							// remover usuario
							
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
						case 5:
							
							System.out.println("Quantidade de reservas existentes: " + biblioteca.quantidadeDeReservas());
							System.out.println("Reservas: ");
							biblioteca.mostrarReservasExistentes();
							
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

