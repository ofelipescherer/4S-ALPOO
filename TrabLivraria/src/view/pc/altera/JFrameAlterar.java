package view.pc.altera;



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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import entities.Author;
import entities.Publisher;
import view.pc.FrameBase;


public class JFrameAlterar extends FrameBase implements ViewAltera{
	
	JComboBox<String> lista;
	PanelAlterar panelEscolhas;
	
	JFormattedTextField txtIDAutor;
	
	JFormattedTextField txtIDEditora;
	
	JComboBox cb;
	JFormattedTextField txtISBN;
	JTextField txtTitulo;
	JFormattedTextField txtBookPrice;
	JButton buttonChooseAuthors;
	JButton buttonChoosePublishers;
	
	JTextField txtNomeAntigoAutor;
	JButton AutorEscolhido;
	JTextField txtNomeAutor;
	JTextField txtSobrenomeAutor;
	
	JTextField txtNomeEditora;
	JTextField txtNovoNomeEditora;
	JTextField txtNovaUrlEditora;
	
	Publisher editora;
	
	JButton buttonSubmit;
	ArrayList<Author> autoresEscolhidos;
	Publisher editoraEscolhida;
	
	JFrameListEditoras JanelalistaEditoras;
	JFrameListAutores JanelalistaAutores;
	
	ArrayList<Author> possiveisAutores;
	
	public JFrameAlterar(){
		super("alterar");
		setTitle("Alterar");
		
		panelEscolhas = new PanelAlterar();
		add(panelEscolhas);

		setSize(500,350);
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
	        card1.setLayout(new GridLayout(3,2));
	        
	        txtNomeAntigoAutor = new JTextField();
            card1.add(new JLabel("Nome antigo do Autor: ", JLabel.TRAILING));
            JPanel divisoria = new JPanel();
            divisoria.setLayout(new GridLayout(1,2));
            divisoria.add(txtNomeAntigoAutor);
            AutorEscolhido = new JButton("Verificar Autor");
            divisoria.add(AutorEscolhido);
            card1.add(divisoria);
            
            
            
            card1.add(new JLabel("Novo Nome do Autor: ", JLabel.TRAILING));
            txtNomeAutor = new JTextField();
	        card1.add(txtNomeAutor);
	        
	        card1.add(new JLabel("Novo Sobrenome do Autor: ", JLabel.TRAILING));
	        txtSobrenomeAutor = new JTextField();
	        card1.add(txtSobrenomeAutor);
	        
	        
	        //card1.add(buttonSubmit);
	        
	        
	        JPanel card2 = new JPanel();
	        card2.setLayout(new GridLayout(5,2));
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
					arrayList.add(new Author(312, "Scherer", "Felipe"));
					arrayList.add(new Author(313, "Skoll", "Redondo"));
					arrayList.add(new Author(313, "Nahara", "Yui"));
					arrayList.add(new Author(313, "Xandão", "Super"));
					
					JanelalistaAutores = new JFrameListAutores(arrayList);
					JanelalistaAutores.addEscolheAutores(new EscolherAutores());

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
					
					JanelalistaEditoras = new JFrameListEditoras(array);
					JanelalistaEditoras.addEscolheEditora(new EscolherEditora());
					
				}
			});
            card2.add(buttonChoosePublishers);
            
	       // buttonSubmit = new JButton("Enviar");
	       // card2.add(buttonSubmit);

	        
	        JPanel card3 = new JPanel();
	        card3.setLayout(new GridLayout(3,2));
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
	        
	        //buttonSubmit = new JButton("Enviar");
	        //card3.add(buttonSubmit);
	        
	        //Create the panel that contains the "cards".
	        cards = new JPanel(new CardLayout());
	        cards.add(card1, AutoresPanel);
	        cards.add(card2, LivrosPanel);
	        cards.add(card3,EditorasPanel);
	        
	        pane.add(comboBoxPane, BorderLayout.PAGE_START);
	        pane.add(cards, BorderLayout.CENTER);
	        buttonSubmit = new JButton("Enviar");
	        pane.add(buttonSubmit, BorderLayout.SOUTH);
	        
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
	
	class EscolherEditora implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			editora = JanelalistaEditoras.getEditora();
			buttonChoosePublishers.setEnabled(false);
		}
		
	}
	
	class EscolherAutores implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			autoresEscolhidos = JanelalistaAutores.getAutores();
			buttonChooseAuthors.setEnabled(false);
		}
	}
	
	class setAutoresBehavior implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	

	@Override
	public Publisher getEditora() {
		return editora;		
	}
	
	@Override
	public void addSubmitBehavior(ActionListener al) {
		buttonSubmit.addActionListener(al);
	}

	@Override
	public ArrayList<Author> getAuthors() {
		return null;
	}

	@Override
	public Object getAlteraType() {
		return cb.getSelectedItem();
	}

	@Override
	public void setPossiveisAutores(ArrayList<Author> e) {
		possiveisAutores = e;
	}
	
    
	
}
