package view;

import controller.Controller;

public class View {
	private GraphicsWindow _graphicsWindow;
	private Controller _controller;
	public View(Controller controller){
		_controller = controller;
		_graphicsWindow = new GraphicsWindow(_controller);
	}

}
