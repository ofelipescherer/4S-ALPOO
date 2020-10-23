package view.pc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entities.Author;

public class JFrameListAutores extends JFrame  {
    private JList list;
	//JTable table;
    private DefaultListModel listModel;
 
    private static final String finishString = "Terminar";
    private static final String addAutorString = "Adicionar Autor";
    private JButton buttonAddAutor;
    private JButton buttonFinish;
    private JLabel labelAutores;
    
	ArrayList<Author> arrayAutoresEscolhidos;
	ArrayList<Author> arrayAutores;
	ArrayList<Integer> indexes;
	
	public JFrameListAutores(ArrayList<Author> arrayAutores) {
		super("APS Livraria");
		
		this.arrayAutores = arrayAutores;
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//setResizable(false);
		//setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
		
		listModel = new DefaultListModel();
//
		indexes = new ArrayList<>();
		arrayAutoresEscolhidos = new ArrayList<>();
		
		for(Author a : this.arrayAutores) {
			listModel.addElement(a.getFname() + " " + a.getName());
		}
 
        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        //list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        //list.setCellRenderer(new AuthorRender()); //Mostra as celulas bonitinhas na lista 
// 
        buttonFinish = new JButton(finishString);
        buttonFinish.addActionListener(new TerminaListener());
        buttonFinish.setEnabled(false);
// 
        buttonAddAutor = new JButton(addAutorString);
        buttonAddAutor.setActionCommand(addAutorString);
        buttonAddAutor.addActionListener(new AdicionaListener());
 
        labelAutores = new JLabel();
 
        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                                           BoxLayout.LINE_AXIS));
        buttonPane.add(buttonAddAutor);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(labelAutores);
        buttonPane.add(buttonFinish);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
 
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
        
        pack();
        setLocationRelativeTo(null);
    }
 
    class AdicionaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	boolean isIndexViable = true; //Variavel que verifica se o item ja foi adicionado
            int index = list.getSelectedIndex();
            
        	for(Integer i : indexes) { //Fazemos um for para ver se o item ja foi adicionado
        		if(i == index) {
        			isIndexViable = false;
        		}
        	}
        	
    		if(isIndexViable) { 
    			//Ainda nao foi adicionado, precisamos adiciona-lo
    			labelAutores.setText(labelAutores.getText() + list.getSelectedValue() + "; ");
    			indexes.add(index);
    		}
        	//Quando adicionar um item, o botão terminar fica ativado de novo
            if(!buttonFinish.isEnabled()) {
            	buttonFinish.setEnabled(true);
            }
            
            }
        }
    
    class TerminaListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for(Integer i : indexes) {
				arrayAutoresEscolhidos.add(arrayAutores.get(i));
			}
			
			System.out.println(arrayAutoresEscolhidos);
			
		}
    }
    
    
    //Show list more friendly
    class AuthorRender extends DefaultListCellRenderer{
        public Component getListCellRendererComponent(
            JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value,
                index, isSelected, cellHasFocus);

            Author author = (Author)value;
            setText(author.getFname() + " " + author.getName());

            return this;
        }
    }
	
}

