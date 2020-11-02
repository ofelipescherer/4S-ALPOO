package view.pc.altera;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import entities.Author;
import entities.Publisher;

public interface ViewAltera {
	
	public Publisher getEditora();
	
	public ArrayList<Author> getAuthors();
	
	public Object getAlteraType();
	
	public void setPossiveisAutores(ArrayList<Author> autores);
	
	public void addSubmitBehavior(ActionListener al);
	
	
}
