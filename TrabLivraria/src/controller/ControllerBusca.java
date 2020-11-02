package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import entities.Author;
import entities.Publisher;
import model.dao.DaoBusca;
import view.pc.busca.ViewBusca;



public class ControllerBusca {

	ArrayList<Publisher> arrayEditora;
	ArrayList<Author> arrayAutores;
	
	//private DAOBusca dao;
	private ViewBusca view;
	private DaoBusca dao;
	
	public ControllerBusca(ViewBusca viewBusca, DaoBusca daoBusca) {
		this.view = viewBusca;
		this.dao = daoBusca;
		init();
		//geraArray();
	}
	
	private void init() {
		this.view.addSubmitBehavior(new SubimitBehavior());;
	}
	
	private void geraArray() {
		arrayEditora = new ArrayList<>();
		arrayEditora.add(new Publisher(3213, "Bandai", "www.bandai.com"));
		arrayEditora.add(new Publisher(123, "Companhia das Letras", "www.companhiadasletras.com.br"));
		arrayEditora.add(new Publisher(123, "Panda Books", "www.pandabooks.com.br"));
		
		arrayAutores = new ArrayList<>();
		arrayAutores.add(new Author(2312, "Shirou", "Ogami"));
		arrayAutores.add(new Author(232, "Kiyoko", "Shimizu"));
		arrayAutores.add(new Author(23, "Nao", "Tomori"));
		arrayAutores.add(new Author(32, "Yuu", "Otosaka"));
		arrayAutores.add(new Author(122, "Yu", "Nishinoya"));
		
		
		
	} 
	
	
	class SubimitBehavior implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String texto = view.getJRadioButton();
			String jtxtText = view.getJTextFieldText();
			
			if(texto.equals("Todas Editoras")) {
				//Usuario escolheu mostrar editoras
				view.mostrarListaEditora(dao.buscaEditora(jtxtText));
			} else if(texto.equals("Todos Autores")) {
				//Usuario escolheu autores
				view.mostrarListaAutor(dao.buscaAutor(jtxtText,jtxtText));
			}
			
			
			
			
			
		}
		
	}
	
	
}
