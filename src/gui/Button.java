package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import controller.Controller;

public class Button extends JButton implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	private Controller _controller;
	
	public Button(String text, Controller controller){
		super();
		setText(text);
		this.addMouseListener(this);
		_controller = controller;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed: " + getText());
		_controller.buttonPressed(this);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString(){
		return getText();
		
	}
}