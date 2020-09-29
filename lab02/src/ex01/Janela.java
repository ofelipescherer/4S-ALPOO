package ex01;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Janela extends JFrame{
	private static final long serialVersionUID = 1L;

	//Fazer uma janela com um bot�o que, quando pressionado, escreva na sa�da padr�o quantas vezes o bot�o foi pressionado desde o come�o do programa.
	
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
		JPanel panel = new JPanel();
		add(panel);
		
		//Criar um bot�o
		JButton button = new JButton("Pressione");
		panel.add(button);
		button.addActionListener(new ButtonBehavior());
		
	}
}
