package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controller.Controller;

public class LayoutPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	DrawingPanel _drawingPanel;
	ButtonPanel _buttonPanel;
	Controller _controller;
	
	public LayoutPanel(Controller controller){
		_controller = controller;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		_drawingPanel = new DrawingPanel(_controller);
		_buttonPanel = new ButtonPanel(_controller);
		_drawingPanel.setButtonPanel(_buttonPanel);
		_buttonPanel.setMaximumSize(_buttonPanel.getMaximumSize());
		this.add(_drawingPanel);
		this.add(_buttonPanel);
		
	}


}
