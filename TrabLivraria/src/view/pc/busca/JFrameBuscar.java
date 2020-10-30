package view.pc.busca;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entities.Publisher;
import view.pc.FrameBase;
import view.pc.busca.tables.JTableEditoras;

public class JFrameBuscar extends FrameBase {

	JRadioButton bTodosLivros;
	JRadioButton bTodosAutores;
	JRadioButton bTodasEditoras;
	JRadioButton bLivrosPorAutor;
	JRadioButton bAutorPorEditora;
	
	JTextFieldPersonalizado txtSubimit;
	JButton bSubmit;
	
	final String pesquisaLivro = "Escreva um livro";
	final String pesquisaAutor = "Escreva um autor";
	final String pesquisaEditora = "Escreva uma editora";
	String NomeDaDica = pesquisaEditora;
	ButtonGroup bg;
	
	public JFrameBuscar() {
		super("buscar");
		
		setSize(500,400);
		add(Box.createRigidArea(new Dimension(0, 20)));
		add(new PanelPrincipal());
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	class PanelPrincipal extends JPanel{
		public PanelPrincipal() {
			setLayout(new BorderLayout());
			
			add(new PanelButtons(), BorderLayout.CENTER);
			
			add(new PanelTxt(), BorderLayout.PAGE_END);
		}
	}
	
	class PanelButtons extends JPanel{
		
		public PanelButtons() {
			ActionListener al = new JButtonBehavior();
			bg = new ButtonGroup();
			bTodasEditoras = new JRadioButton("Todas Editoras");
			bTodasEditoras.addActionListener(al);
			bTodasEditoras.setActionCommand(pesquisaEditora);
			bTodosAutores = new JRadioButton("Todos Autores");
			bTodosAutores.addActionListener(al);
			bTodosAutores.setActionCommand(pesquisaAutor);
			bTodosLivros = new JRadioButton("Todos livros");
			bTodosLivros.addActionListener(al);
			bTodosLivros.setActionCommand(pesquisaLivro);
			bLivrosPorAutor = new JRadioButton("Livros por Autor");
			bLivrosPorAutor.addActionListener(al);
			bLivrosPorAutor.setActionCommand(pesquisaAutor);
			bAutorPorEditora = new JRadioButton("Autores por Editora");
			bAutorPorEditora.addActionListener(al);
			bAutorPorEditora.setActionCommand(pesquisaEditora);
			bg.add(bTodasEditoras);
			bg.add(bTodosAutores);
			bg.add(bTodosLivros);
			bg.add(bLivrosPorAutor);
			bg.add(bAutorPorEditora);
			add(bTodasEditoras);
			add(bTodosAutores);
			add(bTodosLivros);
			add(bLivrosPorAutor);
			add(bAutorPorEditora);
			bTodasEditoras.setSelected(true);
			
			
			System.out.println(bg.getSelection());
		}
	}
	
	class PanelTxt extends JPanel {
		
		public PanelTxt() {
//			setBackground(Color.yellow);
			
			txtSubimit = new JTextFieldPersonalizado();
			txtSubimit.setHorizontalAlignment(txtSubimit.CENTER);
			bSubmit = new JButton("Enviar");
			//bSubmit.addActionListener(new ButtonSubmitBehavior());
			
			add(txtSubimit);
			add(bSubmit);
		}
	}
	
	class JTextFieldPersonalizado extends JTextField implements FocusListener{
		 private boolean showingHint;
		  
		public JTextFieldPersonalizado() {
			setText(NomeDaDica);
			super.addFocusListener(this);
			setColumns(25);
		    this.showingHint = true;  
		}
		
		@Override
		public void focusGained(FocusEvent arg0) {
			if(this.getText().isEmpty()) {
			      super.setText("");
			      showingHint = false;
			      }
		}

		@Override
		public void focusLost(FocusEvent arg0) {
		    if(this.getText().isEmpty()) {
		        super.setText(NomeDaDica);
		        showingHint = true;
		      }
		}
		
		@Override
		public String getText() {
			if(showingHint) {
				return "";
			} else {
				return super.getText();
			}
			//return showingHint ? "" : super.getText(); outro jeito de escrever, isso se chama operator ternario
		}
		
	}
	
	public void addBuscaEditora(ActionListener al) {
		bSubmit.addActionListener(al);	
	}
	
	class JButtonBehavior implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			NomeDaDica = e.getActionCommand();
			txtSubimit.focusLost(null);
			
		}
		
	}
	
	class ButtonSubmitBehavior implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			System.out.println("PRINTEI");
//			ArrayList<Publisher> array = new ArrayList<>();
//			array.add(new Publisher(3213, "Bandai", "www.bandai.com"));
//			array.add(new Publisher(123, "Companhia das Letras", "www.companhiadasletras.com.br"));
//			array.add(new Publisher(123, "Panda Books", "www.pandabooks.com.br"));
//			
//			if (bTodasEditoras.isSelected()) { new JTableEditoras(array);}
//			else if(bTodosAutores.isSelected()) {}
//			else if(bTodosLivros.isSelected()) {}
//			else if(bLivrosPorAutor.isSelected()) {}
//			else if(bAutorPorEditora.isSelected()) {}	
		}
		
		
	}
	
	


	
}
