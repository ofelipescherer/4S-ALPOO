package teste;

import javax.swing.JFrame;

public class PrimeiraJanela {		
	
	public static void main(String[] args) {
		JFrame jframe;
		jframe = new JFrame();
		//O tamanho da janela
		jframe.setSize(500,500);
		//O comportamento da janela quando o bot�o para fechar � pressionado
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		//Tornar a janela vis�vel.
		jframe.setVisible(true);
	}
	

}
