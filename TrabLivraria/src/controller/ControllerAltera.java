package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entities.Author;
import view.pc.altera.ViewAltera;
import view.pc.busca.ViewBusca;

public class ControllerAltera {
	
	//private DAOBusca dao;
	private ViewAltera view;
	
	public ControllerAltera(ViewAltera viewAltera) {
		this.view = viewAltera;
		
		init();
	}
	
	private void init() {
		view.addSubmitBehavior(new submitBehavior());
	}

	class submitBehavior implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object tipo = view.getAlteraType();
			System.out.println("certo");
			if(tipo.equals("Livros")) {
//				if(!txtISBN.getText().equals(" -   -     - ") && !txtTitulo.getText().equals("") 
//						&& !txtBookPrice.getText().equals("  .  ")
//						&& !buttonChooseAuthors.isVisible() && !buttonChoosePublishers.isVisible()) {
//					String stringAutores = "";
//					for(Author a : autoresEscolhidos) {
//						stringAutores +=  "\n" + a.getFname() + " " + a.getName() ;
//					}
//					System.out.println(autoresEscolhidos);
//					JOptionPane.showMessageDialog(null, "ISBN: " + txtISBN.getText() +
//																	"\nTitulo: " + txtTitulo.getText() + 
//																	"\nPreco: " + txtBookPrice.getText() +
//																	"\nAutores: " + stringAutores + 
//																	"\nEditora: " + editoraEscolhida);
			}
			
		}
		
	}
	
	class AddSubmitBehavior implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// {
			//	System.out.println("LIVROS");
			//}
			
		}

	}

}

//public void actionPerformed(ActionEvent e) {
//	if(cb.getSelectedItem().equals("Livros")) {
//		if(!txtISBN.getText().equals(" -   -     - ") && !txtTitulo.getText().equals("") 
//				&& !txtBookPrice.getText().equals("  .  ")
//				&& !buttonChooseAuthors.isVisible() && !buttonChoosePublishers.isVisible()) {
//			String stringAutores = "";
//			for(Author a : autoresEscolhidos) {
//				stringAutores +=  "\n" + a.getFname() + " " + a.getName() ;
//			}
//			System.out.println(autoresEscolhidos);
//			JOptionPane.showMessageDialog(null, "ISBN: " + txtISBN.getText() +
//															"\nTitulo: " + txtTitulo.getText() + 
//															"\nPreco: " + txtBookPrice.getText() +
//															"\nAutores: " + stringAutores + 
//															"\nEditora: " + editoraEscolhida);
//		} else
//			JOptionPane.showMessageDialog(null, "Preencha os campos corretamente e/ou escolha a editora e/ou autores");
//	}else if(cb.getSelectedItem().equals("Autores")) {
//		if(!txtIDAutor.getText().equals("")) {
//			int input = JOptionPane.showConfirmDialog(null,
//	                "Caso esse autor esteja relacionado a um livro, também será excluido.\nDeseja continuar?",
//	                "Selecione uma opção...",JOptionPane.YES_NO_CANCEL_OPTION);
//			if(input == 0)
//				JOptionPane.showMessageDialog(null, "ID do autor: " + txtIDAutor.getText());
//		}else
//			JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
//	}else if(cb.getSelectedItem().equals("Editoras")) {
//		if(!txtIDEditora.getText().equals("")) {
//			int input = JOptionPane.showConfirmDialog(null,
//	                "Caso essa editora esteja relacionado a um autor, ele também será excluido.\nDeseja continuar?",
//	                "Selecione uma opção...",JOptionPane.YES_NO_CANCEL_OPTION);
//			if(input == 0)
//				JOptionPane.showMessageDialog(null, "ID da editora: " + txtIDEditora.getText());
//		}else
//			JOptionPane.showMessageDialog(null, "Preencha o campo corretamente");
//	}
//}

