package controller;

import gui.Button;
import view.DrawingPanel;
import view.View;

public class Controller {
	private View _view;
	private DrawingPanel _drawingPanel;
	public Controller(){
		
	}

	public void buttonPressed(Button button) {
		switch(button.getText()){
		case "Draw": 
			_drawingPanel.turnOffAll();
			_drawingPanel.toggleDrawing();
			break;
		case "Box" :
			_drawingPanel.turnOffAll();
			_drawingPanel.toggleBox();
			break;
		case "Nothing":
			_drawingPanel.turnOffAll();
			break;
		case "Clear":
			_drawingPanel.clearPanel();
			break;
		case "Create New Object":
			_drawingPanel.turnOffAll();
			_drawingPanel.createNewObject(); 
			break;
		case "Create Lines":
			_drawingPanel.createLines();
			break;
		case "Choose Center of Mass":
			_drawingPanel.chooseCenterMass();
			break;
		case "Finish Creating":
			_drawingPanel.finishCreating();
			break;
		case "Increase Swiveling":
			_drawingPanel.increaseSwivel();
			break;
		case "Decrease Swiveling":
			_drawingPanel.decreaseSwivel();
			break;
		case "Increase Rolling":
			_drawingPanel.increaseRoll();
			break;
		case "Decrease Rolling":
			_drawingPanel.decreaseRoll();
			break;
		case "Increase Pitching":
			_drawingPanel.increasePitch();
			break;
		case "Decrease Pitching":
			_drawingPanel.decreasePitch();
			break;
		default:
			System.out.println("Nothing in controller for button");
		}
		
	}

	

		
	public void setDrawingPanel(DrawingPanel drawingPanel) {
		_drawingPanel = drawingPanel;
		
	}

	public void setView(View view){
		_view = view;
	}
}
