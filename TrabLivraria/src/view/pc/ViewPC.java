package view.pc;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewPC extends JFrame implements View{

	private JButton buttonBusca;
	private JButton buttonAltera;
	private JButton buttonInclui;
	private JButton buttonExclui;
	
	private JFrameExcluir janelaExclui;
	private JFrameAlterar janelaAltera;
	private JFrameIncluir janelaInclui;
	private JFrameBuscar janelaBusca;
	
	public ViewPC() {
		super("APS Livraria");
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
		
		JPanel panelLabels = new JPanel();
		add(panelLabels);
		panelLabels.setLayout(new GridLayout(2,1));
		//panelLabels.setBackground(Color.magenta);
		
		JLabel labelWellcome = new JLabel("Bem vindo a biblioteca!", JLabel.CENTER);
		panelLabels.add(labelWellcome);
		labelWellcome.setFont(new Font("Serif", Font.PLAIN, 40));
		
		JLabel labelWellcome2 = new JLabel("O que deseja fazer com os livros?", JLabel.CENTER);
		panelLabels.add(labelWellcome2);
		labelWellcome2.setFont(new Font("Serif", Font.PLAIN, 20));
		
		JPanel panelPrinButton = new PanelButtons();
		add(panelPrinButton);
		

	}
	
	class PanelButtons extends JPanel{
		
		public PanelButtons(){
			setLayout(new GridLayout(2,2, 30, 30));
			
			//Inicializando os botoes
			buttonBusca = new JButton("Buscar");
			buttonAltera = new JButton("Alterar");
			buttonInclui = new JButton("Incluir");
			buttonExclui = new JButton("Excluir");
	
			buttonBusca.setPreferredSize(new Dimension(150, 80));
			buttonBusca.setFont(new Font("Serif", Font.PLAIN, 25));
			buttonAltera.setFont(new Font("Serif", Font.PLAIN, 25));
			buttonInclui.setFont(new Font("Serif", Font.PLAIN, 25));
			buttonExclui.setFont(new Font("Serif", Font.PLAIN, 25));
			
			buttonExclui.addActionListener(new AtivaJanelaEscolheTipo());
			buttonAltera.addActionListener(new AtivaJanelaEscolheTipo());
			buttonBusca.addActionListener(new AtivaJanelaEscolheTipo());
			buttonInclui.addActionListener(new AtivaJanelaEscolheTipo());
			
			add(buttonBusca);
			add(buttonAltera);
			add(buttonInclui);
			add(buttonExclui);
		}
	}

	
	class AtivaJanelaEscolheTipo implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == buttonExclui) {
				janelaExclui = new JFrameExcluir();
			}
			else if(e.getSource() == buttonAltera) {
				janelaAltera = new JFrameAlterar();
			}
			else if(e.getSource() == buttonInclui) {
				janelaInclui = new JFrameIncluir();
			}
			else if(e.getSource() == buttonBusca) {
				janelaBusca = new JFrameBuscar();
			}
			
			//janelaInclui = new JFrameEscolheTipo("excluir");
			//janelaBusca = new JFrameEscolheTipo("excluir");
			//janelaExclui.setCadastrarListener(cadastraListener);
		}
		
	}


	@Override
	public float getPreco() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getISBN() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getAuthorID() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getPublisherID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}













































