package ex07;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;

	//Usando JCheckBox, fazer uma janela onde o usu�rio deve escolher um conjunto de roupas, podendo escolher qualquer combina��o entre: �Camisa�, �Cal�a� e �Sapatos�. A janela deve ter um bot�o que imprime na sa�da padr�o o conjunto escolhido pelo usu�rio.
	
	//Para acessar a label atrav�s da inner class, declaramos o panel fora do constructor
	JPanel panel;
	JLabel label;
	JCheckBox checkboxCalca;
	JCheckBox checkboxCamisa;
	JCheckBox checkboxSapato;
	
	Janela(){
		//tamanho da janela
		setSize(400,400);
		
		//O que a janela faz ao clicar no x
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inicia no meio da tela
		setLocationRelativeTo(null);
		
		//tornar a janela visivel
		setVisible(true);
		
		//Fazer um container para o texfield e label
		panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout());
		
		//Cria um label
		label = new JLabel();
		
		
		//Cria um bot�o
		JButton button = new JButton("Verificar");
		button.addActionListener(new ButtonBehavior());
		
		
		//Cria um checkbox
		checkboxCalca = new JCheckBox("Cal�a");
		checkboxCamisa = new JCheckBox("Camisa");
		checkboxSapato = new JCheckBox("Sapato");
		panel.add(checkboxCalca);
		panel.add(checkboxCamisa);
		panel.add(checkboxSapato);
		panel.add(button);
		panel.add(label);
		
	}
	
	class ButtonBehavior implements ActionListener{
		String sapato = "", calca = "", camisa = "";
		@Override
		public void actionPerformed(ActionEvent e) {
			if(checkboxCalca.isSelected()) {
				calca = "Cal�a; ";
			} else {
				calca = "";
			}
			if(checkboxSapato.isSelected()) {
				sapato = "Sapato; ";
			} else {
				sapato = "";
			}
			if(checkboxCamisa.isSelected()) {
				camisa = "Camisa; ";
			} else {
				camisa = "";
			}

			label.setText("Itens Selecionados: " + sapato + calca + camisa);

		}
		
	}
}
