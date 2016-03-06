package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

public class Box implements Shape{
	private Point _p;
	private Line ltop,lright,lbottom,lleft;
	private int lx,rx,ty,by;
	private int _size;
		public Box(int x, int y, int size){
			this(new Point(x,y), size);
		}
		public Box(Point p, int size){
			_p = p;
			_size = size;
			lx = (int) (_p.getX()-size/2);
			rx = (int) (_p.getX()+size/2);
			ty = (int) (_p.getY()+size/2);
			by = (int) (_p.getY()-size/2);
			ltop = new Line(lx,ty,rx,ty);
			lright = new Line(rx,ty,rx,by);
			lbottom = new Line(rx,by,lx,by);
			lleft = new Line(lx,by,lx,ty);
		}
		
		@Override
		public void paint(Graphics g) {
			ltop.paint(g);
			lright.paint(g);
			lbottom.paint(g);
			lleft.paint(g);
		
		}

		@Override
		public void mousePressed(MouseEvent mev) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Point p) {
			// TODO Auto-generated method stub
			return false;
		}
		

}
