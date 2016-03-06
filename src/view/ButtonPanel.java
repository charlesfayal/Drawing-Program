package view;

import java.awt.Dimension;
import java.awt.event.MouseListener;


import javax.swing.JPanel;

import controller.Controller;
import gui.Button;

public class ButtonPanel extends JPanel  {
	private static final long serialVersionUID = 1L;
	MouseListener _mouseListener;
	private Button _drawButton;
	private Button _boxButton;
	private Button _createNewObjectButton;
	private Button _stopButton;
	private Button _clearButton;
	private Button _increaseSwivel;
	private Button _decreaseSwivel;
	private Button _increaseRoll;
	private Button _decreaseRoll;
	private Button _increasePitch;
	private Button _decreasePitch;
	
	Dimension _panelDimension;
	Controller _controller;
	
	public ButtonPanel(Controller controller){
		_controller = controller;
		
		_drawButton = new Button("Draw", _controller);
		_boxButton = new Button("Box", _controller);
		_createNewObjectButton = new Button("Create New Object", _controller);
		_clearButton = new Button("Clear", _controller);
		_stopButton = new Button("Nothing", _controller);
		_increaseSwivel = new Button("Increase Swiveling" , _controller);
		_decreaseSwivel = new Button("Decrease Swiveling" , _controller);
		_increaseRoll = new Button("Increase Rolling" , _controller);
		_decreaseRoll = new Button("Decrease Rolling" , _controller);
		_increasePitch = new Button("Increase Pitching" , _controller);
		_decreasePitch = new Button("Decrease Pitching" , _controller);
		
		add(_boxButton);
		add(_drawButton);
		//add(_createNewObjectButton);
		add(_clearButton);
		//add(_stopButton);
		add(_increaseSwivel);
		add(_decreaseSwivel);
		add(_increaseRoll);
		add(_decreaseRoll);
		add(_increasePitch);
		add(_decreasePitch);
		
		_panelDimension = new Dimension(1200,300);
		this.setMaximumSize(_panelDimension);
	}



	public void changeToCreatePoints() {
		_createNewObjectButton.setText("Create New Object");
	}
	public void changeToCreateLines() {
		_createNewObjectButton.setText("Create Lines");		
	}
	public void changeToChooseCenterMass() {
		_createNewObjectButton.setText("Choose Center of Mass");
	}
	public void changeToFinishCreating(){
		_createNewObjectButton.setText("Finish Creating");		 // doesnt do anything, it finishes when the person chooses a point

	}
}
