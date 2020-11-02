package view.pc.inclui;

import javax.swing.JOptionPane;

public class FrameMessage extends JOptionPane{

	public FrameMessage(String tipo) {
		showMessageDialog(null, "Esse(a) " + tipo + " ja esta cadastrado");
	}
	
}
