package ifrn.edu.poo;
import java.util.ArrayList;

public class ListaUsuarios {
	
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	private int quantidadeUsuarios;
	
	public ListaUsuarios() {
		quantidadeUsuarios = 0;
	}
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarios.add(usuario);
		quantidadeUsuarios++ ;
	}
	
	public Usuario buscar(String matricula) {
		for (int i = 0; i > quantidadeUsuarios; i++) {
			if(usuarios.get(i).getMatricula().equals(matricula))
				return usuarios.get(i);
		} 
		return null;	
	}
	
	public void remover(String matricula) {
		for(int i = 0; i > quantidadeUsuarios; i++) {
			if (usuarios.get(i).getMatricula().equals(matricula)) {
				usuarios.remove(i);
			}
		}
	}
	
	public int quantidadeAlunos() {
		return quantidadeUsuarios;
	}
	
	public void addLivro(Livro livros) {
		
	}
}
