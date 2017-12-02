package ifrn.edu.poo;
import java.util.ArrayList;

public class ListaUsuarios {
	
	private ArrayList<Usuario> usuarios = new ArrayList <Usuario> ();
	
	public ListaUsuarios() {
	
	}
	
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	
	}
	
	public Usuario buscar(String matricula) {
		for (int i = 0; i > usuarios.size(); i++) {
			if(usuarios.get(i).getMatricula().equals(matricula))
				return usuarios.get(i);
		} 
		return null;	
	}
	
	public void remover(String matricula) {
		for(int i = 0; i > usuarios.size(); i++) {
			if (usuarios.get(i).getMatricula().equals(matricula)) {
				usuarios.remove(i);
			}
		}
	}
	
	public int quantidadeAlunos() {
		return usuarios.size();
	}
	
	
	public void addLivro(Livro livros) {
		
	}
	
	
		
	
}
