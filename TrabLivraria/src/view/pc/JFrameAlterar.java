package view.pc;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import entities.Author;
import entities.Publisher;

public class JFrameAlterar extends FrameBase{
	JComboBox<String> lista;
	PanelAlterar panelEscolhas;
	
	JComboBox cb;
	JFormattedTextField txtISBN;
	JTextField txtTitulo;
	JFormattedTextField txtBookPrice;
	JButton buttonChooseAuthors;
	JButton buttonChoosePublishers;
	
	JTextField txtNomeAntigoAutor;
	JTextField txtNomeAutor;
	JTextField txtSobrenomeAutor;
	
	JTextField txtNomeEditora;
	JTextField txtNovoNomeEditora;
	JTextField txtNovaUrlEditora;
	
	JButton buttonSubmit;
	public ArrayList<Author> autoresEscolhidos;
	public Publisher editoraEscolhida;
	
	JFrameAlterar(){
		super("alterar");
		setTitle("Alterar");
		
		panelEscolhas = new PanelAlterar();
		add(panelEscolhas);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	
	class PanelAlterar extends JPanel implements ItemListener{
		JPanel cards; //a panel that uses CardLayout
	    final static String AutoresPanel = "Autores";
	    final static String EditorasPanel = "Editoras";
	    final static String LivrosPanel = "Livros";  
	    
	    public PanelAlterar() {
	    	this.addComponentToPane(this);
	    }
	    
	    public void addComponentToPane(Container pane) {
	    	
	    	//Criando uma mascara que so aceita numeros
	    	NumberFormat number = NumberFormat.getInstance();
	    	number.setGroupingUsed(false); //Tira vírgula
	        NumberFormatter mascaraNumero = new NumberFormatter(number);
	        mascaraNumero.setValueClass(Integer.class);
	        mascaraNumero.setMinimum(0);
	        mascaraNumero.setMaximum(Integer.MAX_VALUE);
	        mascaraNumero.setAllowsInvalid(false);
	        
	        //Put the JComboBox in a JPanel to get a nicer look.
	        JPanel comboBoxPane = new JPanel(); //use FlowLayout
	        String comboBoxItems[] = { AutoresPanel, LivrosPanel, EditorasPanel };
	        cb = new JComboBox(comboBoxItems);
	        cb.setEditable(false);
	        cb.addItemListener(this);
	        comboBoxPane.add(cb);

	        //Create the "cards".
	        JPanel card1 = new JPanel();
	        card1.setLayout(new GridLayout(4,2));
	        
	        txtNomeAntigoAutor = new JTextField();
            card1.add(new JLabel("Nome antigo do Autor: ", JLabel.TRAILING));
            card1.add(txtNomeAntigoAutor);
            
            card1.add(new JLabel("Novo Nome do Autor: ", JLabel.TRAILING));
            txtNomeAutor = new JTextField();
	        card1.add(txtNomeAutor);
	        
	        card1.add(new JLabel("Novo Sobrenome do Autor: ", JLabel.TRAILING));
	        txtSobrenomeAutor = new JTextField();
	        card1.add(txtSobrenomeAutor);
	        
	        buttonSubmit = new JButton("Enviar");
	        buttonSubmit.addActionListener(new testBehavior());
	        card1.add(buttonSubmit);
	        
	        
	        JPanel card2 = new JPanel();
	        card2.setLayout(new GridLayout(6,2));
	        txtISBN = new JFormattedTextField(createFormatter("#-###-#####-#"));
            card2.add(new JLabel("ISBN: ", JLabel.TRAILING));
	        txtISBN.setPreferredSize( new Dimension( 50, 30 ));
	        card2.add(txtISBN);
	        
	        
	        txtTitulo = new JTextField();
            card2.add(new JLabel("Titulo: ", JLabel.TRAILING));
            txtTitulo.setPreferredSize( new Dimension( 50, 30 ));
	        card2.add(txtTitulo);
	        
	        txtBookPrice = new JFormattedTextField(createFormatter("##.##"));
            card2.add(new JLabel("Novo preço: ", JLabel.TRAILING));
            txtBookPrice.setPreferredSize( new Dimension( 50, 30 ));
	        card2.add(txtBookPrice);
	        
	        card2.add(new JLabel("Escolher Autores: ", JLabel.TRAILING));
            buttonChooseAuthors = new JButton("Autores");
            buttonChooseAuthors.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<Author> arrayList = new ArrayList<Author>();
					autoresEscolhidos = new ArrayList<Author>();
					arrayList.add(new Author(312, "Scherer", "Felipe"));
					arrayList.add(new Author(313, "Skoll", "Redondo"));
					arrayList.add(new Author(313, "Nahara", "Yui"));
					arrayList.add(new Author(313, "Xandão", "Super"));
					new JFrameListAutores(arrayList, autoresEscolhidos);
					
				}
			});
            card2.add(buttonChooseAuthors);
            
	        card2.add(new JLabel("Escolher Editora: ", JLabel.TRAILING));
	        buttonChoosePublishers = new JButton("Editora");
	        buttonChoosePublishers.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<Publisher> array = new ArrayList<>();
					array.add(new Publisher(2121, "Bandai", "www.bandai.com"));
					array.add(new Publisher(351, "Behavior", "www.behavior.com"));
					array.add(new Publisher(5643, "Jota", "www.jota.com"));
					
					new JFrameListEditoras(array, editoraEscolhida);
					
				}
			});
            card2.add(buttonChoosePublishers);
            
	        buttonSubmit = new JButton("Enviar");
	        buttonSubmit.addActionListener(new testBehavior());
	        card2.add(buttonSubmit);

	        
	        JPanel card3 = new JPanel();
	        card3.setLayout(new GridLayout(4,2));
	        txtNomeEditora = new JTextField();
            card3.add(new JLabel("Nome antigo da editora: ", JLabel.TRAILING));
            txtNomeEditora.setPreferredSize( new Dimension( 50, 30 ));
	        card3.add(txtNomeEditora);
	        
	        txtNovoNomeEditora = new JTextField();
	        card3.add(new JLabel("Novo nome da Editora: ", JLabel.TRAILING));
	        card3.add(txtNovoNomeEditora);
	        
	        txtNovaUrlEditora = new JTextField();
	        card3.add(new JLabel("Nova URL da editora: ", JLabel.TRAILING));
	        card3.add(txtNovaUrlEditora);	        
	        
	        buttonSubmit = new JButton("Enviar");
	        buttonSubmit.addActionListener(new testBehavior());
	        card3.add(buttonSubmit);
	        
	        
	    	
	    	
	        
	        //Create the panel that contains the "cards".
	        cards = new JPanel(new CardLayout());
	        cards.add(card1, AutoresPanel);
	        cards.add(card2, LivrosPanel);
	        cards.add(card3,EditorasPanel);
	        
	        pane.add(comboBoxPane, BorderLayout.PAGE_START);
	        pane.add(cards, BorderLayout.CENTER);
	        
	    }
	    
	    public void itemStateChanged(ItemEvent evt) {
	        CardLayout cl = (CardLayout)(cards.getLayout());
	        cl.show(cards, (String)evt.getItem());
	    }
	}
	
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
            
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
	
    class testBehavior implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(cb.getSelectedItem().equals("Livros")) {
				if(!txtISBN.getText().equals(" -   -     - ")) {
					String stringAutores = "";
					for(Author a : autoresEscolhidos) {
						stringAutores +=  "\n" + a.getFname() + " " + a.getName() ;
					}
					System.out.println(autoresEscolhidos);
					JOptionPane.showMessageDialog(null, "ISBN: " + txtISBN.getText() +
																	"\nTitulo: " + txtTitulo.getText() + 
																	"\nPreco: " + txtBookPrice.getText() +
																	"\nAutores: " + stringAutores + 
																	"\nEditora: " + editoraEscolhida);
				} else
					JOptionPane.showMessageDialog(null, "Preencha o campo corretamente");
			}else if(cb.getSelectedItem().equals("Autores")) {
				if(!txtIDAutor.getText().equals("")) {
					int input = JOptionPane.showConfirmDialog(null,
			                "Caso esse autor esteja relacionado a um livro, também será excluido.\nDeseja continuar?",
			                "Selecione uma opção...",JOptionPane.YES_NO_CANCEL_OPTION);
					if(input == 0)
						JOptionPane.showMessageDialog(null, "ID do autor: " + txtIDAutor.getText());
				}else
					JOptionPane.showMessageDialog(null, "Preencha o campo corretamente");
			}else if(cb.getSelectedItem().equals("Editoras")) {
				if(!txtIDEditora.getText().equals("")) {
					int input = JOptionPane.showConfirmDialog(null,
			                "Caso essa editora esteja relacionado a um autor, ele também será excluido.\nDeseja continuar?",
			                "Selecione uma opção...",JOptionPane.YES_NO_CANCEL_OPTION);
					if(input == 0)
						JOptionPane.showMessageDialog(null, "ID da editora: " + txtIDEditora.getText());
				}else
					JOptionPane.showMessageDialog(null, "Preencha o campo corretamente");
			}
		}
    	
    }
	
    
	
}
