package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Dot implements Shape {
	public int radius =5;
	public WorldPoint _worldPoint;
	public Color _color = Color.BLACK; 
	public Dot(LocalPoint p){
		_worldPoint = p;
		
	}
	public Dot(double cornerx,double cornery,double z){
		double	 x = cornerx;
		double y = cornery;
		_worldPoint = new WorldPoint(x,y,z);
		
	}
	public WorldPoint  getWorldPoint (){
		return _worldPoint;
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(_color);
		g.drawOval((int)( _worldPoint.getX())- radius , (int)( _worldPoint.getY())- radius , radius*2, radius*2);
	
	
	}
	public void turnBlack(){
		_color = Color.BLACK;
		
	}
	public void turnGreen(){
		_color = Color.GREEN;
		
	}
	@Override
	public void mousePressed(MouseEvent mev) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean contains(Point p) {
	 double px = p.getX();
	 double py = p.getY();
	 double dx = _worldPoint.getX();
	 double dy = _worldPoint.getY();
		if(px >=dx-radius && px<=dx+radius){
			if(py >=dy-radius && py<=dy+radius){
				return true;
			} // area is a box not a circle
		}
		return false;
	}
	
}
