package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.MouseMotionListener;




import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Controller;
import drawing.Line;
import drawing.Object3D;
import drawing.Cubeing;
import drawing.Dot;
import drawing.DrawLine;

import drawing.Shape;
import drawing.CreateObject;
import drawing.Cube;
public class DrawingPanel extends JPanel implements  ActionListener, MouseListener, MouseMotionListener
	{
		private ArrayList<Shape> _shapes = new ArrayList<Shape>();
		private ArrayList<Object3D> _object3D = new ArrayList<Object3D>();
		
		private static final long serialVersionUID = 1L;
		private ButtonPanel _buttonPanel;
		
		private int _swivel = 0;
		private int _roll = 0;
		private int _pitch = 0;
		private Cube _square;
		private Controller _controller;
	 public DrawingPanel(Controller controller)
	 {
		 _controller = controller;
		 _controller.setDrawingPanel(this);
		 this.addMouseListener(this);
		 this.addMouseMotionListener(this);
		 this.setBackground(Color.WHITE);
		 Timer timer = new Timer(1, this);
		 timer.start();
	
	 }
	 
	
	
	 /**
	  * (non-Javadoc)
	  * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	  * when timer ticks action performed
	  */
	//int j =0;
	 @Override
	 public void actionPerformed(ActionEvent aev)
	 {
		 this.repaint();	 
		 this.swivelImageDeg(_swivel);
		 this.rollImageDeg(_roll);
		 this.pitchImageDeg(_pitch);
	 }
	 
	 @Override
	 public void paint(Graphics g){
		 for(Shape shape: _shapes){
			 shape.paint(g);
		 }
		 for(Dot dot: CreateObject._dots){
			 dot.paint(g);
		 }
		 for(Line line: CreateObject._lines){
			 line.paint(g);
		 }
		 for(Object3D object: _object3D){
			 object.paint(g);
		 }
	 } 
	 public void addShape(Shape shape)
	 {
	  _shapes.add(shape);
	 }
	 public void addObject3D(Object3D object)
	 {
		 _object3D.add(object);
	 }
	private boolean _drawing=false;
	public void toggleDrawing(){
		if(_drawing){
			_drawing=false;
		}else{
			_drawing=true;
		}
		System.out.println("Drawing toggled: " + _drawing);
	}
	private boolean _boxing=false;
	public void toggleBox(){
		if(_boxing){
			_boxing = false;
		}else{
			_boxing = true;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(_drawing){
			DrawLine.endLine(e);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		if(_drawing){
			DrawLine.startLine(e);
		}
		if(_boxing){
			
				addObject3D(Cubeing.addBox(p));
		}
		if(_creatingObjectPoints){
			CreateObject.addPoint(p);
		}
		if(_creatingObjectLines){
			CreateObject.addLine(p);
		}
		if(_choosingCenterMass){
			CreateObject.chooseCenterMass(p);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(_drawing){
			Point p = e.getPoint();
			if(DrawLine._drawing){
			Line l = DrawLine.drawLine(p);
			addObject3D(l);
			}
			
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		}
	
	public void turnOffAll() {
		_drawing = false;
		_boxing = false;
		_creatingObjectPoints= false;
		
	}
	
	public void clearPanel() {
		_shapes.clear();
		_object3D.clear();
		_swivel = 0; 
		_roll = 0;
		_pitch = 0;
	}
	
	private boolean _creatingObjectPoints = false;
	private boolean _creatingObjectLines = false;
	private boolean _choosingCenterMass = false;

	
public void createNewObject() {
		_buttonPanel.changeToCreateLines(); // next button once new object pressed
		_creatingObjectPoints = true;
	}

	public void createLines() {
		_buttonPanel.changeToChooseCenterMass();
		_creatingObjectPoints = false;
		_creatingObjectLines = true;
	}
	public void chooseCenterMass() {
		_buttonPanel.changeToFinishCreating();	
		_creatingObjectLines = false;
		_choosingCenterMass = true;
	}
	public void finishCreating() {
		_buttonPanel.changeToCreatePoints(); 
		_creatingObjectPoints = false;
		_creatingObjectLines = false;
		_choosingCenterMass = false;


	}
	

	public void swivelImageDeg(int deg) {
		for(Object3D object : _object3D){
			object.swivelPoints(deg);
		}
	}
	public void rollImageDeg(int deg) {
		for(Object3D object : _object3D){
			object.rollPoints(deg);
		}
	}
	public void pitchImageDeg(int deg) {
		for(Object3D object : _object3D){
			object.pitchPoints(deg);
		}
	}
	public void increaseSwivel() {
		_swivel += 1;
	}
	public void decreaseSwivel() {
		_swivel -= 1;
	}
	public void increaseRoll() {
		_roll += 1;
	}
	public void decreaseRoll(){
		_roll -= 1;
	}
	public void increasePitch() {
		_pitch += 1;
	}
	public void decreasePitch(){
		_pitch -= 1;
	}

	// Set main objects
	public void setButtonPanel(ButtonPanel buttonPanel){
		_buttonPanel = buttonPanel;
	}

	


	

	
}