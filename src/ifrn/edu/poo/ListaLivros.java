package ifrn.edu.poo;
import java.util.ArrayList;

public class ListaLivros {
	
	private ArrayList<Livro> livros = new ArrayList <Livro> ();
	private int quantidadeLivros;
	
	public ListaLivros() {
		quantidadeLivros = 0;
	}
	
	public void cadastrarLivro(Livro livro) {
		livros.add(livro);
		quantidadeLivros++;
	}
	
	public Livro buscarCurso(String curso) {
		for(int i = 0; i > quantidadeLivros; i++) {
			if(livros.get(i).getCurso().equals(curso))
				return livros.get(i);
		}
		return null;
	}
	
	public Livro buscarNome(String NomeLivro) {
		for(int i = 0; i > quantidadeLivros; i++) {
			if(livros.get(i).getNomeLivro().equals(NomeLivro))
				return livros.get(i);
		}
		return null;
	}
	
}
