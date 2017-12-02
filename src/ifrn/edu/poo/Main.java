package ifrn.edu.poo;
import java.util.Scanner;

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
			case 0:
				System.out.println("Saindo do aplicativo.");
				break;
				
			case 1:
				texto.menuAluno();
				int menuA = ler.nextInt();
				switch(menuA) {
					case 1: 
					
						break;
					case 2:
						
						System.out.println("Digite a matr�cula: ");
						String matricula = ler.next();
						
						System.out.println("Digite seu nome: ");
						String nome = ler.next();
						
						System.out.println("Digite a senha: ");
						String senha = ler.next();
			
						Usuario u = new Usuario(nome, matricula, senha);
						
						System.out.println("Sua matr�cula �: " + u.getMatricula());
						System.out.println("Seu nome �: " + u.getNome());
						System.out.println("Sua senha �: " + u.getSenha());
						texto.confirmarCadastro();
						int confirma = ler.nextInt();
						switch(confirma) {
						case 1:
							listaDeUsuarios.cadastrarUsuario(u);
							System.out.println("Usu�rio cadastrado!");
							break;
						}
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
							System.out.println("Digite a matr�cula do usuario");
							String buscaMatricula = ler.next();
							listaDeUsuarios.buscar(buscaMatricula);
							break;
						case 2:
							System.out.println("N�mero de usu�rios cadastrados: "+ listaDeUsuarios.quantidadeAlunos());
							break;
						case 3:
							System.out.println("Digite o nome do livro: ");
							String nomeLivro = ler.next();
							
							System.out.println("Digite o c�digo do livro: ");
							String codigoLivro = ler.next();
							
							System.out.println("Digite o curso ao qual pertence o livro: ");
							String curso = ler.next();
							
							Livro l = new Livro(nomeLivro, codigoLivro, curso);
							
							System.out.println("O nome do livro �: " + l.getNomeLivro());
							System.out.println("O c�digo do livro �: " + l.getCodigoLivro());
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
							System.out.println("Digite a matr�cula do usu�rio: ");
							String matriculaExcluida = ler.next();
							System.out.println("Digite a senha de administrador para conirmar essa a��o:");
							senhaAdm = ler.nextInt();
							if(senhaAdm == 0001) {
								listaDeUsuarios.remover(matriculaExcluida);
								System.out.println("Usu�rio removido!");
							}else {
								System.out.println("A��o negada!");
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

