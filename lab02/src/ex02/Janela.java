package ex02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;

	//Fazer uma janela com um bot�o e um label. No label est� escrito quantas vezes o bot�o foi pressionado e deve atualizar a contagem cada vez que o bot�o for pressionado.
	
	//Para acessar a label atrav�s da inner class, declaramos o panel fora do constructor
	JPanel panel;
	JLabel label;
	
	Janela(){
		//tamanho da janela
		setSize(400,400);
		
		//O que a janela faz ao clicar no x
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inicia no meio da tela
		setLocationRelativeTo(null);
		
		//tornar a janela visivel
		setVisible(true);
		
		//Fazer um container para o bot�o
		panel = new JPanel();
		add(panel);
		panel.setLayout(new FlowLayout());
		
		//Criar um bot�o
		JButton button = new JButton("Pressione");
		panel.add(button);
		button.addActionListener(new ButtonBehaviorInner());
		
		//Cria um label
		label = new JLabel();
		panel.add(label);
		
	}
	
	class ButtonBehaviorInner implements ActionListener{
		int cont = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			cont++;
			label.setText(String.valueOf(cont));
			
		}
		
	}
}
