package view;

import controller.Controller;

public class GraphicsWindow extends gui.GraphicsWindow {
	Controller _controller;
	LayoutPanel _layoutPanel;
	private static final long serialVersionUID = 1L;
	public GraphicsWindow(Controller controller){
		super();
		_controller = controller;
		_layoutPanel = new LayoutPanel(_controller);
		 this.setContentPane(_layoutPanel);
	}

}
