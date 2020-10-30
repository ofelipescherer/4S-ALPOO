package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.dao.jdbc.DaoJDBC;
import view.pc.View;
import view.pc.ViewPC;
import view.pc.busca.JFrameBuscar;
import view.pc.busca.ViewBusca;

public class Controller {

	private DaoJDBC dao;
	private View view;
	
	public Controller(View viewPC) {
		this.view = viewPC;
		
		init();
	}
	
	private void init() {
		this.view.addComportamentoBuscaEditoras(new BuscaEditoraBehavior());;
	}
	
	class BuscaEditoraBehavior implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("oi");
		}
		
	}
	
}
