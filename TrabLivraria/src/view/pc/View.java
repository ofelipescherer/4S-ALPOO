package view.pc;

public interface View {
	
	
	
	public float getPreco(); //Pre�o do livro, usado para incluir

	public String getNome(); //Nome pode ser de qualquer um, incluir
	
	public String getISBN(); //Usado para excluir, incluir
	
	public int getAuthorID(); //Usado para excluir, incluir
	
	public int getPublisherID(); //Usado para excluir, incluir
}
